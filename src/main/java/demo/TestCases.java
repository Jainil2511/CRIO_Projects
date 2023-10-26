package src.main.java.demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
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

    public void countHyperlinks() throws InterruptedException, IOException{
    
        //Navigate to URL  www.bookmyshow.com
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
    
        // Get the count of hyperlinks Using Locator "XPath" //a[@href] / size()
        List<WebElement> hyperlinks = driver.findElements(By.xpath("//a[@href]"));
        
        // Print the number of hyperlinks  System.out.println()
        System.out.println("Hyperlinks present on Book my show page are: " + hyperlinks.size());
    }

    public void postOnLinkedIn() throws InterruptedException, IOException{

        // Navigate to URL  https://in.linkedin.com
        driver.get("https://in.linkedin.com");

        // Enter text on email or phone text box Using Locator "XPath" //input[@autocomplete='username']/sendKeys("abc123@gmail.com")
        WebElement usernametxtBox = driver.findElement(By.xpath("//input[@autocomplete='username']"));
        usernametxtBox.click();
        usernametxtBox.sendKeys("abc123@gmail.com");

        // Enter text on password text box Using Locator "xpath" //input[@autocomplete='current-password']/sendKeys("******")
        WebElement passwordtxtBox = driver.findElement(By.xpath("//input[@autocomplete='current-password']"));
        passwordtxtBox.click();
        passwordtxtBox.sendKeys("******");

        // Click on sign in button  Using Locator "XPath" //button[contains(text(),'Sign in')]
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

        // Locate profile viewers and get count  Using Locator "XPath" //ul[@class='entity-list row']//child::li[1]//child::a//child::div//child::div[2] /.getText()
        String profileViews = driver.findElement(By.xpath("//ul[@class='entity-list row']//child::li[1]//child::a//child::div//child::div[2]")).getText();
        System.out.println("Profile viewers: " + profileViews);

        // Locate post impressions and get count Using Locator "XPath" //ul[@class='entity-list row']//child::li[2]//child::a//child::div//child::div[2] / .getText()
        String postImpressions = driver.findElement(By.xpath("//ul[@class='entity-list row']//child::li[2]//child::a//child::div//child::div[2]")).getText();
        System.out.println(("Post impressions: " + postImpressions));

        // Click on Start a post button Using Locator "XPath" //button[contains(@class , 'share-box-feed-entry_')]
        driver.findElement(By.xpath("//button[contains(@class , 'share-box-feed-entry_')]")).click();

        // Click on post setting button with 'Connections only' Using Locator "XPath" | //button[contains(@class,'entry-button')]
        driver.findElement(By.xpath("//button[contains(@class,'entry-button')]")).click();

        // Click on connections only button Using Locator "ID" CONNECTIONS_ONLY
        driver.findElement(By.id("CONNECTIONS_ONLY")).click();

        // Click on Done button Using Locator "XPath" //span[text()='Done']
        driver.findElement(By.xpath("//span[text()='Done']")).click();

        // Enter text on text box Using Locator xpath "//div[@aria-placeholder='What do you want to talk about?']"|sendKeys("CRIO Masters in QA automation")
        WebElement textField = driver.findElement(By.xpath("//div[@aria-placeholder='What do you want to talk about?']"));
        textField.click();
        textField.sendKeys("CRIO Masters in QA automation");

        // Click on post button Using Locator "xpath" //span[text()='Post']
        driver.findElement(By.xpath("//span[text()='Post']")).click();

        // Confirm User name in Different shows in page using locator xpath "//span[@dir='ltr' and text()='Jainil Hirpara']"
        Boolean userNameValidation = driver.findElement(By.xpath("//span[@dir='ltr' and text()='Jainil Hirpara']")).isDisplayed();
        System.out.println("Post is created with user name Jainil Hirpara in it: " + userNameValidation);

        // LinkedIn page validate CRIO Masters in QA automation Using Locator "XPath" //span[text()='CRIO Masters in QA automation']/isDisplayed()
        Boolean postValidation = driver.findElement(By.xpath("//span[text()='CRIO Masters in QA automation']")).isDisplayed();
        System.out.println("In post confirm CRIO Masters in QA automation text exists: " + postValidation);

    }
}



