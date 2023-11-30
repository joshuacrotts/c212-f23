class Suit {

  public static Suit DIAMOND = new Suit("diamond");
  public static Suit HEART = new Suit("heart");
  public static Suit SPADE = new Suit("spade");
  public static Suit CLUB = new Suit("club");


  private String suit;

  private Suit() {}

  private Suit(String _suit) { this.suit = _suit; }
}
