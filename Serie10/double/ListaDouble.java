class Nodo{
    double number;
    Nodo next = null;
}

class Lista{
  Nodo head = null;

  void addHead(double num){
    Nodo newNodo = new Nodo();
    newNodo.next = head;
    head = newNodo;
    newNodo.number = num;
  }

  void addToEnd(double num){
    if(head == null){
      addHead(num);
    }else{
      Nodo newNodo = new Nodo();
      newNodo.number = num;
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
        System.out.println(temp.number);
        temp = temp.next;
      }
    }
      System.out.println("");
  }

  void remove(double num){
    if(head == null){
      System.out.println("Your list is empty.");
    }else{
      Nodo temp = head;
      Nodo tempMem = null;

      while(temp != null && temp.number != num){
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
        tempMem.next = temp.next;
        temp.next = null;
      }
    }
  }

  Nodo find(double num){
    if(head == null){
      System.out.println("Your list is empty.");
      return null;
    }else{
      Nodo temp = head;

      while(temp != null && temp.number != num){
        temp = temp.next;
      }

      if(temp == null){
          System.out.println("Your list does not contain this number. Cannot find it.");
          return null;
      }

      if(temp == head){
        return head;
      }else{
        return temp;
      }
    }
  }

  void copyList(Lista originalList){
    Nodo tempNodo = originalList.head;

    if(tempNodo == null){
      System.out.println("Your list is empty. Nothing to copy.");
    }else{
      while(tempNodo != null){
        addToEnd(tempNodo.number);
        tempNodo = tempNodo.next;
      }
    }
  }

  void copyListReverse(Lista originalList){
    Nodo tempNodo = originalList.head;

    if(tempNodo == null){
      System.out.println("Your list is empty. Nothing to copy.");
    }else{
      while(tempNodo != null){
        addHead(tempNodo.number);
        tempNodo = tempNodo.next;
      }
    }
  }
}

public class ListaDouble{
  public static void main(String[] args){
    Lista list = new Lista();
    list.addToEnd(1);
    list.addToEnd(2);
    list.addToEnd(3);
    list.addToEnd(4);
    list.addToEnd(5);
    list.addToEnd(6);
    list.addToEnd(7);
    list.addToEnd(8);
    list.addToEnd(9);

    Lista list2 = new Lista();
    list2.copyList(list);
    list2.printAll();

    Lista list3 = new Lista();
    list3.copyListReverse(list);
    list3.printAll();
  }
}
