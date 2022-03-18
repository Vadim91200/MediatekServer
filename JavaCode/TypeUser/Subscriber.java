package JavaCode.TypeUser;
import java.util.ArrayList;
public class Subscriber extends aUser{
    public Subscriber(String name, ArrayList<String> l){
        super(name, l);
    }
    @Override
    public boolean isBibliothecaire() {
        return false;
    }
}
