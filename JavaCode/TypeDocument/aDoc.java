package JavaCode.TypeDocument;
import java.sql.*;
import mediatek2022.Utilisateur;
public abstract class aDoc implements mediatek2022.Document {
    protected String Dname;
    protected boolean available;
    protected Utilisateur Owner;
    private static Connection bdd;

    public aDoc(String name){
        this.Dname = name;
        this.available = true;
    }

    public boolean disponible() {
        return this.available;
    }
    
    public void emprunt(Utilisateur u) throws Exception {
        this.Owner = u;
        this.available = false;
        bdd = DriverManager.getConnection("jdbc:mariadb://localhost:3306/projet", "root", "root");
        try {
            Statement requeteStatique = bdd.createStatement();
            System.out.println(u.name());
            System.out.println(this.Dname);
            ResultSet Utilisateur = requeteStatique.executeQuery("SELECT Matricule FROM user WHERE Name = '"+ u.name() + "'");
            Utilisateur.next();
            ResultSet Document = requeteStatique.executeQuery("SELECT * FROM document where Namedoc = '" + this.Dname + "'");
            Document.next();
            ResultSet tableResult = requeteStatique.executeQuery("UPDATE document SET Ownerdoc = '" + Utilisateur.getString("Matricule") + "' WHERE Numdoc = '" + Document.getString("numdoc") + "'"); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retour() {
        this.Owner = null;
        this.available = true;
        
    }
    @Override
    public String toString() {
        return Dname;
    }
}
