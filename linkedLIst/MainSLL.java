package java5.linkedLIst;

import java.util.Arrays;

// import java.util.LinkedList;
import java5.linkedLIst.SLL.Node;

public class MainSLL {
    public static void main(String[] args) {
        // LinkedList <Integer> list = new LinkedList<>();
        // list.add(3);

        // SLL list = new SLL();
        // we are inserting the elements at the front
        // list.insertFirst(5);
        // list.insertFirst(6);
        // list.insertFirst(7);
        // list.insertFirst(8);
        // list.insertFirst(9);
        // list.insertLast(4);
        // list.display();
        // list.insertUsingRec(14, 3);
        // list.insertUsingRec(34, 5);
        // list.display();

        // System.out.println(list.deleteFirst());
        // list.display();

        // System.out.println(list.deleteLast());
        // list.display();

        // System.out.println(list.delete(3));
        // list.display();

        // Node search = list.find(2);

        // list.insertLast(1);
        // list.insertLast(1);
        // list.insertLast(1);
        // list.insertLast(2);
        // list.insertLast(3);
        // list.insertLast(3);
        // list.insertLast(3);
        // list.display();
        // list.removeDuplicates();
        // list.display();

        // SLL list1 = new SLL();
        // SLL list2 = new SLL();

        // list1.insertLast(1);
        // list1.insertLast(3);
        // list1.insertLast(5);

        // list2.insertLast(1);
        // list2.insertLast(2);
        // list2.insertLast(3);
        // list2.insertLast(9);
        // list2.insertLast(14);

        // SLL ans = SLL.merge(list1, list2);
        // ans.display();


        // SLL dinchak = new SLL();
        // for (int i = 1; i < 6; i++) {
        //     dinchak.insertLast(i);
            
        // }
        // dinchak.display();
        // dinchak.reverseInPlace();
        // dinchak.display();

        SLL list = new SLL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.display();

        list.backtrack();

        list.display();

        
        


    }

    
}
