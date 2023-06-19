public class Piatto {

    public Piatto(String ingredienti, double prezzo, String chef) {
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
        this.chef = chef;
    }

    public String getIngredienti() {
        return this.ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getChef() {
        return this.chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    private String ingredienti;
    private double prezzo;
    private String chef;

    @Override
    public String toString() {

        return "Piatto: " + ingredienti + ", Prezzo: " + prezzo + ", Chef: " + chef;
    }

}
