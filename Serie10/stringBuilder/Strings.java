public class Strings{
  public static void main(String[] args){
    StringBuilder letters = new StringBuilder();

    String paragraph = "Lorem ipsSum dolor sit amet, consectetuer adipiscing elit. Ut purus elit, vestibulum ut, placerat ac, adipiscing vitae, felis. Curabitur dictum gravida mauris. Nam arcu libero, nonummy eget, consectetuer id, vulputate a, magna. Donec vehicula augue eu neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Mauris ut leo. Cras viverra metus rhoncus sem. Nulla et lectus vestibulum urna fringilla ultrices. Phasellus eu tellus sit amet tortor gravida placerat. Integer sapien est, iaculis in, pretium quis, viverra ac, nunc. Praesent eget sem vel leo ultrices bibendum. Aenean faucibus. Morbi dolor nulla, malesuada eu, pulvinar at, mollis ac, nulla. Curabitur auctor semper nulla. Donec varius orci eget risus. Duis nibh mi, congue eu, accumsan eleifend, sagittis quis, diam. Duis eget orci sit amet orci dignissim rutrum.";

    paragraph = paragraph.toLowerCase();
    String[] words = paragraph.split(" ");

    for(int i = 0; i < words.length; i++){
      if(i == 0){
        letters.append(words[i].charAt(0));
      }else {
        if((words[i-1].charAt(0) == 'a' || words[i-1].charAt(0) == 'e' || words[i-1].charAt(0) == 'i' || words[i-1].charAt(0) == 'o' || words[i-1].charAt(0) == 'u') && (words[i].charAt(0) == 'a' || words[i].charAt(0) == 'e' || words[i].charAt(0) == 'i' || words[i].charAt(0) == 'o' || words[i].charAt(0) == 'u')){
          letters.append(" ");
          letters.append(words[i].charAt(0));
        }else{
          letters.append(words[i].charAt(0));
        }
      }
    }
    System.out.println(letters.toString());
  }
}
