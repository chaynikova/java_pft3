package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    gotoContactPage();
    fillContactForm(new ContactData("test2", "test2", "test2", "C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg", "test2", "1985"));
    submitContactCreation();
    gotoHomePage();
  }


}
