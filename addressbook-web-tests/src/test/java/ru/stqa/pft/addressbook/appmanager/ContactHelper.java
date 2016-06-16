package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    type(By.name("home"), contactData.getContactphone());
    type(By.name("mobile"), contactData.getMobilephone());
    type(By.name("work"), contactData.getWorkphone());
    type(By.name("email"),contactData.getEmail());
    type(By.name("email2"),contactData.getEmail2());
    type(By.name("email3"),contactData.getEmail3());
    type(By.name("address"),contactData.getMail());
    type(By.name("address2"),contactData.getMail2());


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

  public void selectContactById(int id) {

    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void create(ContactData contactData) {
   fillContactForm(contactData, false);
   submitContactCreation();
    contactCache = null;
    returnToHomePage();

  }
  public void modify(ContactData contact) {
    returnToHomePage();
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(int index) {
   selectContact(index);
    deleteSelectedContact();
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
    returnToHomePage();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

       for (WebElement element : elements)
    {
      int id = Integer.parseInt(element.findElement(By.xpath("td[1]/input")).getAttribute("id"));
      String name = element.findElement(By.xpath("td[3]")).getText();
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      ContactData contact = new ContactData().withId(id).withContactname(name).withContactlastname(lastname);
      contacts.add(contact);
    }
    return contacts;
  }
private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();

    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement element : elements)
    {
      int id = Integer.parseInt(element.findElement(By.xpath("td[1]/input")).getAttribute("id"));
      String name = element.findElement(By.xpath("td[3]")).getText();
      String lastname = element.findElement(By.xpath("td[2]")).getText();
      String[] phones = element.findElement(By.xpath("td[6]")).getText().split("\n");


      //ContactData contact = new ContactData().withId(id).withContactname(name).withContactlastname(lastname)
      //        .withContactphone(phones[0]).withMobilephone(phones[1]).withWorkphone(phones[2]);
      contactCache.add(new ContactData().withId(id).withContactname(name).withContactlastname(lastname)
              .withContactphone(phones[0]).withMobilephone(phones[1]).withWorkphone(phones[2]));
    }

    return new Contacts(contactCache);
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void returnToHomePage() {
    if (isElementPresent(By.id("maintable"))){
    return;
  }
    click(By.linkText("home")); }

  public ContactData infoFromEditForm(ContactData contact){
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String mail = wd.findElement(By.name("address")).getText();
    String mail2 = wd.findElement(By.name("address2")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withContactname(firstname).withContactlastname(lastname)
            .withContactphone(home).withMobilephone(mobile).withWorkphone(work).withMail(mail).withMail2(mail2).withEmail(email).withEmail2(email2).withEmail3(email3);
  }
  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  private void initContactDetailsCheck(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(6).findElement(By.tagName("a")).click();
  }

  public Set<ContactData> alls() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));

      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));

      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      String allMails = cells.get(3).getText();
      String allEmails = cells.get(4).getText();

      contacts.add(new ContactData().withId(id).withContactname(firstname).withContactlastname(lastname)
              .withAllPhones(allPhones).withAllMail(allMails).withAllEmail(allEmails));

    }
    return contacts;

  }
    public Set<ContactData> allDetails() {
      Set<ContactData> contacts = new HashSet<ContactData>();
      List<WebElement> rows = wd.findElements(By.name("entry"));
      for (WebElement row : rows) {
        List<WebElement> cells = row.findElements(By.tagName("td"));

        int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
        String allPhones = cells.get(5).getText();
        contacts.add(new ContactData().withId(id).withAllPhones(allPhones));

      }
      return contacts;
  }


    public ContactData infoFromDetailsForm(ContactData contact){

      initContactDetailsCheck(contact.getId());
      WebElement content = wd.findElement(By.id("content"));
      String home = content.findElement(By.xpath("a[1]")).getText();
      String mobile = content.findElement(By.xpath("a[2]")).getText();
      String work = content.findElement(By.xpath("a[3]")).getText();

      wd.navigate().back();
      return new ContactData().withId(contact.getId()).withContactphone(home).withMobilephone(mobile).withWorkphone(work);

    }

        }


