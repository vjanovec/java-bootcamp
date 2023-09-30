/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;


import Model.Performances;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lmasic
 */
public class DefaultControler {
    private Performances Performancemodel = new Performances();

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
}
