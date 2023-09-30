/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.vojtechjanovec.festival.sqldriver;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Performance {
    private sqldriver DB;

    public Performance() {
        // TODO: Connect parameters to DB
        try {
            this.DB = sqldriver.getInstance();
        } catch(ClassNotFoundException e) {
//            Logger.getLogger(Movie.class.getName().log(LEVEL.SEVERE, null, e));
        }
    }
    
    public ArrayList<ArrayList<String>> getMoviePerformances(String movie, ArrayList<Date> date, String cinemaName) {
        try {
            DB.querySelect("SELECT * FROM promitani inner join kinosal on kinosal.idkinosal = promitani.idkinosal inner join film on film.idfilm = promitani.idfilm");
        } catch (SQLException ex) {
            Logger.getLogger(Performance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
        
}
