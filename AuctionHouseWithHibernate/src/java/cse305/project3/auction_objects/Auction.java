/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305.project3.auction_objects;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Tomasz
 */
@Entity
public class Auction {

    @Id
    @GeneratedValue
    private int auctionID;
    @OneToOne
    private AuctionItem item;
    //private int itemID;
    @OneToOne
    private Customer seller;
    @OneToOne
    private Customer buyer;

    /**
     * empty constructor
     */
    public Auction(){}
    /**
     * full constructor
     */
    public Auction(AuctionItem item,Customer seller){
        this.item=item;
        this.seller=seller;
    }
     
    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }
    //private int buyerID;
    private Timestamp openingDate;
    private Timestamp closingDate;
    private float minBid = (float) 0.0;
    private Float closingBid;
    private Float currentBid;
    private Float currentHighBid;
    private float reserve = (float) 0.0;
    private int increment;
    @OneToOne
    private Employee employee;
    //private int employeeID;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getAuctionID() {
        return auctionID;
    }

    public void setAuctionID(int auctionID) {
        this.auctionID = auctionID;
    }

    public Timestamp getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Timestamp openingDate) {
        this.openingDate = openingDate;
    }

    public Timestamp getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Timestamp closingDate) {
        this.closingDate = closingDate;
    }

    public float getMinBid() {
        return minBid;
    }

    public void setMinBid(float minBid) {
        this.minBid = minBid;
    }

    public Float getClosingBid() {
        return closingBid;
    }

    public void setClosingBid(Float closingBid) {
        this.closingBid = closingBid;
    }

    public Float getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(Float currentBid) {
        this.currentBid = currentBid;
    }

    public Float getCurrentHighBid() {
        return currentHighBid;
    }

    public void setCurrentHighBid(Float currentHighBid) {
        this.currentHighBid = currentHighBid;
    }

    public float getReserve() {
        return reserve;
    }

    public void setReserve(float reserve) {
        this.reserve = reserve;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public Customer getSeller() {
        return seller;
    }

    public void setSeller(Customer seller) {
        this.seller = seller;
    }

    public AuctionItem getItem() {
        return item;
    }

    public void setItem(AuctionItem item) {
        this.item = item;
    }
}
