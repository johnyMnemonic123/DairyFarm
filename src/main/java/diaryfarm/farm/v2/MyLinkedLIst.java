package diaryfarm.farm.v2;


public class MyLinkedLIst<T> {
    Node<T> head;

    static class Node<T> {

        T data;
        Node<T> next;

        Node(T d) {
            data = d;
            next = null;
        }
    }

    public MyLinkedLIst insert(MyLinkedLIst list, T data) {

        Node<T> node = new Node<T>(data);
        node.next = null;

        if (list.head == null) {
            list.head = node;
        } else {
            Node<T> last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
        return list;
    }



    public MyLinkedLIst deleteByKey(MyLinkedLIst list,T key) {
        Node<T> currNode = list.head, prev = null;

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;
          //  System.out.println(key + " found and deleted");
            return list;
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
        }

        return list;
    }

    public  MyLinkedLIst deleteAtPosition(MyLinkedLIst list, int index) {
        Node currNode = list.head, prev = null;

        if (index == 0 && currNode != null) {
            list.head = currNode.next;
            return list;
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
        return list;
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
    }

    public static void main(String[] args) {
        /* Start with the empty list. */
//        MyLinkedLIst list = new MyLinkedLIst();
//
//        //
//        // ******INSERTION******
//        //
//
//        // Insert the values
//        list = insert(list, 1);
//        list = insert(list, 2);
//        list = insert(list, 3);
//        list = insert(list, 4);
//        list = insert(list, 5);
//        list = insert(list, 6);
//        list = insert(list, 7);
//        list = insert(list, 8);
//
//        // Print the LinkedList
//        printList(list);
//
//        //
//        // ******DELETION BY KEY******
//        //
//
//        // Delete node with value 1
//        // In this case the key is ***at head***
//        deleteByKey(list, 1);
//
//        // Print the LinkedList
//        printList(list);
//
//        // Delete node with value 4
//        // In this case the key is present ***in the
//        // middle***
//        deleteByKey(list, 4);
//
//        // Print the LinkedList
//        printList(list);
//
//        // Delete node with value 10
//        // In this case the key is ***not present***
//        deleteByKey(list, 10);
//
//        // Print the LinkedList
//        printList(list);
//
//        //
//        // ******DELETION AT POSITION******
//        //
//
//        // Delete node at position 0
//        // In this case the key is ***at head***
//        deleteAtPosition(list, 0);
//
//        // Print the LinkedList
//        printList(list);
//
//        // Delete node at position 2
//        // In this case the key is present ***in the
//        // middle***
//        deleteAtPosition(list, 2);
//
//        // Print the LinkedList
//        printList(list);
//
//        // Delete node at position 10
//        // In this case the key is ***not present***
//        deleteAtPosition(list, 10);
//
//        // Print the LinkedList
//        printList(list);
    }
}
