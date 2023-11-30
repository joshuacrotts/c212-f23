import java.util.ArrayList;
import java.util.List;

class FractionFactory {

  private static final int LIMIT = 500;
  private static List<Fraction> savedFractions;

  public FractionFactory() {
    savedFractions = new ArrayList<>();
    for (int i = 1; i <= LIMIT; i++) {
      savedFractions.add(new Fraction(1, i));
    }
  }

  public Fraction create(int num, int den) {
    // If it's a fraction that we have cached.
    if (den >= 1 && den <= LIMIT) {
      return savedFractions.get(den - 1);
    } else {
      return new Fraction(num, den);
    }
  }
}
