class Artist{
  String name;
  String lastName;
//String group;

  Artist(String f, String l){
    name = f;
    lastName = l;
  }

  Artist(String g){
    name = g;
  }

  void show(){
    if(lastName != null){
      System.out.print(name + " " + lastName);
    }else{
      System.out.print(name);
    }
  }
}
