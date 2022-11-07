package it.fi.itismeucci.lanzi;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    String nomeServer = "localhost"; // indirizzo server locale
    int portaServer = 12121; // porta x servizio data e ora
    Socket miosocket;
    BufferedReader tastiera; // buffer per l'input da tastiera
    String StringaUtente; // stringa inserita da utente
    String StringaRicevutaDalServer; // stringa ricevuta dal server
    DataOutputStream outVersoServer; // stream output
    BufferedReader inDalServer; // stream input


    public void comunica() throws IOException {
        
        Comu C1 = new Comu();
        Threadin ti = new Threadin(C1);
        Threadout to = new Threadout(C1);

        to.start();
        ti.start();
    }
}
