import java.util.Scanner;

public class TastieraTelefonicaConT9{
	public static void main(String[] args){
		System.out.print("Type a string to see how to type it in T9. Please only include spaces and letters. Don't type anything and click enter to exit. ");
		String [ ] [ ] letters = {{" "                 },
								  {                    },
								  { "A", "B", "C"      },
                                  { "D", "E", "F"      },
                                  { "G", "H", "I"      },
                                  { "J", "K", "L"      },
                                  { "M", "N", "O"      },
                                  { "P", "Q", "R", "S" },
                                  { "T", "U", "V"      },
                                  { "W", "X", "Y", "Z" }
                             };

        String word;
 
        do{
        	word = getInput(); 
        	findNumbers(word.toLowerCase(), letters);
        }while(!word.equals(""));
	}
	
	public static String getInput(){
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter your string: ");
		return input.nextLine();
		
	}
	public static void findNumbers(String word, String [ ] [ ] letters){
		//System.out.println(test);
		//System.out.println(letters[0][0]);
		for (char ch: word.toCharArray()) {
			for(int x = 0; x < letters.length; x++){
				for(int y = 0; y < letters[x].length; y++){
					if(ch == letters[x][y].toLowerCase().toCharArray()[0]){
							System.out.print(x);
					}
				}
			}
		}
	}
}