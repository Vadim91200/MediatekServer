package JavaCode.TypeUser;
import java.util.ArrayList;

import JavaCode.persistance.MediathequeData;
public abstract class aUser implements mediatek2022.Utilisateur{
    protected String Uname;
    protected Object[] Datalist; 
    public aUser(){
        Datalist = new Object[250];
    }
    public String name() {
        return this.Uname;
    }

    public abstract boolean isBibliothecaire();

    public Object[] data() {
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
        
    }
}
