public class ListTest{

    public static void main(String[] args) {
        SLL sll = new SLL();
        // sll.find(4);
        sll.add(3);
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        // sll.remove();
        // sll.remove();
        sll.printValues();
        sll.find(15);
        sll.find(6);
    }
} 