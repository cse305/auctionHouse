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
public class Customer extends Person{
  
    private int customerId;
    private String email="";
    private String creditCardNumber="";
    private int rating;
    private boolean active;
    private String loginId;
    private String password;
    /**
     * basic constructor
     */
    public Customer(){}
    
    /**
     * full constructor;
     * @param lastName
     * @param firstName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param telephone
     * @param email
     * @param creditCardNumber
     * @param rating
     * @param active
     * @param loginId
     * @param password 
     */
    public Customer(String lastName, String firstName, String address, 
            String city, String state, String zip, String telephone,
            String email, String creditCardNumber, int rating, boolean active,
            String loginId, String password){
        setLastName(lastName);
        setFirstName(firstName);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setTelephone(telephone);
        this.email=email;
        this.creditCardNumber=creditCardNumber;
        this.rating=rating;
        this.active=active;
        this.loginId=loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
