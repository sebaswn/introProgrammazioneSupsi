import javakara.JavaKaraProgram;

/*
 * COMMANDS:
 *   kara.move()           kara.turnRight()      kara.turnLeft()
 *   kara.putLeaf()        kara.removeLeaf()
 * SENSORS:
 *   kara.treeFront()      kara.treeLeft()       kara.treeRight()
 *   kara.mushroomFront()  kara.onLeaf()
 */
public class Labirinto2 extends JavaKaraProgram {
  
  private void solve(){
      if(!kara.treeRight()){
          kara.turnRight();
          if(kara.onLeaf()){
              kara.removeLeaf();
          }
      }else if(kara.treeFront()){
          
          kara.turnLeft();
        
      }
      if(kara.onLeaf()){
              kara.removeLeaf();
          }else{
              kara.putLeaf();
          }
          
      if(!kara.treeFront()){
          
          kara.move();
      }
      if(!kara.mushroomFront()){
        solve();
      }
  }

  public void myProgram() {
    solve();
  }
}

        