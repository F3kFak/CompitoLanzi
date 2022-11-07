package it.fi.itismeucci.lanzi;

public class Biglietto {
    public int ID;
    public String numeroB;


    public Biglietto() {
    }

    public Biglietto(int ID, String numeroB) {
        this.ID = ID;
        this.numeroB = numeroB;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNumeroB() {
        return this.numeroB;
    }

    public void setNumeroB(String numeroB) {
        this.numeroB = numeroB;
    }

    public Biglietto ID(int ID) {
        setID(ID);
        return this;
    }

    public Biglietto numeroB(String numeroB) {
        setNumeroB(numeroB);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " ID='" + getID() + "'" +
            ", numeroB='" + getNumeroB() + "'" +
            "}";
    }

}
