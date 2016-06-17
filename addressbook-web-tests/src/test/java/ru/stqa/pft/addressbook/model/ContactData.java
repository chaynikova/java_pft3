package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {
  private  String contactname;
  private  String contactlastname;
  private  String contactcompany;
  private  String contactbirthyear;
  private  String contactphone;
  private  String contactmiddlename;
  private  String filepath;
  private String group;
  private String mobilephone;
  private String workphone;
  private String allPhones;
  private String allMail;
  private String allEmail;
  private String email;
  private String email2;
  private String email3;
  private String mail;
  private String mail2;
  private int id =Integer.MAX_VALUE;
  private File photo;


  public int getId() { return id;  }

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

  public String getContactphone() {    return contactphone;  }

  public String getMobilephone() {return mobilephone;}

  public String getWorkphone() {return workphone; }

  public String getGroup() {
    return group;
  }

  public String getMail() {return mail;  }

  public String getMail2() {    return mail2;  }

  public String getEmail() { return email;  }

  public String getEmail2() { return email2;  }

  public String getEmail3() { return email3;  }

  public String getAllPhones() {return allPhones;  }

  public String getAllMail() {  return allMail; }

  public String getAllEmail() {   return allEmail;  }

  public Integer id() {
    return id;
  }

  public File getPhoto() {return photo;  }


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

  public ContactData withContactphone(String contactphone) {
    this.contactphone = contactphone;
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
  public ContactData withMail(String mail) {
    this.mail = mail;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllMail(String allMail) {
    this.allMail = allMail;
    return this;
  }


  public ContactData withMail2(String mail2) {
    this.mail2 = mail2;
    return this;
  }
  public ContactData withAllEmail(String allEmail) {
    this.allEmail = allEmail;
    return this;
  }
  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "contactname='" + contactname + '\'' +
            ", contactlastname='" + contactlastname + '\'' +
            ", mail='" + mail + '\'' +
            ", mail2='" + mail2 + '\'' +
            ", id=" + id +
            ", workphone='" + workphone + '\'' +
            ", mobilephone='" + mobilephone + '\'' +
            ", contactphone='" + contactphone + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (contactname != null ? !contactname.equals(that.contactname) : that.contactname != null) return false;
    if (contactlastname != null ? !contactlastname.equals(that.contactlastname) : that.contactlastname != null)
      return false;
    if (contactphone != null ? !contactphone.equals(that.contactphone) : that.contactphone != null) return false;
    if (mobilephone != null ? !mobilephone.equals(that.mobilephone) : that.mobilephone != null) return false;
    return workphone != null ? workphone.equals(that.workphone) : that.workphone == null;

  }

  @Override
  public int hashCode() {
    int result = contactname != null ? contactname.hashCode() : 0;
    result = 31 * result + (contactlastname != null ? contactlastname.hashCode() : 0);
    result = 31 * result + (contactphone != null ? contactphone.hashCode() : 0);
    result = 31 * result + (mobilephone != null ? mobilephone.hashCode() : 0);
    result = 31 * result + (workphone != null ? workphone.hashCode() : 0);
    result = 31 * result + id;
    return result;
  }
}
