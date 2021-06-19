package com.egen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Item {

	@Id
	@Column(columnDefinition = "VARCHAR(36)")
	private String itemId;
	private String itemName;
	private int itemQty;

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemQty=" + itemQty + "]";
	}
	
	public Item() {
		
		super();
        this.itemId = UUID.randomUUID().toString();
        
	}

	public Item(String itemId, String itemName, int itemQty) {
		super();
		this.itemId = UUID.randomUUID().toString();;
		this.itemName = itemName;
		this.itemQty = itemQty;
	}


	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}


	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}


	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	/**
	 * @return the itemQty
	 */
	public int getItemQty() {
		return itemQty;
	}


	/**
	 * @param itemQty the itemQty to set
	 */
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	
	
	
	
	
	
}
