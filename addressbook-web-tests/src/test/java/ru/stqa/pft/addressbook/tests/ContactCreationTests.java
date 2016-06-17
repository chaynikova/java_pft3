package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().contactPage();
    File photo = new File("src\\test\\java\\ru\\stqa\\pft\\addressbook\\resources\\53826235_fr.jpg");
    ContactData contact = new ContactData().withContactname("test2").withContactmiddlename("test2").withContactlastname("test2")
            .withContactcompany("test2").withContactbirthyear("1985").withContactphone("0505005050").withMobilephone("06060060606").withWorkphone("0707007070").withPhoto(photo);


    app.contact().create(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    //  assertThat(app.contact().count(), equalTo(before.size() + 1));
    //   Contacts after = app.contact().all();
    //   assertThat(after, equalTo(
  }

  @Test(enabled = false)
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().contactPage();
    ContactData contact = new ContactData().withContactname("test2").withContactmiddlename("test2").withContactlastname("test2")
            .withFilepath("C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg").withContactcompany("test2").withContactbirthyear("1985")
            .withContactphone("0505005050").withGroup("second");

    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
@Test(enabled = false)
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsoluteFile());
  File photo = new File("src\\test\\java\\ru\\stqa\\pft\\addressbook\\resources\\53826235_fr.jpg");
  System.out.println(currentDir.getAbsoluteFile());
  System.out.println(photo.exists());
  }
}
