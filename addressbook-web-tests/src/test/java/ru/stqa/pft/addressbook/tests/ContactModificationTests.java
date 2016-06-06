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
    // app.getGroupHelper().selectGroup();
      app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test2", "test2", "test2", "C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg", "test3", "1986", "0505015151", null), false);
      app.getContactHelper().submitContactModification();
     app.getNavigationHelper().gotoHomePage();
  }
}
