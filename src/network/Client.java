package network;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;



public class Client {

    public static void main(String[] args) throws IOException
    {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter server port: ");
        Socket socket = new Socket("127.0.0.1", Integer.parseInt(inputScanner.nextLine()));
        System.out.println("Listening on port: " + socket.getLocalPort());
        try (PrintStream printer = new PrintStream(socket.getOutputStream());
             Scanner socketScanner = new Scanner(socket.getInputStream()))
        {
            while (inputScanner.hasNextLine())
            {
                printer.println(inputScanner.nextLine());
                System.out.println("Server said: " + socketScanner.nextLine());
            }
        }
    }
}

class Client2 {

    public static void main(String[] args) throws IOException {

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter server port: ");
        Socket socket = new Socket("127.0.0.1", Integer.parseInt(inputScanner.nextLine()));
        System.out.println("Listening on port: " + socket.getLocalPort());
        try (PrintStream printer = new PrintStream(socket.getOutputStream());
             Scanner socketScanner = new Scanner(socket.getInputStream()))
        {
            while (inputScanner.hasNextLine())
            {
                printer.println(inputScanner.nextLine());
                System.out.println("Server said: " + socketScanner.nextLine());
            }
        }
    }
}