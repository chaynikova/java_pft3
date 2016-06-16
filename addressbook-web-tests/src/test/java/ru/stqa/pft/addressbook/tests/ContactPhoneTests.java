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

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withContactname("test7").withContactmiddlename("test2").withContactlastname("test7")
              .withFilepath("C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg").withContactcompany("test2").withMail("111")
              .withContactbirthyear("1985").withContactphone("0505005050")
              .withMobilephone("06060060606").withWorkphone("0707007070").withMail2("222").withEmail("test2.test2test2.@test2").withEmail2("testemail").withGroup("second"));
    }
  }
  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().alls().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)) );
    assertThat(contact.getAllEmail(), equalTo(mergeEmails(contactInfoFromEditForm)) );
    assertThat(contact.getAllMail(), equalTo(mergeMails(contactInfoFromEditForm)) );

  }


  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getContactphone(), contact.getMobilephone(), contact.getWorkphone())
            .stream().filter((s)->! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
    }

  private String mergeMails(ContactData contact) {
    return Arrays.asList(contact.getMail(), contact.getMail2())
            .stream().filter((s)->! s.equals(""))
            .map(ContactPhoneTests::cleanedMail)
            .collect(Collectors.joining("\n"));
  }
  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s)->! s.equals(""))
            .map(ContactPhoneTests::cleanedEmail)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned (String phone)
  {
    return phone.replaceAll("\\s", "").replaceAll("-()","");
  }

  public static String cleanedMail (String mail)
  {
    return mail.replaceAll("\\s", "").replaceAll("-()","");
  }

  public static String cleanedEmail (String email)
  {
    return email.replaceAll("\\s", "").replaceAll("-()","");
  }
}

