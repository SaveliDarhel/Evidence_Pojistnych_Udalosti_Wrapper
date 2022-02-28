/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojistnychudalosti;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.ResultSet;
import DB.Database;

/**
 *
 * @author savel
 */
public class Pojisteny {
    
    private Pojisteni pojisteni;
    
    public Pojisteny(){
        
    }
    
    public void insert(String jmeno, String prijmeni, String datum_narozeni, String tel_cislo, String email){
        try{
            Database database = new Database("evidence_pojistnych_udalosti", "root", "");
            Object[] objekty = {null, jmeno, prijmeni, datum_narozeni, tel_cislo, email};
            int uspech = database.insert("pojistene", objekty);
            System.out.println("Vytvoreni uzivatele probehlo uspesne! " + uspech);
        } catch (SQLException ex) {
            System.out.println("Chyba pri vytvoreni pojisteneho: " + ex.getMessage());
        }
    }
    
    public void delete(String jmeno, String prijmeni, int id){
        try {
            Database database = new Database("evidence_pojistnych_udalosti", "root", "");
            Object[] objekty = {jmeno, prijmeni, id};
            int uspech1 = database.delete("pojistene", "jmeno = ? AND prijmeni = ? AND id = ?", objekty);
            pojisteni = new Pojisteni();
            pojisteni.deleteAll(id);
            System.out.println("Vymazani pojisteneho probehlo uspesne! " + uspech1);
        } catch (SQLException ex){
            System.out.println("Chyba pri vymazani pojisteneho: " + ex.getMessage());
        }
    }
    
    public void select(String jmeno, String prijmeni, int id){
        try {
            Database database = new Database("evidence_pojistnych_udalosti", "root", "");
            Object[] objects = {jmeno, prijmeni, id};
            ResultSet rs = database.select("pojistene", null, "jmeno = ? AND prijmeni = ? AND id = ?", objects);
            
            while(rs.next()){
                System.out.println(rs.getString("id") + " | " + rs.getString("jmeno") + " | " + rs.getString("prijmeni") + " | " + rs.getString("datum_narozeni") + " | " + rs.getString("tel_cislo") + " | " + rs.getString("email"));
            }
            System.out.println("Zobrazeni pojisteneho probehlo uspesne! ");
            
        } catch (SQLException ex) {
            System.out.println("Chyba zobrazeni uzivatele a jeho pojisteni: " + ex.getMessage());
        }
    }
    
    public void selectPlus(String jmeno, String prijmeni, int id){
        this.select(jmeno, prijmeni, id);
        pojisteni = new Pojisteni();
        pojisteni.select(id);
    }
    
    public void selectAll(){
        try {
            Database database = new Database("evidence_pojistnych_udalosti", "root", "");
            ResultSet rs = database.select("pojistene", null, null);
            
            while(rs.next()){
                System.out.println(rs.getString("id") + " | " + rs.getString("jmeno") + " | " + rs.getString("prijmeni") + " | " + rs.getString("datum_narozeni") + " | " + rs.getString("tel_cislo") + " | " + rs.getString("email"));
            }
            System.out.println("Zobrazeni seznamu pojistenych probehlo uspesne! ");
        } catch (SQLException ex) {
            System.out.println("Chyba zobrazeni seznamu pojistenych: " + ex.getMessage());
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
            int uspech = database.update("pojistene", columns, podminka , parametry);
            System.out.println("Prepsani hodnot pojisteneho probehlo uspesne! ");
            
        } catch (SQLException ex){
            System.out.println("Chyba prepsani informaci pojisteneho: " + ex.getMessage());
        }
    }
    
}
