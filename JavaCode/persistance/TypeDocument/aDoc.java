package JavaCode.persistance.TypeDocument;
import java.sql.*;

import JavaCode.persistance.PersonalException.DatabaseProblemException;
import JavaCode.persistance.PrepareDatabase;
import mediatek2022.Utilisateur;
public abstract class aDoc implements mediatek2022.Document {
    protected String Dname;
    protected boolean available;
    protected Utilisateur Owner;
    private static PrepareDatabase bdd;

    public aDoc(String name){
        this.Dname = name;
        this.available = true;
        this.bdd = new PrepareDatabase();
    }

    public boolean disponible() {
        return this.available;
    }
    
    public void emprunt(Utilisateur u) throws Exception {
        this.Owner = u;
        this.available = false;
        
        try {
            ResultSet Utilisateur =  this.bdd.getselect("user", "Name = '"+ u.name() + "'");
            Utilisateur.next();
            ResultSet Document = this.bdd.getselect("document", "Namedoc = '" + this.Dname + "'");
            Document.next();
            ResultSet tableResult = this.bdd.getUpdate("document", "Ownerdoc = '" + Utilisateur.getString("Matricule") + "'", "Numdoc = '" + Document.getString("numdoc") + "'"); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retour() {
        this.Owner = null;
        this.available = true;
        try {
            ResultSet Document = this.bdd.getselect("document", "Namedoc = '" + this.Dname + "'");
            Document.next();
            ResultSet tableResult = this.bdd.getUpdate("document", "Ownerdoc = NULL", "Numdoc = '" + Document.getString("numdoc") + "'"); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    @Override
    public String toString() {
        return Dname;
    }
}
