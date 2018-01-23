class Mediateca{
  Album head = null;

  void add(Album album){
    if(head == null){
      head = album;
    }else{
      album.next = head;
      head = album;
    }
  }

  void findArtists(String name, String lastName){
    Album tempNode = head;
    while(tempNode.next != null ){
      if(tempNode.artist.firstName == name && tempNode.artist.lastName == lastName){
        tempNode.showWithSongs();
        System.out.println();
      }
      tempNode = tempNode.next;
    }
  }

  void findArtists(String group){
    Album tempNode = head;
    while(tempNode != null ){
      if(tempNode.artist.group == group){
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

}
