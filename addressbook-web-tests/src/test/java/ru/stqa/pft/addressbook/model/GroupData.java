package ru.stqa.pft.addressbook.model;

public class GroupData {
  private final String name;
  private final String parentGroup;
  private final String header;
  private final String footer;

  public GroupData(String name, String parentGroup,  String header, String footer) {
    this.name = name;
    this.parentGroup = parentGroup;
    this.header = header;
    this.footer = footer;
  }

  public String getName() {
    return name;
  }

  public String getParentGroup() { return parentGroup;  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }


}
