package Project;
 

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class Activity6 {
	    WebDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setUp() {
	        // Set the path to the chromedriver executable
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Initialize the Chrome driver
	        driver = new ChromeDriver();

	        // Initialize the WebDriverWait
	        
	    }

	    @Test
	    public void verifyTitle() {
	        // Navigate to the URL
	        driver.get("https://alchemy.hguy.co/jobs");

	        // Get the title of the page
	        String title = driver.getTitle();

	        // Expected title
	        String expectedTitle = "Alchemy Jobs – Job Board Application";

	        // Verify the title
	        Assert.assertEquals(title, expectedTitle, "Title does not match!");
	    }

	    @Test
	    public void verifyHeading() {
	        // Navigate to the URL
	        driver.get("https://alchemy.hguy.co/jobs");

	        // Locate the heading element
	        WebElement heading = driver.findElement(By.xpath("//h1[@class='entry-title']"));

	        // Get the text of the heading
	        String headingText = heading.getText();

	        // Expected heading text
	        String expectedHeading = "Welcome to Alchemy Jobs";

	        // Verify the heading text
	        Assert.assertEquals(headingText, expectedHeading, "Heading does not match!");
	    }

	    @Test
	    public void verifyHeaderImageURL() {
	        // Navigate to the URL
	        driver.get("https://alchemy.hguy.co/jobs");

	        // Locate the header image element
	        WebElement headerImage = driver.findElement(By.xpath("//img[@class='attachment-large size-large wp-post-image']"));

	        // Get the URL of the header image
	        String headerImageURL = headerImage.getAttribute("src");

	        // Expected header image URL (replace with the actual expected URL)
	        String expectedHeaderImageURL = "https://alchemy.hguy.co/wp-content/uploads/2020/07/alchemy.jpg";

	        // Verify the header image URL
	        Assert.assertEquals(headerImageURL, expectedHeaderImageURL, "Header image URL does not match!");
	    }

	    @Test
	    public void verifySecondTitle() {
	        // Navigate to the URL
	        driver.get("https://alchemy.hguy.co/jobs");

	        // Locate the second title element
	        WebElement secondTitle = driver.findElement(By.xpath("(//h2)[2]"));

	        // Get the text of the second title
	        String secondTitleText = secondTitle.getText();

	        // Expected second title text (replace with the actual expected text)
	        String expectedSecondTitleText = "Second Title Here";

	        // Verify the second title text
	        Assert.assertEquals(secondTitleText, expectedSecondTitleText, "Second title does not match!");
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

	    @Test
	    public void applyForJob() {
	        // Navigate to the URL
	        driver.get("https://alchemy.hguy.co/jobs");

	        // Find the navigation bar and click the "Jobs" menu item
	        WebElement jobsMenuItem = driver.findElement(By.linkText("Jobs"));
	        jobsMenuItem.click();

	        // Locate the search box
	        WebElement searchBox = driver.findElement(By.id("search_keywords"));

	        // Enter the job title to search
	        String jobTitle = "Test Engineer"; // Replace with the job title you want to search
	        searchBox.sendKeys(jobTitle);

	        // Click the search button
	        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Search Jobs']"));
	        searchButton.click();

	        // Wait for the job listings to appear
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("position")));

	        // Click on the first job listing
	        WebElement firstJobListing = driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a"));
	        firstJobListing.click();

	        // Wait for the job details page to load
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("entry-title")));

	        // Click on the "Apply for job" button
	        WebElement applyButton = driver.findElement(By.xpath("//input[@value='Apply for job']"));
	        applyButton.click();

	        // Verify that the application process has started (e.g., an email or link is shown)
	        WebElement applicationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("application_details")));
	        Assert.assertTrue(applicationMessage.isDisplayed(), "Application details are not displayed!");

	        // Print application details (if needed)
	        System.out.println(applicationMessage.getText());
	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}

	
}
