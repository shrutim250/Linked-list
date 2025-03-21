package LL;
public class DLL {
   private Node head;
   
   public void insertFirst(int val){
    Node node=new Node(val);
    node.next=head;
    node.prev=null;
    if (head != null) {
        head.prev = node;
    }
    head=node;
   }

   public void display(){
    Node temp=head;
    Node last=null;
    while(temp!=null){
        System.out.print(temp.val+" -> ");
        last=temp;
        temp=temp.next;
    }
    System.out.println("END");
    System.out.println("Print in reverse");
    while (last != null) {
        System.out.print(last.val + " -> ");
        last = last.prev;
    }
    System.out.println("START");
   }

  public void insertLast(int val){
  Node temp=new Node(val);
  Node last = head;
  temp.next=null;
  if (head == null) {
    temp.prev = null;
    head = temp;
    return;
}
while (last.next != null) {
    last = last.next;
}
last.next = temp;
temp.prev = last;
   }


public Node find(int value){
    Node temp=head;
    while (temp != null) {
        if (temp.val == value) {
            return temp;
        }
        temp = temp.next;
    }
    return null;
}

public void insert(int after, int val) {
    Node p = find(after);

    if (p == null) {
        System.out.println("does not exist");
        return;
    }

    Node node = new Node(val);
    node.next = p.next;
    p.next = node;
    node.prev = p;
    if (node.next != null) {
        node.next.prev = node;
    }
}

    private class Node {
    int val;
    Node prev;
    Node next;
        public Node (int val){
            this.val=val;
        }

@SuppressWarnings("unused")
public Node(int val,Node prev,Node next){
    this.val=val;
    this.prev=prev;
    this.next=next;
}
    }
    public static void main(String[] args) {
        DLL list=new DLL();
        list.insertFirst(5);
        list.insertFirst(9);
        list.insertFirst(8);
        list.insertFirst(27);
         list.insertLast(45);
         list.insert(8, 78);
        list.display();


    }
}
