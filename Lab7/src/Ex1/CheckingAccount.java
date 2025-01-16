/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex1;

/**
 *
 * @author pitch
 */
public class CheckingAccount extends Account {

    private double credit;

    public CheckingAccount() {
        super(0, "");
        this.credit = 0;
    }

    public CheckingAccount(double balance, String name, double credit) {
        super(balance, name);
        this.credit = credit;
    }

    public void setCredit(double credit) {
        if (credit > 0) {
            this.credit = credit;
        } else {
            System.out.println("Input number must be a positive integer.");
        }
    }

    public double getCredit() {
        return credit;
    }

    /**
     *
     * @param a
     */
    @Override
    public void withdraw(double a) {
        if ((balance - a) >= 0) {
            balance -= a;
            System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is " + credit + ".");
        } else if ((balance - a + credit) >= 0) {
            setBalance(0);
            credit -= (a - balance);
            System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is " + credit + ".");
        } else if ((balance - a + credit) < 0) {
            System.out.println("Not enough money!");
        }
    }

    public void withdraw(String a) {
        withdraw(Double.parseDouble(a));
    }

    @Override
    public String toString() {
        return "The " + getName() + " account has " + getBalance() + " baht and " + credit + " credits.";

    }
}
