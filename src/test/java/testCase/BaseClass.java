package testCase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @SuppressWarnings("static-access")
    @BeforeClass(groups = { "Sanity", "Regression" })
    @Parameters({ "os", "browser" })
    void setup(String os, String br) throws IOException {

        // Loading config.properties file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            if (os.equalsIgnoreCase("Windows")) {
                capabilities.setPlatform(Platform.WINDOWS);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            }

            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                default:
                    System.out.println("No Matching browser");
                    return;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }

        else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Invalid Browser");
                    return;
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }

    @AfterClass(groups = { "Sanity", "Regression" })
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
