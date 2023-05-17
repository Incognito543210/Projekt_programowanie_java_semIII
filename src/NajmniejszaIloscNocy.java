import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NajmniejszaIloscNocy {

    public String algorytm(int[][] tab)
    {
        //wypelnienie tablicy poprzednikow oraz ilosci noclegow
        int[] nastepny =new int[tab.length];
        for (int i=0;i< tab.length;i++)
        {
            nastepny[i]=-1;
        }

        int[] iloscNoclegow =new int[tab.length];
        for (int i=0;i< tab.length;i++)
        {
            //hoteli nie moze byc wiecej niz 1000
            iloscNoclegow[i]=20000;
        }
        //Zainicjowanie aby punkt ostatni mial nastepce 0 oraz ilosc noclegow 0
        nastepny[tab.length-1]=0;
        iloscNoclegow[tab.length-1]=0;
        //Utworzenie listy przeanalizowanych wierzcholkow
        ArrayList<Integer> Q = new ArrayList<Integer>();
        //Utworzenie kolejki priorytetowej. Dodanie wierzcholkow wraz z ich ilosciami noclegow do kolejki priorytetowe
        PriorityQueue<ElementyPQ> wyborNajmniejszego = new PriorityQueue<>();
        for (int i=0;i< tab.length;i++)
        {
            wyborNajmniejszego.add(new ElementyPQ(iloscNoclegow[i],i));
        }
        //u - obecenie rozpatrzany wierzcholek. Hoteli nie moze byc wiecej niz 1002
       int u=1002;
        //Petla bedzie sie wykonywala dopoki do sprawdzonych wierzcholkow nie wpadnie wierzcholek 0
        while (!Q.contains(0))
        {   //pobranie z kolejki wierzcholka o najmniejszej ilości noclegow
            ElementyPQ k=wyborNajmniejszego.poll();
            assert k != null;
            u=k.getWierzcholek();
            Q.add(u);
            //Obliczenie odleglosci od wierzcholka, ktora nie moze byc wieksza niz 800 km
            int odleglosc=tab[u][0]-800;
            for(int v =0; v< tab.length;v++)
            {   //w - odleglosc dla wierzcholka v
                int w=tab[v][0];
                if (w<odleglosc && odleglosc != tab[u][0])
                    continue;
                if(!Q.contains(v))
                {
                    if(iloscNoclegow[v]> iloscNoclegow[u]+1)
                    {
                        nastepny[v]=u;
                        iloscNoclegow[v]=iloscNoclegow[u]+1;
                        wyborNajmniejszego.add(new ElementyPQ(iloscNoclegow[v],v));
                    }
                }
            }

        }
        //lista hoteli (wierzchokow) przez ktore przebiega trasa o najmniejszej ilosci noclegow
        List<Integer> V =new ArrayList<>();
        int i=0;
        while(!V.contains(tab.length-1))
        {
            V.add(nastepny[i]);
            i=nastepny[i];
        }
        //usuniecie konca trasy z listy
        V.remove(V.size()-1);

        //zapisanie odleglosci hoteli do stringa, aby zapisac dane wyjsciowe do pliku
        StringBuilder wyjscie = new StringBuilder();

        for (Integer integer : V) {
            wyjscie.append(Integer.toString(tab[integer][0])).append(" ");
        }
        return wyjscie.toString();

    }


}
