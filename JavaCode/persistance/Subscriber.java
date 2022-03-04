package persistance;

public class Subscriber implements mediatek2022.Utilisateur{
    private String Uname;
    public Subscriber(String name){
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
