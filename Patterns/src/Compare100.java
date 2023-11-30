import java.util.Arrays;

class Compare100 implements Comparable<Integer> {

  @Override
  public int compareTo(Integer o) {
    if (o > 100) { return 1; }
    else if (o < 100) { return -1; }
    else { return 0; }
  }

  public static boolean isOneHundred(int x, Compare100 obj) {
    return obj.compareTo(x) == 0;
  }

  public static void main(String[] args) {
    int[] array = new int[500];
    for (int i = 0; i < array.length; i++) {
      array[i] = new Compare100().compareTo(i);
    }

    System.out.println(Arrays.toString(array));
  }
}
