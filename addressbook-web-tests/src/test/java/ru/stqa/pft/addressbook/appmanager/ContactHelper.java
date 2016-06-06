package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import static org.testng.Assert.*;

import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;



/**
 * Created by t.chaynikova on 5/23/2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void fillContactForm(ContactData contactData, boolean creation ) {
    type(By.name("firstname"), contactData.getContactname());
    type(By.name("middlename"), contactData.getContactmiddlename());
    type(By.name("lastname"), contactData.getContactlastname());
    sendkeys(By.name("photo"), contactData.getFilepath());
    type(By.name("company"), contactData.getContactcompany());
    type(By.name("mobile"), contactData.getContactphone());

    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[9]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[1]//option[9]"));
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[2]")).isSelected()) {
      click(By.xpath("//div[@id='content']/form/select[2]//option[2]"));
    }
    type(By.name("byear"), contactData.getContactbirthyear());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
        Assert.assertFalse(isElementPresent(By.name("new group")));
    }
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }


  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void initContactModification() {
    click(By.xpath("//tr[@class='odd']/td[8]/a/img[@title='Edit']"));
  }
}
