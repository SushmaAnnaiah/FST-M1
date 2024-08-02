package Project;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;

public class Activity4 {
    WebDriver driver;

    @BeforeClass
    
        
    	public void beforeMethod() {
    	       
            WebDriverManager.firefoxdriver().setup();
        
            driver = new FirefoxDriver();
            
            //Open browser
            driver.get("https://alchemy.hguy.co/jobs");
        }

   
    
    @Test
    
    public void verifySecondTitle() {
    	   driver.get("https://alchemy.hguy.co/jobs");

    	   WebElement header2 = driver.findElement(By.cssSelector(".entry-content > h2:nth-child(6)"));
    	   System.out.println("Second title: "+ "Quia quis non");
           Assert.assertEquals(header2.getText(), "Quia quis non");
           
          
 
       }
        

  

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

