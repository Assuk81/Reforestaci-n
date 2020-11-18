//Juan Carlos Corredor Sánchez
//https://github.com/Assuk81/Reforestaci-n.git

package dia12Noviembre;

import java.util.Scanner;

public class Reforestacion02 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		String[] zonas = new String[5]; //iniciamos con 5 zonas
		int[][] datosZonas = new int[5][3];//si hay 5 zonas iniciamos con 5 datos(1 dato por cada zona y como son 5 ponemos 5 datos) 
											//y 3 columnas que serán area, densidad y calculo de area *densidad
		
		int contador = 0;//aqui se van contando las posiciones ocupadas al ir metiendo datos
		int opcion;
		boolean finalizado = false;//finalizado de momento falso para iniciar el bucle hasta que se elija la opcion SALIR
		
		do {//el menu se muestra 1 primera vez
			
			mostrarOpciones();//llama a la funcion MENU y muestra las opciones
			opcion = entrada.nextInt();//se introduce una opcion por teclado
			
			switch(opcion){
			
			case 1://Introducir datos
					
				if(contador == zonas.length) {//si contador es igual a 5 zonas iniciales entonces pasamos a las funciones de aumentar
					zonas = incrementarZonas(zonas);//las zonas en 5 y
					datosZonas = incrementaDatosZonas(datosZonas);//aumentar los datos tambien en 5, que tiene que ir a la par de zonas
				}													//1 nueva zona=1 nuevo datoZona
				System.out.println("Introduce el nombre de la zona: ");
				zonas[contador] = entrada.next();//se introduce una zona y se guarda en la variable zonas y contador
				
				System.out.println("Introduce el área: ");//se introduce el area y se guarda en la columna 0
				datosZonas[contador][0] = entrada.nextInt();
				
				System.out.println("Introduce la densidad: ");//se introduce densidad y se guarda en la columna 1 de la matriz datosZonas
				datosZonas[contador][1] = entrada.nextInt();//y contador(contador es la fila nueva introducidad
				
				datosZonas[contador][2] = datosZonas[contador][0] * datosZonas[contador][1];//calculo de reforestacion, se guarda en
																							//columna 2 de datosZonas
				contador++;// contador se aumenta en 1 conforme se añade 1 nuevo dato
				break;
				
			case 2://Mostrar reforestación por zona
				System.out.println("Introduce la zona que deseas ver: ");
				
				for (int i = 0; i < contador; i++) {
					System.out.println((i+1) + "." + zonas[i]);//recorre contador, que son todas las zonas con sus datos introducidos
				}											//y muestra por pantalla las opciones.Se pone i+1 para que la primera opcion 
				opcion = entrada.nextInt();					//comience de 1 y no de 0
				
				if(opcion < 1 || opcion > zonas.length) {//si se elige un numero que esta fuera de rango de las zonas dice 
					System.out.println("Zona NO válida");//no valido
				}else {
					System.out.println("La reforestación de la zona " + zonas[opcion-1] + " es "//muestra las zonas pero se pone -1 para 
										+ datosZonas[opcion-1][2]);// que coja la primera desde la posicion 0.Posicion 0 equivale a elegir
				}													//por teclado opcion 1
				
				break;
				
			case 3://Mostrar total de reforestación
				int total = 0;
				
				for (int i = 0; i < contador; i++) {//recorre todas las zonas introducidas, hace calculo de reforestacion y suma 
					total += datosZonas[i][2];		//todos los resultados.
				}
				System.out.println("La reforestación total es: " + total);
				break;
				
			case 4://Salir
				
				finalizado = true;//se pone la boolean a verdadero para salir del programa
				break;
				
			default:
					System.out.println("Opción NO válida");
			}
			
			}while(! finalizado);//mientras NO este finalizado seguirá en el bucle

		entrada.close();
		
	}

	public static void mostrarOpciones(){//menu a mostrar en pantalla
		System.out.print("----------------\n1.Introduce datos\n2.Mostrar reforestación por zona"
				+ "\n3.Mostrar reforestación total\n4.Salir\n>>>");
	}
	
	public static String[] incrementarZonas(String[]zonas) {//funcion incremento de zonas en 5
		String[] aux = new String [zonas.length+5];//nueva variable que coge la variable zonas y aumenta en 5
		for (int i = 0; i < zonas.length; i++) {
			aux[i] = zonas[i];//aux copia los valores de zonas con cada vuelta de bucle
		}
		return aux;
	}
	
	public static int[][] incrementaDatosZonas(int[][]datosZonas){//funcion incrementar de 5 en 5 los datos, se aumenta a la
		int[][] aux = new int[datosZonas.length+5][3];//par que las zonas. SI la zona aumenta 5, los datos tambien
		for(int i = 0; i < datosZonas.length; i++) {
			aux[i][0] = datosZonas[i][0];//copia datosZona en variable aux con cada vuelta de bucle, aqui el area de la columna 0
			aux[i][1] = datosZonas[i][1];//copia datosZona en variable aux con cada vuelta de bucle, aqui la densidad de la columna 1
		}
		return aux;
	}
	
	
	
}
