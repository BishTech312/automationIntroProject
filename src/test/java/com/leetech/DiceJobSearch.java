package com.leetech;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DiceJobSearch {


    public static void main(String[] args) throws InterruptedException {

        //Set up Chrome Driver Path
        WebDriverManager.chromedriver().setup();

        //Invoke Selenium WebDriver
        WebDriver driver = new ChromeDriver();

        // FullScreen the dice website
        driver.manage().window().fullscreen();

        //Set universal wait time in case web page is slow
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 // If you use Thread.sleep , in that case your java code stops for 10 seconds.
        /*
        When you using implicit wait , if after five second is already available
        it will continue to next steps. It's not gonna wait for whole 10 seconds
        Efficient way.
        But sometimes we use Thread.sleep as well.
         */


        /*
        Step1: Launch browser  and navigate to https://dice.com
        Expected : dice home page should be displayed
         */

  String url ="https://dice.com";
  driver.get(url);

  String keyword ="Java developer";
  driver.findElement(By.xpath("//input[@class='form-control ng-tns-c2-0 ng-star-inserted']")).clear();
  driver.findElement(By.xpath("//input[@class='form-control ng-tns-c2-0 ng-star-inserted']"))
          .sendKeys(keyword);

  String location ="Chicago ,IL,USA,60659";

  driver.findElement(By.id("google-location-search")).sendKeys(location);

  Thread.sleep(3000);

  driver.findElement(By.xpath("//button [@class='btn btn-block btn-primary btn-efc-primary']")).click();

  String Jobs= driver.findElement(By.id("totalJobCount")).getText();

  System.out.println(Jobs);
  int Result =Integer.parseInt(Jobs.replace(",",""));

  if(Result>0){
      System.out.println("Keyword :" + keyword + " search returned " + Result + " results in ");
  }else{
      System.out.println("Test is Fail");
  }
driver.close();

    }
}
