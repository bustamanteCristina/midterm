/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugstore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupB
 */
public class DrugStore {

    Scanner input = new Scanner(System.in);
    private ArrayList<Medicine> medicines;
    private ArrayList<Account> accounts;

    public DrugStore() {
        medicines = new ArrayList();
        accounts = new ArrayList();
    }

    //==============GETTERS AND SETTER================
    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
    //==============GETTERS AND SETTER================
    //
    //
    //
    //
    //
    //==========AUTHENTICATION=============================

    public Account register() {
        String uname = stringInput("Enter username: ");
        String pass = stringInput("Enter password: ");
        System.out.println("\nPERSONAL INFORMATION");
        String fname = stringInput("Enter first name: ");
        String lname = stringInput("Enter last name: ");
        int u_age = 0;
        while (true) {
            String age = stringInput("Enter age: ");
            try {
                u_age = Integer.parseInt(age);
                break;
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            if (u_age < 18) {
                System.out.println("18 BELOW ARE NOT ALLOWED TO REGISTER!");
            } else {
                break;
            }
        }
        return new Account(uname, pass, fname, lname, u_age);
    }

    public Account loginAccount() {
        String username = stringInput("Enter username: ");
        String password = stringInput("Enter password: ");
        for (Account a : accounts) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                return a;
            }
        }
        return new Account();
    }

    public Customer registerCustomer() {
        Account a = register();
        Customer c = new Customer(a.getUsername(), a.getPassword(), a.getFname(), a.getLname(), a.getAge());
        accounts.add(c);
        System.out.println("\nSuccessfully registered");
        return c;
    }

    public Pharmacist registerPharmacist() {
        Account a = register();
        Pharmacist p = new Pharmacist(a.getUsername(), a.getPassword(), a.getFname(), a.getLname(), a.getAge());
        accounts.add(p);
        System.out.println("\nSuccessfully registered");
        return p;
    }
    //==========AUTHENTICATION======================================
    //
    //
    //
    //
    //
    //
    //
    ///
    //
    //
    //
    //=======PHARMACY METHODS | PHARMACIST METHODS========================

    public void addMedicine(Medicine m) {
        medicines.add(m);
        System.out.println("\nMedicine successfully added!\n");
    }

    public void addStock() {
        medicines.add(new Medicine("Benzonatate", 100, "benzonatate", "Tessalon", "cough", 100));
        medicines.add(new Medicine("Mucinex", 100, "guaifenesin", "Robitussin Mucus", "cough", 100));
        medicines.add(new Medicine("Cheratussin", 100, "codeine", "Allfen CD", "cough", 100));
        medicines.add(new Medicine("Fioricet", 100, "caffeine", "capacet", "headache", 100));
        medicines.add(new Medicine("Ibuprofen", 100, "Ibuprofen", "Midol", "headache", 100));
        medicines.add(new Medicine("Advil", 100, "\tAdvil", "\tIbuprofen", "headache", 100));
        medicines.add(new Medicine("Naproxen", 100, "naproxen", "Aleve", "body pain", 100));
        medicines.add(new Medicine("Acetminophen", 100, "Acetminophen", "Actamin", "body pain", 100));
        medicines.add(new Medicine("Declofenac", 100, "Declofenac", "Cambia", "body pain", 100));
        medicines.add(new Medicine("Hydroxyzine", 100, "Hydroxyzine", "Vistaril", "alergy", 100));
        medicines.add(new Medicine("Levocetiricine", 100, "Levocetiricine", "Xyzal", "alergy", 100));
        medicines.add(new Medicine("Doxylamine", 100, "Doxylamine", "Usinom", "alergy", 100));
    }

    public void displayMed(String type) {
        printLine();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "NAME", "BRAND", "GENERIC NAME", "TYPE", "PRICE", "QUANITY");
        for (Medicine m : medicines) {
            if (m.getType().equals(type) && m.getQuantity() != 0) {
                System.out.println(m);
            }
        }
        printLine();
    }

    public void total(Customer c) {
        int total = 0;
        for (Medicine m : c.getPurchasedMed()) {
            System.out.println(m);
            total += m.getPrice() * m.getQuantity();
        }
        System.out.println("Your total is: " + total);
    }

    public void inventory() {
        double totalSale = 0;
        for (Medicine m : medicines) {
            printLine();
            double total = 0;
            int num = 0;
            for (Account a : accounts) {
                if (a instanceof Customer) {
                    if (!((Customer) a).getPurchasedMed().isEmpty()) {
                        for (Medicine m2 : ((Customer) a).getPurchasedMed()) {
                            if (m.getMedName().equals(m2.getMedName())) {
                                total += m2.getPrice() * m2.getQuantity();
                                num += m2.getQuantity();
                            }
                        }
                    }
                }
            }
            System.out.println(m);
            System.out.println("Total number of item purchased: " + num);
            System.out.println("Total amount: " + total);
            totalSale += total;
        }
        printLine();
        System.out.println("TOTAL SALE: " + totalSale);
    }

    public Medicine inputMedicine() {
        String medName = stringInput("\nEnter medicine name: ");
        String genName = stringInput("Enter generic name: ");
        String brandName = stringInput("Enter brand name: ");
        String type = stringInput("Enter type: ");
        double price = intInput("Enter price: ");
        int quantity = intInput("Enter quantity: ");
        return new Medicine(medName, price, genName, brandName, type, quantity);
    }

    public void removeMedicine() {
        String medName = stringInput("\nEnter medicine name: ");
        if (searchMedId(medName) != "Medicine not found") {
            medicines.remove(Integer.parseInt(searchMedId(medName)));
            System.out.println("\nMedicine successfully deleted!\n");
        } else {
            System.out.println("\nCannot find medicine!\n");
        }
    }

    public void displayCustomers() {
        boolean hasCus = false;
        printLine();
        int total = 0;
        System.out.printf("%-20s %-20s %-20s %-20s %-20S", "USERNAME", "FIRST NAME", "LAST NAME", "AGE", "TOTAL PURCHASED MEDICINE\n");
        for (Account a : accounts) {
            if (a instanceof Customer) {
                hasCus = true;
                for (Medicine m: ((Customer) a).getPurchasedMed()){
                    total += m.getQuantity();
                }
                System.out.println(a.toString() + total);
            }
        }
        System.out.println((hasCus) ? "" : "\nNO CUSTOMER REGISTERED YET!\n");
        printLine();
    }

    public void displayMedicines() {
        printLine();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "NAME", "BRAND", "GENERIC NAME", "TYPE", "PRICE", "QUANITY");
        for (Medicine m : medicines) {
            System.out.println(m);
        }
        printLine();
    }

    public void searchCustomer() {
        String username = stringInput("Enter customer's username: ");
        boolean hasFound = false;
        for (Account a : accounts) {
            if (a instanceof Customer) {
                if (a.getUsername().equalsIgnoreCase(username)) {
                    hasFound = true;
                    System.out.println("\nUSRENAME: " + a.getUsername());
                    System.out.println("FIRST NAME: " + a.getFname());
                    System.out.println("LAST NAME: " + a.getLname());
                    System.out.println("AGE: " + a.getAge());
                    System.out.println("\nPURCHASE HISTORY");
                    computePurchasedTotal(((Customer) a).getPurchasedMed(), a.getAge());
                }
            }
        }
        System.out.println((hasFound) ? "" : "\nCANNOT FIND CUSTOMER");

    }
    //=======PHARMACY METHODS | PHARMACIST METHODS========================
    //
    //
    //

    //
    //
    //
    //
    //
    //
    //
    //
    //============CUSTOMER'S METHODS===============================
    public void purchase(Customer a, ArrayList pm) {
        while (true) {
            String name = this.stringInput("\nMedicine Name : ");
            if (searchMed(name).getType() != null || searchMed(name).getQuantity() != 0) {
                int quantity = this.intInput("Quantity : ");
                Medicine m = searchMed(name);
                if (m.getQuantity() >= quantity) {
                    m.setQuantity(m.getQuantity() - quantity);
                    Medicine med = new Medicine(m.getMedName(), m.getPrice(), quantity);
                    a.addPurchased(med);
                    pm.add(med);
                } else {
                    System.out.println("\nINSUFFICIENT STOCK!\nREMAING STOCK:  " + m.getQuantity() + "\n");
                }
            } else {
                System.out.println("\nMEDICINE NOT FOUND!\n");
            }
            String answer = stringInput("Add another Medicine ? y/n\n");
            if (answer.equalsIgnoreCase("n")) {
                computePurchasedTotal(pm, a.getAge());
                break;
            }
        }
    }

    public void computePurchasedTotal(ArrayList<Medicine> m, int age) {
        if (!m.isEmpty()) {
            System.out.println("\n\n_________________________________________");
            double total = 0;
            for (Medicine n : m) {
                System.out.println("Medicine: " + n.getMedName());
                System.out.println("quantity: " + n.getQuantity());
                System.out.println("Price: " + n.getPrice());
                System.out.println("TOTAL: " + n.getPrice() * n.getQuantity());
                total += n.getPrice() * n.getQuantity();
                System.out.println("_________________________________________");
            }
            if (age > 65) {
                total = total - (total * .20);
                System.out.println("Discount: 20%");
            }
            System.out.println("TOTAL AMOUNT: " + total + "\n");
        } else {
            System.out.println("\nNO PURCHASED MEDICINE");
        }
    }

    //============CUSTOMER'S METHODS===============================
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //=======COMMON TOOLS========================
    public Medicine searchMed(String name) {
        for (Medicine m : medicines) {
            if (m.getMedName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return new Medicine();
    }

    public String searchMedId(String name) {
        for (int i = 0; i < medicines.size(); ++i) {
            if (medicines.get(i).getMedName().equalsIgnoreCase(name)) {
                return i + "";
            }
        }
        return "Medicine not found";
    }

    public String stringInput(String label) {
        System.out.print(label);
        return input.next();
    }

    public int intInput(String label) {
        System.out.print(label);
        return input.nextInt();
    }

    public void printLine() {
        for (int i = 0; i < 10; ++i) {
            System.out.print("------------");
        }
        System.out.println("");
    }

}
