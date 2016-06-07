package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by t.chaynikova on 5/26/2016.
 */
public class ContactDeletionTests extends TestBase{
  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactPage();
      app.getContactHelper().createContact(new ContactData("test2", "test2", "test2", "C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg", "test2", "1985", "0505005050", "second"));
    }
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().gotoHomePage();
  }
}
