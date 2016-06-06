package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String contactname;
  private final String contactmiddlename;
  private final String contactlastname;
  private final String filepath;
  private final String contactcompany;
  private final String contactbirthyear;
  private final String contactphone;
  private String group;

  public ContactData(String contactname, String contactmiddlename, String contactlastname, String filepath, String contactcompany, String contactbirthyear, String contactphone, String group) {
    this.contactname = contactname;
    this.contactmiddlename = contactmiddlename;
    this.contactlastname = contactlastname;
    this.filepath = filepath;
    this.contactcompany = contactcompany;
    this.contactbirthyear = contactbirthyear;
    this.contactphone = contactphone;

    this.group = group;
  }

  public String getContactname() {    return contactname;  }

  public String getContactmiddlename() {
    return contactmiddlename;
  }

  public String getContactlastname() {
    return contactlastname;
  }

  public String getFilepath() {
    return filepath;
  }

  public String getContactcompany() {
    return contactcompany;
  }

  public String getContactbirthyear() {
    return contactbirthyear;
  }

  public String getContactphone() {
    return contactphone;
  }

  public String getGroup() {
    return group;
  }
}
