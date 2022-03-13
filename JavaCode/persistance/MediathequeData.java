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
				ResultSet tableResult = requeteStatique.executeQuery("SELECT * FROM document");
				ArrayList<Document> Doclist = new ArrayList<Document>();
				if(!tableResult.next()){
					System.out.println("The request is empty");
					return null;
				}else do{
					if(tableResult.getString("Ownerdoc")==null){
						System.out.println("There is a result");
						switch(tableResult.getString("Typedoc")){
							case "1":
								Document D = new Book(tableResult.getString("Namedoc"));
								Doclist.add(D);
								break;
							case "2":
								Document g = new DVD(tableResult.getString("Namedoc"));
								Doclist.add(g);
								break;
							case "3":
								Document l = new CD(tableResult.getString("Namedoc"));
								Doclist.add(l);
								break;
							default:
								throw new DatabaseProblemException("The type of the document is unknown");
						}
					} else{
						continue;
					}
				}while (tableResult.next());
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
				ResultSet tableResult = requeteStatique.executeQuery("SELECT * FROM user WHERE (Login = '" + login + "') AND (Password = '" + password + "')");
				if(!tableResult.next()){
					System.out.println("The request is empty");
					return null;
				}else{
					System.out.println("There is a result");
					switch(tableResult.getString("Typeuser")){
						case "subscriber":
							return new Subscriber(tableResult.getString("Name"));
						case "librarian":
							return new librarian(tableResult.getString("Name"));
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
				ResultSet tableResult = requeteStatique.executeQuery("SELECT * FROM document WHERE (Numdoc = '" + numDocument + "')");
				if(!tableResult.next()){
					System.out.println("The request is empty");
					return null;
				}else{
					System.out.println("There is a result");
					switch(tableResult.getString("Typedoc")){
						case "1":
							return new Book(tableResult.getString("Name"));
						case "2":
							return new DVD(tableResult.getString("Name"));
						case "3":
							return new CD(tableResult.getString("Name"));
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
			try {
				Statement requeteStatique = bdd.createStatement();
				ResultSet tableResult = requeteStatique.executeQuery("INSERT INTO document (Namedoc , Typedoc) values('" + (String) args[0] + "','" + type + "')"); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
