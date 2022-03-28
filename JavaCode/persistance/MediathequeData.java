package JavaCode.persistance;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.lang.StringBuilder;
import JavaCode.persistance.PersonalException.*;
import JavaCode.persistance.TypeDocument.*;
import JavaCode.persistance.TypeUser.*;
import mediatek2022.*;
// classe mono-instance  dont l'unique instance est connue de la mï¿½diatheque
// via une auto-dï¿½claration dans son bloc static



public class MediathequeData implements PersistentMediatheque {
	private static PrepareDatabase bdd;
	// Jean-Fran�ois Brette 01/01/2018
		static {
			Mediatheque.getInstance().setData(new MediathequeData());
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			bdd = new PrepareDatabase();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

		private MediathequeData() {
		}

		// renvoie la liste de tous les documents disponibles de la m�diath�que

		public synchronized List<Document> tousLesDocumentsDisponibles() {
			try {
				ResultSet ResultDocument = bdd.getselect("Document", "Ownerdoc IS NULL");
				ArrayList<Document> Doclist = new ArrayList<Document>();
				int i=0;
				if(!ResultDocument.next()){
					System.out.println("Request empty : No such document(s)");
					return null;
				}else do{
						switch(ResultDocument.getString("Typedoc")){
							case "1":
								Document D = new Book(ResultDocument.getString("Namedoc"));
								Doclist.add(D);
								break;
							case "2":
								Document g = new DVD(ResultDocument.getString("Namedoc"));
								Doclist.add(g);
								break;
							case "3":
								Document l = new CD(ResultDocument.getString("Namedoc"));
								Doclist.add(l);
								break;
							default:
								throw new DatabaseProblemException("The type of the document is unknown");
						}
						i++;
				}while (ResultDocument.next());
				System.out.println("There is a result : " + i + " document(s) found");
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

		public synchronized Utilisateur getUser(String login, String password) {
			try {
				ResultSet ResultUser = bdd.getselect("user", "(Login = '" + login + "') AND (Password = '" + password + "')");
				if(!ResultUser.next()){
					System.out.println("Request empty : No such user");
					return null;
				}else{
					System.out.println("There is a result : user found");
					ResultSet ResultOwner = bdd.getselect("document", "Ownerdoc = '" + ResultUser.getString("Matricule") + "'");
					ArrayList<Document> l = new ArrayList<Document>();
					if(ResultOwner.next()){
						do{
							l.add(getDocument(Integer.parseInt(ResultOwner.getString("Numdoc"))));
							
						}while (ResultOwner.next());
					}
					switch(ResultUser.getString("Typeuser")){
						case "subscriber":
							return new Subscriber(ResultUser.getString("Name"), l);
						case "librarian":
							return new librarian(ResultUser.getString("Name"), l);
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

		public synchronized Document getDocument(int numDocument) {
			try {
				ResultSet ResultDocument = bdd.getselect("document", "(Numdoc = '" + numDocument + "')");
				if(!ResultDocument.next()){
					System.out.println("Request empty : No such document");
					return null;
				}else{
					System.out.println("There is a result : document found");
					switch(ResultDocument.getString("Typedoc")){
						case "1":
							return new Book(ResultDocument.getString("Namedoc"));
						case "2":
							return new DVD(ResultDocument.getString("Namedoc"));
						case "3":
							return new CD(ResultDocument.getString("Namedoc"));
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


		public synchronized void ajoutDocument(int type, Object... args) {
			// args[0] -> le titre
			// args [1] --> l'auteur
			// etc... variable suivant le type de document
				ResultSet tableResult = bdd.getInsert("document (Namedoc , Typedoc)", "'" + (String) args[0] + "','" + type + "'"); 
		}
	}
