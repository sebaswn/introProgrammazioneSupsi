class Node{
  int number;
  Node next = null;
  Node prev = null;
}

class List{
  //Node newNode = new Node();
  Node head = null;
  Node tail = null;

  List(){
    addOrdered(11,true);
    addOrdered(24,true);
    addOrdered(321,true);
    addOrdered(43,true);
    addOrdered(51,true);
    addOrdered(9,true);
    addOrdered(21,true);
    addOrdered(104,true);
    addOrdered(3,true);
    addOrdered(56,true);
  }
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

  void remove(double num){
    if(head == null){
      System.out.println("Your list is empty.");
    }else{
      Node temp = head;
      Node tempMem = null;
      Node tempPrev = null;

      while(temp != null && temp.number != num){
        tempPrev = tempMem;
        tempMem = temp;
        temp = temp.next;
      }

      if(temp == null){
          System.out.println("Your list does not contain this number. Cannot remove it.");
          return;
      }

      if(temp == head){
        head = temp.next;
      }else{
        tempMem.prev = tempPrev;
        tempMem.next = temp.next;
        temp.next = null;
      }
    }
  }

  boolean findDuplicate(double num){
    if(head == null){
      return false;
    }else{
      Node temp = head;

      while(temp != null && temp.number != num){
        temp = temp.next;
      }

      if(temp == null){
          return false;
      }

      if(temp == head){
        System.out.println("This number already exists.");
        return true;
      }else{
        System.out.println("This number already exists.");
        return true;
      }
    }
  }

  void addOrdered(int num, boolean ahead){
    Node newNode = new Node();
    Node tempNode = head;
    newNode.number = num;

    if(findDuplicate(num) == false){
      if(ahead == true){
        if(head == null){
          head = newNode;
          tail = newNode;
          return;
        }
        if(head.number > num){
          newNode.next = head;
          head = newNode;
        }else{
          while(tempNode.next != null && tempNode.next.number < num){
            tempNode = tempNode.next;
          }

          newNode.next = tempNode.next;
          if(tempNode.next != null){
            tempNode.next.prev = newNode;
          }else{
            tail = newNode;
          }
          newNode.prev = tempNode;
          tempNode.next = newNode;
        }
      }else{
        if(tail == null){
          addOrdered(num, true);
          return;
        }
        if(tail.number < num){
          newNode.prev = tail;
          tail = newNode;
        }else{
          tempNode = tail;
          while(tempNode.prev != null && tempNode.prev.number > num){
            tempNode = tempNode.prev;
          }
          newNode.prev = tempNode.prev;
          if(tempNode.prev != null){
            tempNode.prev.next = newNode;
          }
          tempNode.prev = newNode;
          newNode.next = tempNode;
        }
      }
    }
  }

  void find(int num){
    System.out.println("");
    if(head == null){
      System.out.println("Your list is empty, nothing to find.");
      return;
    }else{
      Node tempNode = head;

      while(tempNode != null && tempNode.number != num){
        tempNode = tempNode.next;
      }

      if(tempNode == null){
        System.out.println("Your list does not contain this number, cannot find it.");
        return;
      }

      if(tempNode.prev == null){
        System.out.println("----");
      }else{
        System.out.println(tempNode.prev.number);
      }

      System.out.println(tempNode.number);
      if(tempNode.next == null){
        System.out.println("----");
      }else{
        System.out.println(tempNode.next.number);
      }
    }
    System.out.println("");
  }

  void filter(int minNum, int maxNum){
    int counter = 0;
    System.out.println("");
    if(head == null){
      System.out.println("Your list is empty, nothing to filter.");
      return;
    }else{
      Node tempNode = head;
      while(tempNode != null){
        if(tempNode.number > minNum && tempNode.number < maxNum){
          System.out.println(tempNode.number);
          counter ++;
        }else if(tempNode.number> maxNum){
          break;
        }
        tempNode = tempNode.next;
      }
    }

    if(counter == 0){
      System.out.println("There are no numbers in your field");
    }
    System.out.println("");
  }
}

public class Bidirezionale{
  public static void main(String[] args){
    List listNumeri = new List();

    listNumeri.printList();

    listNumeri.addOrdered(423,true);
    listNumeri.addOrdered(1,false);
    listNumeri.addOrdered(5,true);
    listNumeri.addOrdered(352,false);
    listNumeri.addOrdered(78,true);

    listNumeri.printList();

    listNumeri.remove(43);
    listNumeri.remove(51);
    listNumeri.remove(9);
    listNumeri.remove(21);
    listNumeri.remove(104);

    listNumeri.find(5);
    listNumeri.filter(10,200);
  }
}
