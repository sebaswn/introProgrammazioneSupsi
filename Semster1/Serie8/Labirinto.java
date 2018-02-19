import javakara.JavaKaraProgram;

/*
 * COMMANDS:
 *   kara.move()           kara.turnRight()      kara.turnLeft()
 *   kara.putLeaf()        kara.removeLeaf()
 * SENSORS:
 *   kara.treeFront()      kara.treeLeft()       kara.treeRight()
 *   kara.mushroomFront()  kara.onLeaf()
 */
public class Labirinto extends JavaKaraProgram {

  private void solve(){
      
      
      if(!kara.treeRight()){
          kara.turnRight();    
      }else if(!kara.treeLeft()){
          kara.turnLeft();
      }else if(kara.treeFront()){
          kara.turnLeft();
          kara.turnLeft();
          if(!kara.onLeaf()){
             kara.putLeaf();
          }
      }
      if(!kara.mushroomFront()){
          if(kara.onLeaf()){
              kara.removeLeaf();
          }else{
              kara.putLeaf();
          }
	      kara.move();
	      solve();
      }else{
          kara.putLeaf();
      }
  }
  
  
  public void myProgram() {
    solve();
  }
}

        