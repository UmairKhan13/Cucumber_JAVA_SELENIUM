package org.example.generalizedOperations.commonActions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.commons.io.FileUtils;
import org.example.generalizedOperations.constants.FrameworkTimeConstants;
import org.example.generalizedOperations.enums.IdentifierType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import static org.example.drivers.WebDriverManager.getWebDriver;

public class WebPortalActions {
    public static void clearWebElement(WebElement webElement) {
        waitForWebElementToAppear(webElement);
        webElement.clear();
    }
    public static void enterText(IdentifierType strategy, String identifier, String txt) {
        setImplicitWaitForWebElement(FrameworkTimeConstants.EXPLICIT_WAIT);
        WebElement webElement = getWebElementBy(strategy, identifier);
        waitForWebElementToAppear(webElement);
        clearWebElement(webElement);
        webElement.sendKeys(txt);
    }
    public static void click(IdentifierType strategy, String identifier) {
        WebElement webElement = getWebElementBy(strategy, identifier);
        waitForWebElementToAppear(webElement);
        webElement.click();
    }
    public static String getElementText(IdentifierType strategy, String identifier) {
        WebElement webElement = getWebElementBy(strategy, identifier);
        waitForWebElementToAppear(webElement);
        return webElement.getText();
    }
    public static void waitForWebElementToAppear(WebElement element) {
        setImplicitWaitForWebElement(FrameworkTimeConstants.EXPLICIT_WAIT);
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(FrameworkTimeConstants.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement getWebElementBy(IdentifierType strategy, String identifier) {
        return switch (strategy) {
            case ID -> getWebDriver().findElement(By.id(identifier));
            case XPATH -> getWebDriver().findElement(By.xpath(identifier));
            case CLASS -> getWebDriver().findElement(By.className(identifier));
            case NAME -> getWebDriver().findElement(By.name(identifier));
            case CSS -> getWebDriver().findElement(By.cssSelector(identifier));
            default -> throw new IllegalArgumentException("Invalid strategy: " + strategy);
        };
    }
    public static boolean isElementDisplayed(IdentifierType strategy, String identifier) {
        try {
            WebElement element = getWebElementBy(strategy, identifier);
            waitForWebElementToAppear(element);
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }
    public static void setImplicitWaitForWebElement(int seconds) {
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
    public static Dotenv loadDotenv(String filePath) {
        return Dotenv.configure()
                .directory(filePath)
                .load();
    }
}