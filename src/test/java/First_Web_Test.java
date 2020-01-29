import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_Web_Test {

    @Test
    public void delfiTest() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe"); // nahozdenie drivera
        WebDriver driver = new ChromeDriver(); //
        driver.manage().window().maximize(); // raskroet na ves ekran
        driver.get("http://rus.delfi.lv");
    }
}
