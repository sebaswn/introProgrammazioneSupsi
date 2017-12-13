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
    char[] mosse = {'m','r','m','m','l','m','p',
                    'l','l','m','m','p',
                    'l','l','m','m','l','m','r','m','m','p',
                    'r','m','p',
                    'm','r','m','l','m','l','m','r','m','p',
                    'l','l','m','l','m','m','p',
                    'l','m','r','m','p',
                    'm','r','m','l','m','r','m','p'};
                    // m = straight, l = left, r = right, p = pick up, i = move mushroom
    
   for(int i = 0; i < mosse.length; i++){
        switch(mosse[i]){
            case 'm': kara.move();
                break;
            case 'l': kara.turnLeft();
                break;
            case 'r': kara.turnRight();
                break;
            case 'p': kara.removeLeaf();
                break;
        }
    }
    
    kara.turnLeft();
    kara.turnLeft();
    
    for(int x = mosse.length-1; x>=0; x--){
        switch(mosse[x]){
            case 'm': kara.move();
                break;
            case 'l': kara.turnRight();
                break;
            case 'r': kara.turnLeft();
                break;
            case 'p': kara.putLeaf();
            
        }
    }
  }
}

        