import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" for codechef only if the class is public. */
public class Main{
	static int noOfChains;
	static int noOfCuts;
	public static void main (String[] args) throws java.lang.Exception{
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		int T = Integer.parseInt(inp.readLine());
		for(int t = 0;t<T;t++){
			//for each test case
			noOfCuts = 0;
			String[] numbers = inp.readLine().split(" ");
			int N = Integer.parseInt(numbers[0]);//order
			int M = Integer.parseInt(numbers[1]);//cooked chains
			noOfChains = M;
			String[] input = inp.readLine().split(" ");
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i =0;i<M;i++){
				list.add(Integer.parseInt(input[i]));
			}
			Collections.sort(list);
			int i = 0;
			while(noOfChains > 1){
				int currentMin = list.get(i);
				while(currentMin >= 1){
					noOfChains--;
					currentMin--;
					noOfCuts++;
					if(noOfChains == 1){
						break;
					}
				}
				noOfChains--;
				i++;
			}
			System.out.println(noOfCuts);
		}
	}
}
