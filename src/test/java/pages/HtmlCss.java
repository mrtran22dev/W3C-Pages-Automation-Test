package pages;

import lombok.Getter;
import org.openqa.selenium.By;


@Getter
public class HtmlCss extends Page {
    private final String url = "https://www.w3.org/standards/webdesign/htmlcss";

    By twitter = By.cssSelector(".social-icon");
}
