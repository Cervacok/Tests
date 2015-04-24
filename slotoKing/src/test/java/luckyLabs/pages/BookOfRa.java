package luckyLabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookOfRa extends Page {
  public BookOfRa(WebDriver webDriver) {
    super(webDriver);
  }
  WebDriverWait wait = new WebDriverWait(driver, 40);

  @FindBy(xpath = "//*[@id=\"tab1\"]/a[4]")
  @CacheLookup
  private WebElement demoMode;
  @FindBy(xpath = "//object[@id='flashGame']")
  @CacheLookup
  private WebElement gameWindow;


  public Boolean ensureGameWindowIsDisplayed() {
    return gameWindow.isDisplayed();
  }//Проверка запущено ли окно игры
  public Boolean ensureCurrentUrlIsCorrect() {
    return getUrl().equals("https://slotoking.com/online-game/book-of-ra-deluxe/");
  }//Проверка правильный ли урл
  public void goDemo()
  {
    demoMode.click();
  }//Вход в демо режим игры
}
