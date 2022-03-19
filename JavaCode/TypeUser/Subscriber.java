package JavaCode.TypeUser;
import java.util.ArrayList;
import mediatek2022.Document;
public class Subscriber extends aUser{
    public Subscriber(String name, ArrayList<Document> l){
        super(name, l);
    }
    @Override
    public boolean isBibliothecaire() {
        return false;
    }
}
