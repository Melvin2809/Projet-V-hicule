import java.awt.Color;

public abstract class V�hicule {
	
	// Abstract car on ne veut pas instanci� un v�hicule mais une voiture ou des scooters etc...
	
	private double prix;
	private Color couleur;
	private String marque;	
	private String model;
	private int id;
	private String plaqueImmatriculation;
	private static int compteur=0;
	private int vitesse;
	private int puissance;   // kilogs Watt
	private int anciennet�;  // (ceux sont des mois). A voir si on le laisse ou non. C'est pour pouvoir solder un v�hicule difficile � vendre.
	
	public V�hicule(int prix,Color couleur, String marque,String model, String plaqueImmatriculation, int vitesse, int puissance, int anciennet�) {
		this.prix = prix;
		this.couleur = couleur;
		this.marque = marque;
		this.model = model;
		this.id = compteur++;
		this.plaqueImmatriculation = plaqueImmatriculation;
		this.vitesse = vitesse;
		this.puissance = puissance;
		this.anciennet� = anciennet�;
	}

	public Color getCouleur() {
		return couleur;
	}

	public String getMarque() {
		return marque;
	}

	public int getId() {
		return id;
	}

	public static int getCompteur() {
		return compteur;
	}

	public int getVitesse() {
		return vitesse;
	}

	public int getPuissance() {
		return puissance;
	}

	public String getModel() {
		return model;
	}

	public int getAnciennet�() {
		return anciennet�;
	}
	
	public double getPrix() {
		return prix;
	}

	public String getPlaqueImmatriculation() {
		return plaqueImmatriculation;
	}

	
	
	 

	
}
