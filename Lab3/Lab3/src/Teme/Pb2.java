/*Să se insereze într-o anumită poziție a unui șir de caractere, un alt șir. Datele vor fi
preluate de la tastatură sau din fișier. Să se șteargă o porțiune a unui șir de caractere care
începe dintr-o anumită poziție și are un anumit număr de caractere. 
Se recomandă utilizarea clasei StringBuilder*/

package Teme;

import java.util.Scanner;

public class Pb2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Dati primul sir: ");
		Scanner keyboard = new Scanner(System.in);
		StringBuilder sir1 = new StringBuilder();
		sir1.append(keyboard.nextLine()); //adauga in StringBuilder sir1
		System.out.println("Dati al doilea sir: ");
		Scanner keyboard2 = new Scanner(System.in);
		//String sir2 = keyboard2.nextLine();
		StringBuilder sir2 = new StringBuilder();
		sir2.append(keyboard2.nextLine());
		
		
		System.out.println(sir1);
		System.out.println(sir2);
		
		System.out.println("La ce pozitie doriti sa se insereze sirul1 in sirul2: ");
		Scanner keyboard3 = new Scanner(System.in);
		int poz = keyboard3.nextInt();
		
		sir2.insert(poz, sir1);
		System.out.println(sir2);
		
		System.out.println("De la ce pozitie stergem din sirul2: ");
		Scanner keyboard4 = new Scanner(System.in);
		int poz2 = keyboard4.nextInt();
		System.out.println("Cate caractere stergem: ");
		Scanner keyboard5 = new Scanner(System.in);
		int poz3 = keyboard4.nextInt();
		
		sir2.delete(poz2, poz3);
		System.out.println(sir2);
	}

	private static void StringBuilder(String nextLine) {
		// TODO Auto-generated method stub
		
	}

}
