package ru.stqa.pft.addressbook;

public class ContactData {
  private final String contactname;
  private final String contactmiddlename;
  private final String contactlastname;
  private final String filepath;
  private final String contactcompany;
  private final String contactbirthyear;

  public ContactData(String contactname, String contactmiddlename, String contactlastname, String filepath, String contactcompany, String contactbirthyear) {
    this.contactname = contactname;
    this.contactmiddlename = contactmiddlename;
    this.contactlastname = contactlastname;
    this.filepath = filepath;
    this.contactcompany = contactcompany;
    this.contactbirthyear = contactbirthyear;
  }

  public String getContactname() {
    return contactname;
  }

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
}
