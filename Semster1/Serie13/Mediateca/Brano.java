class Song{
  String title;
  int length;
  Artist guest;

  Song(String t, int l, Artist g){
    title = t;
    length = l;
    guest = g;
  }

  Song(String t, int l){
    title = t;
    length = l;
  }

  void show(){
    if(guest == null){
      System.out.print(title + " " + length);
    }else{
      System.out.print(title + " " + "ft. " );
      guest.show();
      System.out.print(" " + length);
    }
  }
}
