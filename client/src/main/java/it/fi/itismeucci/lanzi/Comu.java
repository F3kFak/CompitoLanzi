package it.fi.itismeucci.lanzi;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Comu {
    String nomeServer = "localhost"; // indirizzo server locale
    int portaServer = 6969; // porta x servizio data e ora
    Socket miosocket;
    BufferedReader tastiera; // buffer per l'input da tastiera
    String StringaUtenteID; // stringa inserita da utente
    String StringaRicevutaDalServer; // stringa ricevuta dal server
    String StringaUtenteBiglietto;
    DataOutputStream outVersoServer; // stream output
    BufferedReader inDalServer; // stream input
    Messaggio m;
    ArrayList<Biglietto> biglietti;
    ArrayList<Biglietto> richiesta;

    public Comu() throws IOException{
        tastiera = new BufferedReader(new InputStreamReader(System.in));
        miosocket = new Socket(nomeServer, portaServer);
        outVersoServer = new DataOutputStream(miosocket.getOutputStream());
        inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
    }

    public void Output() throws IOException {
        System.out.println("Scegli ID");
        StringaUtenteID = tastiera.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        m = objectMapper.readValue(StringaRicevutaDalServer, Messaggio.class);
        for (int i = 0; i < biglietti.size(); i++) {
            if (biglietti.get(i).getID() == (Integer.parseInt(StringaUtenteID))) {
                richiesta.add(biglietti.get(i));
            }
        }

        Messaggio m = new Messaggio(richiesta);

        String stringa = objectMapper.writeValueAsString(m);
        outVersoServer.writeBytes(stringa + '\n');
    }

    public void Input() throws IOException {

        StringaRicevutaDalServer = inDalServer.readLine();
        ObjectMapper objectMapper = new ObjectMapper();
        m = objectMapper.readValue(StringaRicevutaDalServer, Messaggio.class);
        biglietti = m.biglietti;
        System.out.println(m.biglietti);
        if (StringaRicevutaDalServer.equals("spegni")) {
            miosocket.close();
            System.out.println("FINE");
        }


    }
}
