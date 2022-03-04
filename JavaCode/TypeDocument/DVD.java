package JavaCode.TypeDocument;

import mediatek2022.Utilisateur;

public class DVD implements mediatek2022.Document{
    private String Dname;
    private boolean available;
    private Utilisateur propriétaire;
    public DVD(String name){
        this.Dname = name;
        this.available = true;
    }

    @Override
    public boolean disponible() {
        return this.available;
    }

    @Override
    public void emprunt(Utilisateur u) throws Exception {
        this.propriétaire = u;
        this.available = false;
        
    }

    @Override
    public void retour() {
        this.propriétaire = null;
        this.available = true;
        
    }
}
