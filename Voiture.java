import java.awt.Color;

public class Voiture extends V�hicule{
	//private int places;     on verra plus tard comment g�rer le nombre de places.

	public Voiture(int prix, Color couleur, String marque,String model,String plaqueImmatriculation, int vitesse, int puissance, int anciennet�) {
		super(prix, couleur, marque, model, plaqueImmatriculation, vitesse, puissance, anciennet�);
	}
	
	@Override
	public String toString() { 
		return "ID: "+this.getId()+" - Marque: "+this.getMarque()+" - Model: "+this.getModel()+" - Prix: "+this.getPrix()+"� - plaque d'immatriculation: "+this.getPlaqueImmatriculation()+" - couleur: "+this.getCouleur()+" - Puissance: "+this.getPuissance()+"kW - vitesse: "+this.getVitesse()+"km/h - anciennet�: "+this.getAnciennet�()+" mois.";
	}

}
