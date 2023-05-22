package com.Lisa.monsters;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class Server extends MonstersApp {
    public static void main(String[] args){
        final String[] lastClientMessage = {""};
        final String[] _out = {""};

        Game core = new Game();

        final ServerSocket serverSocket ;
        final Socket clientSocket ;
        final BufferedReader in;
        final PrintWriter out;
        final Scanner sc=new Scanner(System.in);

        try {
            System.out.println("Starting server...");
            serverSocket = new ServerSocket(5000);
            System.out.println("Waiting for client...");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));

            Thread sender= new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    while(true){
                        if (lastClientMessage[0] != "") {
                            _out[0] = core.inOut(String.valueOf(lastClientMessage[0]));
                            System.out.println("1 Output: " + _out[0]);
                            out.println(Arrays.toString(_out));    // write data stored in msg in the clientSocket
                            out.flush();   // forces the sending of the data
                            lastClientMessage[0] = "";
                        }
                        //msg = sc.nextLine();
                    }
                }
            });
            sender.start();

            Thread receive= new Thread(new Runnable() {
                String msg ;
                @Override
                public void run() {
                    try {
                        msg = in.readLine();
                        lastClientMessage[0] = msg;
                        while(msg!=null){
                            System.out.println("Client : "+msg);
                            msg = in.readLine();
                        }

                        System.out.println("Client disconnected");

                        out.close();
                        clientSocket.close();
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receive.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
