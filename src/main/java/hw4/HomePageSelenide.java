package hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.eo.Se;
import enums.Ranges;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Ranges.*;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

//    @FindBy(xpath = "//span[contains(.,'PITER CHAILOVSKII')]")
//    private SelenideElement profileName;

    @FindBy(css = ".profile-photo span")
    private SelenideElement profileName;

//    //@FindBy(xpath = "\"header .nav > li\"")
//    @FindBy(xpath = "//span[contains(.,'Support')]")
//    private SelenideElement serviceMenu;

//    @FindBy(xpath = "//span[contains(.,'Dates')]")
//    private SelenideElement datesMenu;

//    @FindBy(xpath = "//label[contains(.,'Range2')]")
//    private SelenideElement range;
//
//    @FindBy(css = "ui-slider-range ui-widget-header ui-corner-all span")
//    private SelenideElement leftSlider;
//
//    @FindBy(css = ".profile-photo span")
//    private SelenideElement rightSlider;

//    @FindBy(xpath = "//*[@class='ui-slider-handle ui-state-default ui-corner-all']")
//    private SelenideElement

    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown")
    private SelenideElement serviceMenu;

    @FindBy(css = "li.dropdown.open > ul > li [href='dates.html']")
    private SelenideElement datesPage;

    @FindBy(css = "div.info-panel-body.info-panel-body-log > div > ul")
    public SelenideElement logsWindow;

//    )).
//
//    click();
//        driver.findElement(
//
//    cssSelector(
//
//}
//    @FindBy(css = ".sidebar-menu .menu-title ui span")

    //$(".profile-photo span").shouldHave(text("Piter Chailovskii"));

    //================================methods===================================

    @Step("Open JDI Test Application - Home Page")
    public void openPage() {
        open("https://epam.github.io/JDI");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }


    public void openDatesPage() {
        serviceMenu.click();
        datesPage.click();
    }

//    public void setRange(int left,int right){
//        List<WebElement> webElementList = getWebDriver().findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        WebElement rightSlider =webElementList.get(1);
//        WebElement leftSlider = webElementList.get(0);
//        left<leftSlider.get ? left=-left};
//        Actions builder = new Actions(getWebDriver());
//        builder.dragAndDropBy(left,74,0).perform();
//        builder.dragAndDropBy(right,0,0).perform();
//    }


    public ArrayList<WebElement> getSliders(){
        return new ArrayList<>(getWebDriver().findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']")));
    }


    public void setRange0to100() {
        List<WebElement> webElementList = getWebDriver().findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
        WebElement left = webElementList.get(0);
        WebElement right =webElementList.get(1);
        Actions builder = new Actions(getWebDriver());
        builder.dragAndDropBy(ge,Integer.MIN_VALUE,0).perform();
        builder.dragAndDropBy(right,0,0).perform();
//        builder.build();
//    }
//
//    public void setRange0to0() {
//        ElementsCollection selenideElements = $$(xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        SelenideElement rightSlider = selenideElements.get(0);
//        SelenideElement leftSlider = selenideElements.get(1);
//        actions().dragAndDropBy(leftSlider, -100, 0).perform();
//        actions().dragAndDropBy(rightSlider, -100, 0).perform();
//        List<WebElement> webElementList = getWebDriver().findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        WebElement left = webElementList.get(0);
//        WebElement right =webElementList.get(1);
//        Actions builder = new Actions(getWebDriver());
        builder.dragAndDropBy(left,0,0).perform();
        builder.dragAndDropBy(right,-1000,0).perform();
        builder.dragAndDropBy(left,1000,0).perform();
        builder.dragAndDropBy(right,1000,0).perform();
        builder.build();
    }

    public void setRange100to100() {
        List<WebElement> webElementList = getWebDriver().findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
        WebElement left = webElementList.get(0);
        WebElement right =webElementList.get(1);
        Actions builder = new Actions(getWebDriver());
        builder.dragAndDropBy(left,1000,0).perform();
        builder.dragAndDropBy(right,1000,0).perform();
        builder.build();
    }

    public void setRange30to70() {
        List<WebElement> webElementList = getWebDriver().findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
        WebElement left = webElementList.get(0);
        WebElement right = webElementList.get(1);
        Actions builder = new Actions(getWebDriver());
        builder.dragAndDropBy(left, -259, 0).perform();
        builder.dragAndDropBy(right, -111, 0).perform();
        builder.build();
    }


    //        List<WebElement> webElementList = driver.findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        WebElement right =webElementList.get(1);
//        WebElement left = webElementList.get(0);
//       Actions builder = new Actions(getWebDriver());
//        builder.dragAndDropBy(left,Integer.MIN_VALUE,0).perform();
//        builder.dragAndDropBy(right,0,0).perform();

//       builder.build();


//    public ArrayList<SelenideElement> getSliders() {
//        ElementsCollection selenideElements = $$(xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        ArrayList<SelenideElement> selList = new ArrayList<SelenideElement>();
//        selList.add(selenideElements.get(0));

//        selList.add(selenideElements.get(1));

//    return selList;

//    }


    //    @Step
//    public void findDate() {
//        serviceMenu.click();
//        datesMenu.click();
//    }

//
//    public  getSliders
//    ElementsCollection selenideElements=$$(xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//    SelenideElement leftSlider=selenideElements.get(0);
//    SelenideElement rightSlider=selenideElements.get(1);
//
//

//            5
//        driver.findElement(cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown")).click();
//                driver.findElement(cssSelector("li.dropdown.open > ul > li [href='dates.html']")).click();

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void check0to100() {
        $(logsWindow).shouldHave(text(TO_100.s));
        $(logsWindow).shouldHave(text(FROM_0.s));
    }

    public void check0to0() {
        $(logsWindow).shouldHave(text(TO_0.s));
        $(logsWindow).shouldHave(text(FROM_0.s));
    }

    public void check100to100() {
        $(logsWindow).shouldHave(text(TO_100.s));
        $(logsWindow).shouldHave(text(FROM_100.s));
    }

    public void check30to70() {
        $(logsWindow).shouldHave(text(TO_70.s));
        $(logsWindow).shouldHave(text(FROM_30.s));
    }

    public void checkProfileName() {
        profileName.shouldHave(Condition.text("Piter Chailovskii"));
    }
//
//        List<WebElement> webElementList = driver.findElements(By.xpath("//*[@class='ui-slider-handle ui-state-default ui-corner-all']"));
//        WebElement left = webElementList.get(0);
//        WebElement right = webElementList.get(1);
//    }


    //    @Step
//    public void checkMainText() {
//        //mainTitle.shouldBe(visible);
//        //mainTitle.shouldHave(text("EPA FRAMEWORK WISHES..."));
//    }


}