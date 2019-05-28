package datastructure;

public class PersistentStack<T> {

  private final T top;
  private final PersistentStack<T> next;
  private final int size;

  private PersistentStack(int size, T top, PersistentStack<T> next) {
    this.top = top;
    this.size = size;
    this.next = next;
  }

  public PersistentStack() {
    this.top = null;
    this.next = null;
    this.size = 0;
  }

  public PersistentStack<T> push(T t) {
    return new PersistentStack<>(size + 1, t, this);
  }

  public PersistentStack<T> pop() {
    return next;
  }

  public T peek() {
    return this.top;
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public static void main(String[] args) {

    PersistentStack<Integer> stack = new PersistentStack<>();

    for (int i = 0; i < 5; i++) {
      stack = stack.push(i);
//      System.out.println(stack.size());
    }

//    System.out.println(stack.size());

    while (!stack.isEmpty()) {
      System.out.println(stack.peek());
      stack = stack.pop();
    }


  }

}
