package socket1;

import java.io.*;import java.net.*;import java.util.Scanner;
public class Client {
public static void main(String[] args) {
try {
System.out.println("Cr�er une connexion au serveur:");

/*Cr�ation d�un client :*/

try (Socket clientSocket = new Socket("localhost", 1234)) {
	System.out.println("G�n�ration de objet InptStream et OutputStream de la socket");
	
	InputStream is=clientSocket.getInputStream();
	
	OutputStream os=clientSocket.getOutputStream();
	System.out.print("Lire un nombre au clavier NB=");
	try (Scanner clavier = new Scanner(System.in)) {
		int nb=clavier.nextInt();
		System.out.println("Envoyer le nombre "+nb+" au serveur");
		os.write(nb);
	}
	System.out.println("Attendre la r�ponse du serveur:");
	int rep=is.read();
	System.out.println("La r�ponse est :"+rep);
}
} catch (Exception e) {
e.printStackTrace();
}
}
}
