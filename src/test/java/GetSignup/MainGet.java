package GetSignup;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.tools.ant.taskdefs.WaitFor;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainGet {


    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "E:\\driver\\chromedriver.exe");
         WebDriver driver = new ChromeDriver();

        //Mazimize current window
        driver.manage().window().maximize();
        driver.get("https://phptravels.net/signup");


        //provide test data csv file
        String CSV_path = "E:\\GetAutomationTask/TestData.csv";

        CSVReader csvReader;
        String[] csvCell;


        // create an object of csvReader
        csvReader = new CSVReader(new FileReader(CSV_path));
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //You can use while loop like below, It will be executed until the last line in CSV used.
        while ((csvCell = csvReader.readNext()) != null) {

            String FirstName = csvCell[0];
            String LastName = csvCell[1];
            String Phone = csvCell[2];
            String Email = csvCell[3];
            String Password = csvCell[4];
            // first name
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/form/div[1]/div/input")).clear();
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys(FirstName);
            // last name
            driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[2]/div/input")).clear();
            driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[2]/div/input")).sendKeys(LastName);
            // Phone
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/form/div[3]/div/input")).clear();
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/form/div[3]/div/input")).sendKeys(Phone);
            // E-Mail
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/form/div[4]/div/input")).clear();
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/form/div[4]/div/input")).sendKeys(Email);
            // Password
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/form/div[5]/div/input")).clear();
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/form/div[5]/div/input")).sendKeys(Password);
            // scroll down
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", "");
            // select account type
            //driver.wait(100);
            // driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/form/div[6]/div/div/span/span[1]/span/span[1]")).click();
            // click select one type
            //driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[3]")).click();
            // click not robot
            //driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]")).click();
// click on sign up
            driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/div/form/div[8]/button")).click();
            Screenshoot.captureScreenshot(driver,"name of screenshot");
// close application
            driver.quit();
        }
    }


    }
