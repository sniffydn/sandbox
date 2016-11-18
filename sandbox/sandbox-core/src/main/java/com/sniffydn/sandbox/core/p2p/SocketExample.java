package com.sniffydn.sandbox.core.p2p;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketExample {

    private static int port = 2000;

    public static void main(String[] argv) throws Exception {

    }

    public static void writeToSocket() throws Exception {
        ServerSocket srv = new ServerSocket(port);

        // Wait for connection from client.
        Socket socket = srv.accept();
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        wr.write("aString");
        wr.flush();
    }

    public static void readTextFromSocket() throws Exception {
        ServerSocket srv = new ServerSocket(port);

        // Wait for connection from client.
        Socket socket = srv.accept();
        BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String str;
        while ((str = rd.readLine()) != null) {
            System.out.println(str);
        }
        rd.close();
    }
}
