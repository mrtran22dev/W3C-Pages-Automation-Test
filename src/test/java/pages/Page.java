package pages;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import common.Base;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Slf4j
@Getter
public class Page {
    public static Page pageObj;
    private String url;
    Config config = ConfigFactory.load();
    String locale = config.getString("locale");

    By links = By.tagName("a");

    public Page navigateTo(String page) {
        log.info("sanitized page name > " + sanitize(page));
        pageObj = new Page().makePageObject(page);
        Base.webDriver.get(pageObj.getUrl());

        log.info(Base.webDriver.getCurrentUrl());
        return pageObj;
    }

    public Page makePageObject(String page) {
        page = sanitize(page);
        switch (page) {
            case "bad":
                return new BadPage();
            case "multimodal":
                return new MultiModal();
            case "htmlcss":
                return new HtmlCss();
            default:
                log.info("PAGE NOT FOUND: " + page);
                throw new RuntimeException();
        }
    }

    private String sanitize(String arg) {
        return arg.replaceAll("[^\\w\\d]","").toLowerCase();
    }

    public List<WebElement> getLinks() {
        return Base.webDriver.findElements(links);
    }

    public int getResponse(String link) throws IOException {
        URL url = new URL(link);
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.disconnect();
            return conn.getResponseCode();
        } catch (ClassCastException e) {
            log.info("Link is not a valid http address: " + url);
            return 0;
        }
    }
}

