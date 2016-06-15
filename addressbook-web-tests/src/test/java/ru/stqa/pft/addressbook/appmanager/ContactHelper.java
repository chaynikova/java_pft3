package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by t.chaynikova on 5/23/2016.
 */
public class ContactHelper extends HelperBase {


  private NavigationHelper navigationHelper;


  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void fillContactForm(ContactData contactData, boolean creation) {
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
    click(By.name("submit"));
  }

  public void selectContact(int index) {
wd.findElements(By.name("selected[]")).get(index).click();
  }


  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img[@title='Edit']"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contactData) {
   fillContactForm(contactData, false);
   submitContactCreation();

  }
  public void modifyContact(ContactData contact) {
    returnToHomePage();
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }


  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

       for (WebElement element : elements)
    {
      int id = Integer.parseInt(element.findElement(By.xpath("td[1]/input")).getAttribute("id"));
      String name = element.findElement(By.xpath("td[3]")).getText();
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      ContactData contact = new ContactData (id, name, null, lastname, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void returnToHomePage() {
    if (isElementPresent(By.id("maintable"))){
    return;
  }
    click(By.linkText("home")); }

}
