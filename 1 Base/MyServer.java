import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServer{
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(5000);
        while(true){
            Socket client =server.accept();
            ClientHandler handler = new ClientHandler(client);
            Thread t = new Thread(handler); 
            t.start();
            
        }

    }
}