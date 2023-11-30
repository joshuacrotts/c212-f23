import java.util.ArrayList;
import java.util.List;


class Fraction {

  private int numerator;
  private int denominator;
  public Fraction(int num, int den) {
    this.numerator = num;
    this.denominator = den;
  }

  public static void main(String[] args) {
    FractionFactory ff = new FractionFactory();
    List<Fraction> ffList = new ArrayList<>();
    for (int i = 0; i < 500; i++) {
      ffList.add(ff.create(1, 2));
    }

    Fraction first = ffList.get(0);
    for (int i = 1; i < 500; i++) {
      System.out.println(first == ffList.get(i));
    }
  }
}
