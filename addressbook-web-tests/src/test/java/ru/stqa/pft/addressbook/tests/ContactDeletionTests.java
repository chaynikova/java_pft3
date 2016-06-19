package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by t.chaynikova on 5/26/2016.
 */
public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){


    //app.goTo().homePage();
    if (app.db().contacts().size()==0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withContactname("test2").withContactmiddlename("test2").withContactlastname("test2")
              .withFilepath("C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg").withContactcompany("test2").withContactbirthyear("1985")
              .withContactphone("0505005050").withMobilephone("06060060606").withWorkphone("0707007070").withGroup("second"));
    }
  }

  @Test(enabled = false)
  public void testContactDeletion(){
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.goTo().contactPage();
    app.goTo().homePage();
    app.contact().delete(deletedContact);

    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
   // Assert.assertEquals(after.size(), before.size()-1 );
    assertThat(after, equalTo(before.without(deletedContact)));
  }


}
