package JavaCode.TypeDocument;


import mediatek2022.Utilisateur;
public abstract class aDoc implements mediatek2022.Document {
    protected String Dname;
    protected boolean available;
    protected Utilisateur Owner;

    public boolean disponible() {
        return this.available;
    }
    
    public void emprunt(Utilisateur u) throws Exception {
        this.Owner = u;
        u.adddocument(this);
        this.available = false;
        
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
