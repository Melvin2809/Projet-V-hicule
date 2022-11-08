import java.awt.Color;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

public class Menu {
	
	static Scanner sc = new Scanner(System.in);
	
	
	//****************************************************************\\
	public static void AfficherCatalogueVéhicule(Stock s) {
		for(Voiture v : s.getStock()) {
			System.out.println(v.toString());
		}
		System.out.println("\n");
	}
	//****************************************************************\\
	public static void RechercheDansCatalogue(Stock s) {		
		try {
			boolean voitureTrouvé = false;
			do {
				System.out.println("Veuillez entrer le nom d'un véhicule: ");
				String véhicule = sc.nextLine();
				for( Voiture v : s.getStock()) {
					String temp = v.getMarque();
					if(v.getMarque().contains(véhicule)) {
						System.out.println(v.toString());
						voitureTrouvé = true;
					}
				}
			}while(voitureTrouvé == false);
		}catch(InputMismatchException e) {
			System.out.println("Ce véhicule n'existe pas, veuillez entrez un nom de véhicule svp: ");
		}catch (Exception exception) {
            exception.printStackTrace();
        }
	}
	
	
	public static void main(String[] args) {
		Voiture v1 = new Voiture(15225,Color.BLUE,"Peugeot","208","AB 1234 CD",200,100,4);
		Voiture v2 = new Voiture(19224,Color.BLACK,"Citroen","C3","AB 1235 EF",230,120,2);
		Voiture v3 = new Voiture(19687,Color.YELLOW,"Citroen","C4","AB 1236 EG",250,140,1);
		
		Stock s = new Stock();
		s.getStock().add(v1);
		s.getStock().add(v2);
		s.getStock().add(v3);
		
		AfficherCatalogueVéhicule(s);
		RechercheDansCatalogue(s);
	}

}
