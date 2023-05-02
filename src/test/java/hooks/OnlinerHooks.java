package hooks;

import OnlinerPages.ShoppingCartPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static staticData.WebUrls.ONLINER_URL;

public class OnlinerHooks {
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    WebDriver driver;
    private final String browser = "chrome";
    public RemoteWebDriver remoteWebDriver;
    public static String userName, accessKey;
    public static Map<String, Object> browserStackYamlMap;

    public OnlinerHooks() {
        File file = new File("/Users/da/IdeaProjects/OnlinerAndPetfinderTesting/src/test/resources/browserstack.yml");
        browserStackYamlMap = convertYamlFileToMap(file, new HashMap<>());
        userName = System.getenv("BROWSERSTACK_USERNAME") != null ? System.getenv("BROWSERSTACK_USERNAME") : (String) browserStackYamlMap.get("userName");
        accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY") != null ? System.getenv("BROWSERSTACK_ACCESS_KEY") : (String) browserStackYamlMap.get("accessKey");
    }

    @Before("@ui")
    public void setUpBrowser() throws MalformedURLException {
        Configuration.baseUrl = ONLINER_URL;
        if (browser.equals("remote")) {
            MutableCapabilities capabilities = new MutableCapabilities();
            HashMap<String, String> bstackOptions = new HashMap<>();
            bstackOptions.put("source", "selenide:sample-master:v1.2");
            capabilities.setCapability("bstack:options", bstackOptions);
            remoteWebDriver = new RemoteWebDriver(new URL(String.format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", userName, accessKey)), capabilities);
            WebDriverRunner.setWebDriver(remoteWebDriver);
        } else {
            Configuration.browser = browser;
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            Configuration.browserCapabilities = options;
            Configuration.timeout = 8000;
        }
    }

    @After("@ui")
    public void quiteBrowser(Scenario scenario) {
        if (browser.equals("remote")) {
            remoteWebDriver = (RemoteWebDriver) getWebDriver();
        } else {
            driver = getWebDriver();
        }

        if (scenario.isFailed()) {
            Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) remoteWebDriver).getScreenshotAs(OutputType.BYTES)));
        }
        open(baseUrl);
        shoppingCartPage.goInCart();
        shoppingCartPage.cleanShoppingCartIfProductsExist();
        closeWebDriver();
    }

    private Map<String, Object> convertYamlFileToMap(File yamlFile, Map<String, Object> map) {
        try {
            InputStream inputStream = Files.newInputStream(yamlFile.toPath());
            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(inputStream);
            map.putAll(config);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Malformed browserstack.yml file - %s.", e));
        }
        return map;
    }
}
