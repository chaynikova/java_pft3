package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
try (BufferedReader reader = new BufferedReader(new FileReader(new File("src\\test\\java\\ru\\stqa\\pft\\addressbook\\resources\\groups.xml")))) {
  String xml = "";
  String line = reader.readLine();
  while (line != null) {
    xml += line;
    line = reader.readLine();
    //String[] split = line.split(",");
    //  list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[0]).withFooter(split[0])} );
  }
  XStream xstream = new XStream();
  xstream.processAnnotations(GroupData.class);
  List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
  //System.out.println("some text");
  return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
}
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.db().groups();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.db().groups();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    verifyGroupListInUI();
  }

  // @Test(enabled = false)
  // public void testBadGroupCreation() {
  //   app.goTo().groupPage();
  //   Groups before = app.group().all();
  //   GroupData group = new GroupData().withName("third'");

  //   app.group().create(group);
  //   assertThat(app.group().count(), equalTo(before.size()));
  //   Groups after = app.group().all();

  //  assertThat(after, equalTo(before));
//  }
}
