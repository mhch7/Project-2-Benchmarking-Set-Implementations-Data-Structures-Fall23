import java.util.ArrayList;

public class ArrayListSet<T> implements Set<T> {
  private ArrayList<T> l;

  public ArrayListSet() {
    l = new ArrayList<>();
  }

  public boolean contains(T item) {
    return l.contains(item);
  }

  public void insert(T item) {
    if (!l.contains(item)) {
      l.add(item);
    }
  }
}