class Node{
  String firstName;
  String lastName;
  Node next = null;

  public Node(String f, String l){
    firstName = f;
    lastName = l;
  }
}

class Tail{
  Node head = null;
  Node tail = null;

  void enqueue(String fName, String lName){
    Node newNode = new Node(fName, lName);

    if(head == null){
      head = newNode;
      tail = newNode;
    }else{
      tail.next = newNode;
      tail = newNode;
    }
  }

  Node dequeue(){
    Node tempNode = head;
    if(head != null){
      head = head.next;
      if(head == null){
        tail = head;
      }
    }else{
      return null;
    }
    return tempNode;
  }

  int dimensions(){
    int counter = 0;
    Node tempNode = head;

    if(head == null){
      return counter;
    }

    while(tempNode != null){
      counter ++;
      tempNode = tempNode.next;
    }
    return counter;
  }
}

public class Traffic{
  public static void main(String[] args){
    Tail firstLight = new Tail();
    Tail secondLight = new Tail();
    Tail thirdLight = new Tail();
    Tail outOfLight = new Tail();

    firstLight.enqueue("Sebastian","Nee");
    firstLight.enqueue("Corrado","Pansoni");
    firstLight.enqueue("Nick","Sala");
    firstLight.enqueue("Simone","Carlesi");
    firstLight.enqueue("Davide","Nasi");
    firstLight.enqueue("Ale","Centazzo");
    firstLight.enqueue("Mattia","Nee");
    firstLight.enqueue("James","Bond");
    firstLight.enqueue("Micheal","Jackson");
    firstLight.enqueue("Freddy","Kreuger");

    System.out.println("-------------------");
    printNumbers(firstLight, secondLight, thirdLight);
    System.out.println("-------------------");
    changeLight(3, firstLight, secondLight);
    printNumbers(firstLight, secondLight, thirdLight);
    System.out.println("-------------------");
    changeLight(2, firstLight, secondLight);
    changeLight(4, secondLight, thirdLight);
    printNumbers(firstLight, secondLight, thirdLight);
    System.out.println("-------------------");
    changeLight(1, firstLight, secondLight);
    changeLight(1, secondLight, thirdLight);
    changeLight(1, thirdLight, outOfLight);
    printNumbers(firstLight, secondLight, thirdLight);
    System.out.println("-------------------");
    changeLight(3, firstLight, secondLight);
    changeLight(3, secondLight, thirdLight);
    changeLight(2, thirdLight, outOfLight);
    printNumbers(firstLight, secondLight, thirdLight);
    System.out.println("-------------------");
    changeLight(0, firstLight, secondLight);
    changeLight(0, secondLight, thirdLight);
    changeLight(4, thirdLight, outOfLight);
    printNumbers(firstLight, secondLight, thirdLight);
    System.out.println("-------------------");
    changeLight(1, firstLight, secondLight);
    changeLight(2, secondLight, thirdLight);
    changeLight(0, thirdLight, outOfLight);
    printNumbers(firstLight, secondLight, thirdLight);
    System.out.println("-------------------");
    changeLight(0, firstLight, secondLight);
    changeLight(0, secondLight, thirdLight);
    changeLight(3, thirdLight, outOfLight);
    printNumbers(firstLight, secondLight, thirdLight);

  }

  public static void changeLight(int num, Tail from, Tail to){
    for(int i = 0; i < num; i ++){
      Node tempNode = from.dequeue();
      to.enqueue(tempNode.firstName, tempNode.lastName);
    }
  }

  public static void printNumbers(Tail one, Tail two, Tail three){
    System.out.println("First Light:  " + one.dimensions());
    System.out.println("Second Light: " + two.dimensions());
    System.out.println("Third Light:  " + three.dimensions());

  }
}
