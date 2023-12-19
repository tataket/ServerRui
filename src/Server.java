import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socketCreator;
    private PrintStream out;
    private BufferedReader in;

    public void serverIn(int port) throws IOException {
        serverSocket = new ServerSocket(8666);
        boolean isOn = true;
        socketCreator = serverSocket.accept();
        out = new PrintStream(socketCreator.getOutputStream(), true);   //limpar+escrever
        in = new BufferedReader(new InputStreamReader(socketCreator.getInputStream()));  //ler

        while(isOn){
            out.println("Write.....");
            String msg = in.readLine().toLowerCase();
            if ("hey babe".equals(msg)){
                out.println("Server: ");
                out.println("Write something dear....");
            }
            if (msg.contains("exit")){
                out.println("Exiting.......");
                isOn = false;
            }
            if (!msg.contains("hey babe") && !msg.contains("exit")){
                out.println("Listening bitch.....");
            }
        }




    }
}
