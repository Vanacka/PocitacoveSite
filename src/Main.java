import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("start");
        int x = 0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        ServerSocket server = new ServerSocket(10000);

        System.out.println("kork 1");

        try (Socket socket = server.accept()) {
            System.out.println("krok 2");

            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    out.println("HTTP/1.0 200");
                    out.println();
                    out.println(dtf.format(now));
            }
        }
        System.out.println("hotovo");
    }
}