import java.util.Random;

public class Benchmark {
  public void insertRandoms(Set<Integer> set, int n) {
    long startTime = System.nanoTime();
    Random r = new Random();

    for (int i = 0; i < n; i++) {
      set.insert(r.nextInt());
    }

    long endTime = System.nanoTime();
    long difference = endTime - startTime;

    System.out.println("Time to insert " + n + " random numbers: " + difference + " nanoseconds");
  }

  public void insertInOrder(Set<Integer> set, int n) {
    long startTime = System.nanoTime();

    for (int i = 0; i < n; i++) {
      set.insert(i);
    }

    long endTime = System.nanoTime();
    long difference = endTime - startTime;

    System.out.println("Time to insert numbers from 0 to " + (n - 1) + " in order: " + difference + " nanoseconds");
  }

  public void containsRandom(Set<Integer> set, int size, int n, int numSearches) {
    Random r = new Random();
    for (int i = 0; i < size; i++) {
      set.insert(r.nextInt(n));
    }

    long startTime = System.nanoTime();

    for (int i = 0; i < numSearches; i++) {
      int target = r.nextInt(n);
      set.contains(target);
    }

    long endTime = System.nanoTime();
    long difference = endTime - startTime;

    System.out
        .println("Time to perform " + numSearches + " random contains: " + difference + " nanoseconds");
  }

  public void containsInOrder(Set<Integer> set, int size, int n, int numSearches) {
    for (int i = 0; i < size; i++) {
      set.insert(i);
    }

    long startTime = System.nanoTime();

    for (int i = 0; i < numSearches; i++) {
      int target = i % size;
      set.contains(target);
    }

    long endTime = System.nanoTime();
    long difference = endTime - startTime;

    System.out
        .println("Time to perform " + numSearches + " ordered contains: " + difference + " nanoseconds");
  }
}
