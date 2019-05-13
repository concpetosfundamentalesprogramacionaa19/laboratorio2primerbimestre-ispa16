package laboratorio_2;
import java.util.Scanner ;
public class Principal {
	public static void main (String []args) {
		Scanner entrada = new Scanner (System.in);
		//variables
		int contador = 1;
		int contador2 = 1;
		int contador3 = 1;
		int auxiliar2 = 1;//para un ciclo while
		int contador_aux = 1;
		int contador_aux2 = 1;
		String nombre_padre [][];
		nombre_padre = new String [100][100];
		double sueldo[][];
		sueldo = new double [100][100];
		int num_hijos [][];
		num_hijos = new int [100][100];
		boolean bandera = true ;
		double pasaje[][];
		pasaje = new double [100][100];//bidimensional
		double bar[][];
		bar = new double [100][100];//bidimensional
		double salidas[][];
		salidas = new double [100][100];//bidimensional
		double totales[][];
		totales = new double [100][100];//bidimensional
		double total;
		double total_aux = 0;
		double total_aux2 = 0;
		double total_aux3 = 0;
		double total_aux4 = 0;
		
		
		//pedir informacion e ingreso de datos
		
		while (bandera == true) {
			
			System.out.println("Ingrese el nombre del padre de familia");
			nombre_padre[0][contador] = entrada.nextLine();
			
			System.out.println("Ingrese el sueldo semanal");
			sueldo [0][contador] = entrada.nextDouble();
			
			//entrada.nextLine(); por si hay que limpiar el buffer
			
			System.out.println("Ingrese el numero de hijos");
			contador2 = entrada.nextInt();
			num_hijos [0][contador] = contador2;
			//crear la dimension de la matriz segun los hijos
			while (contador2 > 0) {
				System.out.printf("ingrese el gasto por pasaje del hijo %s\n",contador2);//pasajes
				pasaje [contador][contador2] = entrada.nextDouble();
				System.out.printf("ingrese el gasto en bares del hijo %s\n",contador2);//bar
				bar [contador][contador2] = entrada.nextDouble();
				System.out.printf("ingrese el gasto por salidas del hijo %s\n",contador2);//salidas
				salidas [contador][contador2] = entrada.nextDouble();
				contador2 = contador2 - 1;
			}
			entrada.nextLine();
			System.out.println("Desea ingresar otro padre de familia");
			String decision = entrada.nextLine();
			if (decision.equals("no")) {
				bandera = false;
			}
				
			
			
			contador = contador + 1;
		}//fin while, fin entrada de datos
		
		//salida de datos
		System.out.println("Reporte Gastos de Padres de Familia\n" + 
				"\n");
		while (contador_aux < contador) {
			//reinicio de contadores
			total_aux = 0;
			total_aux2 = 0;
			total_aux3 = 0;
			total_aux4 = 0;
			total = 0;
			contador_aux2 = 1;
			System.out.printf("reporte 0%s\n\nNombre del padre de"
					+ " familia: %s\nSueldo semanal: %s\nNúmero de Hijos: %s\n\n"
					+ "Reporte de Gastos\nPersona\t\tPasaje\t\tBar\t\tSalidas\n"
					, contador_aux, nombre_padre[0][contador_aux] ,sueldo[0][contador_aux],
					num_hijos[0][contador_aux]);
			//segundo ciclo repetitivo 
			while (contador_aux2 <= num_hijos[0][contador_aux]) {
				System.out.printf("Hijo %s\t\t%s\t\t%s\t\t%s\n",contador_aux2, pasaje [contador_aux][contador_aux2],
						 bar [contador_aux][contador_aux2],	 salidas [contador_aux][contador_aux2]);
				total = pasaje [contador_aux][contador_aux2] + bar [contador_aux][contador_aux2] +
						salidas [contador_aux][contador_aux2];
				total = total + total_aux; //calculo del total a pagar 
				total_aux = total;
				
				totales [contador_aux][1] =  pasaje [contador_aux][contador_aux2] + total_aux4 ;
				total_aux4 = totales [contador_aux][1];
				totales [contador_aux][2] =  bar [contador_aux][contador_aux2] + total_aux2 ;
				total_aux2 = totales [contador_aux][2];
				totales [contador_aux][3] =  salidas [contador_aux][contador_aux2] + total_aux3 ;
				total_aux3 = totales [contador_aux][3];
				
				contador_aux2 = contador_aux2 + 1;//contador principal de esta estructura while
				
			}
			System.out.printf("Totales\t\t%s\t\t%s\t\t%s\n ",totales [contador_aux][1],
					totales [contador_aux][2],totales [contador_aux][3] );
			//condicion
			if (sueldo[0][contador_aux] >= total) {
				System.out.printf("El padre de familia %s le alcanza"
						+ " el dinero semanal, para sus gastos\n",nombre_padre[0][contador_aux]);
			}else {
				System.out.printf("Al padre de familia %s le falta"
						+ " el dinero semanal, para sus gastos\n",nombre_padre[0][contador_aux]);
			}
			System.out.printf("\nFin del reporte 0%s\n", contador_aux);
			contador_aux = contador_aux + 1;//contador principal de la estructura
		}
	}
}
