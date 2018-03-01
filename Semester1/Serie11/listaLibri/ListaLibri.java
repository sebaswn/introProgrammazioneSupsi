class Node{
  String title;
  String author;
  int year;
  Node next = null;

  Node(String n, String a, int y){
    title = n;
    author = a;
    year = y;
  }
}

class List{
  Node head = null;

  void printAll(){
    System.out.println("");
    if(head == null){
      System.out.println("List is empty, no books to show.");
    }else{
      Node temp = head;
      while(temp != null){
        System.out.print(temp.title + " by " + temp.author + " (" +  temp.year +").");
        System.out.println("");
        temp = temp.next;
      }
    }
  }

  List findYear(int year){
    if(head == null){
      System.out.println("Your list is empty, cannot find book in that year.");
    }else{
      List yearList = new List();
      Node tempNode = head;

      while(tempNode != null){
        if(tempNode.year == year){
            yearList.add(tempNode.title, tempNode.author, tempNode.year);
        }
        tempNode = tempNode.next;
      }
      return yearList;
    }
    return null;
  }


  List findAuthor(String author){
    if(head == null){
      System.out.println("Your list is empty, cannot find author.");
    }else{
      List authorList = new List();
      Node tempNode = head;

      while(tempNode != null){
        if(tempNode.author.equals(author)){
          System.out.println(tempNode.title);
          authorList.add(tempNode.title, tempNode.author, tempNode.year);
        }
        
        tempNode = tempNode.next;
      }
      return authorList;
    }
    return null;
  }

  void delete(String title){
    if(head == null){
      System.out.println("Your list is empty, nothing to delete");
    }else{
      Node tempNode = head;
      Node memNode = null;

      while(tempNode != null && tempNode.title.equals(title) == false){
        memNode = tempNode;
        tempNode = tempNode.next;
      }
      if(memNode == null){
        head = head.next;
      }else if(tempNode == null){
        System.out.println("Your list does not contain this book.");
      }else{
        memNode.next = tempNode.next;
        tempNode.next = null;
      }
    }
  }

  void add(String title, String author, int year){
    Node newNode = new Node(title, author, year);
    Node tempNode = head;
    Node memNode = null;
    if(head == null){
      head = newNode;
    }else{
      //System.out.println(author.compareTo(tempNode.author));
      while(tempNode != null && author.compareTo(tempNode.author) >= 0){

        if(author.compareTo(tempNode.author) == 0){
          while(author.compareTo(tempNode.author) == 0 && title.compareTo(tempNode.title) > 0 ){

            memNode = tempNode;
            tempNode = tempNode.next;
            if(tempNode == null){
              break;
            }
          }
          break;
        }
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
}

public class ListaLibri{
    public static void main(String[] args){
      List list = new List();

      list.add("Game of Thrones", "JRR Martin", 1998);
      list.add("Monkey Farm", "George Orwell", 1970);
      list.add("The House of Spirits", "Isabel Allende", 1945);
      list.add("Invisible Man", "Ralph Ellison", 1995);
      list.add("Animal Farm", "George Orwell", 1976);
      list.add("Left Of Boom", "Millenial Hater", 1988);
      list.add("Rock and Roll History", "Rolling Stones", 1988);
      list.add("American Gods", "Ian Hisplop", 2001);
      list.add("Hitchikers Guide to the Galaxy", "Douglas Adams", 1988);
      list.add("Humans Suck", "George Orwell", 1972);
      //list.delete("The House of Spirits");

      list.printAll();

      System.out.println("---------------------------------------");
      List orwellList = list.findAuthor("George Orwell");
      orwellList.printAll();

      List yearList = list.findYear(1988);
      yearList.printAll();
    }
}
