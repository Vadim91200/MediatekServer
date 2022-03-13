package JavaCode.TypeUser;

public class Subscriber extends aUser{
    public Subscriber(String name){
        this.Uname = name;
    }
    @Override
    public boolean isBibliothecaire() {
        return false;
    }
}
