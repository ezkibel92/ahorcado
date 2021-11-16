import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class ahorcado {

	public static void main(String[] args)  {
		
		Scanner teclado = new Scanner(System.in);
		int opcion;
		String pelicula;
		String letra;
		int vidas = 3;
		
		
		do{
			System.out.println("Hola, bienvenido");
			System.out.println("Seleccione una de las siguientes opciones para continuar");
			System.out.println("1- Jugar al ahorcado");
			System.out.println("2- Clima");
			System.out.println("3- Fecha y hora");
			System.out.println("0- Salir del juego y apagar el pc");
			opcion = teclado.nextInt();
			
			switch(opcion) {
			
				case 1:
					
					System.out.println("Haz elegido jugar al ahorcado");
					System.out.println("Ingrese la pelicula");
					teclado.nextLine();
					pelicula = teclado.next();
					char[]peliculaIngresada=pelicula.toCharArray();
					char[]ingreso = new char[peliculaIngresada.length];;
					char[]adivinado = new char[peliculaIngresada.length];
					
					
					boolean finDelJuego = false;
					do{
						
						System.out.println("\nIngresa una letra");
						teclado.nextLine();
						letra = teclado.next();
						ingreso =letra.toCharArray();
						
						if(Arrays.equals(ingreso, peliculaIngresada)){
							System.out.println("\nSi!! La pelicula es: "+pelicula+". Haz GANADO!!!");
							finDelJuego = true;
						}
						
						boolean adivino = false;
						for(int j = 0; j < peliculaIngresada.length; j++){
							
							if(peliculaIngresada[j] == letra.charAt(0)){
								adivinado[j] = letra.charAt(0);
								adivino = true;
							}
							
							if(adivinado[j] != peliculaIngresada[j] && adivinado[j] != ' ')
								adivinado[j] = '_';

							System.out.print(adivinado[j]);
							}
							
						
						if(!adivino) {
							vidas--;
							System.out.print("\nNo haz acertado, te quedan "+vidas+" vidas");
						}
						if(Arrays.equals(adivinado, peliculaIngresada)) {
							
							System.out.println("\nSi!! La pelicula es: "+pelicula+". Haz GANADO!!!");
							finDelJuego = true;
						}
						if (vidas == 0){
							System.out.println("\nLa pelicula era: "+pelicula+". Te quedaste sin vidas. Haz PERDIDO!!!");
							finDelJuego = true;
						}
					}while(!finDelJuego);
					break;
				case 2:
					
					URL url=null;
					try {
					    url = new URL("https://www.meteored.com.uy/tiempo-en_Montevideo-America+Sur-Uruguay-Montevideo-SUMU-1-13027.html");
					    try {
					        Desktop.getDesktop().browse(url.toURI());
					    } catch (IOException e) {
					        e.printStackTrace();
					    } catch (URISyntaxException e) {
					        e.printStackTrace();
					    }
					} catch (MalformedURLException e1) {
					    e1.printStackTrace();
					}
					break;
				case 3:
					System.out.println("La hora y fehca es: ");
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			        System.out.println(dtf.format(LocalDateTime.now()));
			        break;
				case 0:
					
					try {
						String [] cmd = {"shutdown","-s","-t", "10"};
						Runtime.getRuntime().exec(cmd);
					} catch (IOException ioe) {
						System.out.println (ioe);
					}
			}
			
		}while(opcion <= 3);
		teclado.close();
		}
	}
