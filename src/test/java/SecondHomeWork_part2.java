import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondHomeWork_part2 {
    @Test

    public void delfiTestHomePart2() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv/");

        WebElement secondTitleCommentCount = driver.findElement(By.xpath("(.//a[contains(@class, 'comment-count')])[2]"));


        String secondTitleCommentCountText = secondTitleCommentCount.getText();

        String secondTitleCommentCountTextInt = secondTitleCommentCountText.replaceAll("[^0-9]","");
        int toIntSecondTitleCommCount = Integer.parseInt(secondTitleCommentCountTextInt);
        System.out.println("The commnet count in Title:  " + toIntSecondTitleCommCount);

        secondTitleCommentCount.click();

        WebElement articalCommentCountAnonimus = driver.findElement(By.xpath("(.//span[@class= 'type-cnt'])[1]"));
        String articalCommentCountAnonimusText = articalCommentCountAnonimus.getText();

        String articalCommentCountAnonimInt = articalCommentCountAnonimusText.replaceAll("[^0-9]","");
        int toIntarticalComCountAnonim = Integer.parseInt(articalCommentCountAnonimInt);
        System.out.println("The anonimus commnet count in artical : " + toIntarticalComCountAnonim);


        WebElement articalCommentCountRegistred = driver.findElement(By.xpath("(.//span[@class= 'type-cnt'])[2]"));
        String articalCommentCountRegistredText = articalCommentCountRegistred.getText();

        String articalCommentCountRegistredInt = articalCommentCountRegistredText.replaceAll("[^0-9]","");
        int toIntarticalComCountRegisted = Integer.parseInt(articalCommentCountRegistredInt);
        System.out.println("The registrated commnet count in artical: " + toIntarticalComCountRegisted);

     int articalCommentCount = (toIntarticalComCountAnonim + toIntarticalComCountRegisted);

        System.out.println("The summ of commnet count in artical : " + articalCommentCount);

        Assertions.assertEquals(toIntSecondTitleCommCount, articalCommentCount, "Wrong article commet title!");

        driver.navigate().back();

        WebElement secondTitle = driver.findElement(By.xpath("(.//h1[contains(@class, 'headline__title')])[2]"));

        secondTitle.click();

        WebElement articalTitleComment = driver.findElement(By.xpath("//a[contains(@class, 'text-red-ribbon')]"));

        String articalTitleCommentsCountText = articalTitleComment.getText();

        String articalTitleCommentsCountTextInt = articalTitleCommentsCountText.replaceAll("[^0-9]","");
        int toIntarticalTitleCommCount = Integer.parseInt(articalTitleCommentsCountTextInt);
        System.out.println("The artical title commnet count: " + toIntarticalTitleCommCount);

        Assertions.assertEquals(toIntSecondTitleCommCount, toIntarticalTitleCommCount, "Wrong article commet title!");

        driver.close();
    }
}
