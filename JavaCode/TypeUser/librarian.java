package JavaCode.TypeUser;

public class librarian  implements mediatek2022.Utilisateur{
    private String Uname;
    public librarian (String name){
        this.Uname = name;
    }

    public String name() {
        return this.Uname;
    }


    public boolean isBibliothecaire() {
        return false;
    }


    public Object[] data() {
        return new Object[0];
    }
}
