class MyCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Initialize the queue with given capacity
    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Insert element into circular queue
    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) front = 0;
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    // Delete element from circular queue
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (front == rear) { // only one element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        return true;
    }

    // Get front item
    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    // Get rear item
    public int Rear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }
}
