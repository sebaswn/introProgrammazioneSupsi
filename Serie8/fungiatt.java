import javakara.JavaKaraProgram;

/*
 * COMMANDS:
 *   kara.move()           kara.turnRight()      kara.turnLeft()
 *   kara.putLeaf()        kara.removeLeaf()
 * SENSORS:
 *   kara.treeFront()      kara.treeLeft()       kara.treeRight()
 *   kara.mushroomFront()  kara.onLeaf()
 */
public class Fungiatt extends JavaKaraProgram {
  private boolean noLeaf = false;
  
  private void solve(){
      
      if(!kara.treeLeft()){
          kara.turnLeft();
          if(kara.onLeaf()){
              kara.removeLeaf();
	      }else{
	          kara.putLeaf();
	      }
          kara.move();
          solve();
      }else if(kara.treeFront()){
          kara.turnLeft();
          if(kara.treeFront()){
              kara.turnRight();
              kara.turnRight();
              noLeaf = true;
		  }
          solve();
      }
      
      //kara.move();
      if(kara.onLeaf()){
          kara.removeLeaf();
          noLeaf = false;
      }else if(!kara.onLeaf() && noLeaf == false){
          kara.putLeaf();
          noLeaf = false;
      }
      kara.move();
      solve();
      
  }
  
  
  public void myProgram() {
    solve();
  }
}

        