package com.vojtechjanovec;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Logger;

import static com.vojtechjanovec.sqldriver.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
	// write your code here
        sqldriver DB = getInstance();
        try {
            ArrayList a = DB.singleSelectQ("SELECT * FROM promitani inner join kinosal on kinosal.idkinosal = promitani.idkinosal inner join film on film.idfilm = promitani.idfilm");
            System.out.println(a.size());
//            while(rs.next()){
//                //Retrieve by column name
//                int id  = rs.getInt("idpromitani");
////                int age = rs.getInt("narozen");
////                String first = rs.getString("jmeno");
////                String last = rs.getString("last");
//
//                //Display values
//                System.out.print("ID: " + id);
////                System.out.print(", Age: " + age);
////                System.out.print(", First: " + first);
////                System.out.println(", Last: " + last);
//            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
