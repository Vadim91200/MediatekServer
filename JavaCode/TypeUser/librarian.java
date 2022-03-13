package JavaCode.TypeUser;

public class librarian extends aUser{
    public librarian (String name){
        this.Uname = name;
    }
    @Override
    public boolean isBibliothecaire() {
        return true;
    }
}
