package tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverFactory {
    private static WebDriver instance = null;

    public static synchronized WebDriver getWebDriver() {
        if (instance == null) {
            throw new RuntimeException("Create WebDriver first");
        }
        return instance;
    }

    @Before
    public static synchronized void setUp() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        instance = new ChromeDriver();
        instance.manage().window().maximize();
    }

    @After
    public static synchronized void tearDown() {
        instance.manage().deleteAllCookies();
        if (instance != null) instance.quit();
    }
}
