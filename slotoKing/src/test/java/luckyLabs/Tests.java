package luckyLabs;

import luckyLabs.pages.BookOfRa;
import luckyLabs.pages.LoggedInterface;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import luckyLabs.pages.HomePage;
import org.testng.Assert;

import java.io.IOException;

public class Tests extends TestNgTestBase {

  private HomePage hp; //Создание экземпляров класса
  private LoggedInterface li;
  private BookOfRa bor;

  @BeforeMethod
  public void initPageObjects() {
    hp  = PageFactory.initElements(driver, HomePage.class);
    li  = PageFactory.initElements(driver, LoggedInterface.class);
    bor = PageFactory.initElements(driver, BookOfRa.class);

  } //Инициализация элементов страниц до запуска метода
  @AfterMethod
  public void quitIfLoggedIn() //После каждого теста запускается метод выхода, если появляется Exception из-за отсутствия элемента на странице - обработчик перехватывает исключение
  {
    try {
      li.quit();
    }
    catch (Exception e) {
      System.out.println();
    }
  }

  @Test
  public void validLogin()  {
    hp.go() //переход на главную страницу
            .loginAs("autotest17@test.net","testpass"); // логин пользователя autotest17@test.net
    li.ensureLoggedIn();//Проверка видимости кнопки "выход"
      Assert.assertTrue(li.userID().equals("227202")); //проверка, что ID пользователя - 227202
      Assert.assertTrue(li.userStatus().equals("Игрок")); //проверка, что статус - Игрок
      Assert.assertTrue(li.userBalance().equals("0.00 RUB")); //проверка, что баланс игрока 0.0 RUB
  }
  @Test
  public void googleValidLogin()
  {
    hp.go() //переход на главную страницу
            .googleLoginAs("alxttrv@gmail.com", "329hfw321"); // логин пользователя alxttrv@gmail.com
    li.ensureLoggedIn();//Проверка видимости кнопки "выход"
    Assert.assertTrue(li.userID().equals("575544")); //проверка, что ID пользователя - 575544
    Assert.assertTrue(li.userStatus().equals("Игрок")); //проверка, что статус - Игрок
    Assert.assertTrue(li.userBalance().equals("0.00")); //проверка, что баланс игрока 0.0 RUB
  }
  @Test
  public void indexInfoMenuTesting() throws IOException {
    hp.go(); //заход на главную страницу
    Assert.assertTrue(hp.compareUrls(hp.getUrlFromMenu(),hp.getUrlFromXls("/home/ievgenii/slotoking/slotoKing/data.xls", 1, 1, 6))); //Проверка всех href сравнительно с данными из excel
  }

  @Test
  public void playDemoBookOfRa() {
    hp.go() //Переход на стартовую страницу
      .moveToBookOfRa(); //переход в меню игры Book of Ra
    bor.goDemo(); //Заход в демо режим
    Assert.assertTrue(bor.ensureGameWindowIsDisplayed()); //проверка наличия элемента игрового окна
    Assert.assertTrue(bor.ensureCurrentUrlIsCorrect()); //проверка корректности урла
  }


}
