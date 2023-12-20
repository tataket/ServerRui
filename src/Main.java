import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final String SERVER_ADDRESS = "172.20.10.2";
        final int SERVER_PORT = 6666;
        boolean isConnect = true;
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            while (isConnect) {
                // send to server
                System.out.println("Client write");
                String msg  = scanner.next();
                if (!msg.equals("quit")) {
                    writer.println(msg);
                    // receive msg
                    String serverResponse = reader.readLine();
                    System.out.println("Server response: " + serverResponse);
                }
                if (msg.equals("quit")) {
                    System.out.println("Exiting...");
                    // Fecha o socket e os fluxos de entrada/saída
                    reader.close();
                    writer.close();
                    socket.close();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}