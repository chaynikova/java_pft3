package ru.stqa.pft.addressbook.model;

public class ContactData {
  private  String contactname;
  private  String contactlastname;
  private  String contactcompany;
  private  String contactbirthyear;
  private  String contactphone;
  private String mobilephone;
  private String workphone;
  private  String contactmiddlename;
  private  String filepath;
  private String group;
  private int id =Integer.MAX_VALUE;


  public int getId() {
    return id;
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

  public String getMobilephone() {return mobilephone;}

  public String getWorkphone() {return workphone;}

  public Integer id() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withContactname(String contactname) {
    this.contactname = contactname;
    return this;
  }

  public ContactData withContactlastname(String contactlastname) {
    this.contactlastname = contactlastname;
    return this;
  }

  public ContactData withContactcompany(String contactcompany) {
    this.contactcompany = contactcompany;
    return this;
  }

  public ContactData withContactbirthyear(String contactbirthyear) {
    this.contactbirthyear = contactbirthyear;
    return this;
  }

  public ContactData withMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
    return this;
  }
  public ContactData withWorkphone(String workphone) {
    this.workphone = workphone;
    return this;
  }
  public ContactData withContactphone(String contactphone) {
    this.contactphone = contactphone;
    return this;
  }

  public ContactData withContactmiddlename(String contactmiddlename) {
    this.contactmiddlename = contactmiddlename;
    return this;
  }

  public ContactData withFilepath(String filepath) {
    this.filepath = filepath;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
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
