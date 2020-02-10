//package network;
//import javafx.scene.image.Image;
//
//import javax.sound.sampled.Port;
//import java.io.IOException;
//import java.io.PrintStream;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Server {
//
//    public static String username;
//    public static YaGson yaGson = new YaGson();
//
//    public static void main(String[] args) throws IOException {
//
//        ServerSocket server = new ServerSocket(6001);
//        System.out.println(server.getInetAddress());
//        System.out.println(server.getLocalPort());
//
//        while (!server.isClosed()) {
//            Socket client = server.accept();
//
//            new Thread(() ->
//            {
//                System.out.println("Sending to port: " + client.getPort());
//
//                try (PrintStream printer = new PrintStream(client.getOutputStream());
//                     Scanner reader = new Scanner(client.getInputStream())) {
//
//                    String mode = reader.nextLine();
//
//                    if (mode.equals("signUp")) {
//
//                        String newUsername = reader.nextLine();
//                        String newPassword = reader.nextLine();
//                        String profilePhotoJson = reader.nextLine();
//                        Image profilePhoto = yaGson.fromJson(profilePhotoJson, Image.class);
//                        if (User.getUserByUsername(newUsername) == null) {
//                            new User(newUsername, newPassword, profilePhoto);
//                            printer.println("done");
//                        } else {
//                            printer.println("cant");
//                        }
//
//                    } else if (mode.equals("login")) {
//
//                        username = reader.nextLine();
//                        String password = reader.nextLine();
//
//                        if (User.userAndPassMatches(username, password)) {
//                            printer.println("You are logged in.");
//
//                        } else {
//                            printer.println(new StringBuilder("username and password doesn't match."));
//                        }
//                    } else if (mode.equals("send current user")) {
//                        User currentUser = User.getUserByUsername(username);
//                        YaGson yaGson = new YaGson();
//                        String currentUserJson = yaGson.toJson(currentUser);
//                        printer.println(currentUserJson);
//                        username = null;
//                    } else if (mode.equals("show other profiles")) {
//                        String userNamesArrayListJson = yaGson.toJson(User.getUsersStringArrayList());
//                        printer.println(userNamesArrayListJson);
//
//                    } else if (mode.equals("adding post")) {
//                        String username = reader.nextLine();
//                        String caption = reader.nextLine();
//                        String photoNumber = reader.nextLine();
//                        String photoAddress = photoNumber + ".jpg";
//                        Image image = new Image(photoAddress);
//                        Post post = new Post(image, caption);
//                        User.getUserByUsername(username).getPosts().add(post);
//
//                    }
//
////                    while (reader.hasNextLine())
////                        printer.println(new StringBuilder(reader.nextLine()).reverse());
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }).start();
//        }
//    }
//
//
//}