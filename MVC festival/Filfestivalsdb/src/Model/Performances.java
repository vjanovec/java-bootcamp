/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author lmasic
 */
public class Performances {

    private sqldriver DB;

    //TODO: předělat na singleton
    public Performances() {
        try {
            //TODO: parametry připojení k DB
            this.DB = sqldriver.getInstance();
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sqldriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
     public ArrayList<ArrayList<String>> getListperformancesOfmovie(
            String moovie) {

    }
    public ArrayList<ArrayList<String>> getListperformancesOfmovie(
            String moovie, ArrayList<Date> date, String cinameName) {
        
    }
*/
    public ArrayList<String> getAllMovies() throws SQLException {
        ArrayList<String> ret = new ArrayList<String>();
        
       
        String str = null;

        
        for (ArrayList<Object> m : this.DB.singleSelectQ("movie","")) {

            for (Object o : m) {
                if (o==null) continue;
                if (o instanceof String) {
                    str = (String) o ;
                    ret.add(str);
                }
                
            }

        }
        ret = new ArrayList<>(ret.stream().filter(m -> !m.equals("db") && !m.equals("tt")).collect(Collectors.toList()));


    return ret;
}

    public ArrayList<String> getAllCinemas() throws SQLException {
        ArrayList<String> ret = new ArrayList<>();
        String str = null;

        for(ArrayList<Object> c : this.DB.singleSelectQ("cinema", "")) {
            for(Object o : c) {
                if(o==null) continue;
                if(o instanceof String) {
                    str = (String) o;
                    ret.add(str);
                }
            }
        }
        return ret;
    }
    
    public ResultSet getAllProjection() throws SQLException {
        ResultSet rs = DB.querySelect("SELECT movie.name as movieName, cinema.name as cinemaName, cinema.capacity, genre.name as genreName, movie.year, movie.ddtt, actor.name as actorName FROM projection inner join cinema on projection.idCinema = cinema.idCinema inner join movie on projection.idMovie = movie.idMovie inner join genre on genre.idGenre = movie.idGenre inner join actor on actor.idActor = movie.idActor;");
        while (rs.next()) {
            String movieName = rs.getString("movieName");
            String cinemaName = rs.getString("cinemaName");
            int capacity = rs.getInt("capacity");
            String genreName = rs.getString("genreName");
            int year = rs.getInt("year");
            String ddtt = rs.getString("ddtt");
            String actorName = rs.getString("actorName");
             System.out.println(movieName+" "+cinemaName+" "+capacity+" "+genreName+" "+year+" "+ddtt+" "+actorName);
        }
        return rs;
    }
    
/*
     Vrátí všechny filmy promítaní v zadané dny
 */
    
      /*
public ArrayList<String> getAllMoviesPerdays(ArrayList<Date> dates) {
     
     }
     
      /*
     Vrátí všechny filmy promítaní v kinosále
     
     public ArrayList<String> getAllMoviesInCinema(String cinema) {
     
     }*/
}
