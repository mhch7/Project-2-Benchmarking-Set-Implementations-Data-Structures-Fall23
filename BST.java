public class BST<T extends Comparable<? super T>> implements Set<T> {
   AVLTree<T> bst;

  public BST() {
    bst = new AVLTree<>(false);
  }

  public boolean contains(T item) {
    return bst.contains(item);
  }

  public void insert(T item) {
    bst.insert(item);
  }
}
