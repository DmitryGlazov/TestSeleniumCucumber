package tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        instance = new ChromeDriver(options);

        instance.manage().window().maximize();
    }

    @After
    public static synchronized void tearDown() {
        instance.manage().deleteAllCookies();
        if (instance != null) instance.quit();
    }
}
