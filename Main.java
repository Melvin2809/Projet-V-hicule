import java.awt.Color;

public class Main {
	public static void main(String[] args) {
		Voiture v1 = new Voiture(15225,Color.BLUE,"Peugeot","208","AB 1234 CD",200,100,4);
		Voiture v2 = new Voiture(19224,Color.BLACK,"Citroen","C3","AB 1235 EF",230,120,2);
		Voiture v3 = new Voiture(19687,Color.YELLOW,"Citroen","C4","AB 1236 EG",250,140,1);
		
		Stock s = new Stock();
		s.getStock().add(v1);
		s.getStock().add(v2);
		s.getStock().add(v3);
		
		for(Voiture v : s.getStock()) {
			System.out.println(v.toString());
		}
	}

}
