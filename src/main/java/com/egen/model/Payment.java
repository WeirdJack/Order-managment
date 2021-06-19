package com.egen.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Payment {

	@Id
	@Column(columnDefinition = "VARCHAR(36)")
	private String paymentId;
	private String paymentMethod;
    private ZonedDateTime paymentDate;
    private String paymentConfirmationNumber;
    private Address billingAddress;
    private Order totalAmount;

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentMethod=" + paymentMethod + ", paymentDate=" + paymentDate
				+ ", paymentConfirmationNumber=" + paymentConfirmationNumber + ", billingAddress=" + billingAddress
				+ ", totalAmount=" + totalAmount + "]";
	}
	
	public Payment() {
		super();
		this.paymentId = UUID.randomUUID().toString();
	}
	
	public Payment(String paymentId, String paymentMethod, ZonedDateTime paymentDate, String paymentConfirmationNumber,
			Address billingAddress, Order totalAmount) {
		super();
		this.paymentId = UUID.randomUUID().toString();
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.paymentConfirmationNumber = paymentConfirmationNumber;
		this.billingAddress = billingAddress;
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the totalAmount
	 */
	public Order getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(Order totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
    /**
	 * @return the paymentId
	 */
	public String getPaymentId() {
		return paymentId;
	}
	
	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	/**
	 * @return the paymentDate
	 */
	public ZonedDateTime getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(ZonedDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * @return the paymentConfirmationNumber
	 */
	public String getPaymentConfirmationNumber() {
		return paymentConfirmationNumber;
	}
	/**
	 * @param paymentConfirmationNumber the paymentConfirmationNumber to set
	 */
	public void setPaymentConfirmationNumber(String paymentConfirmationNumber) {
		this.paymentConfirmationNumber = paymentConfirmationNumber;
	}
	/**
	 * @return the billingAddress
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}
	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
}
