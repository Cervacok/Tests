package luckyLabs.pages;


import luckyLabs.util.DDT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;


public class HomePage extends Page {
  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  @FindBy(xpath = "//*[@id=\"enter-site\"]")
  @CacheLookup
  private WebElement loginButton;
  @FindBy(xpath = "//*[@id=\"LoginForm_login\"]")
  @CacheLookup
  private WebElement emailField;
  @FindBy(xpath = "//*[@id=\"LoginForm_password\"]")
  @CacheLookup
  private WebElement passwordField;
  @FindBy(xpath = "//*[@id=\"LoginForm_remember\"]")
  @CacheLookup
  private WebElement rememberUser;
  @FindBy(xpath = "//*[@class=\"btn btn_green\"]")
  @CacheLookup
  private WebElement submitLoginButton;
  @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div[2]/ul/li[1]/a")
  @CacheLookup
  private WebElement userID;
  @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div[2]/a[1]")
  @CacheLookup
  private WebElement googleLoginButton;
  @FindBy(xpath = "//*[@id=\"Email\"]")
  @CacheLookup
  private WebElement googleEmailField;
  @FindBy(xpath = "//*[@id=\"Passwd\"]")
  @CacheLookup
  private WebElement googlePasswordField;
  @FindBy(xpath = "//*[@id=\"signIn\"]")
  @CacheLookup
  private WebElement googleSubmitLoginButton;
  @FindBy(xpath = "//*[@id=\"container\"]/article/div/div[3]/div[1]/ul/li[1]")
  @CacheLookup
  private WebElement bookOfRaDiv;
  @FindBy(xpath = "//*[@id=\"container\"]/article/div/div[3]/div[1]/ul/li[1]/div/div/a[1]")
  @CacheLookup
  private WebElement bookOfRaPlayFree;
  @FindBy(xpath = ".//*[@id='indexinfo']/div/div[1]/div[2]")
  @CacheLookup
  private WebElement indexMenu;



  private void pressLoginButton()
  {
    loginButton.click();
  }

  private void fillEmailField(String userName)
  {
    emailField.sendKeys(userName);
  }

  private void fillPasswordField(String userPassword)
  {
    passwordField.sendKeys(userPassword);
  }

  private void checkRememberUser() {
    rememberUser.click();
  }

  private  void pressSubmitLoginButton() {
    submitLoginButton.click();
  }

  private void pressLoginGoogleButton() {
    googleLoginButton.click();
  }

  private void fillGoogleEmailField(String userName)
  {
    googleEmailField.sendKeys(userName);
  }

  private void fillGooglePasswordField(String userPassword)
  {
    googlePasswordField.sendKeys(userPassword);
  }

  private  void pressGoogleLoginButton() {
    googleSubmitLoginButton.click();
  }

  public HomePage moveToBookOfRa() //переход в меню игры "Book Of Ra"
  {
    bookOfRaDiv.click();
    bookOfRaPlayFree.click();
    return this;
  }

  public HomePage go() {
    driver.get("https://slotoking.com");
    return this;
  } //переход на главную страницу

  public HomePage loginAs(String userName, String userPassword) //Логин обычного пользователя. принимает логин и пароль.
  {
    pressLoginButton();
    fillEmailField(userName);
    fillPasswordField(userPassword);
    checkRememberUser();
    pressSubmitLoginButton();
    return this;
  }

  public HomePage googleLoginAs(String userName, String userPassword) //Логин пользователя через гугл+. принимает логин и пароль.
  {
    pressLoginGoogleButton();
    fillGoogleEmailField(userName);
    fillGooglePasswordField(userPassword);
    pressGoogleLoginButton();
    return this;
  }

  public String[] getUrlFromXls(String pathFile, int cell, int begin, int end) throws IOException {
    String[] arr = new String[6];
    DDT ddt= new DDT(pathFile);
    for(int i = begin;i<=end;i++)
    {
      arr[i-1] = (ddt.getData(i, cell));
    }
    return arr;
  } //"Подтягивает" весь текст из excel и добавляет их в массив. Принимает параметры:путь к файлу, номер строчки, первая ячейка, последняя ячейка
  public String[] getUrlFromMenu() {
    String[] arr = new String[6];
    String locator = ".//*[@id='indexinfo']/div/div[1]/div[2]";
    for(int i = 1;i<=6;i++)
    {
      WebElement elem = driver.findElement(By.xpath(locator + "/ul/li[" + i + "]/a"));
      arr[i-1] = elem.getAttribute("href");
    }
    return arr;
  } //"Подтягивает" все ссылки из меню и добавляет их в массив
  public Boolean compareUrls(String[] arr1, String arr2[]) //сравнение всех параметров двух массивов, если хоть 1 пара параметров не true - возвращает false
  {
    Boolean b = true;
    for(int i = 0;i<arr1.length;i++)
    {
      if((arr1[i].equals(arr2[i]))){}
      else { b=false;}
    }
    return b;
  }
}
