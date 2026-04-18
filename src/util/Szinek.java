package util;

public enum Szinek {
    // Itt rendeljük hozzá a kódokat az enum értékekhez
    PIROS("\u001B[31m"),
    SARGA("\u001B[33"),
    KEK("\u001B[34m"),
    ZÖLD("\u001B[32m"),
    RESET("\u001B[0m");

    private final String kod;

    // Konstruktor
    Szinek(String kod) {
        this.kod = kod;
    }

    // Getter, hogy elérjük a kódot
    public String getKod() {
        return kod;
    }
}