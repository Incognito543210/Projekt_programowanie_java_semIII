import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception {

     //zmienna odpowedzialna za wilekość tablicy z danymi wczytanymi z pliku
     int wielkosc=0;

     //inicjalizacja zmiennej wielkość, przez sprawdzenie ile linijek znajduje sie w pliku
     try {
             FileReader file = new FileReader("tan.in");
             Scanner scan = new Scanner(file);

             while (scan.hasNextLine())
             {
              String c = scan.nextLine();
              wielkosc++;
             }

     } catch(Exception e)
     {
           e.getMessage();
     }

     //inicjalizacja tablicy z danymi, powiekszona o jeden ze wzgledu na uwzgledniany w obliczeniach punkt stratowy trasy
     int[][] tablica =new int[wielkosc+1][2];

     //wczytanie danych z pliku do tablicy
     try{
              FileReader file = new FileReader("tan.in");
              Scanner scan = new Scanner(file);

              int licznik =0;

              while (scan.hasNext())
              {
               String s = scan.nextLine();
               s=s.trim();
               String tab[]=s.split(" ");
               tablica[licznik][0]=Integer.parseInt(tab[0]);
               tablica[licznik][1]=Integer.parseInt(tab[1]);
               licznik++;
              }

      }catch (Exception e)
     {
                e.getMessage();
     }
     //posortowanie tablicy rosnąco ze względu na odległość
     Arrays.sort(tablica, (a, b) -> a[0] - b[0]);

     //utworzenie obiektow dla obu algorytmow obliczjacych kolejno najmniejsza ilosc nocy, oraz najmnoejsza cene
      NajmniejszaIloscNocy test1=new NajmniejszaIloscNocy();
      NajnizszaCena test2=new NajnizszaCena();

      //utworzenie pliku wynikowego i zapisanie do niego wynikow obliczen
      try{
          FileOutputStream oso = new FileOutputStream("tan.out");
          Writer wr = new BufferedWriter(new OutputStreamWriter(oso,"UTF-8"));
          String s = test1.algorytm(tablica);
          wr.append(s).append("\r\n");
          System.out.println("Najmniejsza ilość nocy i najniższa cena:");
          System.out.println(s);
          s=test2.algorytm(tablica);
          System.out.println(s);
          wr.append(s);
          wr.flush();
     }catch(IOException e)
      {
          System.out.println(e.getLocalizedMessage());
      }catch (Exception e)
      {
          System.out.println(e.getMessage());
      }


    }
}