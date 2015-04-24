package luckyLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoggedInterface extends Page {
  public LoggedInterface(WebDriver webDriver) {
    super(webDriver);
  }
  WebDriverWait wait = new WebDriverWait(driver, 40);

  @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div[2]/ul/li[1]/a")
  @CacheLookup
  private WebElement userIDField;
  @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div[2]/ul/li[2]/span")
  @CacheLookup
  private WebElement userStatusField;
  @FindBy(xpath = "//*[@id=\"refreshBalance\"]")
  @CacheLookup
  private WebElement userBalanceField;
  @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div[2]/ul/li[5]/a")
  @CacheLookup
  private WebElement quitButton;


  public void ensureLoggedIn() {
    wait.until(ExpectedConditions.elementToBeClickable(quitButton));
  } //Ожидание, пока на страницу не появится кнопка "выход"
  public String userID()
  {
    return userIDField.getText();
  }//Значение ID пользователя
  public String userStatus()
  {
    return userStatusField.getText();
  } //Значение статуса пользователя
  public String userBalance()
  {
    return userBalanceField.getText();
  } //Значение баланса пользователя
  public LoggedInterface quit() {
    quitButton.click();
    return this;
  } //Выход из профиля
}
