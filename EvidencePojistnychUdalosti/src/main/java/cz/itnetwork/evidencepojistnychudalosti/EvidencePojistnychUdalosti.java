/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojistnychudalosti;
import DB.Database;
import java.util.Scanner;


/**
 *
 * @author savel
 */
public class EvidencePojistnychUdalosti {
    public static void main(String[] args) {
        
        Pojisteny pojisteny = new Pojisteny();
        Pojisteni pojisteni = new Pojisteni();
        
        //pojisteny.insert("Gleb", "Butsev", "1998-12-01", "420123456879", "nemaemail@seznam.cz");
        //pojisteni.insert(7, "Pojistka na blbosti", "Pojisteni hmotne odpovednosti", 45000);
        //pojisteni.insert(7, "Pojisteni bytu", "Pojisteni majetku", 2500000);
        pojisteni.update();
    }
}
