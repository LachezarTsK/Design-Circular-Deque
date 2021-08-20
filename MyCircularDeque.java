
/*
Design of a Circular Deque without applying any of the built-in queue data structures.
 */
public class MyCircularDeque {

    int[] circularDeque;
    int maxCapacity;
    int front;
    int rear;

    // By this design, empty Circular Deque is always with rear = -1 and front = 0.
    public MyCircularDeque(int k) {
        circularDeque = new int[k];
        maxCapacity = k;
        rear = -1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            circularDeque[++rear] = value;
        } else {
            front = front > 0 ? --front : maxCapacity - 1;
            circularDeque[front] = value;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = rear < maxCapacity - 1 ? ++rear : 0;
        circularDeque[rear] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        if (front % maxCapacity != rear % maxCapacity) {
            front = front < maxCapacity - 1 ? ++front : 0;
        } else {
            // deleting the only remaining element.
            front = 0;
            rear = -1;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (front % maxCapacity != rear % maxCapacity) {
            rear = rear > 0 ? --rear : maxCapacity - 1;
        } else {
            // deleting the only remaining element.
            front = 0;
            rear = -1;
        }
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return circularDeque[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return circularDeque[rear];
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear >= 0 && (rear + 1) % maxCapacity == Math.abs(front) % maxCapacity;
    }
}
