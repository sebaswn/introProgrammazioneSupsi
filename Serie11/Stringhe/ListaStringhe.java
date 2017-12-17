import java.util.Scanner;

class Node{
  String word;
  Node next = null;
}

class List{
  Node head = null;

  void delete(String word){

    if(head == null){
      System.out.println("Your list is empty.");
    }else{
      Node temp = head;
      Node tempMem = null;

      while(temp != null && temp.word.equals(word) == false){
        tempMem = temp;
        temp = temp.next;
      }

      if(temp == null){
        System.out.println("Cannot find word in list.");
      }else if(temp == head){
          head = temp.next;
      }else{
        tempMem.next = temp.next;
        temp.next = null;
      }
    }
  }

  void add(String word){
    Node newNode = new Node();
    newNode.word = word;

    if(head == null){
      head = newNode;
    }else if(word.compareTo(head.word) < 0){
        newNode.next = head;
        head = newNode;
    }else{
      Node tempNode = head;
      Node memNode = null;

      while(tempNode != null && word.compareTo(tempNode.word) > 0){
        memNode = tempNode;
        tempNode = tempNode.next;
      }

      if(memNode == null){
        newNode.next = head;
        head = newNode;
      }else{
        newNode.next = tempNode;
        memNode.next = newNode;
      }
    }
  }

  void printAll(){
    System.out.println("");
    if(head == null){
      System.out.println("Your list is empty, nothing to print here");
    }else{
      Node temp = head;
      while(temp != null){
        System.out.println(temp.word);
        temp = temp.next;
      }
    }
      System.out.println("");
  }

  void showLetters(){
    System.out.println("");
    if(head == null){
      System.out.println("Your list is empty. No characters to show");
    }else{
      StringBuilder letters = new StringBuilder();
      Node temp = head;

      while(temp != null){
        int wordLength = temp.word.length();
        letters.append(temp.word.charAt(0));
        letters.append(temp.word.charAt(1));
        letters.append(temp.word.charAt(wordLength - 2));
        letters.append(temp.word.charAt(wordLength - 1));
        letters.append(" ");
        temp = temp.next;
      }

      System.out.println(letters.toString());
      System.out.println("");
    }
  }
}

public class ListaStringhe{
  public static void main(String[] args){
    //test();
    Scanner input = new Scanner(System.in);

    List list = new List();

    System.out.println("Syntax: [command]-[word]");
    System.out.println("Commans: a = add; d = delete; p = print (no word necessary); l = see letters (no word necessary); e = exit (no word necessary)");
    System.out.println("");
    String userCommand;
    do{
      System.out.print("---> ");
      userCommand = input.next();
      String[] userInput = userCommand.split("-");

      switch(userInput[0]){
        case "a":  list.add(userInput[1]);
          break;
        case "d":  list.delete(userInput[1]);
          break;
        case "p": list.printAll();
          break;
        case "l": list.showLetters();
          break;
        case "e":
          break;
        default: System.out.println("Command not valid. Please try again");
      }
    }while(userCommand.charAt(0) != 'e');

    input.close();
  }

  private static void test(){
    List listTest = new List();
    listTest.add("charlie");
    listTest.add("india");
    listTest.add("papa");
    listTest.add("victor");
    listTest.add("whiskey");
    listTest.add("oscar");
    listTest.add("zulu");
    listTest.add("yankee");
    listTest.add("mike");
    listTest.add("juliett");
    listTest.add("echo");
    listTest.add("tango");
    listTest.add("golf");
    listTest.add("alpha");
    listTest.add("romeo");
    listTest.add("foxtrot");
    listTest.add("sierra");
    listTest.add("delta");
    listTest.add("lima");
    listTest.add("bravo");
    listTest.add("quebec");
    listTest.add("uniform");
    listTest.add("kilo");
    listTest.add("hotel");
    listTest.add("xray");
    listTest.add("november");

    listTest.delete("alpha");
    listTest.delete("remeo");
    listTest.delete("kilo");

    listTest.printAll();
    listTest.showLetters();
  }
}
