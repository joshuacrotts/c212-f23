class Stand17 implements Player {

    private int hand;

    public Stand17() { this.hand = 0; }

    @Override
    public boolean anotherCard() {
        return this.hand < 17;
    }

    @Override
    public void addCard(int value) {
        this.hand += value;
    }

    @Override
    public void print() { }
}
