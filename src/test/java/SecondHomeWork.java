import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SecondHomeWork {

    private By articleElementTag = By.tagName("article");
    private By articleTitleElement = By.xpath(".//h1[contains(@class,'headline__title')]");
    private By commentCountElement = By.xpath(".//a[contains(@class, 'comment-count')]"); // jaraksta camelcase
    private By articlePageTitleElement = By.xpath(".//h1[contains(@class,'d-inline')]");
    private By articlePageCommentElements = By.xpath(".//a[contains(@class, 'text-red-ribbon')]");
    private By commentPageTheArticleTitleElement = By.xpath(".//h1[@class= 'article-title']");
    private By comentPageTheCommentCountElements = By.xpath(".//span[@class= 'type-cnt']");

    private final Logger LOGGER = LogManager.getLogger(FirstWebTest.class);
    private WebDriver driver; // null

    @Test
    public void delfiTestHome() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");

        LOGGER.info("Find 2st Article element");
        List<WebElement> allArticles = driver.findElements(articleElementTag);
        WebElement secondArticle = allArticles.get(1);
        LOGGER.info("Get second article title text");
        String articleTitleText = secondArticle.findElement(articleTitleElement).getText().replaceAll("\"", "").trim();
        LOGGER.info("Get second article title comment count");
        List<WebElement> commentCountElements = secondArticle.findElements(commentCountElement);
        LOGGER.info("Get and save article page count element text");
        String titleCommentCount = "0";
        if (!commentCountElements.isEmpty()) {
            titleCommentCount = commentCountElements.get(0).getText();
        }
        LOGGER.info("string to int");
        titleCommentCount = titleCommentCount.replaceAll("[^0-9]","");
        int toIntTitleCommentCount = Integer.parseInt(titleCommentCount);

        LOGGER.info("secondTitleText: " + articleTitleText + " The commnet count:  " + toIntTitleCommentCount);
        LOGGER.info("Click on article Title element");
        secondArticle.click();

        LOGGER.info(  "Into artital page find article title element");
        WebElement articlePageTitle = driver.findElement(articlePageTitleElement);
        LOGGER.info("Get and save the artical page title's text");
        String articlePageTitleText = articlePageTitle.getText().replaceAll("\"", "").trim();

        LOGGER.info("Into artital page find comments article's title element");
        List<WebElement> articleTitleCommentsElements = driver.findElements(articlePageCommentElements);
        LOGGER.info("get the article page count elemen's text");
        String articlePageCommentCount = "0";
        if (!articleTitleCommentsElements.isEmpty()) {
            articlePageCommentCount = articleTitleCommentsElements.get(0).getText();
        }
        LOGGER.info("string to int");
        articlePageCommentCount = articlePageCommentCount.replaceAll("[^0-9]","");
        int toIntarticlePageCommentCount = Integer.parseInt(articlePageCommentCount);
        LOGGER.info("articleTitleText " + articlePageTitleText + " The article page commnet count is:  " + toIntarticlePageCommentCount);

        LOGGER.info("Check second article title with the article page title's text");
        Assertions.assertEquals(articleTitleText, articlePageTitleText, "Wrong article title!");

        LOGGER.info("Check second title comment count' and article Title comment's count");
        Assertions.assertEquals(toIntTitleCommentCount, toIntarticlePageCommentCount, "Wrong article commet title!");

        LOGGER.info("click on comment element into article page if it is posible");
        if (!articleTitleCommentsElements.isEmpty()){
            articleTitleCommentsElements.get(0).click();
        }
        else {
            LOGGER.info(" ERROR!! The comment element not exist!");
            Assertions.assertFalse(articleTitleCommentsElements.isEmpty());
        }

        LOGGER.info("Find comments article's title element");
        WebElement articleCommentTitle = driver.findElement(commentPageTheArticleTitleElement);
        LOGGER.info("Get and save element text");
        String articleCommentTitleText = articleCommentTitle.getText().replaceAll("'", "");
        LOGGER.info("articleCommentTitleText " + articleCommentTitleText);

        LOGGER.info("Check the article page title's text with article ");
        Assertions.assertEquals(articlePageTitleText, articleCommentTitleText, "Wrong article commet title!");


        LOGGER.info("Find the anonumus comment's count element and save it");
        List<WebElement> articleCommentCountAnonimusElements = driver.findElements(comentPageTheCommentCountElements);
        String articleCommentCountAnonimusElementText = articleCommentCountAnonimusElements.get(0).getText();
        LOGGER.info("string to int");
        articleCommentCountAnonimusElementText = articleCommentCountAnonimusElementText.replaceAll("[^0-9]","");
        int toIntarticlelCommentCountAnonim = Integer.parseInt(articleCommentCountAnonimusElementText);
        LOGGER.info("The anonimus commnet count in artical : " + toIntarticlelCommentCountAnonim);

        LOGGER.info("Find the registrated comment's count element and save it");
        List<WebElement> articleCommentCountregistratedElements = driver.findElements(comentPageTheCommentCountElements);
        String articleCommentCountregistratedElementText = articleCommentCountregistratedElements.get(1).getText();
        LOGGER.info("string to int");
        articleCommentCountregistratedElementText = articleCommentCountregistratedElementText.replaceAll("[^0-9]","");
        int toIntarticlelCommentCountregistrated = Integer.parseInt(articleCommentCountregistratedElementText);
        LOGGER.info("The registrated commnet count in artical : " + toIntarticlelCommentCountregistrated);

//      int articalCommentCount = (toIntarticlelCommentCountAnonim + toIntarticlelCommentCountregistrated);
        int articalCommentCount = ((toIntarticlelCommentCountAnonim + toIntarticlelCommentCountregistrated)-1);
        LOGGER.info("The summ of commnet count in artical : " + articalCommentCount);

        LOGGER.info("Check article Title comment's count and The comment page comment's count");
        Assertions.assertEquals(toIntarticlePageCommentCount, articalCommentCount, "Wrong article commet title!");
        LOGGER.info("The all tests were succesful! :)");
    }
    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

}
