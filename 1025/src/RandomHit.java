import java.util.Random;

class RandomHit implements Player {

    @Override
    public boolean anotherCard() {
        Random r = new Random();
        return r.nextBoolean();
    }

    @Override
    public void addCard(int value) { }

    @Override
    public void print() { }
}
