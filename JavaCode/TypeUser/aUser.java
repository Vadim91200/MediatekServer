package JavaCode.TypeUser;
<<<<<<< HEAD

import java.util.ArrayList;
public abstract class aUser implements mediatek2022.Utilisateur{
    protected String Uname;
    protected Object[] thedata;

    public aUser (String name, ArrayList<String> l){
        this.Uname = name;
        this.thedata = new Object[4];
        this.thedata[0] = new ArrayList<String>();
        this.thedata[0] = l;
    }
    public String name() {
        return this.Uname;
    }

    public abstract boolean isBibliothecaire();

    public Object[] data() {
<<<<<<< HEAD
        return this.thedata;
=======
        return this.Datalist;
    }
    public void adddocument(mediatek2022.Document d){
        int i = 0;
        while(true){
            if (this.Datalist[i] != null){
                i++;
                continue;
            }else {
                this.Datalist[i] = d;
                i++;
            }
        }
        
>>>>>>> e84c438854ba892fac7785f97dfd505aaea30a11
    }
}
