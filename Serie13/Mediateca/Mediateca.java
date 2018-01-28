class Mediateca{
  Album head = null;

  void add(Album album){
    Album tmp = head;
    Album mem = null;

    if(head == null){
      head = album;
      return;
    }

    while((tmp != null &&
            tmp.artist.name.compareTo(album.artist.name) < 0 )||
          (tmp != null &&
            tmp.artist.name.compareTo(album.artist.name) == 0 &&
            tmp.title.compareTo(album.title) < 0) ||
          (tmp != null &&
            tmp.artist.name.compareTo(album.artist.name) == 0 &&
            tmp.title.compareTo(album.title) == 0 &&
            tmp.year < album.year)){
      mem = tmp;
      tmp = tmp.next;

    }

    if(tmp == null){
      tmp = album;
      mem.next = tmp;
    }else if(mem == null){
      album.next = head;
      head = album;
    }else{
      album.next = mem.next;
      mem.next = album;
    }
  }

  void remove(String title){
    if(head == null){
     System.out.println("Your list is empty.");
    }else{
      Album temp = head;
      Album tempMem = null;
      while(temp != null && temp.title != title){
        tempMem = temp;
        temp = temp.next;
      }
      if(temp == null){
         System.out.println("Value not found.");
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


  int count(){
    int counter = 0;
    Album tempNode = head;

    while(tempNode != null){
      counter ++;
      tempNode = tempNode.next;
    }

    return counter;
  }

  Album getAlbumNumber(int num){
    Album tempNode = head;
    for(int i = 0;i < num; i++){
      if(tempNode.next != null){
        tempNode = tempNode.next;
      }
    }
    return tempNode;
  }

  void findArtists(String name, String lastName){
    Album tempNode = head;
    while(tempNode.next != null ){
      if(tempNode.artist.name == name && tempNode.artist.lastName == lastName){
        tempNode.showWithSongs();
        System.out.println();
      }
      tempNode = tempNode.next;
    }
  }

  void findArtists(String name){
    Album tempNode = head;
    while(tempNode != null ){
      if(tempNode.artist.name == name){
        tempNode.showWithSongs();
        System.out.println();
      }
      tempNode = tempNode.next;
    }
  }

  void findYear(int year){
    Album tempNode = head;
    while(tempNode != null ){
      if(tempNode.year == year){
        tempNode.showWithSongs();
        System.out.println();
      }
      tempNode = tempNode.next;
    }
  }

  void showAllWithSongs(){
    Album tempNode = head;

    while(tempNode != null){
      tempNode.showWithSongs();
      tempNode = tempNode.next;
    }
  }

  void showAllWithoutSongs(){
    Album tempNode = head;

    while(tempNode != null){
      tempNode.showWithoutSongs();
      tempNode = tempNode.next;
    }
  }

  Playlist createPlaylist(int length){
    Playlist play = new Playlist();
    int x;
    int y;
    for(int i = 0; i<length; i++){
      x = 1+(int)(Math.random() * count());
      //System.out.println("x: " + x);
      y = 1+(int)(Math.random() * getAlbumNumber(x).songs.length);
      //System.out.println("y: " + y);
      play.enqueue(getAlbumNumber(x).songs[y-1]);
    }
    return play;
  }
}
