package it.fi.itismeucci.lanzi;

public class Threadout extends Thread {
    Comu comunica;
    public Threadout(Comu comunica){
        this.comunica = comunica;
    }

    public void run(){
        try {
            comunica.Output();
        } catch (Exception e) {}
    }
}
