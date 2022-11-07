package it.fi.itismeucci.lanzi;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ThreadServer extends Thread{
    Socket client;
    ArrayList<Socket> socket;
    String s;
    ServerSocket server;

    public ThreadServer(Socket client, ArrayList<Socket> socket, ServerSocket server, String s) {
        this.client = client;
        this.socket = socket;
        this.server = server;
        this.s = s;
    }

    public void run(){
        comunica();
    }

    public void comunica() {
        try {
            BufferedReader inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutput outVersoClient = new DataOutputStream(client.getOutputStream());
            outVersoClient.writeBytes(s + '\n');
            String StringaRicevuta = inDalClient.readLine();
            System.out.println("ricevuta la stringa dal cliente: " + StringaRicevuta);
                
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("E22");
            System.exit(1);
        }
    }
}
