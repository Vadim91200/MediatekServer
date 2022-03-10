package JavaCode.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JavaCode.PersonalException.*;
import JavaCode.TypeDocument.*;
import JavaCode.TypeUser.*;
import mediatek2022.*;
// classe mono-instance  dont l'unique instance est connue de la mï¿½diatheque
// via une auto-dï¿½claration dans son bloc static



public class MediathequeData implements PersistentMediatheque {
	private static Connection bdd;
	// Jean-Fran�ois Brette 01/01/2018
		static {
			Mediatheque.getInstance().setData(new MediathequeData());
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			bdd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/projet", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

		private MediathequeData() {
		}

		// renvoie la liste de tous les documents disponibles de la m�diath�que

		public List<Document> tousLesDocumentsDisponibles() {
			try {
				Statement requeteStatique = bdd.createStatement();
				ResultSet tableResultat = requeteStatique.executeQuery("SELECT * FROM document");
				ArrayList<Document> Doclist = new ArrayList<Document>();
				if(!tableResultat.next()){
					System.out.println("The request is empty");
					return null;
				}else do{
					System.out.println("There is a result");
						switch(tableResultat.getString("Typedoc")){
							case "1":
								Document D = new Book(tableResultat.getString("Namedoc"));
								Doclist.add(D);
								break;
							case "2":
								Document g = new DVD(tableResultat.getString("Namedoc"));
								Doclist.add(g);
								break;
							case "3":
								Document l = new CD(tableResultat.getString("Namedoc"));
								Doclist.add(l);
								break;
							default:
								throw new DatabaseProblemException("The type of the document is unknown");
						}
					
				}while (tableResultat.next());
				return Doclist;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (DatabaseProblemException h){
				System.out.println(h);
				return null;
			}
		}

		// va r�cup�rer le User dans la BD et le renvoie
		// si pas trouv�, renvoie null

		public Utilisateur getUser(String login, String password) {
			try {
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
						    throw new DatabaseProblemException("The type of the user is unknown");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (DatabaseProblemException h){
				System.out.println(h);
				return null;
			}
		}

		// va r�cup�rer le document de num�ro numDocument dans la BD
		// et le renvoie
		// si pas trouv�, renvoie null

		public Document getDocument(int numDocument) {
			try {
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
						case "2":
							return new DVD(tableResultat.getString("Name"));
						case "3":
							return new CD(tableResultat.getString("Name"));
						default:
						    throw new DatabaseProblemException("The type of the document is unknown");
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (DatabaseProblemException h){
				System.out.println(h);
				return null;
			}
		}


		public void ajoutDocument(int type, Object... args) {
			// args[0] -> le titre
			// args [1] --> l'auteur
			// etc... variable suivant le type de document
			System.out.println("Je vais inserer ma vie");
			try {
				Statement requeteStatique = bdd.createStatement();
				ResultSet tableResultat = requeteStatique.executeQuery("INSERT INTO document (Namedoc , Typedoc) values('" + (String) args[0] + "','" + type + "')"); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
