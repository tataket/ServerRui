import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private PrintStream out;
    private BufferedReader in;
    private Socket socketCreator;

    public void answerClient(String ip, int port) throws IOException {
        socketCreator = new Socket(ip, port);
        out = new PrintStream(socketCreator.getOutputStream(), true);   //limpar+escrever
        in = new BufferedReader(new InputStreamReader(socketCreator.getInputStream()));  //ler
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        socketCreator.close();
    }
}
