import javakara.JavaKaraProgram; 

enum Direzione{
    SU, GIU
}

public class OrdinaMondo extends JavaKaraProgram { 
     
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
    
    public void myProgram() {
      int[] quadrifogli = new int[world.getSizeY()-2];
      
      for(int x = 0; x < quadrifogli.length; x++){
		  quadrifogli[x] = leggiRiga();
		  cambiaRiga(Direzione.GIU, 1);
      }
      
      cambiaRiga(Direzione.SU, world.getSizeY()-1);
      
      for (int i = 0; i < quadrifogli.length - 1; i++) {

            if (quadrifogli[i + 1] < quadrifogli[i]) {
                int j = i;
                while (quadrifogli[j + 1] < quadrifogli[j] && j >= 0) {

                    int tempVar = quadrifogli[j];
                    quadrifogli[j] = quadrifogli[j + 1];
                    quadrifogli[j + 1] = tempVar;
                    if (j > 0) {
                        j = j - 1;
                    }
                }
            }
        }
       for (int y = 0; y <quadrifogli.length; y++){
           scriviRiga(quadrifogli[y]);
           cambiaRiga(Direzione.GIU, 1);
       }
        
    }
}       