abstract class Person {
  private String name;

  public Person(String name) { this.name = name; }
}

class Student extends Person {

  public Student(String name) {
    super(name);
  }
}

class Faculty extends Person {

  public Faculty(String name) {
    super(name);
  }
}

class Staff extends Person {

  public Staff(String name) {
    super(name);
  }
}

class PersonFactory {

  private DBConnection conn;

  public Person create(String name) {
    String type = conn.lookup(name);
    if (type.equals("student")) { return new Student(name); }
    else if (type.equals("staff")) { return new Staff(name); }
    else if (type.equals("faculty")) { return new Faculty(name); }
  }
}
