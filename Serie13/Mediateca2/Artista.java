class Artist{
  String firstName;
  String lastName;
  String group;

  Artist(String f, String l){
    firstName = f;
    lastName = l;
  }

  Artist(String g){
    group = g;
  }

  void show(){
    if(group == null){
      System.out.print(firstName + " " + lastName);
    }else{
      System.out.print(group);
    }
  }
}
