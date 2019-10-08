/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugstore;

import java.util.ArrayList;

/**
 *
 * @author 2ndyrGroupB
 */
public class Customer extends Account{
    private ArrayList<Medicine> purchasedMed;

    public Customer() {
        purchasedMed = new ArrayList();
    }

    public Customer(String username, String password, String fname, String lname, int age) {
        super(username, password, fname, lname, age);
        purchasedMed = new ArrayList();
    }

    public ArrayList<Medicine> getPurchasedMed() {
        return purchasedMed;
    }

    public void setPurchasedMed(ArrayList<Medicine> purchasedMed) {
        this.purchasedMed = purchasedMed;
    }
  
    
    public void addPurchased(Medicine m) {
        purchasedMed.add(m);
    }
    
    
}
