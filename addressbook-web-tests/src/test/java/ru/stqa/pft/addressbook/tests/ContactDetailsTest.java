package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by t.chaynikova on 6/16/2016.
 */
public class ContactDetailsTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions()
  {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withContactname("test2").withContactmiddlename("test2").withContactlastname("test2")
              .withFilepath("C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg").withContactcompany("test2").withContactbirthyear("1985")
              .withContactphone("0505005050").withMobilephone("06060060606").withWorkphone("0707007070").withGroup("second"));
    }
  }

  @Test
  public void testContactDetails() {
    app.goTo().homePage();
    ContactData contact = app.contact().allDetails().iterator().next();
    ContactData contactinfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactinfoFromDetailsForm)) );

  }
  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getContactphone(), contact.getMobilephone(), contact.getWorkphone())
            .stream().filter((s)->! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }
  public static String cleaned (String phone)
  {
    return phone.replaceAll("\\s", "").replaceAll("-()","");
  }
}
