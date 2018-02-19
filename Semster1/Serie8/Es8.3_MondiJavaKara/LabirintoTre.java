import javakara.JavaKaraProgram;

/*
 * COMMANDS:
 *   kara.move()           kara.turnRight()      kara.turnLeft()
 *   kara.putLeaf()        kara.removeLeaf()
 * SENSORS:
 *   kara.treeFront()      kara.treeLeft()       kara.treeRight()
 *   kara.mushroomFront()  kara.onLeaf()
 */
public class LabirintoTre extends JavaKaraProgram {
  private void mossa(){ //avanti
      if(kara.onLeaf()){
          ritorno();
      }
	  if(!kara.treeFront()){
	     kara.putLeaf();
	     kara.move();
	     mossa();
	  }
  }
  
  private void solve(){
    mossa();
    if(kara.treeFront()){
      if(!kara.treeLeft() && !kara.onLeaf()){  
        kara.turnLeft();
        solve();
      }else if(kara.onLeaf()){
          ritorno();
      }else{
          kara.turnRight();
          solve();
      }
      
    }
    
  }
  
  private void ritorno(){
      kara.turnRight();
      kara.turnRight();
      kara.move();
      
      if(kara.onLeaf()){
          kara.removeLeaf();
      }
      kara.turnRight();
      kara.turnRight();
      kara.move();
      
      back();
  }
  
  private void back(){
    if(kara.onLeaf()){
        kara.removeLeaf();
    }
	    if(!kara.treeFront()){
	        kara.move();    
	    }else if(!kara.treeLeft()){
	        kara.turnLeft();
	    }else if(!kara.treeRight()){
	        kara.turnRight();
	    }
    
        back();
    
  }
  
  
  public void myProgram() {
    solve();
  }
}

        