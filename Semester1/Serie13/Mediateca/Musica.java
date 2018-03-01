public class Musica{
  public static void main(String[] args){
    //testDev();
    test();
  }

  private static void test(){
    Mediateca med = new Mediateca();

    Artist art1 = new Artist("Green Day");
    Artist art2 = new Artist("Micheal","Jackson");
    Artist art3 = new Artist("Jackson 5");
    Artist art4 = new Artist("Corrado","Pansoni");

    Song a = new Song("Basket Case", 124);
    Song b = new Song("American Idiot", 243, art2 );
    Song c = new Song("21 Guns", 563);
    Song d = new Song("Billie Jean", 534);
    Song e = new Song("Thriller", 243, art4 );
    Song f = new Song("Come I Bambino", 563);
    Song g = new Song("Addio Lugano", 23);
    Song h = new Song("Splendido Splendente", 432);
    Song i = new Song("La Vita Mia", 875, art3 );
    Song j = new Song("Come Vorrei", 54);

    Song[] s1 = {a,b,c};
    Song[] s2 = {d,e};
    Song[] s3 = {f,g,h,i,j};

    Album al1 = new Album("American Idiot", art1, 1998, "Punk-Rock", s1);
    Album al2 = new Album("Black or White", art2, 1998, "Pop", s2);
    Album al3 = new Album("Addio", art4, 4636, "jazz", s3);
    Album al4 = new Album("Buongiorno", art4, 2341, "Pop", s1);
    Album al5 = new Album("Ciao", art3, 1234, "electro", s3);

    med.add(al1);
    med.add(al2);
    med.add(al3);
    med.add(al4);
    med.add(al5);

    System.out.println("Album da Corrado Pansoni");
    med.findArtists("Corrado", "Pansoni");

    System.out.println("Canzoni del 1998");
    med.findYear(1998);
    med.remove("Addio");

    System.out.println("Playlist 1");
    Playlist pl1 = med.createPlaylist(3);
    PlaylistNode ps1 = pl1.dequeue();
    ps1.song.show();
    System.out.println();
    PlaylistNode ps2 = pl1.dequeue();
    ps2.song.show();
    System.out.println();
    PlaylistNode ps3 = pl1.dequeue();
    ps3.song.show();
    System.out.println();

    System.out.println("");
    System.out.println("Playlist 2");
    Playlist pl2 = med.createPlaylist(5);
    PlaylistNode p2s1 = pl2.dequeue();
    p2s1.song.show();
    System.out.println();
    PlaylistNode p2s2 = pl2.dequeue();
    p2s2.song.show();
    System.out.println();
    PlaylistNode p2s3 = pl2.dequeue();
    p2s3.song.show();
    System.out.println();
    PlaylistNode p2s4 = pl2.dequeue();
    p2s4.song.show();
    System.out.println();
    PlaylistNode p2s5 = pl2.dequeue();
    p2s5.song.show();
    System.out.println();


    System.out.println("----------------");
    System.out.println("----------------");
    System.out.println("----------------");
    med.showAllWithoutSongs();
    System.out.println(med.count());
    med.findArtists("Corrado", "Pansoni");




  }

  private static void testDev(){
    Mediateca med = new Mediateca();

    //Creando artisti
    Artist art1 = new Artist("Green Day");
    Artist art2 = new Artist("Micheal","Jackson");
    Artist art3 = new Artist("Jackson 5");
    Artist art4 = new Artist("Corrado","Pansoni");

    //Creando canzoni
    Song a = new Song("Basket Case", 124);
    Song b = new Song("American Idiot", 243, art2 );
    Song c = new Song("21 Guns", 563);
    Song d = new Song("Billie Jean", 534);
    Song e = new Song("Thriller", 243, art4 );
    Song f = new Song("Come I Bambino", 563);
    Song g = new Song("Addio Lugano", 23);
    Song h = new Song("Splendido Splendente", 432);
    Song i = new Song("La Vita Mia", 875, art3 );
    Song j = new Song("Come Vorrei", 54);

    //Aggiungi canzoni
    Song[] s1 = {a,b,c};
    Song[] s2 = {d,e};
    Song[] s3 = {f,g,h,i,j};


    Album al1 = new Album("American Idiot", art1, 1998, "Punk-Rock", s1);
    Album al2 = new Album("Black or White", art2, 1998, "Pop", s2);
    Album al3 = new Album("Addio", art4, 4636, "jazz", s3);
    med.add(al1);
    med.add(al2);
    med.add(al3);

    // Playlist pl1 = med.createPlaylist(3);
    //
    // PlaylistNode ps1 = pl1.dequeue();
    // ps1.song.show();
    // System.out.println();
    // PlaylistNode ps2 = pl1.dequeue();
    // ps2.song.show();
    // System.out.println();
    // PlaylistNode ps3 = pl1.dequeue();
    // ps3.song.show();
    // System.out.println();
    //
    // System.out.println();


    //al3.showWithSongs();
    //med.findArtists("Corrado", "Pansoni");
    //med.findYear(1998);
    //med.showAllWithSongs();
    med.showAllWithoutSongs();
    System.out.println(med.count());
    //med.remove("Addio");
    //System.out.println();
    //med.showAllWithoutSongs();
  }
}
