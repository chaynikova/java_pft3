package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String contactname;
  private final String contactlastname;
  private final String contactcompany;
  private final String contactbirthyear;
  private final String contactphone;
  private final String contactmiddlename;
  private final String filepath;
  private String group;
  private int id;

  public ContactData(int id, String contactname, String contactmiddlename, String contactlastname, String filepath, String contactcompany, String contactbirthyear, String contactphone, String group) {
    this.id = id;
    this.contactname = contactname;
    this.contactmiddlename = contactmiddlename;
    this.contactlastname = contactlastname;
    this.filepath = filepath;
    this.contactcompany = contactcompany;
    this.contactbirthyear = contactbirthyear;
    this.contactphone = contactphone;
    this.group = group;
  }

  public ContactData( String contactname, String contactmiddlename, String contactlastname, String filepath, String contactcompany, String contactbirthyear, String contactphone, String group) {

    this.id = 0;
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

  public Integer id() {
    return id;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", contactname='" + contactname + '\'' +
            ", contactlastname='" + contactlastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (contactname != null ? !contactname.equals(that.contactname) : that.contactname != null) return false;
    return contactlastname != null ? contactlastname.equals(that.contactlastname) : that.contactlastname == null;

  }

  @Override
  public int hashCode() {
    int result = contactname != null ? contactname.hashCode() : 0;
    result = 31 * result + (contactlastname != null ? contactlastname.hashCode() : 0);
    result = 31 * result + id;
    return result;
  }
}
