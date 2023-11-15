package java5.linkedLIst;

public class MainCLL {
    public static void main(String[] args) {
        
        CLL list = new CLL();

        list.insert(12);
        list.insert(13);
        list.insert(56);
        list.insert(87);
        list.insert(47);
        list.display();
        System.out.println();
        list.delete(56);
        list.display();
    }
}
