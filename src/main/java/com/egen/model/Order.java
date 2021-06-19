package com.egen.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NamedQueries({
		@NamedQuery(name = "Order.findAll", query = "SELECT order FROM Order order JOIN fetch order.shippingAddress JOIN FETCH order.itemsList"),
		@NamedQuery(name = "Order.findById", query = "SELECT *  from Order where orderId = :orderId"),
		@NamedQuery(name = "Order.findWithinInterval", query = "SELECT order FROM Order order JOIN fetch order.shippingAddress JOIN fetch order.itemsList WHERE order.createdAt > :startTime AND order.createdAt < :endTime"),
		@NamedQuery(name = "Order.findTop10OrdersWithHighestDollarAmountInZip", query = "")

})
public class Order {

	@Id
	@Column(columnDefinition = "VARCHAR(36)")
    private String orderId;
    private OrderStatus orderStatus;
    private String custId;
    private double subTotal;
    private double tax;
	private ZonedDateTime createdAt;

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	private double shippingCharges;
	private double total;

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private Address shippingAddress;

	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private List<Item> itemsList;

	public Order(String id) {
		
        this.orderId = UUID.randomUUID().toString();
    }
	
	public Order(OrderStatus orderStatus, String custId, double subTotal, double tax,
			double shippingCharges, Address shippingAddress, double total, List<Item> itemsList) {
		
		super();
        this.orderId = UUID.randomUUID().toString();
		this.orderStatus = orderStatus;
		this.custId = custId;
		this.subTotal = subTotal;
		this.tax = tax;
		this.shippingCharges = shippingCharges;
		this.shippingAddress = shippingAddress;
		this.total = total;
        this.itemsList = itemsList;
	}

	public Order() {

	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", custId=" + custId + ", subTotal="
				+ subTotal + ", tax=" + tax + ", shippingCharges=" + shippingCharges + ", shippingAddress="
				+ shippingAddress + ", total=" + total + "]";
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @return the orderStatus
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}

	/**
	 * @return the subTotal
	 */
	public double getSubTotal() {
		return subTotal;
	}

	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * @return the tax
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(double tax) {
		this.tax = tax;
	}

	/**
	 * @return the shippingCharges
	 */
	public double getShippingCharges() {
		return shippingCharges;
	}

	/**
	 * @param shippingCharges the shippingCharges to set
	 */
	public void setShippingCharges(double shippingCharges) {
		this.shippingCharges = shippingCharges;
	}

	/**
	 * @return the shippingAddress
	 */
	public Address getShippingAddress() {
		return shippingAddress;
	}

	/**
	 * @param shippingAddress the shippingAddress to set
	 */
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	

	
	/**
	 * @return the itemsList
	 */
	public List<Item> getItemsList() {
		return itemsList;
	}

	/**
	 * @param itemsList the itemsList to set
	 */
	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}
}
