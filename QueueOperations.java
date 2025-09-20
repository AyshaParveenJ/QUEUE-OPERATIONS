import java.util.*;
class queue{
    class Node{
        int data;
        Node next;
        public Node(int x){
            this.data = x;
            this.next = null;
        }
    }
    Node rear;
    Node front;
    public queue(){
        this.rear = null;
        this.front = null;
    }
    public void enqueue(int v){
        Node newnode = new Node (v);
        if(rear == null){
            rear = front = newnode;
            rear.next = front;
        }
        else{
            rear.next = newnode;
            rear = newnode;
            rear.next = front;
        }
    }
    public int dequeue(){
        if(isEmpty()){
            return -1;
        }
        int a = front.data;
        if(rear == front){
            front=rear=null;
        }
        else{
            front = front.next;
            rear.next = front;
        }
        return a;
    }
    public int peek(){
       if(isEmpty()){
            return -1;
        }
        return front.data;
    }
    public void display() {
    if (isEmpty()) {
        System.out.println("Queue is empty");
        return;
    }

    System.out.print("Queue elements: ");
    Node temp = front;
    while (true) {
        System.out.print(temp.data + " ");
        temp = temp.next;

        if (temp == front) break;  // circle complete
    }
    System.out.println();
    }
    public boolean isEmpty() {
    return front == null;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue q = new queue();

        while (true) {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = sc.nextInt();
                    q.enqueue(val);
                    break;

                case 2:
                    int rem = q.dequeue();
                    if (rem == -1)
                        System.out.println("Queue is empty");
                    else
                        System.out.println("Dequeued: " + rem);
                    break;

                case 3:
                    int pk = q.peek();
                    if (pk == -1)
                        System.out.println("Queue is empty");
                    else
                        System.out.println("Front element: " + pk);
                    break;

                case 4:
                    q.display();
                    break;

                case 5:
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
