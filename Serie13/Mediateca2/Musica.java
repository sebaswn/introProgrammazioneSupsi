public class Musica{
  public static void main(String[] args){
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

    System.out.println();

    med.add(al1);
    med.add(al2);
    med.add(al3);

    //al3.show();
    //med.findArtists("Corrado", "Pansoni");
    //med.findYear(1998);
    //med.showAllWithSongs();
    //med.showAllWithoutSongs();
  }
}
