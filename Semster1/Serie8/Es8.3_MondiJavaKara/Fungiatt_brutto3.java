import javakara.JavaKaraProgram;

/*
 * COMMANDS:
 *   kara.move()           kara.turnRight()      kara.turnLeft()
 *   kara.putLeaf()        kara.removeLeaf()
 * SENSORS:
 *   kara.treeFront()      kara.treeLeft()       kara.treeRight()
 *   kara.mushroomFront()  kara.onLeaf()
 */
public class Fungiatt_brutto3 extends JavaKaraProgram {
  // Procedura percorso 
  private void percorso() {
      if (kara.onLeaf()) {
          kara.removeLeaf();
          if (!kara.treeRight()) {
            kara.turnRight();
            kara.move();
          }
          else if (!kara.treeLeft()) {
            kara.turnLeft();
            kara.move();
          }
          else 
            kara.move();
          percorso();
      }
      else {
        if (!kara.mushroomFront()) {
	        if (kara.treeRight() && kara.treeLeft()) {
		        if (!kara.treeFront()) {
		            kara.putLeaf();
	                kara.move();
	            }
		        else {
		            kara.turnRight();
		            kara.turnRight();
                    kara.putLeaf();
                    kara.move();
                    if (kara.onLeaf()) {
                        kara.turnRight();
                        kara.turnRight();
                        kara.move();
                        kara.removeLeaf();
                        kara.turnRight();
                        kara.turnRight();
                        kara.move();       
                    }
		        }
		        percorso();
		    } else if (kara.treeLeft()) {
		        kara.turnRight();
	            kara.putLeaf();
			    if (!kara.mushroomFront()) {
	                kara.move();
			        percorso();
	            }
		    } else {
		        if(!kara.onLeaf()){
                    kara.turnLeft();
                }
	            kara.putLeaf();
	            if (!kara.mushroomFront()) {
			        kara.move();
			        percorso(); 
	            }
		    }
		 } else 
	        kara.putLeaf();
      }
  }
  public void myProgram() {
    percorso();
  }
}