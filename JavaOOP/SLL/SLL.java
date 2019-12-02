public class SLL{

    public Node head;
    public SLL() {
        head = null;
    }



    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } 
        else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    } 

    public void remove() {
        if(head == null) {
            System.out.println("No nodes left to remove");
        }
        else {
            Node runner = head;
            while(runner.next.next != null) {
                runner = runner.next;
            }
            runner.next = null;
        }
    }

    public void printValues() {
        Node runner = head;
        while(runner != null) {
            System.out.println(runner.value);
            runner = runner.next;
        }
    }

    public void find(int value) {
        Node runner = head;
        int counter = -1;
        if(head == null){
            System.out.println("No nodes my dude");
        }
        while(runner != null) {
            counter += 1;
            if (runner.value == value){
                System.out.println("The value " + value + " exists at index of " + counter);
                break;
            }
            else if(runner.next == null) {
                System.out.println("That value doesnt exist mi compadre");
            }
            runner = runner.next;
        }
    }



}