/**
 * Created by shibayu36 on 2016/12/25.
 */
public class IntQueue2 {
    public int size;
    private IntQueue2Item[] data;
    private IntQueue2Item first;
    private IntQueue2Item last;
    private int maxSize;

    public IntQueue2 (int maxSize) {
        this.maxSize = maxSize;
    }

    public void enqueue(int value) {
        IntQueue2Item item = new IntQueue2Item(value);
        if (this.first == null) {
            this.first = item;
        }
        else {
            this.last.next = item;
        }
        this.last = item;
        this.size++;
    }

    public int dequeue() {
        IntQueue2Item item = this.first;
        this.first = this.first.next;
        this.size--;
        return item.value;
    }
}

class IntQueue2Item {
    IntQueue2Item next;
    int value;

    public IntQueue2Item(int value) {
        this.value = value;
    }

    public void setNext(IntQueue2Item item) {
        this.next = item;
    }
}