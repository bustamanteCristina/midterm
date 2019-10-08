/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugstore;

/**
 *
 * @author 2ndyrGroupB
 */
public class Medicine {

    private String medName;
    private String brandName;
    private String genericName;
    private String type;
    private double price;
    private int quantity;

    public Medicine() {
    }

    public Medicine(String medName, double price, String genericName, String brandName, String type, int quantity) {
        this.brandName = brandName;
        this.genericName = genericName;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.medName = medName;
    }
    
    
    public Medicine(String medName, double price, int quantity) {
        this.medName = medName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s %-20s %-20f %-20d", this.medName, this.brandName, this.genericName
                , this.type, this.price, this.quantity);
    }

}
