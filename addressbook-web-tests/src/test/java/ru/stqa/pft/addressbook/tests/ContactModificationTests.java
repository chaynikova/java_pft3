package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


/**
 * Created by t.chaynikova on 5/26/2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){


    //app.goTo().homePage();
    if (app.db().contacts().size()==0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withContactname("test2").withContactmiddlename("test2").withContactlastname("test2")
              .withFilepath("C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg").withContactcompany("test2").withContactbirthyear("1985")
              .withContactphone("0505005050").withMobilephone("06060060606").withWorkphone("0707007070"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withContactname("test2").withContactmiddlename("test2").withContactlastname("test2")
            .withFilepath("C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg").withContactcompany("test2")
            .withContactbirthyear("1985").withContactphone("0505005050").withMobilephone("06060060606").withWorkphone("0707007070");
    app.goTo().contactPage();
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    // assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}
