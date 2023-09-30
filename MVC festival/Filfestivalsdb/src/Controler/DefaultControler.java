/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;


import Model.Performances;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmasic
 */
public class DefaultControler {
    //TODO: předělat na singleton
    private Performances Performancemodel = new Performances();
    
     public ArrayList<String> listOfmovies() {
        try {
            return Performancemodel.getAllMovies();
        } catch (SQLException ex) {
            Logger.getLogger(DefaultControler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ArrayList<String> listOfCinemas() {
         try {
            return Performancemodel.getAllCinemas();
         } catch (SQLException ex) {
             Logger.getLogger(DefaultControler.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }
    public void listOfProjections() {
        try {
            Performancemodel.getAllProjection();
            
        } catch (SQLException ex) {
             Logger.getLogger(DefaultControler.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

      /*
      
    public static ArrayList<ArrayList<String>> listperformancesOfmovie(
            String moovie, ArrayList<Date> date, String cinameName
    ) {
        
    }

    public static ArrayList<ArrayList<String>> listOfmovies(
            ArrayList<String> moovies, Date date, String cinameName
    ) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        for (String m : moovies) {
               res.add(listOfmoovie(m, Date date, String cinameName));
        }

    }

      */
     
}
