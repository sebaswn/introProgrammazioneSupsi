import javakara.JavaKaraProgram;
/*
 * COMMANDS:
 *   kara.move()           kara.turnRight()      kara.turnLeft()
 *   kara.putLeaf()        kara.removeLeaf()
 * SENSORS:
 *   kara.treeFront()      kara.treeLeft()       kara.treeRight()
 *   kara.mushroomFront()  kara.onLeaf()
 */
enum Direzione{
		SU, GIU
	}
	
public class OrdinaIlMondo extends JavaKaraProgram {
    
  private void scriviRiga(int cnt){
     boolean done = false;
     for(int x = cnt; x>0; x--){
         if(kara.onLeaf()&& !kara.treeFront()){
             kara.move();
         }else{
             kara.putLeaf();
             if(!kara.treeFront()){
                 kara.move();
             }else{
                 done = true;
             }
         }
     }
     while(kara.onLeaf()&&done == false){
         if (kara.onLeaf()){
             kara.removeLeaf();
         }
         if(!kara.treeFront()){
            kara.move();
         }
     }
  }
  
  private void cambiaRiga(Direzione dir, int offset){
      kara.turnRight();
      kara.turnRight();
      while(!kara.treeFront()){
          kara.move();
      }
      
      
 
      if (dir == Direzione.GIU){
          kara.turnLeft();
          for(int i = offset; i>0; i--){
              if(!kara.treeFront()){
                 kara.move();
              }
          }
          kara.turnLeft();
      }else{
          kara.turnRight();
           for(int i = offset; i>0; i--){
               if(!kara.treeFront()){
                 kara.move();
              }
           }
          kara.turnRight();
          
      }
  }
  
  private int leggiRiga(){
      int numberOfLeaves = 0;
      
      while(kara.onLeaf()){
          numberOfLeaves ++;
          if(!kara.treeFront()){
            kara.move();
          }else{
              break;
          }
      }
      return numberOfLeaves;
      
  }
  
  public void myProgram() {
      int num = 0;
      int num2 = 0;
      num = leggiRiga();
      
      while(!kara.treeRight()){
	     cambiaRiga(Direzione.GIU, 1);
	     num2 = leggiRiga();
	     
	     if (num > num2){
	        cambiaRiga(Direzione.SU, 1);
	        scriviRiga(num2);
	        cambiaRiga(Direzione.GIU, 1);
	        scriviRiga(num);
            cambiaRiga(Direzione.SU,3);
            
	     }else{
           
         }

        num = num2;
        num2 = 0;
      }
    
  }
}

        