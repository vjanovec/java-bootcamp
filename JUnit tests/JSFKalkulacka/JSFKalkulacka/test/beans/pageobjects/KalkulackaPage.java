/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author tunik
 */
public class KalkulackaPage {
    
    private final WebDriver driver;

    @FindBy(id = "cislo1")
    private WebElement cislo1;

    @FindBy(id = "cislo2")
    private WebElement cislo2;

    @FindBy(id = "operace")
    private WebElement operace;

    @FindBy(id = "odeslat")
    private WebElement odeslat;

    public KalkulackaPage(WebDriver driver) {
        this.driver = driver;
        // Obvykle v BaseObject a validace aktuální URL adresy.
        PageFactory.initElements(driver, this);
    }

    public KalkulackaPage setCislo1(Integer cislo1) {
        this.cislo1.clear();
        this.cislo1.sendKeys(cislo1.toString());
        return this;
    }

    public KalkulackaPage setCislo2(Integer cislo2) {
        this.cislo2.clear();
        this.cislo2.sendKeys(cislo2.toString());
        return this;
    }

    public KalkulackaPage setOperace(String operace) {
        Select select = new Select(this.operace);
        select.selectByValue(operace);
        return this;
    }

    public void vypocitej() {
        this.odeslat.click();
    }
}
