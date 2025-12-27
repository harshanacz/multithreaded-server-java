import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServer{
    public static int count = 0;
    public static void main(String[] args) throws IOException{
        
        ServerSocket server = new ServerSocket(5000);

        // 1. අපි කලින්ම සේවකයෝ 10 දෙනෙක් හදලා තියාගන්නවා like this!
        ExecutorService pool = Executors.newFixedThreadPool(10);

        while(true){
            Socket client =server.accept();
            ClientHandler handler = new ClientHandler(client);
            // Thread t = new Thread(handler); 
            // t.start();

            // 2. අලුත් Thread එකක් හදන්නේ නෑ. Pool එකට බාර දෙනවා.
            // pool.execute(handler) හෝ pool.submit(handler) පාවිච්චි කරන්න පුළුවන්
            pool.submit(handler);
            
        }

    }
}