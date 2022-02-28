/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author savel
 */
public class Database {
    
    protected Connection connection;
    protected Query query;
    
    public Database (String db, String username, String password) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/" + db, username, password);
    }
    
    //nahradi otazniky v query za prislusne objekty...
    public int query(String query, Object[] objects) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        if (objects != null){
            int index = 1;
            for (Object object : objects){
                ps.setObject(index, object);
                index++;
            }
        }
        return ps.executeUpdate();
    }
    
    public int insert(String table, Object[] objects) throws SQLException {
        query = new Query();
        query.insert(table).values(objects);
        return query(query.getQuery(), objects);
    }
    
    public int delete(String table, String requirment, Object[] objects) throws SQLException {
        query = new Query();
        query.delete(table).where(requirment);
        return query(query.getQuery(), objects);
    }
    
    public ResultSet select(String table, Object[] columns, Object[] objects) throws SQLException {
        return this.select(table, columns, "", objects);
    }
    
    public ResultSet select(String table, Object[] columns, String requirment, Object[] objects)throws SQLException{
        query = new Query();
        if (objects != null){
            query.select(columns).from(table).where(requirment);
        
            PreparedStatement ps = connection.prepareStatement(query.getQuery());
            int index = 1;
            for (Object object : objects){
                ps.setObject(index, object);
                index++;
            }
            ResultSet rs = ps.executeQuery();
            return rs;
        }
        else {
            query.select(columns).from(table);
            PreparedStatement ps = connection.prepareStatement(query.getQuery());
            ResultSet rs = ps.executeQuery();
            return rs;
        }
    }
    
    public int update(String table, String[] columns, String requirement, Object[] params) throws SQLException {
        query = new Query();
        
        query.update(table).set(columns).where(requirement);
        return query(query.getQuery(), params);
    }
    
}
