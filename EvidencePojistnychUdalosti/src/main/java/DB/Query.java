/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

/**
 *
 * @author savel
 */
public class Query {
    
    private StringBuilder query;
    
    //naformatuje INSERT INTO `table`...
    public Query insert(String table){
        query = new StringBuilder();
        query.append("INSERT INTO ");
        query.append(table);
        return this;
    }
    
    //naformatuje ...VALUES(?,?,?,?,?...,?);
    public Query values(Object[] objects){
        query.append(" VALUES(");
        int count = objects.length;
        if (count == 0){
            throw new IllegalArgumentException("Zadan nulovy pocet parametru");
        }
        for (int i = 0; i < count; i++){
            query.append("?,");
        }
        query.deleteCharAt(query.lastIndexOf(","));
        query.append(");");
        return this;
    }
    
    //naformatuje dotaz jako DELETE FROM `table`...
    public Query delete(String table){
        query = new StringBuilder();
        query.append("DELETE FROM ");
        query.append(table);
        return this;
    }
    
    //naformatuje dotaz jako ... WHERE ...
    public Query where(String requirment){
        query.append(" WHERE ");
        query.append(requirment);
        return this;
    }
    
    //naformatuje dotaz jako SELECT FROM ...
    public Query select(Object[] columns){
        query = new StringBuilder();
        query.append("SELECT ");
        if (columns != null){
            for (Object column : columns){
                query.append(column);
                query.append(",");
            }
            query.deleteCharAt(query.lastIndexOf(","));
        }
        else {
            query.append("*");
        }
        return this;
    }
    
    //naformatuje dotaz jako ...FROM table...
    public Query from(String table){
        query.append(" FROM ");
        query.append(table);
        return this;
    }
    
    //naformatuje dotaz jako UPDATE table SET...
    public Query update(String table){
        query = new StringBuilder();
        query.append("UPDATE ");
        query.append(table);
        query.append(" SET ");
        return this;
    }
    
    //prida znaky "?" posle vyrazu SET...
    public Query set(String[] columns){
        int count = columns.length;
        if (count == 0){
            throw new IllegalArgumentException("Nulový počet parametrů");
        }
        for (String column : columns){
            query.append(column);
            query.append(" = ");
            query.append("?");
            query.append(",");
        }
        query.deleteCharAt(query.lastIndexOf(","));
        return this;
    }
    
    //naformatuje dotaz jako String...
    public String getQuery(){
        return query.toString();
    }
    
}
