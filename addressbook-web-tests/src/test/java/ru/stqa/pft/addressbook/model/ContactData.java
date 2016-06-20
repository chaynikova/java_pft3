package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id =Integer.MAX_VALUE;

  @Column(name = "firstname")
  private  String contactname;

  @Column(name = "lastname")
  private  String contactlastname;

  @Transient
  private  String contactcompany;

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
    int result = id;
    result = 31 * result + (contactname != null ? contactname.hashCode() : 0);
    result = 31 * result + (contactlastname != null ? contactlastname.hashCode() : 0);
    return result;
  }

  @Transient

  private  String contactbirthyear;

  @Column(name = "home")
  @Type(type="text")
  private  String contactphone;

  @Transient
  private  String contactmiddlename;

  @Transient
  private  String filepath;

  @ManyToMany (fetch = FetchType.EAGER)
  @JoinTable(name="address_in_groups", joinColumns = @JoinColumn(name="id"), inverseJoinColumns = @JoinColumn(name="group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();
  //@Transient
 // private String group;

  @Column(name = "mobile")
  @Type(type="text")
  private String mobilephone;
  @Column(name = "work")
  @Type(type="text")
  private String workphone;
  @Transient
  private String allPhones;
  @Transient
  private String allMail;
  @Transient
  private String allEmail;
  @Transient
  private String email;
  @Transient
  private String email2;
  @Transient
  private String email3;
  @Transient
  private String mail;
  @Transient
  private String mail2;
  @Transient
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

 // public String getGroup() {
   // return group;
 // }

  public String getMail() {return mail;  }

  public String getMail2() {    return mail2;  }

  public String getEmail() { return email;  }

  public String getEmail2() { return email2;  }

  public String getEmail3() { return email3;  }

  public String getAllPhones() {return allPhones;  }

  @Override
  public String toString() {
    return "ContactData{" +
            "contactname='" + contactname + '\'' +
            ", contactlastname='" + contactlastname + '\'' +
            ", contactphone='" + contactphone + '\'' +
            '}';
  }

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

  public Groups getGroups() {
    return new Groups(groups);
  }

  //  public ContactData withGroup(String group) {
//    this.group = group;
//    return this;
 // }
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

}
