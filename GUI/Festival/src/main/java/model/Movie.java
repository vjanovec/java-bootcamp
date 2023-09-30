/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.vojtechjanovec.festival.sqldriver;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Movie {
    private String name;
    private ArrayList<String> actors;
    private Date date;
    private String cinemaName;
    private sqldriver DB;

    public Movie() {
        try {
            this.DB = sqldriver.getInstance();
        } catch(ClassNotFoundException e) {
//            Logger.getLogger(Movie.class.getName().log(LEVEL.SEVERE, null, e));
        }
    }
    
    
}
