/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pitch
 */
import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {

    private int id;
    private String name;
    private double price;
    private Date created_on;

    public Item() {
        this.created_on = new Date();
    }

    public Item(int id, String name, double price, Date time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.created_on = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }
}
