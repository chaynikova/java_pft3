package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().fillContactForm(new ContactData("test2", "test2", "test2", "C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg", "test2", "1985", "0505005050"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }

}
