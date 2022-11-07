import java.awt.Color;

public class Voiture extends Véhicule{
	//private int places;     on verra plus tard comment gérer le nombre de places.

	public Voiture(int prix, Color couleur, String marque,String model,String plaqueImmatriculation, int vitesse, int puissance, int ancienneté) {
		super(prix, couleur, marque, model, plaqueImmatriculation, vitesse, puissance, ancienneté);
	}
	
	@Override
	public String toString() { 
		return "ID: "+this.getId()+" - Marque: "+this.getMarque()+" - Model: "+this.getModel()+" - Prix: "+this.getPrix()+"€ - plaque d'immatriculation: "+this.getPlaqueImmatriculation()+" - couleur: "+this.getCouleur()+" - Puissance: "+this.getPuissance()+"kW - vitesse: "+this.getVitesse()+"km/h - ancienneté: "+this.getAncienneté()+" mois.";
	}

}
