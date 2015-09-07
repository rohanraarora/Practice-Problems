import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		int T = Integer.parseInt(inp.readLine());
		for(int t = 0;t<T;t++){
			//for each test case
			int N = Integer.parseInt(inp.readLine());//order
			int[] array = new int[N*N + 1];
			for(int i =0;i<N;i++){
				String[] input = inp.readLine().split(" ");
				for(int j = 0;j<N;j++){
					int value = Integer.parseInt(input[j]);
					array[value] = i*N + j;
				}
			}
			int steps = 0;
			for(int k = 1;k<(N*N);k++){
				steps = steps + Math.abs(array[k]/N - array[k+1]/N) + Math.abs(array[k]%N - array[k+1]%N); 
			}
			System.out.println(steps);
		}
	}
}