import java.util.Random;

public class AVLTree<T extends Comparable<? super T>> {
  private final boolean isBalanced;
  private TreeNode<T> root;

  public AVLTree() {
    this(true);
  }

  public AVLTree(boolean isBalanced) {
    this.isBalanced = isBalanced;
  }

  public static void main(String[] args) {
    AVLTree<Integer> tree = new AVLTree<>();
    Random r = new Random();
    int num;
    for (int i = 0; i < 20; i++) {
      num = r.nextInt(100);
      System.out.println("Inserting " + num);
      tree.insert(num);
    }
    System.out.println("Height: " + tree.height(tree.root));
  }

  public void printTree() {
    if (isEmpty()) {
      System.out.println("Empty tree");
    }

    printTree(root);
  }

  private void printTree(TreeNode<T> tree) {
    if (tree != null) {
      printTree(tree.left);
      System.out.println(tree.data);
      printTree(tree.right);
    }
  }

  private int height(TreeNode<T> subtree) {
    if (subtree == null) {
      return -1;
    }
    return subtree.height;
  }

  public void insert(T item) {
    root = insert(root, item);
  }

  private TreeNode<T> insert(TreeNode<T> subtree, T item) {
    if (subtree == null) {
      return new TreeNode<>(item, null, null);
    }
    int comparison = item.compareTo(subtree.data);
    if (comparison < 0) {
      subtree.left = insert(subtree.left, item);
    } else if (comparison > 0) {
      subtree.right = insert(subtree.right, item);
    }

    if (isBalanced) {
      subtree = balance(subtree);
    }
    return subtree;
  }

  private TreeNode<T> balance(TreeNode<T> subtree) {
    int balance = height(subtree.left) - height(subtree.right);
    if (balance > 1) {
      // left-left or left-right unbalanced
      if (height(subtree.left.left) > height(subtree.left.right)) {
        subtree = rotateRight(subtree);
      } else {

        subtree.left = rotateLeft(subtree.left);
        subtree = rotateRight(subtree);
      }
    } else if (balance < -1) {
      // right-right or right-left
      if (height(subtree.right.right) > height(subtree.right.left)) {
        subtree = rotateLeft(subtree);
      } else {
        subtree.right = rotateRight(subtree.right);
        subtree = rotateLeft(subtree);
      }
    }
    subtree.height = 1 + Math.max(height(subtree.left), height(subtree.right));
    return subtree;
  }

  public boolean contains(T item) {
    return contains(root, item);
  }

  private boolean contains(TreeNode<T> subtree, T item) {
    // first thing to check:
    // what happens if subtree is null?
    // if you forget this you might hit NPE's
    // this is your base case anyway

    if (subtree == null) {
      return false;
    }

    int comparison = item.compareTo(subtree.data);
    if (comparison == 0) {
      return true;
    } else if (comparison < 0) {
      return contains(subtree.left, item);
    } else
      return contains(subtree.right, item);
  }

  public void remove(T item) {
    root = remove(root, item);
  }

  private TreeNode<T> remove(TreeNode<T> subtree, T item) {
    if (subtree == null) {
      return null;
    }
    int comparison = item.compareTo(subtree.data);
    if (comparison < 0) {
      // remove from the left side
      subtree.left = remove(subtree.left, item);
    } else if (comparison > 0) {
      // remove from the right side
      subtree.right = remove(subtree.right, item);
    } else {
      if (subtree.left == null && subtree.right == null) {
        // subtree is a leaf
        return null;
      } else if (subtree.left == null) {
        // has just a right child
        subtree.data = subtree.right.data;
        // recursively delete the right child
        subtree.right = remove(subtree.right, subtree.data);
      } else if (subtree.right == null) {
        // has just a left child
        subtree.data = subtree.left.data;
        subtree.left = remove(subtree.left, subtree.data);
      } else {
        // two children
        // find the successor, and promote it.
        T successor = findMin(subtree.right);
        subtree.data = successor;
        subtree.right = remove(subtree.right, successor);
      }
    }
    subtree = balance(subtree);
    return subtree;
  }

  private T findMin(TreeNode<T> subtree) {
    if (subtree == null) {
      return null;
    }

    while (subtree.left != null) {
      subtree = subtree.left;
    }
    return subtree.data;
  }

  public boolean isEmpty() {
    return root == null;
  }

  private TreeNode<T> rotateLeft(TreeNode<T> subtree) {
    // rotate left around subtree
    // right child becomes the new root
    // the right child's left child becomes the root's right child
    // root becomes the right child's left child
    TreeNode<T> right = subtree.right;
    subtree.right = right.left;
    right.left = subtree;
    subtree.height = 1 + Math.max(height(subtree.left), height(subtree.right));
    right.height = 1 + Math.max(height(right.left), height(right.right));
    return right;
  }

  private TreeNode<T> rotateRight(TreeNode<T> subtree) {
    TreeNode<T> left = subtree.left;
    subtree.left = left.right;
    left.right = subtree;
    // update the heights in both "subtree" and "left"
    subtree.height = 1 + Math.max(height(subtree.left), height(subtree.right));
    left.height = 1 + Math.max(height(left.left), height(left.right));
    return left;
  }

  private static class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;
    int height;

    TreeNode(T d, TreeNode<T> l, TreeNode<T> r) {
      data = d;
      left = l;
      right = r;
      height = 0;
    }
  }
}