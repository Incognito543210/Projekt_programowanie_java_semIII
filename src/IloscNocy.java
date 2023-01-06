import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IloscNocy {

    public String algorytm(int tab[][])
    {
        int nastepny []=new int[tab.length];
        for (int i=0;i< tab.length;i++)
        {
            nastepny[i]=-1;
        }

        int iloscNoclegow []=new int[tab.length];
        for (int i=0;i< tab.length;i++)
        {
            iloscNoclegow[i]=20000;
        }
        nastepny[tab.length-1]=0;
        iloscNoclegow[tab.length-1]=0;
        ArrayList<Integer> Q = new ArrayList<Integer>();
        PriorityQueue<ElementyPQ> wyborNajmnijszego = new PriorityQueue<>();
        for (int i=0;i< tab.length;i++)
        {
            wyborNajmnijszego.add(new ElementyPQ(iloscNoclegow[i],i));
        }
        //hoteli nie moze byc wiecej niz 1002
       int u=1002;
        while (!Q.contains(0))
        {
            ElementyPQ k=wyborNajmnijszego.poll();
            u=k.getWierzcholek();
            Q.add(u);
            int odleglosc=tab[u][0]-800;
            for(int v =0; v< tab.length;v++)
            {
                int w=tab[v][0];
                if (w<odleglosc && odleglosc != tab[u][0])
                    continue;
                if(!Q.contains(v))
                {
                    if(iloscNoclegow[v]> iloscNoclegow[u]+1)
                    {
                        nastepny[v]=u;
                        iloscNoclegow[v]=iloscNoclegow[u]+1;
                        wyborNajmnijszego.add(new ElementyPQ(iloscNoclegow[v],v));
                    }
                }
            }

        }
        System.out.println("nastempny");
        for (int i =0;i< nastepny.length;i++)
        {
            System.out.print(nastepny[i]+" ");
        }
        System.out.println("ilosc noclegow");
        for (int i =0;i< iloscNoclegow.length;i++)
        {
            System.out.print(iloscNoclegow[i]+" ");
        }

        List<Integer> V =new ArrayList<>();
        int i=0;
        while(!V.contains(tab.length-1))
        {
            V.add(nastepny[i]);
            i=nastepny[i];
        }
        V.remove(V.size()-1);
        String wyjscie ="";

        for (int g=0;g< V.size();g++)
        {
            wyjscie+=Integer.toString(tab[V.get(g)][0])+" ";
        }
        return wyjscie;




    }


}
