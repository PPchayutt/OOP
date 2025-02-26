/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

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
     * @throws Ex2.WithdrawException
     */
    @Override
    public void withdraw(double a) throws WithdrawException {
        if (a < 0) {
            System.out.println("Input number must be a positive integer.");
            return;
        }

        if (balance >= a) {
            balance -= a;
            System.out.println(a + " baht is withdrawn from " + name + ".");
        } else if (balance + credit >= a) {
            credit -= (a - balance);
            balance = 0;
            System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is " + credit + ".");
        } else {
            throw new WithdrawException("Account " + name + " has not enough money!");
        }
    }

    public void withdraw(String a) throws WithdrawException {
        withdraw(Double.parseDouble(a));
    }

    @Override
    public String toString() {
        return "The " + getName() + " account has " + getBalance() + " baht and " + credit + " credits.";
    }
}
