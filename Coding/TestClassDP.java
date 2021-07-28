
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClassDP {


    public static int maxWaysToMakeChange (int coins[],int n, int sum){
        //let sol[i][x] denote the number of ways to make x using only coins till index i .. then sol[i+1][x] = Max(sol[i][x], sol[i+1][x-coins[i+1]]+1)
        int sol [][] = new int[n+1][sum+1];
        for(int i =1; i<sum;i++){
            sol[0][i] = 0;
        }
        for(int i =0;i<=n;i++){
            sol[i][0] =1;
        }
       // sol[0][0] =1;
        for(int i =1; i<=n;i++){
         for(int j =1; j<=sum;j++){
            if(coins[i-1] > j){
                sol[i][j] = sol[i-1][j];
            }
            else{
                sol[i][j] =  sol[i][j-coins[i-1]]+sol[i-1][j];
            }
         }   
        }
        return  sol[n][sum];


    }
    public static int minCoinsChange(int coins[],int n, int sum){
        int sol [][] = new int[n+1][sum+1];
        for(int i =0; i<=sum;i++){
            sol[0][i] = Integer.MAX_VALUE;
        }
        for(int i =0;i<=n;i++){
            sol[i][0] =0;
        }
        sol[0][0] =1;
        for(int i =1; i<=n;i++){
            sol[i][coins[i-1]] = 1;
        }
        for(int i =1; i <=n; i++){ // coins
            for(int j =1; j<=sum;j++){
                if(coins[i-1] > j ){
                    sol[i][j] = sol[i-1][j];
                }else{
                    // but u have to take it .. u cannot not take it :| 
                    sol[i][j] = Math.min(sol[i-1][j], sol[i][j-coins[i-1]]+1);
                }
            }
        }
        for(int i =0; i<=n;i++)
        System.out.println(Arrays.toString(sol[i]));
        return sol[n][sum];

    }


    public static void modifiedKnapSack  (int V[], int P[], int n, int m){
        int [] copyP = new int [n];
        for (int i = 0; i< n ; i++){
            copyP[i] = P[i];
        }
        int maxValue = KnapSack(V,P, n,m);;
        for(int i = 0; i<n; i++){
            copyP[i] = P[i]/2;
            int tempValue = KnapSack(V,copyP, n,m);
            if(maxValue < tempValue){
               maxValue = tempValue; 
            }
            copyP[i] = P[i];
        }
        System.out.println(maxValue);
    }

    public static int KnapSack (int V[], int P[], int n, int m){
        int S [][] = new int [n+1][m+1];
        for(int i =0; i<=m;i++){
            S[0][i] =0;
           // temp[0][i] =0;
        }
        for(int i =0; i<=n;i++){
            S[i][0] =0;
          //  temp[i][0] =0;
        }
        for(int i =1; i<= n;i++){
            for(int p =0; p <= m; p++){
                int currentPrice = P[i-1];
                if(currentPrice > p) {
                    // cant take it have to take the value without it   
                    S[i][p] = S[i-1][p];
                }else{
                    S[i][p] = Math.max( S[i-1][p] , S[i-1][p-currentPrice] + V[i-1]);
                }
            }
        }
        int noMagic = S[n][m];
        return noMagic;




    }
    public static void main(String args[] ) throws Exception {
       int [] coins = {1,2,3};
System.out.print( minCoinsChange( coins, 3, 5));
     //System.out.print( maxWaysToMakeChange( coins, 3, 5));
        /*
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase = br.readLine();  
       int t =  Integer.parseInt(testCase);
       while(t>0){
        String [] array = (br.readLine()).split(" ");  
        int n = Integer.parseInt(array[0]);
        int m = Integer.parseInt(array[1]);
        int [] v = new int [n];
        int [] p = new int [n];
        for(int i =0; i < n; i++){
             array = (br.readLine()).split(" "); 
            v[i] =Integer.parseInt( array[0]);
            p[i] = Integer.parseInt(array[1]);
        }

            modifiedKnapSack(v,p,n,m);
            t--;

       }
       
        */
    }
}
