package modell;

import java.util.Objects;
import util.Szinek;

public class Csiga {
    // --- Konstansok az ábrázoláshoz ---
    private static final char UT_SZIMPLA = '-';
    private static final char UT_DUPLA = '=';
    private static final String ABRA_CSIGA_EMOJI = "\ud83d\udc0c";
    private static final String ABRA_KUKAC_JEL = "@";

    // --- Mezők ---
    private Szinek szin;
    private String szinKod;
    private String megtettUt;
    private boolean gyorsito;

    // --- Konstruktorok ---
    public Csiga() {
        this(Szinek.PIROS, "", false);
    }

    public Csiga(Szinek szin) {
        this(szin, "", false);
    }

    public Csiga(Szinek szin, String megtettUt, boolean gyorsito) {
        this.szin = szin;
        szinKod = szin.getKod();
        this.megtettUt = megtettUt;
        this.gyorsito = gyorsito;
    }

    // --- Getterek és Setterek ---
    public static char getUTJEL_1() { return UT_SZIMPLA; }
    public static char getUTJEL_2() { return UT_DUPLA; }
    public static String getABRA_1() { return ABRA_CSIGA_EMOJI; }
    public static String getABRA_2() { return ABRA_KUKAC_JEL; }

    public Szinek getSzin() {
        return szin;
    }

    /**
     * Visszaadja az aktuális színhez tartozó ANSI kódot az enumból.
     */
    public String getSzinKod() {
        return szin.getKod();
    }

    public String getMegtettUt() {
        return megtettUt;
    }

    public boolean isGyorsito() {
        return gyorsito;
    }

    public void setGyorsito(boolean gyorsito) {
        this.gyorsito = gyorsito;
    }

    // --- Logika ---
    public void megy() {
        int tav = (int) (Math.random() * 4);
        
        // Gyorsító logika
        tav = gyorsito ? tav * 2 : tav;
        if (gyorsito && tav == 0) {
            tav = 1;
        }
        
        char jel = gyorsito ? UT_DUPLA : UT_SZIMPLA;
        
        for (int i = 0; i < tav; i++) {
            megtettUt += jel;
        }
    }

    // --- Standard metódusok ---
    @Override
    public String toString() {
        // A kiírásnál használjuk az enumból lekért színkódot és a RESET-et
        return szin.getKod() + 
               "Csiga{szin=" + szin + ", megtettUt=" + megtettUt + ", gyorsito=" + gyorsito + "}" + 
               Szinek.RESET.getKod();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.szin);
        hash = 97 * hash + Objects.hashCode(this.megtettUt);
        hash = 97 * hash + (this.gyorsito ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        final Csiga other = (Csiga) obj;
        if (this.gyorsito != other.gyorsito) return false;
        if (this.szin != other.szin) return false;
        return Objects.equals(this.megtettUt, other.megtettUt);
    }
}