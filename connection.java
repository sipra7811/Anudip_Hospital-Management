package anudip_project;

import java.sql.*;  

public class connection{
    Connection c;
    Statement s;
    public connection(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///HOSPITAL","root","sipra@1234");    
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}