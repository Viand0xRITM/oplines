package op.modele;

public class Produit {
    int id;
    int tempsProduction;

    public Produit(int id, int tempsProduction)
    {
        this.id = id;
        this.tempsProduction = tempsProduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempsProduction() {
        return tempsProduction;
    }

    public void setTempsProduction(int tempsProduction) {
        this.tempsProduction = tempsProduction;
    }
    
}
