package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.lang.System.setProperty;
import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "#Name")
    private WebElement login;

    @FindBy(css = "#Password")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    @FindBy(css = "header .nav > li")
    private WebElement menuButtons;

    @FindBy(css = ".epam-logo")
    private WebElement logo;

    @FindBy(css = ".benefits .icons-benefit")
    private WebElement icons;

    @FindBy(css = ".benefit-txt")
    private WebElement texts;

    @FindBy(css = "h3.main-title")
    private WebElement mainHeader;

    @FindBy(css = "p.main-txt")
    private WebElement mainText;

    @FindBy(id = "iframe")
    private WebElement iframe;


    //================================methods===================================

    //1 Open BR
    public void open(WebDriver driver) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    //3 Login
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    //12 Switch to original window back		Driver has focus on the original window
    public void switchToDefaultWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //17
    public void closeBR(WebDriver driver) {
        driver.quit();
    }

    //================================checks===================================


    //2 Assert Title
    //5
    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    //6 Menu buttons are displayed and have proper texts
    public void checkButtons(WebDriver driver) {
        assertEquals(driver.findElements(cssSelector(String.valueOf(menuButtons))).stream()
                        .map(WebElement::getText).collect(Collectors.toList()),
                Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
    }

    //7
    public void checkImages(WebDriver driver) {
        assertEquals(driver.findElements(cssSelector(String.valueOf(icons))).stream()
                        .filter(WebElement::isDisplayed).count(),
                4);
    }

    //8
    public void checkTexts(WebDriver driver) {
        assertEquals(driver.findElements(cssSelector(String.valueOf(texts))).stream()
                        .map(WebElement::getText).collect(Collectors.toList()),
                Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                        "To be flexible and\ncustomizable",
                        "To be multiplatform",
                        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));
    }

    //9
    public void checkHeader(WebDriver driver) {
        assertEquals(driver.findElement(cssSelector(String.valueOf(mainHeader))).getText(),
                "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(cssSelector(String.valueOf(mainText))).getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                        "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                        "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS " +
                        "NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN " +
                        "REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    //10 Assert that there is the iframe in the center of page		The iframe exists
    public void checkIframe(WebDriver driver) {
        assertTrue(driver.findElements(By.id(String.valueOf(iframe))).stream().anyMatch(WebElement::isDisplayed));
    }

    //11 The logo exists
    public void checkLogo(WebDriver driver) {
        driver.switchTo().frame(0);
        assertTrue(driver.findElements(By.cssSelector(String.valueOf(logo))).stream().anyMatch(WebElement::isDisplayed));
    }

    //13 Text is displayed and equals to expected result
    // Assert a text of the sub header	JDI GITHUB	Text is displayed and equals to expected result
    public void checkSubHeaderText(WebDriver driver) {
        WebElement subHeader = driver.findElement(cssSelector("h3:not(.main-title)"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    //14 Assert that JDI GITHUB is a link and has a proper URL	https://github.com/epam/JDI	Link is displayed and has proper value
    public void checkLink(WebDriver driver) {
        WebElement subHeader = driver.findElement(cssSelector("h3:not(.main-title)"));
        List<WebElement> subHeaderLink = subHeader.findElements(By.linkText("JDI GITHUB"));
        assertTrue(!subHeaderLink.isEmpty());
        assertEquals(subHeaderLink.get(0).getAttribute("href"), "https://github.com/epam/JDI");
    }

    //15 Assert that there is Left Section		Left section is displayed

    public void checkLeftSection(WebDriver driver) {
        assertTrue(driver.findElements(By.cssSelector("[name=navigation-sidebar]")).stream().anyMatch(WebElement::isDisplayed));
    }

    //16 Assert that there is Footer		Footer is displayed
    public void checkFooter(WebDriver driver) {
        assertTrue(driver.findElements(By.cssSelector("footer")).stream().anyMatch(WebElement::isDisplayed));
    }
}


