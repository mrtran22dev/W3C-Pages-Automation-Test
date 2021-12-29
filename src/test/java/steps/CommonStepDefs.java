package steps;

import common.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import io.cucumber.java.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import pages.Page;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import static org.junit.Assert.*;


@Slf4j
public class CommonStepDefs {

    public static Base base = new Base();
    public static Page pageObj = new Page();

//    @Before
//    public void setUp() {
//        base.init();
//    }

    @After
    public void tearDown() {
        Base.webDriver.quit();
    }

    @Given("the user is on the {string} page")
    public void theUserIsOnThePage(String page) throws MalformedURLException {
        base.init();
        pageObj = pageObj.navigateTo(page);
    }

    @Given("the user opens {string} browser and navigates to the {string} page")
    public void theUserOpensBrowserAndNavigatesToThePage(String browser, String page) throws MalformedURLException {
        base.setWebDriver(browser);
        pageObj = pageObj.navigateTo(page);
    }

    @Then("the page response code should be {int}")
    public void thePageResponseCodeShouldBe(int code) throws IOException {
        int responseCode = pageObj.getResponse(pageObj.getUrl());
        log.info("page status/response code: " + responseCode);
        assertEquals(String.format("response/status code mismatch for page. the actual response code is: %s", responseCode), code, responseCode);
    }

    @And("the console log should have no errors after page load")
    public void theConsoleLogShouldHaveNoErrorsAfterPageLoad() {
        try {
            Thread.sleep(3000);
            LogEntries entries = Base.webDriver.manage().logs().get(LogType.BROWSER);
            List<LogEntry> logEntryList = entries.getAll();
            log.info("retrieved console log size: " + logEntryList.size());
            if(logEntryList.size() > 0) {
                for(LogEntry log: logEntryList) {
                    if (log.getLevel().getName().equals("ERROR") || log.getLevel().getName().equals("SEVERE"))
                        System.out.println(log.getLevel() + " | " + log.getMessage());
                    assertNotEquals(String.format("Console log Level.ERROR detected: %s", log), "ERROR", log.getLevel().getName());
                    assertNotEquals(String.format("Console log Level.SEVERE detected: %s", log), "SEVERE", log.getLevel().getName());
                }
            } else {
                log.info("there are no console logs found after page load");
            }
        } catch (JsonException e) {
            log.info(String.format("browser type: %s", base.getBrowser()));
            log.info(e.getMessage());
            fail(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("all links on the page should redirect to a valid page")
    public void allLinksOnThePageShouldRedirectToAValidPage() {
        List<WebElement> links = pageObj.getLinks();
        log.info("retrieved page link size: " + links.size());
        String linkText;
        int responseCode;
        SoftAssertions softAssertions = new SoftAssertions();

        for (WebElement link : links) {
            linkText = link.getAttribute("href");
            if (linkText != null) {
                try {
                    responseCode = pageObj.getResponse(linkText);
                    log.info(responseCode + " | " + linkText);
                    softAssertions.assertThat(String.valueOf(responseCode).matches("4\\d{2}+"))
                            .withFailMessage(String.format("Redirected link returns status code: %s > %s", responseCode, linkText))
                            .isFalse();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        softAssertions.assertAll();
    }

    @Then("the user should be on the correct page")
    public void theUserShouldBeOnTheCorrectPage() {
        String url = Base.webDriver.getCurrentUrl();
        log.info("page object vs. actual > " + pageObj.getUrl() + " | " + url);
        assertEquals(pageObj.getUrl(), Base.webDriver.getCurrentUrl());
    }
}
