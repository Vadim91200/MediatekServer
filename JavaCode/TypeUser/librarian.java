package JavaCode.TypeUser;
import mediatek2022.Document;
import java.util.ArrayList;
public class librarian extends aUser{
    public librarian (String name, ArrayList<Document> l){
        super(name, l);
    }
    @Override
    public boolean isBibliothecaire() {
        return true;
    }
}
