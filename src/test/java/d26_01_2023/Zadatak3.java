package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

//Napisati program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element
//obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//POMOC: Brisite elemente odozdo.
public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        List<WebElement> xs = driver.findElements(By.xpath("//button"));


            for (int i = xs.size() - 1; i >= 0; i--) {
                xs.get(i).click();
                try {
                    if (!xs.get(i).equals(driver.findElement(By.xpath("(//button)[last()]")))) {
                        System.out.println("Obrisan element");
                        xs.remove(i);
                    }
                } catch (NoSuchElementException erorr) {
                    System.out.println("Obrisano");
                    xs.remove(i);
                }
           }

            driver.quit();
    }
}