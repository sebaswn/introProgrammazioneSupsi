import javakara.JavaKaraProgram;

/*
 * COMMANDS:
 *   kara.move()           kara.turnRight()      kara.turnLeft()
 *   kara.putLeaf()        kara.removeLeaf()
 * SENSORS:
 *   kara.treeFront()      kara.treeLeft()       kara.treeRight()
 *   kara.mushroomFront()  kara.onLeaf()
 */
public class LabirintoComplesso extends JavaKaraProgram {

  public void myProgram() {
      boolean finished = false;
      boolean mush = false;
    while(finished == false){
      while(kara.treeLeft()){
        while(kara.treeFront()){
          kara.turnRight();
        }
        if(kara.mushroomFront()){
            mush = !mush;
            kara.turnRight();
            kara.turnRight();
        }
        kara.move();
        if(!kara.onLeaf()&& mush == false){
            kara.putLeaf();
        }else if(kara.onLeaf()&&mush == true){
            kara.removeLeaf();
            
            
        }
        
      }
      
        kara.turnLeft();
        kara.move();
        if(!kara.onLeaf()&&mush==false){
            kara.putLeaf();
        }else if (kara.onLeaf()&&mush==true){
            kara.removeLeaf();
        }
      
    }
  }
}
