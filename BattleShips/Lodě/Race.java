/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Director itSTEP
 */
public class Race {

    private int lenght = 0;//v metech
    private ArrayList<Car> cars = new ArrayList<Car>();
    private ArrayList<RaceResult> raceResults = new ArrayList<RaceResult>();
    private boolean ready = false;

    public Race(int lenght) {

        this.lenght = lenght;
    }

    public void addRacingCar(Car car) {
        if (!ready) {
            this.cars.add(car);
        }
    }

    public String getWinner() {
        if (ready) {
            return this.raceResults.get(0).car.toString();
        } else {
            return null;
        }
    }

    public void getResult() throws Exception {
        if (!ready) {
            ready = true;

            for (int i = 0; i < this.cars.size(); i++) {
                this.raceResults.add(
                        new RaceResult(this.cars.get(i),
                        new Timespan(
                                this.lenght / this.cars.get(i).getSpeed()
                                    )
                                       )
                );
                Collections.sort(this.raceResults);
                
            }

        }

    }

}
