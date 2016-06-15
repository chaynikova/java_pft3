package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by t.chaynikova on 5/26/2016.
 */
public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData("test2", "test2", "test2", "C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg", "test2", "1985", "0505005050", "second"));

    }
  }
  @Test
  public void testContactDeletion(){
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    int index = before.size()-1 ;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size()-1 );
  }


}
