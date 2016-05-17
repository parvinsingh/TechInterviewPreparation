import java.util.Scanner;

/**
 * Given a string of words, separated by a single space,
 * reverse the words in the String. You can assume that there is 
 * no leading or trailing spaces.
 * input = "Man bites dog"
 * output = "dog bites man"
 * 
 * @author ppanesar
 *
 */
public class ReverseWords {

	private static String reverse(String input){
		if(input==null || input.isEmpty()){
			return null;
		}
		int strLen = input.length();
		StringBuffer strBuff = new StringBuffer();
		StringBuffer output = new StringBuffer();
		for(int i=0; i<strLen; i++){
			char ch = input.charAt(i);
			if(ch!=' '){
				strBuff.append(ch);
			}else{
				output.insert(0, " "+strBuff);
				strBuff = new StringBuffer();
			}
		}
		output.insert(0, strBuff);
		return output.toString();
	}
	
//	public static void main(String args[]){
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
////		String input = "Man bites Snake";
//		String output = reverse(input);
//		System.out.print(output);
//	}
	
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
        
        StairCase(_n);
        
    }
	 private static void StairCase(int n) {
	        if(n<1 || n>100){
	            //system.out.println("Wrong input");
	            return;
	        }
	        
	        for(int i=n; i>=1; i--){
	        	for(int j=1 ; j<i	; j++){
	        		System.out.print(" ");
	        	}
	        	for(int k=n; k>=i; k--){
	        		System.out.print("#");
	        	}
	        	System.out.println();
	        }
	        System.out.println("*******************");
	        for(int i=n; i>=1; i--){
	        	for(int j=n ; j>i	; j--){
	        		System.out.print(" ");
	        	}
	        	for(int k=1; k<=i; k++){
	        		System.out.print("#");
	        	}
	        	System.out.println();
	        }
	    }


	
//	public static void main(String [] args) throws Exception
//    {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int t = 0; t < n; t++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            System.out.println(a+b);
//        }
//    }
}
