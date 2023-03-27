package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DualLinkPage {

    WebDriver driver;

    public DualLinkPage(WebDriver driver){
        this.driver = driver;
    }

    private final String URL = "https://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html";
    private final By searchBox1 = By.xpath("/div[@class='dual-list list-left col-md-5']//input");
    private final By selectButton1 = By.xpath("/div[@class='dual-list list-left col-md-5']//a");
    private final By addItem = By.className("btn btn-default btn-sm move-right");
    private String rightListItem = "//div[@class='dual-list list-right col-md-5']//input/following::li[text()='%s']";

    public void navigate(){
        driver.navigate().to(URL);
    }

    public void inputMessage(String message){
        driver.findElement(searchBox1).sendKeys(message);
    }

    public void clickAddItem(){
        driver.findElement(addItem).click();
    }

    public void clickSelectButton(){
        driver.findElement(selectButton1);
    }

    public boolean findRightListItem(String word){
        try{
            rightListItem = String.format(rightListItem, word);
            //rightListItem = rightListItem.replace("@@@@@", word);
            driver.findElement(By.xpath(rightListItem));
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
