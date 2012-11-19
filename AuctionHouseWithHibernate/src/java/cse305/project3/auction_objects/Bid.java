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
public class Bid {

    @Id
    @GeneratedValue
    private int bidID;
    @OneToOne
    private Auction auction;
    //private int auctionID;
    //private int prospectiveBuyerID;
    @OneToOne
    private Customer prospectiveBuyer;
    private float bidValue = (float) 0.;
    private Timestamp time;
    
    public Bid(){}
    
    public Bid(Auction auction, Customer prospectiveBuyer,float bidValue, Timestamp time){
        this.auction=auction;
        this.prospectiveBuyer=prospectiveBuyer;
        this.bidValue=bidValue;
        this.time=time;
    }

    public int getBidID() {
        return bidID;
    }

    public void setBidID(int bidID) {
        this.bidID = bidID;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Customer getProspectiveBuyer() {
        return prospectiveBuyer;
    }

    public void setProspectiveBuyer(Customer prospectiveBuyer) {
        this.prospectiveBuyer = prospectiveBuyer;
    }

    public float getBidValue() {
        return bidValue;
    }

    public void setBidValue(float bidValue) {
        this.bidValue = bidValue;
    }
}
