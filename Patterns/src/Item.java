interface ItemVisitor {
  void visitFruit(Fruit f);
  void visitCereal(Cereal c);
  void visitMilk(Milk m);
}

interface Item {
  void visit(ItemVisitor visitor);
}

class Fruit implements Item {
  private String name;
  private int weight;

  public Fruit(String name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  public String getName() { return this.name; }
  public int getWeight() { return this.weight; }

  @Override
  public void visit(ItemVisitor visitor) {
    visitor.visitFruit(this);
  }
}

class Cereal implements Item {
  private String brand;
  private String cartoon;

  public Cereal(String brand, String cartoon) {
    this.brand = brand;
    this.cartoon = cartoon;
  }

  public String getBrand() { return this.brand; }
  public String getCartoon() { return this.cartoon; }

  @Override
  public void visit(ItemVisitor visitor) {
    visitor.visitCereal(this);
  }
}

class Milk implements Item {
  private boolean skim;
  private int weight;

  public Milk(boolean skim, int weight) {
    this.skim = skim;
    this.weight = weight;
  }

  public boolean isSkim() { return this.skim; }
  public int getWeight() { return this.weight; }

  @Override
  public void visit(ItemVisitor visitor) {
    visitor.visitMilk(this);
  }
}

class PrintItemVisitor implements ItemVisitor {

  @Override
  public void visitFruit(Fruit f) {
    System.out.printf("%s (%doz)\n", f.getName(), f.getWeight());
  }

  @Override
  public void visitCereal(Cereal c) {
    System.out.printf("%s: %s\n", c.getBrand(), c.getCartoon());
  }

  @Override
  public void visitMilk(Milk m) {
    System.out.printf("%s milk (%doz)\n", m.isSkim() ? "Skim" : "Regular", m.getWeight());
  }
}

class Main {
  public static void main(String[] args) {
    Item fruit = new Fruit("apple", 200);
    Item cereal = new Cereal("frosted flakes", "tony the tiger");
    Item milk = new Milk(true, 16);
    ItemVisitor iv = new PrintItemVisitor();
    fruit.visit(iv);
    cereal.visit(iv);
    milk.visit(iv);
  }
}