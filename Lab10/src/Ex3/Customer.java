/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pitch
 */
package Ex3;

import java.util.ArrayList;

public class Customer {

    private String firstName;
    private String lastName;

    private ArrayList<Account> acct;

    public Customer() {
        acct = new ArrayList<>();
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        acct = new ArrayList<>();
    }

    public void addAccount(Account acc) {
        acct.add(acc);
    }

    public Account getAccount(int index) {
        return acct.get(index);
    }

    public int getNumOfAccount() {
        return acct.size();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " has " + acct.size() + " accounts";
    }
}
