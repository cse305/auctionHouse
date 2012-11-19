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
public class Person {
    @Id
    @GeneratedValue
    private int personID;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String telephone;
    /**
     * basic constructor
     */
    public Person(){}
    /**
     * full constructor
     * @param lastName
     * @param firstName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param telephone 
     */
    public Person(String lastName, String firstName, String address, 
            String city, String state, String zip, String telephone){
        setLastName(lastName);
        setFirstName(firstName);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setTelephone(telephone);
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
}
