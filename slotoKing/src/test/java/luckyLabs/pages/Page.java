package luckyLabs.pages;

import org.openqa.selenium.WebDriver;


public abstract class Page { //базовый класс страницы, от которого наследуются все остальные

  protected WebDriver driver; //экземпляр класса вебдрайвер

  public Page(WebDriver driver) {
    this.driver = driver;
  } //конструктор

  public String getUrl() {
    return driver.getCurrentUrl();
  } //возвращает URL на  странице

}
