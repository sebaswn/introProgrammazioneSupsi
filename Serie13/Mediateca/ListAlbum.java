class NodeAlbum{
  String title;
  String genre;
  int year;
  NodeArtist artist;
  ListSong songs;
  NodeAlbum next = null;

  NodeAlbum(String t, String g, int y, NodeArtist a ){
    title = t;
    genre = g;
    year = y;
    artist = a;
  }
}

class ListAlbum{
  NodeAlbum head = null;

  void printAll(){
    System.out.println("");
    if(head == null){
      System.out.println("Your list is empty, no albums to show");
    }else{
      NodeAlbum temp = head;
      while(temp != null){
        System.out.println(temp.title + " by " + temp.artist.lastName);
        temp = temp.next;
      }
    }
    System.out.println("");
  }

  void delete(String title){
    NodeAlbum tempNode = head;
    NodeAlbum memNode = null;

    while(tempNode != null && tempNode.title != title){
      memNode = tempNode;
      tempNode = tempNode.next;
    }

    if(memNode == null){
      head = head.next;
    }else if(tempNode == null){
      System.out.println("Your list does not contain this Album");
    }else{
      memNode.next = tempNode.next;
      tempNode.next = null;
    }
  }

  void add(String title, String genre, int year, NodeArtist artist){
    NodeAlbum newNode = new NodeAlbum(title, genre, year, artist);
    if(head == null){
      head = newNode;
    }else{
      NodeAlbum tempNode = head;
      NodeAlbum memNode = null;
      boolean found = false;

      while(tempNode != null && artist.lastName.compareTo(tempNode.artist.lastName) >= 0){
        if(artist.lastName.compareTo(tempNode.artist.lastName) == 0){
          if(artist.name.compareTo(tempNode.artist.name) != 0){
            while(artist.lastName.compareTo(tempNode.artist.lastName) == 0 && artist.name.compareTo(tempNode.artist.name) >= 0){
              if(tempNode == null){
                break;
              }
              memNode = tempNode;
              tempNode = tempNode.next;
            }
          }
        }
        if(tempNode == null){
          break;
        }
        memNode = tempNode;
        tempNode = tempNode.next;
      }

      if(tempNode == head){
        newNode.next = head;
        head = newNode;
      }else{
        newNode.next = tempNode;
        memNode.next = newNode;
      }
    }
  }

}
