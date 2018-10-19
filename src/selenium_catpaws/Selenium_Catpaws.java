/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium_catpaws;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.print.Printer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Vipul Chandoor
 */
public class Selenium_Catpaws {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        // TODO code application logic here
        Scanner ScanID = new Scanner(new File("IDs.txt"));
        Scanner ScanPWD = new Scanner(new File("PWDs.txt"));
        PrintWriter PrintOutput = new PrintWriter(new File("Output.txt"));

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\S530459\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ssb.nwmissouri.edu/pls/PRODDAD/twbkwbis.P_GenMenu?name=homepage");
        WebElement clickOnLogin = driver.findElement(By.id("contentItem0"));
        clickOnLogin.click();
        System.out.println("Website Opened");
        while (ScanID.hasNext()) {
            
//          clickOnLogin.click();
            WebElement userid = driver.findElement(By.id("UserID"));
            String str = ScanID.next();
            userid.sendKeys(str);
            System.out.println(str);
//        String str = scanid.next();
//        userid.sendKeys("919559456");  
            WebElement password = driver.findElement(By.name("PIN"));
            password.sendKeys(ScanPWD.next());
//          password.click();
//          password.sendKeys("228782");
            Thread.sleep(2000);
            password.submit();
            if(!"https://ssb.nwmissouri.edu/pls/PRODDAD/twbkwbis.P_ValLogin".equals(driver.getCurrentUrl())){
            WebElement student = driver.findElement(By.id("bmenu--P_StuMainMnu___UID1"));
            student.click();
            Thread.sleep(2000);
           
            PrintOutput.println(true);
            }else{
            PrintOutput.println(false);
            }
            
            driver.get("https://ssb.nwmissouri.edu/pls/PRODDAD/twbkwbis.P_GenMenu?name=homepage");
            clickOnLogin = driver.findElement(By.id("contentItem0"));
            clickOnLogin.click();
   
        }
     
            ScanID.close();
            ScanPWD.close();
            PrintOutput.close();
            driver.quit();
    }

}
