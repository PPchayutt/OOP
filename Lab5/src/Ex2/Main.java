/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

/**
 *
 * @author pitch
 */
public class Main {

    public static void main(String[] args) {
        Book b = new Book();
        b.setTitle("The Great Gatsby");
        b.setAuthor("F. Scott Fitzgerald");
        b.setPrice(10.99);

        System.out.println("\"" + b.getTitle() + "\"" + " by " + b.getAuthor() + " costs " + b.getPrice() + " USD.");
    }
}
