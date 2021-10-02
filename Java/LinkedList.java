import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first; // HEAD
    private Node last; // TAIL
    private int size;

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();

        if(first == last){
            first = last = null;
        } else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    public int size(){
        return size; // O(1)
    }

    public int[] toArray(){
        var current = first;
        int[] arr = new int[size];
        int index = 0;
        while(current != null){
            arr[index++] = current.value;
            current = current.next;
        }
        return arr;
    }

    public void reverse(){
        if(first == null)
            return;

        var previous = first;
        var current = first.next;
        while(current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthNodeFromEnd(int k) throws Exception {
        if(isEmpty())
            throw new IllegalStateException();

        if(k<=0)
            throw new Exception("Please enter positive number!");

        var a  = first;
        var b = first;
        for (int i = 0; i < k-1 ; i++) {
            b = b.next;
            if(b==null)
                throw new IllegalArgumentException();
        }
        while(b!=last){
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    private Node getPrevious(Node node){
        var current = first;
        while(current != null){
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }
}