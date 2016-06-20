package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alexander on 20.06.2016.
 */
public class RemoveContactFromGroup extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
                if (app.db().groups().size()==0){
                app.goTo().groupPage();
                app.group().create(new GroupData().withName("first"));

            }

            if (app.db().contacts().size()==0) {
                app.goTo().contactPage();
                app.contact().create(new ContactData().withContactname("test2").withContactmiddlename("test2").withContactlastname("test2")
                        .withFilepath("C:\\Users\\t.chaynikova\\Desktop\\ToDelete\\53826235_fr.jpg").withContactcompany("test2").withContactbirthyear("1985")
                        .withContactphone("0505005050").withMobilephone("06060060606").withWorkphone("0707007070"));
            }

        }

        @Test

    public void removeContactFromGroup() {
        Groups beforeGroups = app.db().groups();
        beforeGroups.iterator().next();

        Contacts beforeContacts = app.db().contacts();
        ContactData existingContact = beforeContacts.iterator().next();
        beforeGroups = existingContact.getGroups();
        System.out.println(beforeGroups);
        app.goTo().homePage();
        app.contact().linkContactAndGroup(existingContact);
            app.goTo().homePage();
            app.contact().gotoContactGroup();
        app.contact().removeLinkContactAndGroup(existingContact);
        app.goTo().homePage();
        app.contact().gotoContactGroup();
        Groups afterGroups = existingContact.getGroups();
        assertThat(afterGroups, equalTo(beforeGroups));
    }

}
