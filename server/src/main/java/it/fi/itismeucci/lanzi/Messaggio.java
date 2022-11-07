package it.fi.itismeucci.lanzi;

import java.util.*;

public class Messaggio {
    ArrayList<Biglietto> biglietti;

    public Messaggio(){}
    public Messaggio(ArrayList<Biglietto> biglietti)
    {
        this.biglietti = biglietti;
    }


    public ArrayList<Biglietto> getBiglietti() {
        return this.biglietti;
    }

    public void setBiglietti(ArrayList<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }


}
