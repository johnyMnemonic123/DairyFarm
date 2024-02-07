package diaryfarm.farm.v2;


import java.util.function.Predicate;

public class MyLinkedList<T> {
    Node<T> head;

    static class Node<T> {

        T data;
        Node<T> next;

        Node(T d) {
            data = d;
            next = null;
        }
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
    }
    //todo Predicate ain;t data structure, so hopefully its allowed :)
    public void deleteByPredicate(Predicate<T> predicate) {
        Node<T> currNode = head, prev = null;

        if (currNode != null &&  predicate.test(currNode.data)) {
            head = currNode.next;
        }

        while (currNode != null && !predicate.test(currNode.data)) {
            prev = currNode;
            currNode = currNode.next;
        }
        if (currNode != null && prev != null) {
            prev.next = currNode.next;
        }
    }


    public T deleteByKey(T key) {
        Node<T> currNode = head, prev = null;

        if (currNode != null && currNode.data == key) {
            head = currNode.next;
            return key;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            prev.next = currNode.next;
            System.out.println(key + " found and deleted");
        }

        if (currNode == null) {
            System.out.println(key + " not found");
            return null;
        }

        return key;
    }

    public void deleteAtPosition(int index) {
        Node<T> currNode = head, prev = null;
        if (index == 0 && currNode != null) {
            head = currNode.next;

        }
        int counter = 0;
        while (currNode != null) {

            if (counter == index) {
                prev.next = currNode.next;
                break;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
    }

    public void printList()
    {
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

}
