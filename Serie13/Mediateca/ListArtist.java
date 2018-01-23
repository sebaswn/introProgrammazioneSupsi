class NodeArtist{
  String name;
  String lastName;
  String group;
  NodeArtist next = null;

  NodeArtist(String n, String ln){
    name = n;
    lastName = ln;
  }

  NodeArtist(String g){
    group = g;
  }
}

class ListArtist{
  NodeArtist head = null;

  void printAll(){
    System.out.println("");
    if(head == null){
      System.out.println("Your list is empty, no albums to show");
    }else{
      NodeArtist temp = head;
      while(temp != null){
        if(temp.name != null){
          System.out.println(temp.name + " " + temp.lastName);
        }else{
          System.out.println(temp.group);
        }
        temp = temp.next;
      }
    }
    System.out.println("");
  }

  NodeArtist find(String name, String lastName){
    if(head == null){
      //System.out.println("Your list is empty, cannot find artist");
      return null;
    }else{
      NodeArtist tempNode = head;

      while(tempNode != null){
        if(tempNode.name.equals(name) && tempNode.lastName.equals(lastName)){
          return tempNode;
        }
        tempNode = tempNode.next;
      }
      return null;
    }
  }

  NodeArtist add(String name, String lastName){
    if(find(name, lastName) != null){
      return find(name, lastName);
    }else{
      NodeArtist newNode = new NodeArtist(name, lastName);
      if(head == null){
        head = newNode;
      }else{
        newNode.next = head;
        head = newNode;
      }
      return newNode;
    }
  }
}
