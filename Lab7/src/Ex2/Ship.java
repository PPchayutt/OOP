/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Ex2;

/**
 *
 * @author pitch
 */
public class Ship extends Vehicle implements Floatable{
    public Ship(){
        super(0.0);
    }
    
    public Ship(double fuel){
        super.fuel = fuel;
    }
    
    /**
     *
     */
    @Override
    public void fl0at(){
        if(fuel >= 50){
            fuel -= 50;
            System.out.println("Ship moves");
        } else{
            System.out.println("Fuel is not enough.");
        }
    }
    
    /**
     *
     */
    @Override
    public void honk(){
        System.out.println("Shhhhh");
    }
    
    public void move(){
        fl0at();
    }
    
    public void move(int distance){
        for (int i = 0; i < distance; i++) {
            if(fuel >= 50){
                fl0at();
            } else{
            System.out.println("Fuel is not enough.");
            break;
            }
        }
    }
    
    /**
     *
     */
    @Override
    public void startEngine(){
        if(fuel >= 10){
            fuel -= 10;
            System.out.println("Engine starts");
        } else{
            System.out.println("Fuel is not enough.");
        }
    }
    
    /**
     *
     */
    @Override
    public void stopEngine(){
        System.out.println("Engine stops");
    }
}