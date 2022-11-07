
public class Commande {
	private int id;
	private static int compteur;
	private String nom;
	private Voiture voiture;
	private double prix;
	private String Etat;           // "en cours", "expedié", "livrée".
	private Pays PaysLivraison;  // pour calculer la taxe du pays.
	private String paiement;   	   // au comptant ou par crédit.
	
	public Commande(String nom, Voiture voiture, double prix, String etat, Pays paysLivraison,
			String paiement) {
		this.id = compteur++;
		this.nom = nom;
		this.voiture = voiture;
		this.prix = prix;
		Etat = etat;
		PaysLivraison = paysLivraison;
		this.paiement = paiement;
	}
	
	public void calculTaxe(String PaysLivraison) {
		this.setPrix(prix+=((this.PaysLivraison.getTaxe())/100));  
		// ex: prix voiture: 10 000€, pays états-unis, taxe 6%, donc prix = 10 000 + (10 000 * (6/100))
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	

}
