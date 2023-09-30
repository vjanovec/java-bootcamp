package beans;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/*
 *	       __          __                __            
 *	  ____/ /__ _   __/ /_  ____  ____  / /__ _________
 *	 / __  / _ \ | / / __ \/ __ \/ __ \/ //_// ___/_  /
 *	/ /_/ /  __/ |/ / /_/ / /_/ / /_/ / ,< _/ /__  / /_
 *	\__,_/\___/|___/_.___/\____/\____/_/|_(_)___/ /___/
 *                                                   
 *                                                           
 *      TUTORIÁLY  <>  DISKUZE  <>  KOMUNITA  <>  SOFTWARE
 * 
 *	Tento zdrojový kód je součástí tutoriálů na programátorské 
 *	sociální síti WWW.DEVBOOK.CZ	
 *	
 *	Kód můžete upravovat jak chcete, jen zmiňte odkaz 
 *	na www.devbook.cz :-) 
 */
@Named
@RequestScoped
public class KalkulackaBean {

    /**
     * První číslo
     */
    private double cislo1;
    /**
     * Druhé číslo
     */
    private double cislo2;
    /**
     * Výsledek
     */
    private double vysledek;
    /**
     * Vybraná operace
     */
    private String operace;
    /**
     * Možné operace k výběru
     */
    private Map<String, String> mozneOperace;
    
    /**
     * Inicializace beanu
     */
    public KalkulackaBean() {
        mozneOperace = new LinkedHashMap<>();
        mozneOperace.put("Sečti", "+");
        mozneOperace.put("Odečti", "-");
        mozneOperace.put("Vynásob", "*");
        mozneOperace.put("Vyděl", "/");
    }
    
    /**
     * Vypočítá výsledek dle zvolené operace
     */
    public void vypocitej()
    {
        switch (getOperace())
        {
            case "+":
                vysledek = getCislo1()+ getCislo2();
                break;
            case "-":
                vysledek = getCislo1()- getCislo2();
                break;
            case "*":
                vysledek = getCislo1()* getCislo2();
                break;
            case "/":
                vysledek = getCislo1()/ getCislo2();
                break;
        }
        
    }

    /**
     * @return the cislo1
     */
    public double getCislo1() {
        return cislo1;
    }

    /**
     * @param cislo1 the cislo1 to set
     */
    /**
     * 
     * @param cislo1 
     */
    public void setCislo1(double cislo1) {
        this.cislo1 = cislo1;
    }

    /**
     * @return the cislo2
     */
    public double getCislo2() {
        return cislo2;
    }

    /**
     * @param cislo2 the cislo2 to set
     */
    public void setCislo2(double cislo2) {
        this.cislo2 = cislo2;
    }

    /**
     * @return the vysledek
     */
    public double getVysledek() {
        return vysledek;
    }

    /**
     * @return the operace
     */
    public String getOperace() {
        return operace;
    }

    /**
     * @param operace the operace to set
     */
    public void setOperace(String operace) {
        this.operace = operace;
    }

    /**
     * @return the mozneOperace
     */
    public Map<String, String> getMozneOperace() {
        return mozneOperace;
    }

   
    
}
