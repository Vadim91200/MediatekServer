package persistance;

public class Abonné implements mediatek2022.Utilisateur{
    private String name;
    public Abonné(String name){
        this.name() = name;
    }
    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean isBibliothecaire() {
        return false;
    }

    @Override
    public Object[] data() {
        return new Object[0];
    }
}
