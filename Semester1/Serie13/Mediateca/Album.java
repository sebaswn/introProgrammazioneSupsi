class Album{
  String title;
  Artist artist;
  int year;
  String genre;
  Song[] songs = null;
  Album next = null;

  Album(String t, Artist a, int y, String g, Song[] s){
    title = t;
    artist = a;
    year = y;
    genre = g;
    songs = s;
  }

  void showWithSongs(){
    System.out.print(title + " by " );
    artist.show();
    System.out.println( ", " + year + " (" + genre+")");
    for(int i = 0; i < songs.length; i++){
      System.out.print("     " + i + ": " );
      songs[i].show();
      System.out.println("");
    }
    System.out.println("");
  }

  void showWithoutSongs(){
    System.out.print(title + " by " );
    artist.show();
    System.out.println( ", " + year + " (" + genre+")");
    System.out.println("");
  }
}
