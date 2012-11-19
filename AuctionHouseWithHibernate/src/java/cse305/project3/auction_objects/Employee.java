/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305.project3.auction_objects;


import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author Tomasz
 */
@Entity
public class Employee extends Person{
    private int employeeID;
    private String SSN;
    private Timestamp startDate;
    private int hourlyRate=0;
    private boolean manager=false;
    private boolean active=true;
    private String loginID;
    private String password;
    
    /**
     * basic constructor
     */
    public Employee(){}
    /**
     * full constructor
     * @param lastName
     * @param firstName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param telephone
     * @param SSN
     * @param startDate
     * @param hourlyRate
     * @param manager
     * @param active
     * @param loginId
     * @param password 
     */
    public Employee(String lastName, String firstName, String address, 
            String city, String state, String zip, String telephone,
            String SSN, Date startDate, int hourlyRate,
            boolean manager, boolean active,
            String loginId, String password){
        setLastName(lastName);
        setFirstName(firstName);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setTelephone(telephone);
        
        setSSN(SSN);
        
        Timestamp timestamp=new Timestamp(startDate.getTime());
        setStartDate(timestamp);
        setHourlyRate(hourlyRate);
        setManager(manager);
        setActive(active);
        setLoginID(loginId);
        setPassword(password);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
