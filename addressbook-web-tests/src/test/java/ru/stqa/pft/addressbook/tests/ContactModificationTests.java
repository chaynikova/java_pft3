package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


/**
 * Created by t.chaynikova on 5/26/2016.
 */
public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactPage();
      app.getContactHelper().createContact(new ContactData("test2", "test2", "test2", "C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg", "test2", "1985", "0505005050", "second"));
         }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("modified", "testModified", "test2", "C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg", "test3", "1987", "0505015151", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
}
