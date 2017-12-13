import javakara.JavaKaraProgram;

/*
 * COMMANDS:
 *   kara.move()           kara.turnRight()      kara.turnLeft()
 *   kara.putLeaf()        kara.removeLeaf()
 * SENSORS:
 *   kara.treeFront()      kara.treeLeft()       kara.treeRight()
 *   kara.mushroomFront()  kara.onLeaf()
 */
public class Albero extends JavaKaraProgram {
  
  private boolean take = false;
  
  private void move(){
      
      if(kara.onLeaf()){
        kara.move();
        move();
        kara.turnRight();
        kara.turnRight();
        kara.move();
        kara.turnRight();
        kara.turnRight();
        kara.removeLeaf();
      }else{
        kara.turnRight();
        kara.move();
        kara.turnLeft();
        
        if(kara.onLeaf()){
            move();
        }
        
        kara.turnLeft();
        kara.move();
        kara.move();
        kara.turnRight();
       
        if(kara.onLeaf()){
            move();
        }
       
        kara.turnRight();
        kara.move();
        kara.turnLeft();

  }
}
  
  public void myProgram() {
      move();
  }
}

        