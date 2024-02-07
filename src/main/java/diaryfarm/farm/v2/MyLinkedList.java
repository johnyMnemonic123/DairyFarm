package diaryfarm.farm.v2;


import java.util.Iterator;
import java.util.function.Predicate;

public class MyLinkedList<T> implements Iterable<T> {
    Node<T> head;
    private int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
    }

    public Node<T> getHead() {
        return head;
    }


    public void insert(T data) {

        Node<T> node = new Node<T>(data);
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
        size++;
    }

    //todo Predicate ain;t data structure, so hopefully its allowed :)
    public void deleteByPredicate(Predicate<T> predicate) {
        Node<T> currNode = head, prev = null;

        if (currNode != null && predicate.test(currNode.data)) {
            head = currNode.next;
            size--;
        }

        while (currNode != null && !predicate.test(currNode.data)) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null && prev != null) {
            prev.next = currNode.next;
            size--;
        }
    }


    public void printList() {
        Node<T> currNode = head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");
            // Go to next node
            currNode = currNode.next;
        }
        System.out.println();
    }

    // return Iterator instance
    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }
}

class ListIterator<T> implements Iterator<T> {
    Node<T> current;

    public ListIterator(MyLinkedList<T> list) {
        current = list.getHead();
    }

    public boolean hasNext() {
        return current != null;
    }
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T d) {
        data = d;
        next = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }
}

