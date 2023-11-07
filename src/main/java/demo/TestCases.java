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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Set;



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

    public void imdbRatings() throws InterruptedException, IOException{

        // Navigate to URL https://www.imdb.com/chart/top/
        driver.get("https://www.imdb.com/chart/top/");

        // Find list of movies shown in page using xpath "//li[contains(@class,'cli-parent')]" | size()
        List<WebElement> MoviesList = driver.findElements(By.xpath("//li[contains(@class,'cli-parent')]"));
        System.out.println("Included movies in table: " + MoviesList.size());

        // Locate first movie in the list and get text from this locator By xpath "//div[@class='ipc-metadata-list-summary-item__c']//h3" | getText()
        String highestRatedMovieonIMDB =  driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3")).getText();
        String movieName = highestRatedMovieonIMDB.split(" ", 2)[1];
        System.out.println("Highest rated movie on IMDB is: " + movieName);

        // Create object of select class by passing webelement of dropdown by xpath "//select[@id='sort-by-selector']"
        Select select = new Select(driver.findElement(By.xpath("//select[@id='sort-by-selector']")));

        // Selecte dropdown by text select.selectByVisibleText("Release date");
        select.selectByVisibleText("Release date");

        // Locate first movie in the list and get text from this locator By xpath "//div[@class='ipc-metadata-list-summary-item__c']//h3" | getText()
        String mostRecentMovie = driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3")).getText();
        String mostRecentMovieInList = mostRecentMovie.split(" ", 2)[1];

        // Locate released year by using xapth "//div[@class='ipc-metadata-list-summary-item__c']//following::span" | getText()
        String releasedYear = driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//following::span")).getText();
        System.out.println("Most recent movie on the list is " + mostRecentMovieInList + " released in " + releasedYear);

        // Click on swap button using id "swap-sort-order-button"
        driver.findElement(By.id("swap-sort-order-button")).click();

        // Locate first movie in the list and get text from this locator By xpath "//div[@class='ipc-metadata-list-summary-item__c']//h3" | getText()
        String oldestMovie = driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3")).getText();
        String oldestMovieInList = oldestMovie.split(" ", 2)[1].trim();

        // Locate released year of movie by using xpath and get text from the locator "//div[@class='ipc-metadata-list-summary-item__c']//following::span" | getText()
        String releasedYear1 = driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//following::span")).getText();
        System.out.println("Oldest movie on the list is " + oldestMovieInList + " released in " + releasedYear1);

        // In dropdown select By text "Number of ratings"
        select.selectByVisibleText("Number of ratings");

        // Locate first movie in the list by xpath "//div[@class='ipc-metadata-list-summary-item__c']//h3" | getText()
        String mostUserRatings = driver.findElement(By.xpath("//div[@class='ipc-metadata-list-summary-item__c']//h3")).getText();
        String mostUserRatingsMovie = mostUserRatings.split(" ", 2)[1];
        System.out.println(mostUserRatingsMovie + " Movie has the most user ratings");
        
    }
    
    public void windowHandle() throws IOException, InterruptedException{

        // Navigate to url  https://www.w3schools.com/jsref/tryit.aspfilename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        // Get parent page window handle
        String parentPage = driver.getWindowHandle();

        // Switch to the iframe which contain Try it button
        driver.switchTo().frame("iframeResult");

        // Click on try it button Using Locator "XPath" //button[text()='Try it']
        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        // Create set and get window handles
        Set<String> allWindows = driver.getWindowHandles();

        // Using loop move access of selenium to newly opened window 
        for (String window: allWindows) {
            if (!window.equals(parentPage)) {
                driver.switchTo().window(window);
                // Get the URL, Title newly opened window
                System.out.println("URL of the newly opened window: " + driver.getCurrentUrl());
                System.out.println("Title of the newly opened window: " + driver.getTitle());
                Thread.sleep(2000);
                // Get the screenshot of newly opened window
                TakesScreenshot scrShot = ((TakesScreenshot) driver);
                File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
                String fileName = "Screenshot1.png";
                File Destfile = new File(fileName);
                FileUtils.copyFile(SrcFile, Destfile);
                
                // Close newly opened window  driver.close()
                driver.close();
            }
        } 
        Thread.sleep(2000);
        // Switch back to the original window  driver.switchTo().window()
        driver.switchTo().window(parentPage);
      
    }

    public void imageUrls() throws IOException, InterruptedException{

        // Navigate to URL  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");

        // Create list of web elements  Using Locator "XPath" //div[contains(@class,'style__RelativeContainer')]//img[@src]
        driver.findElement(By.xpath("//div[contains(@class,'style__RelativeContainer')]//*[local-name()='svg']")).click();
        Thread.sleep(1000);
        List<WebElement> recommendedMovies = driver.findElements(By.xpath("//div[contains(@class,'style__RelativeContainer')]//img[@src]"));

        // Print the URLs  getAttribute("src")
        // for (WebElement movie : recommendedMovies) {
        //     System.out.println("Recommended movie URL is: " + movie.getAttribute("src"));
        // }
        for(int i = 0; i < recommendedMovies.size(); i++){
            System.out.println(i+1 +". Recommended movie URL is: " + recommendedMovies.get(i).getAttribute("src"));
        }

        Thread.sleep(2000);

        // Use JavascriptExecutor to scroll to the premiere movies list
        // WebElement premiereMovieList = driver.findElement(By.xpath("//*[text()='Premieres']"));
        // Actions actions = new Actions(driver);
        // actions.moveToElement(element).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,509.53)");

        Thread.sleep(2000);

        // By using xpath axes locate 2nd item in the Premieres movies list Using Locator "XPath" getAttribute("src")
        // From this element print name&language of that 2nd movie
        WebElement secondMovie = driver.findElement(By.xpath("//*[text()='Premieres']//ancestor::div[3]//following-sibling::div//a[2]//child::div//div[3]"));
        String nameandLangofMovie = secondMovie.getText();
        System.out.println("Name & Language of second movie in premieres list: " + nameandLangofMovie);
    }
}



