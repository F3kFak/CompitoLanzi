package it.fi.itismeucci.lanzi;

public class Threadin extends Thread{
    Comu comunica;
    public Threadin(Comu comunica){
        this.comunica = comunica;
    }

    public void run(){
        try {
            comunica.Input();
        } catch (Exception e) {}
    }
}
