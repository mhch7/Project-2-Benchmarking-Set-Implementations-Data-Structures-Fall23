public class AVLTreeSet<T extends Comparable<? super T>> implements Set<T> {
  private AVLTree<T> AVLTree = new AVLTree<>();

  public boolean contains(T item) {
    return AVLTree.contains(item);
  }

  public void insert(T item) {
    AVLTree.insert(item);
  }
}
