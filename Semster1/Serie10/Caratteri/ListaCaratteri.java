
class Nodo{
    char character;
    Nodo next = null;
}

class Lista{
  Nodo head = null;

  void addHead(char letter){
    Nodo newNodo = new Nodo();
    newNodo.next = head;
    head = newNodo;
    newNodo.character = letter;
  }

  void addToEnd(char letter){
    if(head == null){
      addHead(letter);
    }else{
      Nodo newNodo = new Nodo();
      newNodo.character = letter;
      Nodo temp = head;
      while(temp.next != null){
        temp = temp.next;
      }
      temp.next = newNodo;
    }
  }

  void printAll(){
    if(head == null){
      System.out.println("Your list is empty.");
    }else{
      Nodo temp = head;
      while(temp != null){
        System.out.println(temp.character);
        temp = temp.next;
      }
    }
  }

  void remove(char letter){
    if(head == null){
      System.out.println("Your list is empty.");
    }else{
      Nodo temp = head;
      Nodo tempMem = null;

      while(temp != null && temp.character != letter){
        tempMem = temp;
        temp = temp.next;
      }

      if(temp == null){
          System.out.println("Your list does not contain this letter. Cannot remove it.");
          return;
      }

      if(temp == head){
        head = temp.next;
      }else{
        tempMem.next = temp.next;
        temp.next = null;
      }
    }
  }
}

public class ListaCaratteri{
  public static void main(String[] args){
    Lista list = new Lista();
    list.addToEnd('a');
    list.addToEnd('d');
    list.addToEnd('f');
    list.addToEnd('h');
    list.addToEnd('m');

    list.addToEnd('g');
    list.addToEnd('m');
    list.addToEnd('z');
    list.remove('f');

    list.printAll();
  }
}
