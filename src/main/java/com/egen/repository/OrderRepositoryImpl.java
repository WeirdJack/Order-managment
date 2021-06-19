package com.egen.repository;

import com.egen.model.Order;
import com.egen.model.OrderStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.ZonedDateTime;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Order> findAllOrders() {
        TypedQuery<Order> query = em.createNamedQuery("Order.findAll", Order.class);
        return query.getResultList();
    }

    @Override
    public Order findOrderById(String orderId) {
        TypedQuery<Order> query = em.createNamedQuery("Order.findById", Order.class);
        query.setParameter("orderId", orderId);
        Order order = query.getResultList().get(0);
        if(order != null)
            return order;
        else
            return null;
    }

    @Override
    public List<Order> findAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime) {
        TypedQuery<Order> query = em.createNamedQuery("Order.findWithinInterval", Order.class)
                .setParameter("startTime", startTime)
                .setParameter("endTime", endTime);
        List<Order> ordersList = query.getResultList();

        if(ordersList != null && ordersList.size() > 0)
            return ordersList;
        else
            return null;
    }

//    @Override
//    public List<Order> OrdersWithHighestDollarAmountInZip(String zip) {
//        TypedQuery<Order> query = em.createNamedQuery("Order.findTop10OrdersWithHighestDollarAmountInZip", Order.class);
//        List<Order> ordersList = query.getResultList();
//
//        if(ordersList != null && ordersList.size() > 0)
//            return ordersList;
//        else
//            return null;
//    }

    @Override
    public Order createOrder(Order order) {
        em.persist(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        Order savedOrder = findOrderById(order.getOrderId());
        savedOrder.setOrderStatus(OrderStatus.CANCELLED);
        return em.merge(savedOrder);
    }

    @Override
    public Order cancelOrder(Order order) {
        em.merge(order);
        return order;
    }
}
