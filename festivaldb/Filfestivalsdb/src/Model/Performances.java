/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmasic
 */
public class Performances {
    private sqldriver DB;
    //TODO: předělat na singleton
     public Performances()
             
     {
         try {
             //TODO: parametry připojení k DB
            this.DB = sqldriver.getInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Moovie.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public ArrayList<ArrayList<String>> getListperformancesOfmovie( 
             String moovie, ArrayList<Date> date, String cinameName)
             
     {
     
           
         
     }
     
     public ArrayList<String> getAllMovies() throws SQLException {
         ArrayList<String> ret=null;
         String q="select from film";
         //Nápověda
         Object obj = new Object();
         String str=null;
         if (obj instanceof  String)
            str = (String) obj;
         
        //TODO: dopsat přetypování na ArrayList<String>
        this.DB.singleSelectQ(q,"");
        
        return ret;
     }
     /*
     Vrátí všechny filmy promítaní v zadané dny
     */
     public ArrayList<String> getAllMoviesPerdays(ArrayList<Date> dates) {
     
     }
     
      /*
     Vrátí všechny filmy promítaní v kinosále
     */
     public ArrayList<String> getAllMoviesInCinema(String cinema) {
     
     }
}
