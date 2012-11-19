/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305.project3.servlets;

/**
 *
 * @author Mike Boruta
 */
public class Storage {
    
    private static Storage storage = null;
    private String itemTypeSelected = " ";
    
    private Storage() {
        
    }
    
    public static Storage getStorage() {
        if(storage == null) {
            storage = new Storage();
            System.out.println("Created Storage");
            return storage;
        } else
            return storage;
    }
    
    public String getItemTypeSelected() {
        System.out.println("Got item selected: " + itemTypeSelected);
        return itemTypeSelected;
    }
    
    public void setItemTypeSelected(String newItemTypeSelected) {
        System.out.println("Set itemTypeSelected to: " + newItemTypeSelected);
        itemTypeSelected = newItemTypeSelected;
    }
}
