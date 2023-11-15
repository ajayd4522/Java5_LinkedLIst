package java5.linkedLIst;

public class MainDLL {
    public static void main(String[] args) {

        DLL list = new DLL();
        // we are inserting the elements at the front
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertFirst(7);
        list.insertFirst(8);
        list.insertFirst(9);
        list.insertFirst(10);
        
        list.insertLast(4);
        list.display();
        System.out.println();

        list.insertAfterIndex(14, 4);
        list.display();
        System.out.println();


        list.insertAfterValue(25, 7);
        list.display();
        System.out.println();

        
    }
}
