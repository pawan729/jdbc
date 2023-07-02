package myPackage;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class student {
    public void createDatabase(){

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
    public void createTable(){
        try{
            String url = "jdbc:mysql://localhost:3306/ ";
            String db = "student";
            String username = "root";
            String password = "Zom50024@";

            Connection conn = DriverManager.getConnection(url+db,username,password);
            Statement stm = conn.createStatement();//statement created

            String query = "create table student(roll_no int(6),name varchar(100),state varchar(100));";
            stm.execute(query); //this returns a boolean value
            System.out.println("Table created successfully");
            conn.close();

        }
        catch( Exception e){
            e.printStackTrace();
        } 
    
    
    }
    public void createData(int roll,String name,String state){ 
        try{
            String url = "jdbc:mysql://localhost:3306/ ";
            String db = "student";
            String username = "root";
            String password = "Zom50024@";

            Connection conn = DriverManager.getConnection(url+db,username,password);
            
            String query = "insert into student(roll_no,name,state) values(?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(query);//   here we are using prepared statement
            pstm.setInt(1,roll);
            pstm.setString(2,name);
            pstm.setString(3,state); //pstm ke help se ham user se input v le sakte hai

            pstm.execute(); //this returns a boolean value
            System.out.println("Data inserted  successfully");
            conn.close();

        }
        catch( Exception e){
            e.printStackTrace();
        } 
    }
    public void readData(){
        try{
            String url = "jdbc:mysql://localhost:3306/ ";
            String db = "student";
            String username = "root";
            String password = "Zom50024@";

            Connection conn = DriverManager.getConnection(url+db,username,password);
            Statement stm = conn.createStatement();//statement created
            String query = "select * from student";
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                System.out.println("roll --> "+rs.getInt(1));
                System.out.println("name --> "+rs.getString(2));
                System.out.println("State --> "+rs.getString(3));
                System.out.println();
            }
            //rs.next means jab tak next row exist karta h true h
            //this returns a boolean value
            System.out.println("read successfully");
            conn.close();

        }
        catch( Exception e){
            e.printStackTrace();
        } 
    

    }
    }
    


