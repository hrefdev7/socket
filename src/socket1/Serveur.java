package socket1;

import java.io.*;import java.net.*;

public class Serveur {
public static void main(String[] args) {
try {
	/*Création d’un serveur:*/
	
try (ServerSocket ss = new ServerSocket(1234)) {
	System.out.println("j'attend la connexion d'un client");
	
	Socket clientSocket=ss.accept();
	
	System.out.println("Nouveau client connecté");
	
	System.out.println("Génération de objet InptStream et OutputStream de la socket");
	
	InputStream is=clientSocket.getInputStream();
	
	OutputStream os=clientSocket.getOutputStream();
	
	System.out.println("J'attend un nombre (1 octet)!");
	
	int nb=is.read();
	System.out.println("J'envoie la réponse");
	os.write(nb*5);
	System.out.println("Déconnexion du client");
	clientSocket.close();
}
} catch (IOException e) {
e.printStackTrace();
}
}
}