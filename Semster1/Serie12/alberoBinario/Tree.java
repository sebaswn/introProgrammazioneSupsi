class Nodo {
  char valore;
  Nodo left = null;
  Nodo right = null;

  Nodo(char valore){
    this.valore = valore;
  }
}

class AlberoBinario {
  Nodo root = null;

  void attraversa(int ordine){
    switch(ordine){
      case 0: attraversaInOrder(root);
        break;
      case 1: attraversaPreOrder(root);
        break;
      case 2: attraversaPostOrder(root);
        break;
    }
  }

  void attraversaPreOrder(Nodo nodo) {
    if (nodo == null)
      return;
    System.out.println(nodo.valore);
    attraversaPreOrder(nodo.left);
    attraversaPreOrder(nodo.right);
  }

  void attraversaInOrder(Nodo nodo) {
    if (nodo == null)
      return;
    attraversaInOrder(nodo.left);
    System.out.println(nodo.valore);
    attraversaInOrder(nodo.right);
  }

  void attraversaPostOrder(Nodo nodo) {
    if (nodo == null)
      return;
    attraversaPostOrder(nodo.left);
    attraversaPostOrder(nodo.right);
    System.out.println(nodo.valore);
  }

  Nodo cercaIterativo(Nodo nodo, char charRichercato) {
    while (nodo != null) {
      if (charRichercato == nodo.valore)
        return nodo;
      if (charRichercato < nodo.valore)
        nodo = nodo.left;
      else
        nodo = nodo.right;
    }
    return null;
  }

  void aggiungi(char valore) {
    if (root == null)
      root = new Nodo(valore);
    else
      aggiungi(root, valore);
  }

  void aggiungi(Nodo nodo, char valore) {
  // I duplicati sono ammessi
    if(valore == nodo.valore){

    }else{
      if (valore <= nodo.valore ) {
        if (nodo.left == null)
          nodo.left = new Nodo(valore);
        else
          aggiungi(nodo.left, valore);
      } else {
        if (nodo.right == null)
          nodo.right = new Nodo(valore);
        else
          aggiungi(nodo.right, valore);
      }
    }
  }
}

public class Tree{
  public static void main(String[] args){
    AlberoBinario test = new AlberoBinario();

    test.aggiungi('a');
    test.aggiungi('f');
    test.aggiungi('h');
    test.aggiungi('j');
    test.aggiungi('k');
    test.aggiungi('b');
    test.aggiungi('k');
    test.aggiungi('c');

    test.attraversa(0);

  }
}
