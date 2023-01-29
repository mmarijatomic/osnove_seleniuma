package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

//Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//Visit Paris
//Visit Prague
//Visit London
//Visit New York
//Visit Belgrade
//Maksimizirati prozor
//Ucitati stranicu https://example.cypress.io/todo
//Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//Nakon svakog unosa todo-a, unosi se enter
//Validira da li je novi todo dodat na stranici
//Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//Validirati da je na kraju programa broj todo-a na stranici 0.
//Cekanje od 5s
//Zatvorite pretrazivac
public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        ArrayList<String> todos = new ArrayList<>();
        todos.add("Visit Paris");
        todos.add("Visit Prague");
        todos.add("Visit London");
        todos.add("Visit New York");
        todos.add("Visit Belgrade");

        for (int i = 0; i < todos.size(); i++) {
            driver.findElement(By.xpath("//*[@class='new-todo']")).sendKeys(todos.get(i));
        }

        List<WebElement> todosElements =
                driver.findElements(By.xpath("//ul[@class='todo-list']/li/div"));

        for (int i = 0; i < todosElements.size(); i++) {
            if (todosElements.get(i).getText().isEmpty()) {
                System.out.println("not found");
            } else {
                System.out.println("found");
            }
        }

        for (int i = 0; i < todosElements.size(); i++) {

            Actions action = new Actions(driver);
            action.moveToElement(todosElements.get(i));

            todosElements.get(i).findElement(By.xpath("//ul[@class='todo-list']/li/div/button[1]"))
                    .click();
        }


    }
}
