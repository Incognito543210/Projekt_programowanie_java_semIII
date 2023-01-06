import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception {

       int dane[][]={{2000,7},
               {100,54},
               {120,70},
               {400,17},
               {700,38},
               {1000,25},
               {1200,18},
               {1440,40},
               {0,0},};

     for (int i = 0; i < dane.length; i++) {
      for (int j = 0; j < dane[i].length; j++)
       System.out.print(dane[i][j] + " ");
      System.out.println();
     }
     Arrays.sort(dane, (a, b) -> a[0] - b[0]);
     System.out.println("0000000000");

     for (int i = 0; i < dane.length; i++) {
      for (int j = 0; j < dane[i].length; j++)
       System.out.print(dane[i][j] + " ");
      System.out.println();
     }

     IloscNocy test1=new IloscNocy();
     System.out.println(test1.algorytm(dane));



























    }
}