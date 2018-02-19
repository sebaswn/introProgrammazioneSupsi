class PlaylistNode{
  Song song;
  PlaylistNode next = null;

  PlaylistNode(Song s){
    song = s;
  }
}

class Playlist{
  PlaylistNode head = null;
  PlaylistNode tail = null;

  void enqueue(Song song){
    PlaylistNode newNode = new PlaylistNode(song);
    if(head == null){
      head = newNode;
      tail = newNode;
    }else{
      tail.next = newNode;
      tail = newNode;
    }
  }

  PlaylistNode dequeue(){
    PlaylistNode tempNode = head;
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

}
