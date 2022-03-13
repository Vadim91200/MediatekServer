package JavaCode.TypeDocument;

import mediatek2022.Utilisateur;

public class DVD implements mediatek2022.Document{
    private String Dname;
    private boolean available;
    private Utilisateur proprietaire;
    public DVD(String name){
        this.Dname = name;
        this.available = true;
    }

    public boolean disponible() {
        return this.available;
    }

    public void emprunt(Utilisateur u) throws Exception {
        this.proprietaire = u;
        this.available = false;
        
    }

    public void retour() {
        this.proprietaire = null;
        this.available = true;
        
    }
}
