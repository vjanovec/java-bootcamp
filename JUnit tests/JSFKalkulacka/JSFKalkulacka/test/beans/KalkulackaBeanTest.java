/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.pageobjects.KalkulackaPage;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertEquals;
import org.openqa.selenium.WebElement;

/**
 *
 * @author tunik
 */
public class KalkulackaBeanTest {

    private static final String URL = "http://localhost:8080/JSFKalkulacka/";
    private static final int TIMEOUT = 10;

    private WebDriver driver;
    
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test of vypocitej method, of class KalkulackaBean.
     */
    @Test
    public void testVypocitej() {
        driver.get(URL);
        driver.manage().deleteAllCookies();
        WebElement cislo1 = driver.findElement(By.id("cislo1"));
        cislo1.clear();
        cislo1.sendKeys("1");
        WebElement cislo2 = driver.findElement(By.id("cislo2"));
        cislo2.clear();
        cislo2.sendKeys("1");
        Select operace = new Select(driver.findElement(By.id("operace")));
        operace.selectByValue("+");
        driver.findElement(By.id("odeslat")).click();
        assertEquals("2.0", driver.findElement(By.id("vysledek")).getText());
    }

    /**
     * Test of vypocitej method, of class KalkulackaBean.
     */
    @Test
    public void testVypocitejObject() {
        driver.get(URL);
        driver.manage().deleteAllCookies();
        KalkulackaPage kalkulackaPage = new KalkulackaPage(driver);
        kalkulackaPage.setCislo1(1).setCislo2(1).setOperace("+").vypocitej();
        assertEquals("2.0", driver.findElement(By.id("vysledek")).getText());
    }
}
