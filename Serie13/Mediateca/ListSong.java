class NodeSong{
  String title;
  int length;
  NodeArtist specialGuest;
  NodeSong next = null;

  NodeSong(String t, int l, NodeArtist sg){
    title = t;
    length = l;
    specialGuest = sg;
  }

  NodeSong(String t, int l){
    title = t;
    length = l;
  }
}

class ListSong{
  NodeSong head = null;

  void add(String title, int length, NodeArtist specialGuest){
    NodeSong newNode = new NodeSong(title, length, specialGuest);
    if(head == null){
      head = newNode;
    }else{
      newNode.next = head;
      head = newNode;
    }
  }

  void add(String title, int length){
    NodeSong newNode = new NodeSong(title, length);
    if(head == null){
      head = newNode;
    }else{
      newNode.next = head;
      head = newNode;
    }
  }

  void printAll(){
    System.out.println("");
    if(head == null){
      System.out.println("No songs to display");
    }else{
      NodeSong tempNode = head;
      while(tempNode != null){
        if(tempNode.specialGuest == null){
          System.out.println(tempNode.title +" "+ tempNode.length);
        }else{
          System.out.println(tempNode.title + " "+ tempNode.specialGuest.name +" "+ tempNode.length);
        }
        tempNode = tempNode.next;
      }
    }
    System.out.println("");
  }



}
