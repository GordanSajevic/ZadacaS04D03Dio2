package lab19;

import java.util.Scanner;

public class Matrica {

	/**
	 * Funkcija kreira matricu za zadani broj redova i kolona
	 * @param redovi
	 * @param kolone
	 * @return matrica 
	 */
	
	private static double[][] kreirajMatricu(int redovi, int kolone) {
		Scanner unos = new Scanner(System.in);
		double[][] matrica = new double [redovi][kolone];
		for (int i=0; i<redovi; i++)
		{
			for (int j=0; j<kolone; j++)
			{
				System.out.println("Unesite (" + (i+1) + ", " + (j+1) + ") član matrice: ");
				matrica[i][j] = unos.nextDouble();
			}
		}
		return matrica;
	}
	
	/**
	 * Funkcija ispisuje zadanu matricu
	 * @param matrica
	 */
	
	private static void ispisiMatricu(double[][] matrica) {
		for (int i=0; i<matrica.length; i++)
		{
			for (int j=0; j<matrica[i].length; j++)
			{
				System.out.printf("%f ", matrica[i][j]);
			}
			System.out.println();
		}
		
	}

	/**
	 * Funkcija sabira dvije zadane matrice i vraća njihov zbir
	 * @param matrica1
	 * @param matrica2
	 * @return suma
	 */
	
	private static double[][] sabiranje(double[][] matrica1, double[][] matrica2) {
		double[][] suma = new double [matrica1.length][matrica1[0].length];
		try
		{
			for (int i=0; i<matrica1.length; i++)
			{
				for (int j=0; j<matrica1[i].length; j++)
				{
					suma[i][j] = matrica1[i][j] + matrica2[i][j];
				}
			}
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Matrice nije moguće sabrati");
		}
		return suma;
	}

	/**
	 * Funkcija oduzima dvije zadana matrice i vraća njihovu razliku
	 * @param matrica1
	 * @param matrica2
	 * @return razlika
	 */
	
	private static double[][] oduzimanje(double[][] matrica1, double[][] matrica2) {
		double[][] razlika = new double [matrica1.length][matrica1[0].length];
		try
		{
			for (int i=0; i<matrica1.length; i++)
			{
				for (int j=0; j<matrica1[i].length; j++)
				{
					razlika[i][j] = matrica1[i][j] - matrica2[i][j];
				}
			}
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Matrice nije moguće sabrati");
		}
		return razlika;
	}

	/**
	 * Funkcija množi dvije zadane matrice i vraća njihov proizvod
	 * @param matrica1
	 * @param matrica2
	 * @return proizvod
	 */
	
	private static double[][] mnozenje(double[][] matrica1, double[][] matrica2) {
		double[][] proizvod = new double [matrica1.length][matrica2[0].length];
		try
		{
			for (int i=0; i<matrica1.length; i++)
			{
				for (int j=0; j<matrica2[0].length; j++)
				{
					for (int k=0; k<matrica1[0].length; k++)
					{
						proizvod[i][j] += matrica1[i][k]*matrica2[k][j];
					}
				}
			}
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Matrice nije moguće pomnožiti");
		}
		return proizvod;
	}
	
	/**
	 * Funkcija prima matricu i vraća transponovanu matricu
	 * @param matrica
	 * @return
	 */
	
	public static double[][] transponuj(double[][] matrica)
	{
		double[][] transponovana = new double [matrica.length][matrica[0].length];
		for (int i=0; i<matrica.length; i++)
		{
			for (int j=0; j<matrica[i].length; j++)
			{
				transponovana[i][j] = matrica[j][i];
			}
		}
		return transponovana;
	}
	
	public static void main(String[] args) {
		System.out.println("Unesi broj redova matrice: ");
		Scanner unos = new Scanner(System.in);
		int redovi = unos.nextInt();
		System.out.println("Unesi broj kolona matrice: ");
		int kolone = unos.nextInt();
		double[][] matrica1 = kreirajMatricu(redovi, kolone);
		ispisiMatricu(matrica1);
		double[][] matrica2 = kreirajMatricu(redovi, kolone);
		ispisiMatricu(matrica2);
		double[][] zbir = sabiranje(matrica1, matrica2);
		System.out.println("Suma matrica: ");
		ispisiMatricu(zbir);
		double[][] razlika = oduzimanje(matrica1, matrica2);
		System.out.println("Razlika matrica: ");
		ispisiMatricu(razlika);
		double[][] proizvod = mnozenje(matrica1, matrica2);
		System.out.println("Proizvod matrica: ");
		ispisiMatricu(proizvod);
		matrica1 = transponuj(matrica1);
		System.out.println("Transponovana matrica: ");
		ispisiMatricu(matrica1);
	}

}
