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
  
  public void myProgram() {
    while(!kara.onLeaf()){
      while(kara.treeLeft()&&!kara.onLeaf()){
        while(kara.treeFront()){
          kara.turnRight();
        }
        
        kara.move();
      }
      if(!kara.onLeaf()){   
        kara.turnLeft();
        kara.move();
      }
    }
    kara.removeLeaf();
  }
}

        