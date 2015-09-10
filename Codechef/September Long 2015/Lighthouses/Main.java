import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" for codechef only if the class is public. */
public class Main{

	static class Island implements Comparable<Island>{
		int id;
		int x;
		int y;

		public Island(int x,int y,int id){
			this.x = x;
			this.y = y;
			this.id = id;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getId() {
			return id;
		}

		public int compareTo(Island island) {
			if(x>island.getX()){
				return 1;
			}
			else return -1;
		}
	}


	public static void main (String[] args) throws java.lang.Exception
	{

		ArrayList<Island> topIslands = new ArrayList<Main.Island>();
		ArrayList<Island> bottomIslands = new ArrayList<Main.Island>();
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		int T = Integer.parseInt(inp.readLine());
		for(int t = 0;t<T;t++){
			int maxY = Integer.MIN_VALUE,minY = Integer.MAX_VALUE,maxX= Integer.MIN_VALUE,minX = Integer.MAX_VALUE;
			topIslands.clear();
			bottomIslands.clear();
			//for each test case
			int N = Integer.parseInt(inp.readLine());
			for(int n = 0;n<N;n++){
				String[] coords = inp.readLine().split(" ");
				int x = Integer.parseInt(coords[0]);
				int y = Integer.parseInt(coords[1]);
				if(x>maxX){
					maxX = x;
				}
				if (x<minX){
					minX = x;
				}
				if(y>maxY){
					maxY = y;
					topIslands.clear();
					topIslands.add(new Island(x, y,n+1));
				}
				if(y == maxY){
					topIslands.add(new Island(x, y,n+1));
				}
				if(y == minY){
					bottomIslands.add(new Island(x,y,n+1));
				}
				if(y < minY){
					minY = y;
					bottomIslands.clear();
					bottomIslands.add(new Island(x, y,n+1));
				}
			}
			int extremeCase = 0;//no extreme - 0, topleft - 1, top right - 2,bottom left -3,bottom right - 4
			Collections.sort(topIslands);
			Collections.sort(bottomIslands);
			Island topLeft = topIslands.get(0);
			Island topRight = topIslands.get(topIslands.size()-1);
			Island bottomLeft = bottomIslands.get(0);
			Island bottomRight = bottomIslands.get(bottomIslands.size() - 1);
			if(topLeft.getX() <= minX){
				extremeCase = 1;
			}
			else if(topRight.getX()>= maxX){
				extremeCase = 2;
			}
			else if(bottomLeft.getX() <= minX){
				extremeCase = 3;
			}
			else if(bottomRight.getX() >= maxX){
				extremeCase = 4;
			}
			switch(extremeCase){
			case 0:
				System.out.println(2);
				if(topLeft.getX()<bottomRight.getX()){
					System.out.println(topLeft.id + " SE");
					System.out.println(bottomRight.id + " NW");
				}
				else{
					System.out.println(topLeft.id + " SW");
					System.out.println(bottomRight.id + " NE");
				}
				break;
			case 1:
				System.out.println(1);
				System.out.println(topLeft.id + " SE");
				break;
			case 2:
				System.out.println(1);
				System.out.println(topRight.id + " SW");
				break;
			case 3:
				System.out.println(1);
				System.out.println(bottomLeft.id + " NE");
				break;
			case 4:
				System.out.println(1);
				System.out.println(bottomRight.id + " NW");
				break;
			}

		}
	}
}
