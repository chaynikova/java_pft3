package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src\\test\\java\\ru\\stqa\\pft\\addressbook\\resources\\contact.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
        //String[] split = line.split(",");
        //  list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[0]).withFooter(split[0])} );
      }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contact = (List<ContactData>) xstream.fromXML(xml);
  //  System.out.println("some text");
    return contact.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }
    }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    app.goTo().contactPage();
    app.contact().create(contact);
    app.goTo().homePage();
    Contacts after = app.db().contacts();

    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    verifyContactListInUI();
      }

  @Test(enabled = false)
  public void testBadContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().contactPage();
    ContactData contact = new ContactData().withContactname("test2").withContactmiddlename("test2").withContactlastname("test2")
            .withFilepath("C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg").withContactcompany("test2").withContactbirthyear("1985")
            .withContactphone("0505005050");

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
