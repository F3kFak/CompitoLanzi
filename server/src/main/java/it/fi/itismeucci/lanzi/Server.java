package it.fi.itismeucci.lanzi;

import java.io.*;
import java.net.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Server{
    ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();
    ArrayList<Socket> socket = new ArrayList<Socket>();
    public void aggiunta(){
    Biglietto b1 = new Biglietto(1, "palco");
    Biglietto b2 = new Biglietto(2, "palco");
    Biglietto b3 = new Biglietto(3, "palco");
    Biglietto b4 = new Biglietto(4, "palco");
    Biglietto b5 = new Biglietto(5, "tribuna");
    Biglietto b6 = new Biglietto(6, "tribuna");
    Biglietto b7 = new Biglietto(7, "tribuna");
    Biglietto b8 = new Biglietto(8, "tribuna");
    Biglietto b9 = new Biglietto(9, "tribuna");
    Biglietto b10 = new Biglietto(10, "tribuna");

    biglietti.add(b1);
    biglietti.add(b2);
    biglietti.add(b3);
    biglietti.add(b4);
    biglietti.add(b5);
    biglietti.add(b6);
    biglietti.add(b7);
    biglietti.add(b8);
    biglietti.add(b9);
    biglietti.add(b10);
    }

    public void connetti() throws IOException {
        System.out.println("Server IN ESECUZIONE!");
        ServerSocket server = new ServerSocket(6969);
        aggiunta();
        ObjectMapper objectMapper = new ObjectMapper();


        Messaggio m = new Messaggio(biglietti);

        String stringa = objectMapper.writeValueAsString(m);
        for(;;) {
            Socket client = server.accept();
            socket.add(client);
            (new ThreadServer(client,socket,server,stringa)).start();
        }
    }

}
