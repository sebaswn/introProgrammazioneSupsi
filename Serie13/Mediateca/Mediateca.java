public class Mediateca{
  public static void main(String[] args){
    ListAlbum albums = new ListAlbum();
    ListArtist artists = new ListArtist();


    albums.add("Let the Boogie Loose", "Blues", 1967, artists.add("Brain", "Bukit"));
    albums.add("American Idiots", "Punk-Rock", 1998, artists.add("Green","Day"));
    // albums.delete("American Idiost");
    // albums.add("American Idiot");
    // albums.add("Cleopatra");
    albums.add("Mutual Friends", "Pop", 20014,artists.add("bekam","Andews"));
    albums.add("Antique Show", "Pop", 20014,artists.add("adam","Andews"));
    albums.add("Rick and roll", "Pop", 20014,artists.add("david","pauls"));
    albums.printAll();

    //System.out.println("");

    artists.add("Sebastian", "Nee");
    artists.add("James", "Bond");
    artists.add("Sebastian", "Nee");
    artists.add("Micheal", "Jackson");
    artists.printAll();

    //System.out.println("");

    ListSong songs = new ListSong();
    // songs.add("21 Guns", 234);
    // songs.add("Shoot and Run", 666);
    // songs.add("Little Numbers", 1254, artists.add("Vicky", "Nee"));
    // songs.add("'Little Boy'", 100);
    // songs.printAll();
    // artists.printAll();




    //TailPlaylist playList = new TailPlaylist();
    //playList.enqueue.


  }

}
