package JavaCode.TypeUser;

import java.util.ArrayList;
public class librarian extends aUser{
    public librarian (String name, ArrayList<String> l){
        super(name, l);
    }
    @Override
    public boolean isBibliothecaire() {
        return true;
    }
}
