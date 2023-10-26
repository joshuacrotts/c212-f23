class AlwaysHit implements Player, Print {
    @Override
    public boolean anotherCard() { return true; }

    @Override
    public void addCard(int value) {}

    @Override
    public void print() { System.out.println("Always hit!"); }
}
