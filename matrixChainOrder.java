//code taken from https://www.programmersought.com/article/48616580/ 
public class matrixChainOrder {
	
	
		private static String name = "ABCDEF";
		private static int[] a = {40, 20, 30, 10, 30};
		
		private static int len = a.length - 1;
		
		private static int[][] m = new int[len][len];
		private static int[][] s = new int[len][len];
		
		public static void main(String[] args)
		{
			System.out.println("Hope this works: ");
			System.out.println("Value tables is:");
			for(int i=0; i<len; i++) {
				for(int j = 0; j < len; j++) {
					System.out.print(m[i][j] + " ");
				}
			}
			
			System.out.println("Decision tables is:");
			for(int i=1; i<len; ++i) {
				for(int j = 1; j < len; ++j) {
					System.out.print(s[i][j] + " ");
				}
			}
			
			int value = 0; 
			int optimal_value = Compute(a, m, s, value);
			System.out.print ("minimum number of calculations required:");
			Compute(a, m, s, value );
			System.out.println(optimal_value);
			
			 System.out.print("The order in which the matrices are multiplied is: ");
			Display(s, name, 0, len-1);
		}
		
		public static int Compute(int[] a, int[][] m, int[][] s, int cost)
		{
			int t = 0;
			int min = 0;
			int temp = 0;
			
			for(int i=2; i<a.length; i++)
		    {
		        for(int j=0; j<a.length-i; j++)
		        {
		            t = j + i - 1;
		            
		            m[j][t] = Integer.MAX_VALUE;
		            
		            for(int k=j; k<t; k++)
		            {
		            	temp = m[j][k] + m[k+1][t] + a[j]*a[k+1]*a[t+1];
		            	
		                if(temp < m[j][t])
		                {
							min = temp;
		                    m[j][t] = temp;
		                    s[j][t] = k;
		                    cost = temp;
		                }
		            }
		        }
		    }
			
			return cost;
			
		}
		
		public static void Display(int[][] s, String name, int i, int j)
		{
			if(i == j)
			{
				System.out.print(name.charAt(i));
			}
			else
			{
				System.out.print("(");
				Display(s, name, i, s[i][j]);
				Display(s, name, s[i][j]+1, j);
				System.out.print(")");
			}
		}
	}


