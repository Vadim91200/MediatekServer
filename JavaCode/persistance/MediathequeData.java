package JavaCode.persistance;

import java.sql.*;
import java.util.List;

import JavaCode.TypeDocument.*;
import JavaCode.TypeUser.*;
import mediatek2022.*;
// classe mono-instance  dont l'unique instance est connue de la m�diatheque
// via une auto-d�claration dans son bloc static



public class MediathequeData implements PersistentMediatheque {
// Jean-Fran�ois Brette 01/01/2018
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

	// renvoie la liste de tous les documents disponibles de la m�diath�que

	public List<Document> tousLesDocumentsDisponibles() {
		return null;
	}

	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null

	public Utilisateur getUser(String login, String password) {
		try {
			Connection bdd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/projet", "root", "root");
			Statement requeteStatique = bdd.createStatement();
			ResultSet tableResultat = requeteStatique.executeQuery("SELECT * FROM user WHERE (Login = '" + login + "') AND (Password = '" + password + "')");
			if(!tableResultat.next()){
				System.out.println("The request is empty");
				return null;
			}else{
				System.out.println("There is a result");
				switch(tableResultat.getString("Typeuser")){
					case "subscriber":
						return new Subscriber(tableResultat.getString("Name"));
					case "librarian":
						return new librarian(tableResultat.getString("Name"));
					default:
					    throw new DatabaseProblemException();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (DatabaseProblemException){
			return null;
		}
	}

	// va r�cup�rer le document de num�ro numDocument dans la BD
	// et le renvoie
	// si pas trouv�, renvoie null

	public Document getDocument(int numDocument) {
		try {
			Connection bdd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/projet", "root", "root");
			Statement requeteStatique = bdd.createStatement();
			ResultSet tableResultat = requeteStatique.executeQuery("SELECT * FROM document WHERE (Numdoc = '" + numDocument + "')");
			if(!tableResultat.next()){
				System.out.println("The request is empty");
				return null;
			}else{
				System.out.println("There is a result");
				switch(tableResultat.getString("Typedoc")){
					case "1":
						return new Book(tableResultat.getString("Name"));
						break;
					case "2":
						return new DVD(tableResultat.getString("Name"));
						break;
					case "3":
						return new CD(tableResultat.getString("Name"));
							break;
					default:
					    throw new DatabaseProblemException();
					}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (DatabaseProblemException){
			return null;
		}
	}


	public void ajoutDocument(int type, Object... args) {
		// args[0] -> le titre
		// args [1] --> l'auteur
		// etc... variable suivant le type de document
	}

}
