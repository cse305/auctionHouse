/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305.project3.auction_objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



/**
 *
 * @author Tomasz
 */
@Entity
public class AuctionItem {
    @Id
    @GeneratedValue
    private int itemID;
    private String name="*No Name*";
    private String type="*No Type*";
    private int yearManufactured;
    private int copiesSold=0;
    private int amountInStock=0;
    
    /** 
     * simple constructor
     */
    public AuctionItem(){}
    /**
     * full constructor
     */
    public AuctionItem(String name, String type, int yearManufactured,
            int copiesSold,int amountInStock){
        this.name=name;
        this.type=type;
        this.yearManufactured=yearManufactured;
        this.copiesSold=copiesSold;
        this.amountInStock=amountInStock;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(int yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }
    
}
