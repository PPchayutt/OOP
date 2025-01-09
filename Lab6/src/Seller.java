/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
public class Seller extends Employee {

    public Food sell(Employee e) {
        if (e.getWallet().getBalance() >= 50) {
            e.getWallet().setBalance(e.getWallet().getBalance() - 50);
            this.getWallet().setBalance(this.getWallet().getBalance() + 50);
            return new Food();
        } else {
            System.out.println("Your money is not enough.");
            return null;
        }
    }
}
