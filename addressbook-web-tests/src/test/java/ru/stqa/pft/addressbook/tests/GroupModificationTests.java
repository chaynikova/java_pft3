package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by t.chaynikova on 5/25/2016.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions(){
      if (app.db().groups().size()==0){
          app.goTo().groupPage();
          app.group().create(new GroupData().withName("first"));
         // app.group().create(new GroupData().withName("second"));
      }
    }

  @Test
  public void testGroupModification() {
   Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();

    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("modified").withHeader("test").withFooter(("modified"));
      app.goTo().groupPage();
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.db().groups();
    //assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
