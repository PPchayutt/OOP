/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author pitch
 */
public interface Magicable {

    public abstract void attackSpell(Player player, Player target, Spell spell);

    public abstract void defense(Player player, Player damager);
}
