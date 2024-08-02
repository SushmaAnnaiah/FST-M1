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

public class Activity5 {
    WebDriver driver;

    @BeforeClass
    
        
    	public void beforeMethod() {
    	       
            WebDriverManager.firefoxdriver().setup();
        
            driver = new FirefoxDriver();
            
            //Open browser
            driver.get("https://alchemy.hguy.co/jobs");
        }

    @Test
    public void verifyTitle() {
        
    	   System.out.println("Page title is: " + "Alchemy Jobs – Job Board Application");

        

       
        Assert.assertEquals(driver.getTitle(), "Alchemy Jobs – Job Board Application");
      
    }
    
    @Test
    
    public void verifyHeading() {
        
        driver.get("https://alchemy.hguy.co/jobs");
        
        WebElement heading = driver.findElement(By.xpath("//h1[@class='entry-title']"));
        System.out.println("Heading: " + "Welcome to Alchemy Jobs");
        
        Assert.assertEquals(heading.getText(),"Welcome to Alchemy Jobs");
        
    }
  
    @Test
    
    public void verifyHeaderImageURL() {
    	  
    	    	// identify image
    	        WebElement image_link = driver.findElement(By.xpath("//img[@itemprop='image']"));
    	        //getAttribute() to get src of image
    	        System.out.println("Src attribute is: "+ image_link.getAttribute("src"));
    	 
    	    }
    
    @Test
    public void navigateToJobsPage() {
        // Navigate to the URL
        driver.get("https://alchemy.hguy.co/jobs");

        // Find the navigation bar and click the "Jobs" menu item
        WebElement jobsMenuItem = driver.findElement(By.linkText("Jobs"));
        jobsMenuItem.click();

        // Get the title of the new page
        String jobsPageTitle = driver.getTitle();

        // Expected title of the Jobs page
        String expectedJobsPageTitle = "Jobs – Alchemy Jobs";

        // Verify the Jobs page title
        Assert.assertEquals(jobsPageTitle, expectedJobsPageTitle, "Jobs page title does not match!");
        
    }
    
     @AfterClass
     public void tearDown() {
        // Close the browser
        driver.quit();
    
}


}
