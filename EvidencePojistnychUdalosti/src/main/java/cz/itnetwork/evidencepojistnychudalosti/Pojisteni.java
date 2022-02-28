/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojistnychudalosti;
import java.sql.SQLException;
import java.sql.ResultSet;
import DB.Database;
import java.util.Scanner;

/**
 *
 * @author savel
 */
public class Pojisteni {
    
    public Pojisteni(){
        
    }
    
    public void insert(int pojisteny_id, String nazev_pojisteni, String typ_pojisteni, int pojistna_castka){
        try {
            Database database = new Database("evidence_pojistnych_udalosti", "root", "");
            Object[] objekty = {null, pojisteny_id, nazev_pojisteni, typ_pojisteni, pojistna_castka};
            int uspech = database.insert("pojisteni", objekty);
            System.out.println("Vytvoreni pojisteni probehlo uspesne! " + uspech);
        } catch (SQLException ex){
            System.out.println("Chyba pri vytvoreni pojisteni: " + ex.getMessage());
        }
    }
    
    public void delete(int pojisteny_id, String nazev_pojisteni){
        try {
            Database database = new Database("evidence_pojistnych_udalosti", "root", "");
            Object[] objekty = {pojisteny_id, nazev_pojisteni};
            int uspech = database.delete("pojisteni", "pojisteny_id = ? AND nazev_pojisteni = ? ", objekty);
            System.out.println("Vymazani pojisteni probehlo uspesne! " + uspech);
        } catch (SQLException ex){
            System.out.println("Chyba vzmazani pojisteni: " + ex.getMessage());
        }
    }
    
    public void deleteAll(int pojisteny_id){
        try {
            Database database = new Database("evidence_pojistnych_udalosti", "root", "");
            Object[] objekty = {pojisteny_id};
            int uspech = database.delete("pojisteni", "pojisteny_id = ?", objekty);
            System.out.println("Vymazani vsech pojisteni pojisteneho probehlo uspesne! " + uspech);
        } catch (SQLException ex) {
            System.out.println("Chyba vymazani vsech pojisteni pojisteneho: " + ex.getMessage());
        }
    }
    
    public void select(int pojisteny_id){
        try {
            Database database = new Database("evidence_pojistnych_udalosti", "root", "");
            Object[] objects = {pojisteny_id};
            ResultSet rs = database.select("pojisteni", null, "pojisteny_id = ?", objects);
            
            while(rs.next()){
            System.out.println(rs.getString("nazev_pojisteni") + " | " + rs.getString("typ_pojisteni") + " | " + rs.getString("pojistna_castka"));
            }
            System.out.println("Zobrazeni pojisteni pojisteneho probehlo uspesne! ");
        } catch (SQLException ex) {
            System.out.println("Chyba zobrazeni podrobnosti pojisteni: " + ex.getMessage());
        }   
    }
    
    public void update(){
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Zadejte hodnoty ktere chcete zmenit oddelene carkou - ( , ): ");
        String puvodniHodnoty = sc.nextLine();
        String[] columns = puvodniHodnoty.split(",");
        System.out.println("Zadejte podminky podle ktere chcete hodnoty vybrat oddelene carkou - ( , ): ");
        String podminka = sc.nextLine();
        System.out.println("Zadejte nove hodnoty vzbranych poli oddelene carkou ( , )");
        String noveHodnoty = sc.nextLine();
        String[] parametry = noveHodnoty.split(",");
        try {
            Database database = new Database("evidence_pojistnych_udalosti", "root", "");
            int uspech = database.update("pojisteni", columns, podminka , parametry);
            System.out.println("Prepsani hodnot pojisteni probehlo uspesne! ");
            
        } catch (SQLException ex){
            System.out.println("Chyba prepsani informaci pojisteni: " + ex.getMessage());
        }
    }
    
    
}
