/**
 * Created by shibayu36 on 2016/12/25.
 */
public class IntQueue1 {
    private int size;
    private int[] data;
    private int top;
    private int maxSize;

    public IntQueue1(int maxSize) {
        this.maxSize = maxSize;
        this.top = 0;
        this.data = new int[maxSize];
        this.size = 0;
    }

    public void enqueue(int item) {
        this.data[ (this.top + this.size) % this.maxSize ] = item;
        this.size++;
    }

    public int dequeue() {
        int item = this.data[this.top];
        this.top = (this.top + 1) % this.maxSize;
        this.size--;
        return item;
    }

    public int getSize() {
        return this.size;
    }
}
