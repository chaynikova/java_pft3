package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by t.chaynikova on 5/23/2016.
 */
public class GroupHelper extends HelperBase {
  private NavigationHelper navigationHelper;

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

//  NavigationHelper navigationHelper = new NavigationHelper();

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData, boolean creation) {
    type(By.name("group_name"), groupData.getName());
    if (!creation) {
      new Select(wd.findElement(By.name("group_parent_id"))).selectByVisibleText(groupData.getParentGroup());
    }
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());

  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(new GroupData("second", null, null, null), true);
    submitGroupCreation();
    returnToGroupPage();
  }
  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
   return wd.findElements(By.name("selected[]")).size();
  }
}
