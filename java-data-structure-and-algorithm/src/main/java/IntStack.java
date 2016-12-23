/**
 * Created by shibayu36 on 2016/12/23.
 */
public class IntStack {
    private int maxSize;
    private int[] data;
    private int top;

    public IntStack(int maxSize) {
        this.maxSize = maxSize;
        this.data = new int[maxSize];
        this.top = 0;
    }

    public void push(int x) {
        if (this.isFull()) {
            throw new RuntimeException("Stack is full");
        }

        this.data[this.top] = x;
        this.top++;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        this.top--;
        return this.data[this.top];
    }

    public int size() {
        return this.top;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean isFull() {
        return this.size() == maxSize;
    }
}
