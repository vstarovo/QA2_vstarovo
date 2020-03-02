import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstWebTest {
   // private By articalTitle = By.xpath(".//h1[contains(@class, 'headline__title')]"); - ne konstanta
      private By ARTICAL_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
      private By ARTICAL_PAG_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
      private final Logger LOGGER = LogManager.getLogger(FirstWebTest.class);

      private WebDriver driver; // null

    @Test
    public void delfiTest() {
        LOGGER.info("Setting upp driver path");
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe"); // nahozdenie drivera

        LOGGER.info("Opennig browser");
        driver = new ChromeDriver(); //

        LOGGER.info("Maximizing window");
        driver.manage().window().maximize(); // raskroet na ves ekran

        LOGGER.info("Opening Delfi home page");
        driver.get("http://rus.delfi.lv");

        LOGGER.info("Printing all articles titles: ");
       List<WebElement> articles = driver.findElements(ARTICAL_TITLE);
       for (int i =0; i < articles.size(); i=i+2) {

           if (articles.get(i).getText().length() != 0) {
             LOGGER.info(i + ": " + articles.get(i).getText());
          // System.out.println(i + ": " + articles.get(i).getText());
           }
       }


/*
        // Find 1st title element
       // WebElement firstTitle = driver.findElement(By.xpath(".//h1[contains(@class, 'headline__title')]"));
        WebElement firstTitle = driver.findElement(ARTICAL_TITLE);


        String firstTitleText = firstTitle.getText();

        // Click on this element
        firstTitle.click();

        // Find article's title element
       WebElement articleTitle = driver.findElement(ARTICAL_PAG_TITLE);

        // Get and save element text
        String articalTitleText = articleTitle.getText();

        // Check
        Assertions.assertEquals(firstTitleText, articalTitleText, "Wrong article title!");

 */
    }
    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}
