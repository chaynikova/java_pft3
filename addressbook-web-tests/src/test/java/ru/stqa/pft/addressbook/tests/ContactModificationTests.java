package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


/**
 * Created by t.chaynikova on 5/26/2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
     if (app.contact().list().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withContactname("test2").withContactmiddlename("test2").withContactlastname("test2")
              .withFilepath("C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg").withContactcompany("test2").withContactbirthyear("1985").withContactphone("0505005050").withGroup("second"));
    }
  }
  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withContactname("test2").withContactmiddlename("test2").withContactlastname("test2")
            .withFilepath("C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg").withContactcompany("test2").withContactbirthyear("1985").withContactphone("0505005050");
    app.contact().modify(contact);

    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }



}
