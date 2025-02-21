package Ex2;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pitch
 */
public class Customer {

    private String firstName;
    private String lastName;
    private final Account acct[];
    private int numOfAccount;

    public Customer() {
        acct = new Account[5];
        numOfAccount = 0;
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        acct = new Account[5];
        numOfAccount = 0;
    }

    public void addAccount(Account acc) {
        acct[numOfAccount] = acc;
        numOfAccount++;
    }

    public Account getAccount(int index) {
        return acct[index];
    }

    public int getNumOfAccount() {
        return numOfAccount;
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
        return firstName + " " + lastName + " has " + numOfAccount + " accounts";
    }
}
