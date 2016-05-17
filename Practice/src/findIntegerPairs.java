import java.util.LinkedList;


public class findIntegerPairs {
	
	static int numberOfPairs(int[] a, long sum) {
		LinkedList<Integer> unique = new LinkedList<Integer>();
		
		for(int i: a){
			if(!unique.contains(i)){
				unique.add(i);
			}
		}
		int count=0;
		for(int j=0; j<unique.size()-1; j++){
			int first = unique.get(j);
			for(int k=j+1; k<unique.size(); k++){
				int second = unique.get(k);
				if(sum==(int)(first+second)){
					count++;
					break;
				}
			}
		}
		return count;
    }

	public static void main(String args[]){
//		int[] arr = {1,3,1,1,6,46,2,46};
		int[] arr = {1,3,11,6,9,3,1,9};
		int count = numberOfPairs(arr, 12);
		System.out.print(count);
	}
	
//	public static void main(String[] args) throws IOException{
//        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//        int res;
//        
//        int _a_size = 0;
//        _a_size = Integer.parseInt(in.nextLine().trim());
//        int[] _a = new int[_a_size];
//        int _a_item;
//        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
//            _a_item = Integer.parseInt(in.nextLine().trim());
//            _a[_a_i] = _a_item;
//        }
//        
//        long _k;
//        _k = Long.parseLong(in.nextLine().trim());
//        
//        res = numberOfPairs(_a, _k);
//        bw.write(String.valueOf(res));
//        bw.newLine();
//        
//        bw.close();
//    }
}
	

