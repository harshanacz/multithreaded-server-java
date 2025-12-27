import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            
            synchronized (MyServer.class) {
                MyServer.count++; 
               }

        out.println("Hello! You are connected.");

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client sent: " + message);
                out.println("Echo: " + message);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}