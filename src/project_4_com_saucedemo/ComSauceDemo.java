package project_4_com_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-4 - ProjectName : com-saucedemo BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */
public class ComSauceDemo {
    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    //setup multi browser
    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
        } else {
            System.out.println("Wrong Browser name");
        }
        //open URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       //Print the title of the page.
        System.out.println("Title of the page: " + driver.getTitle());
        //Print the current url.
        System.out.println("Current URL: " + driver.getCurrentUrl());
        //Print the page source.
        System.out.println("Page Source: " + driver.getPageSource());
        //Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("prime123@gmail.com");
        //Enter the password to password filed
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Prime321");
        //click on login button
        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        //print the current Url
        System.out.println("Current URL after login: " + driver.getCurrentUrl());
        //navigate to baseURL
        driver.navigate().to(baseUrl);
        //Refresh the page.
        driver.navigate().refresh();
        //Close the browser
        driver.quit();
    }
}
