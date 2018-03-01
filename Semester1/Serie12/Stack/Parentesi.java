class Node{
  char character;
  Node next = null;
}

class Stack{
  Node top = null;

  void push(char characterToAdd){
    Node newNode = new Node();
    newNode.character = characterToAdd;

    if(top == null){
      top = newNode;
    }else{
      newNode.next = top;
      top = newNode;
    }
  }

  void pop(){
    if(top == null){
      System.out.println("Nothing to remove. Stack is empty");
    }else{
      top = top.next;
    }
  }

  Node peek(){
    if(top == null){
      //System.out.println("Nothing to show. Stack is empty");
      return null;
    }else{
      return top;
    }
  }
}

public class Parentesi{
  public static void main(String[] args){

    String espressione1 = "{1+([3-(1+4)])}";
    String espressione2 = "{1+[3-(1+4)])}";
    String espressione3 = "{1+[3-((1+4)])}";
    checkIfValid(espressione1);
    checkIfValid(espressione2);
    checkIfValid(espressione3);

  }
  static private void checkIfValid(String espressione){
    Stack list = new Stack();
    boolean valid = true;
    int usedSquared = 0;
    int usedGraff = 0;
    int usedRound = 0;

    System.out.println(espressione);
    for(int i = 0; i < espressione.length(); i++){
      switch(espressione.charAt(i)){
        case '{':
          usedGraff ++;
          if(usedRound == 0){
            list.push(espressione.charAt(i));
          }else{
            valid = false;
          }
          break;
        case '[':
          usedSquared ++;
          if(usedRound == 0){
            list.push(espressione.charAt(i));
          }else{
            valid = false;
          }
          break;
        case '(':
          usedRound ++;
          list.push(espressione.charAt(i));
          break;
        case ')':
          if (list.peek().character == '(') {
            list.pop();
          }else{
            error(i);
            valid = false;
          }
          break;
        case ']':
          if (list.peek().character == '[' ) {
            list.pop();
          }else{
            error(i);
            valid = false;
          }
          break;
        case '}':
          if (list.peek().character == '{' ) {
            list.pop();
          }else{
            error(i);
            valid = false;
          }
          break;
      }
    }

    if(valid == true && list.peek() == null && usedGraff <= 1 && usedSquared <= 1){
      System.out.println(" Expression is valid");
    }else{
        System.out.println(" Expression is not valid");
    }
    System.out.println();
  }

  public static void error(int i) {
    System.out.println("Error on character " + i );
  }
}
