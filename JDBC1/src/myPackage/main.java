package myPackage;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {
        //steps involved jdbc load,connection establish,statement create,execute statement,connection close;
        //in latest versions loading of jdbc is not required
        //connection establish
        try{
            String url = "jdbc:mysql://localhost:3306/ ";
            String username = "root";
            String password = "Zom50024@";

            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stm = conn.createStatement();//statement created

            String query = "create database student";
            stm.execute(query); //this returns a boolean value
            System.out.println("Database created successfully");
            conn.close();

        }
        catch( Exception e){
            e.printStackTrace();
        } 
    }
    
}
 