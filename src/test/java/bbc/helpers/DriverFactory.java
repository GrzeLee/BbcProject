package bbc.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
public class DriverFactory {

    public static WebDriver driverInstance;

    public static WebDriver getChromeDriver(){
        if(driverInstance==null){
            WebDriverManager.chromedriver().setup();
            ChromeDriverService driverService = new ChromeDriverService.Builder()
                    .usingAnyFreePort().build();
            driverInstance = new ChromeDriver(driverService);
        }
        return driverInstance;
    }
}
