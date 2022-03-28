package JavaCode.persistance.TypeUser;

import java.util.ArrayList;
import mediatek2022.Document;
public abstract class aUser implements mediatek2022.Utilisateur{
    protected String Uname;
    protected Object[] thedata;

    public aUser (String name, ArrayList<Document> l){
        this.Uname = name;
        this.thedata = new Object[4];
        this.thedata[0] = new ArrayList<Document>();
        this.thedata[0] = l;
    }
    public String name() {
        return this.Uname;
    }

    public abstract boolean isBibliothecaire();

    public Object[] data() {
        return this.thedata;
    }
}
