/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vojtechjanovec;
import java.sql.*;

/**
 *
 * @author masic
 */
public class Main {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/zoo";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1111";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, jmeno FROM osetrovatele";
            ResultSet rs = stmt.executeQuery(sql);


            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
//                int age = rs.getInt("narozen");
                String first = rs.getString("jmeno");
//                String last = rs.getString("last");

                //Display values
                System.out.print("ID: " + id);
//                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
//                System.out.println(", Last: " + last);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

}