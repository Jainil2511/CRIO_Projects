package src.main.java.demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.lang.InterruptedException;
// Webdriver Manager imports
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        System.out.println("end Test case: testCase02");
    }

    public  void nestedFramesText() throws InterruptedException{
        
        // Navigate to URL   https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Switch to top frame driver.switchTo().frame('frame-top')
        driver.switchTo().frame("frame-top");

        // // Switch to left frame  driver.switchTo().frame('frame-left')
        driver.switchTo().frame("frame-left");
        
        // // Get LEFT text element and print text  Using Locator "XPath" /html/body | getText()
        String lft = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Left frame text: " + lft);

        // // Move back to parent frame  /html/body | getText()
        driver.switchTo().parentFrame();

        // //Switch to middle frame  driver.switchTo().frame('frame-middle')
        driver.switchTo().frame("frame-middle");

        // // Get MIDDLE text element and print  text Using Locator "ID" id='content' | getText()
        String middleTxt = driver.findElement(By.id("content")).getText();
        System.out.println("Middle frame text: "+ middleTxt);

        // // Move back to parent frame  driver.switchTo().parentFrame()
        driver.switchTo().parentFrame();

        // // Switch to right frame  driver.switchTo().frame('frame-right')
        driver.switchTo().frame("frame-right");

        // // Get RIGHT text element and print text Using Locator "XPath" /html/body | getText()
        String rgtTxt = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Right frame text: " + rgtTxt);

        // // Move back to default frame  driver.switchTo().defaultContent()
        driver.switchTo().defaultContent();

        // Switch to bottom frame  driver.switchTo().frame('frame-bottom')
        driver.switchTo().frame("frame-bottom");

        //  Get BOTTOM text element and print text  /html/body | getText()
        String btmTxt = driver.findElement(By.xpath("/html/body")).getText();
        System.out.println("Bottom frame text: " + btmTxt);
    }

    public  void searchAmazon() throws InterruptedException, IOException{

    //Navigate to URL  https://www.google.co.in/
    driver.get("https://www.google.co.in/");

    // Click on search bar and enter text on that Using Locator "ID" APjFqb | SendKeys("amazon")
    WebElement searchBar = driver.findElement(By.id("APjFqb"));
    searchBar.click();
    searchBar.sendKeys("amazon");

    // Click on Google search button Using Locator "XPath" //input[@value='Google Search']
    driver.findElement(By.xpath("//input[@value='Google Search']")).click();

    // Search result page validate Amazon.in present or not Using Locator "XPath" 
    WebElement amazonUrl = driver.findElement(By.xpath("//span[text()='Amazon.in']"));
    System.out.println("Amazon.in is searched in google: " + amazonUrl.isDisplayed());
    }
}



