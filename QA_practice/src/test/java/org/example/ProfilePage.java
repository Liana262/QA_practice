package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'personal-info-login__text personal-info-login__text_decorated')]")
    private WebElement userMenu;
    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "//*[contains(@class, 'menu-item_action_exit menu__item menu__item_type_link')]")
    private WebElement logoutBtn;

    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.)
//        personal-info-login__text personal-info-login__text_decorated
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'personal-info-login__text personal-info-login__text_decorated')]")));
        return userMenu.getText();
    }

    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void entryMenu() {
        driver.findElement(By.xpath("//*[contains(@class,'user-account user-account_has-ticker_yes user-account_has-accent-letter_yes legouser__current-account i-bem')]")).click();
//        userMenu.click();
    }

    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        driver.findElement(By.xpath("//*[contains(@class,'menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_exit')]")).click();
    }
}
