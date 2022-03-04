package persistance;

import java.sql.*;
import java.util.List;
import mediatek2022.*;

import javax.rmi.CORBA.Util;
// classe mono-instance  dont l'unique instance est connue de la médiatheque
// via une auto-déclaration dans son bloc static

public class MediathequeData implements PersistentMediatheque {
// Jean-François Brette 01/01/2018
	static {
		Mediatheque.getInstance().setData(new MediathequeData());
	try {
		Class.forName("org.mariadb.jdbc.Driver");

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}

	private MediathequeData() {
	}

	// renvoie la liste de tous les documents disponibles de la médiathèque
	@Override
	public List<Document> tousLesDocumentsDisponibles() {
		return null;
	}

	// va récupérer le User dans la BD et le renvoie
	// si pas trouvé, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		try {
			Connection bdd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/projet", "root", "root");
			Statement requeteStatique = bdd.createStatement();
			ResultSet tableResultat = requeteStatique.executeQuery("SELECT * FROM user WHERE LOGIN == login AND PASSWORD == password");
			System.out.println(tableResultat);
			Utilisateur Michel = new Abonné(tableResultat.getString("Name"));
			return Michel;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// va récupérer le document de numéro numDocument dans la BD
	// et le renvoie
	// si pas trouvé, renvoie null
	@Override
	public Document getDocument(int numDocument) {
		return null;
	}

	@Override
	public void ajoutDocument(int type, Object... args) {
		// args[0] -> le titre
		// args [1] --> l'auteur
		// etc... variable suivant le type de document
	}

}
