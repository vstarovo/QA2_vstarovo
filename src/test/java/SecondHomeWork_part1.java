import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SecondHomeWork_part1 {

    private By SECOND_ARTICAL_TITLE = By.xpath("(.//h1[contains(@class,'headline__title')])[2]");
    private By ARTICAL_PAG_TITLE = By.xpath(".//h1[contains(@class,'d-inline')]");
    private By COMMMENT_ARTICAL_TITLE = By.xpath("(.//a[contains(@class,'comment-count')])[2]");
    private By COMMMENT_PAG_ARTICAL_TITLE = By.xpath(".//h1[@class= 'article-title']");

    @Test
    public void delfiTestHome() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.delfi.lv");

        WebElement secondTitle = driver.findElement(SECOND_ARTICAL_TITLE);

        String secondTitleText = secondTitle.getText();

        secondTitle.click();

        WebElement articalTitle = driver.findElement(ARTICAL_PAG_TITLE);

        String articalTitleText = articalTitle.getText();
        System.out.println(articalTitleText);

        Assertions.assertEquals(secondTitleText, articalTitleText, "Wrong article title!");

        driver.navigate().back();

        WebElement commentCountTitle = driver.findElement(COMMMENT_ARTICAL_TITLE);

        commentCountTitle.click();

          WebElement articaCommentTitle = driver.findElement(COMMMENT_PAG_ARTICAL_TITLE);

        String articalCommentTitleText = articaCommentTitle.getText();

        Assertions.assertEquals(secondTitleText, articalCommentTitleText, "Wrong article commet title!");
        System.out.println("Compering :" + articalTitleText.compareTo(articalCommentTitleText));

        driver.close();


    }


}
