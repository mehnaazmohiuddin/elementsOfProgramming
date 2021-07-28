// /* IMPORTANT: Multiple classes and nested static classes are supported */


//  //* uncomment this if you want to read input.
// //imports for BufferedReader
// import java.io.BufferedReader;
// import java.io.InputStreamReader;

// //import for Scanner and other utility classes
// import java.util.*;


// // Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

// class TestClass {
//     public static void main(String args[] ) throws Exception {
     
//         //BufferedReader
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());                // Reading input from STDIN
//         int [] ary  = new int [N];
//         HashMap <Integer,Integer> map = new HashMap<Integer,Integer>();
//         for (int i =0; i<N;i++){
//                 ary[i] = Integer.parseInt(br.readLine()); //ids of the vertces
//                 map.put(ary[i] ,i);

//         }
//          int E = Integer.parseInt(br.readLine());  
//          //LinkedList edgesList  = new LinkedList();
//          LinkedList<Integer>[] edgesList = new LinkedList[N];
//          for(int i =0; i < N; i++){
//             edgesList[i] = new  LinkedList<Integer> ();
//          }
//          for (int i=0; i<E ; i++){
//               String edge = br.readLine();   
//               String [] edgeValue = edge.split(" ");
//               int u = Integer.parseInt(edgeValue[0]);
//               int v = Integer.parseInt(edgeValue[1]);
//               edgesList[map.get(u)].add(v);
//          }
//         Queue<Integer> q
//             = new LinkedList<>();
        
        
//          int A = Integer.parseInt(br.readLine()); 
//          int B = Integer.parseInt(br.readLine()); 
//           q.add(A);
//                 HashSet<Integer> vistedVertixMap = new HashSet<Integer>();

//          while(q.isEmpty() == false || vistedVertixMap.size() == N){
//              int vertixNow = q.remove();
//               int iA = map.get(A);
//          for(int i =0;i<edgesList[iA].size();i++){
//              int vertix = edgesList[iA].get(i);
//              if(B == vertix){
//                  System.out.println("1");
//                  return;
//              }else {
//                  if(!vistedVertixMap.contains(vertix)){
//                      q.add(vertix);
//                  }
//              }
//          }
//            vistedVertixMap.add(A);
//             //if()

//          }

//         System.out.println("0");
//         // Write your code here

//     }
// }



/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

/*
 * uncomment this if you want to read input.

*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static String sortTheString (String s){
        char [] a = s.toCharArray();
        Arrays.sort(a);
        return new String (a);
    }
    public static void main(String args[] ) throws Exception {
       /*  Sample code to perform I/O:
         Use either of these methods for input*/

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String name = br.readLine();                // Reading input from STDIN
      //  System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
//Scanner s = new Scanner(System.in);
        int  length = Integer.parseInt(br.readLine());      
      //  String [] words = new String [length];
        int counter=0;
        String newname = sortTheString(name);
      //  System.out.println("This is the sorted name"+newname);
        for (int i =0; i<length; i++){
                String w = br.readLine();   
                System.out.println(sortTheString(w));
               
                if(sortTheString(w).equals( newname))
                    counter++;

        }
        System.out.println(counter);
        
        
        
        

    }
}
