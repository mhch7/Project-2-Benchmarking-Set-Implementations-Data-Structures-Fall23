public class Main {
  public static void main(String[] args) {
    Set<Integer> arrayListSet = new ArrayListSet<>();
    Set<Integer> avlTreeSet = new AVLTreeSet<>();
    Set<Integer> bst = new BST<>();

    Benchmark b = new Benchmark();

    int n = 1000;
    int size = 1000;
    int numSearches = 1000;

    System.out.println("Benchmarking insertRandoms:");
    b.insertRandoms(arrayListSet, n);
    b.insertRandoms(avlTreeSet, n);
    b.insertRandoms(bst, n);

    System.out.println("Benchmarking insertInOrder:");
    b.insertInOrder(arrayListSet, n);
    b.insertInOrder(avlTreeSet, n);
    b.insertInOrder(bst, n);

    System.out.println("Benchmarking containsRandom:");
    b.containsRandom(arrayListSet, size, n, numSearches);
    b.containsRandom(avlTreeSet, size, n, numSearches);
    b.containsRandom(bst, size, n, numSearches);

    System.out.println("Benchmarking containsInOrder:");
    b.containsInOrder(arrayListSet, size, n, numSearches);
    b.containsInOrder(avlTreeSet, size, n, numSearches);
    b.containsInOrder(bst, size, n, numSearches);
  }
}
