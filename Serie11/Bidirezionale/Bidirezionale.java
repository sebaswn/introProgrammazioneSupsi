class Node{
  int number;
  Node next = null;
  Node prev = null;
}

class List{
  //Node newNode = new Node();
  Node head = null;
  Node tail = null;

  void printList(){
    System.out.println(" ");

    if(head == null){
      System.out.println("Your list is empty. Nothing to show :'( ");
    }else{
      Node temp = head;
      while(temp != null){
        System.out.println(temp.number);
        temp = temp.next;
      }
    }
    System.out.println(" ");
  }

  void add(int num, boolean ahead){
    Node newNode = new Node();
    if(ahead == true){
      if (head==null){
				newNode.next = tail;
				newNode.prev = null;
				newNode.number = num;
        head = newNode;
			}else{
        newNode.next = head;
        newNode.prev = null;
        newNode.number = num;
        head = newNode;
      }
    }else if(ahead == false){
      if(head == null){
        add(num, true);
        return;
      }else{
        newNode.next = null;
        newNode.prev = tail;
        newNode.number = num;
        Node temp = head;
        while(temp.next != null){
          temp = temp.next;
        }
        temp.next = newNode;
        }
      }
    }

}

public class Bidirezionale{
  public static void main(String[] args){
    List listNumeri = new List();

    listNumeri.add(1,true);
    listNumeri.add(2,true);
    listNumeri.add(3,true);
    listNumeri.add(432,false);
    listNumeri.add(5,false);
    listNumeri.add(22,true);


    listNumeri.printList();

  }
}
