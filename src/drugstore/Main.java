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
public class Main {

    public static void main(String[] args) {
        DrugStore ds = new DrugStore();
        ds.addStock();
//        ds.displayMed();
        String in;
        String in2;
        Account a = new Account();
        while (true) {
            OUTER:
            while (true) {
                in = ds.stringInput("\nPress 1 if you are a pharmacist\nPress 2 if  you are a customer\n>");
                in2 = ds.stringInput("\nPress 1 to register\nPress 2 to login\n>");
                switch (in2) {
                    case "1":
                        if (in.equals("1")) {
                            a = ds.registerPharmacist();
                            break OUTER;
                        }
                        if (in.equals("2")) {
                            a = ds.registerCustomer();
                            break OUTER;
                        } else {
                            System.out.println("\ninvalid input!\n");
                            break;
                        }
                    case "2":
                        a = ds.loginAccount();
                        if (a.getUsername() != null) {
                            System.out.println(a);
                            break OUTER;
                        }
                        System.out.println("\nAccount not found!\n");
                        break;
                    default:
                        System.out.println("\nInvalid input!\n");

                }

            }
            if (a instanceof Customer) {
                ArrayList<Medicine> pm = new ArrayList();//temporay container of purchased medicine
                OUTER_1:
                while (true) {
                    String in3 = ds.stringInput("\nPres 1 for cough\nPress 2 for alergy\nPress 3 for body pain\nPress 4 for headache\nPress 5 to purchase history\nPress 6 to logout>");
                    switch (in3) {
                        case "1":
                            ds.displayMed("cough");
                            break;
                        case "2":
                            ds.displayMed("alergy");
                            break;
                        case "3":
                            ds.displayMed("body pain");
                            break;
                        case "4":
                            ds.displayMed("headache");
                            break;
                        case "5":
                            ds.computePurchasedTotal(((Customer) a).getPurchasedMed(), a.getAge());
                            break;
                        case "6":
                            break OUTER_1;
                        default:
                            System.out.println("\ninvalid input\n!");
                    }
                    if (in3 != "5") {
                        ds.purchase((Customer) a, pm);
                    }
                }
            } else {
                OUTER_2:
                while (true) {
                    String in4 = ds.stringInput("\nPres 1 to add medicine\nPress 2 for remove medicine\nPress 3 to search medicine\nPress 4 for inventory\nPress 5 to view"
                            + " all costumers\nPress 6 to search customer\nPress 7 to logout>");
                    switch (in4) {
                        case "1":
                            Medicine newMedicine = ds.inputMedicine();
                            ds.addMedicine(newMedicine);
                            break;
                        case "2":
                            ds.removeMedicine();
                            break;
                        case "3":
                            String medicine = ds.stringInput("\nEnter medicine name: ");
                            if (ds.searchMed(medicine).getBrandName() != null) {
                                System.out.println(ds.searchMed(medicine));
                            } else {
                                System.out.println("\nCANNOT FIND MEDICINE!\n");
                            }
                            break;
                        case "4":
                            ds.inventory();
                            break;
                        case "5":
                            ds.displayCustomers();
                            break;
                        case "6":
                            ds.searchCustomer();
                            break;
                        case "7":
                            break OUTER_2;
                        default:
                            System.out.println("\nInvalid input!");
                    }
                }
            }
        }

    }

}
