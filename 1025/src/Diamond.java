class Diamond implements Suit {

    public Diamond() {}
    @Override
    public String suitToString() {
        return "◆";
    }

    public int diamondCount() { return 5; }
}
