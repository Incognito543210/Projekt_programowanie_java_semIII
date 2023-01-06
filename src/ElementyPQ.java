public class ElementyPQ implements Comparable<ElementyPQ> {

    private int ilosc;
    private int wierzcholek;
    public ElementyPQ(int ilosc, int wierzcholek)
    {
        this.ilosc=ilosc;
        this.wierzcholek=wierzcholek;
    }

    public int getIlosc()
    {
        return ilosc;
    }
    public int getWierzcholek()
    {
        return wierzcholek;
    }

    @Override
    public int compareTo(ElementyPQ st) {
        if(ilosc<st.ilosc)
            return -1;
        else if(ilosc>st.ilosc)
            return 1;
        return 0;
    }
}
