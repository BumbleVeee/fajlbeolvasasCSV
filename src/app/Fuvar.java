package app;

public class Fuvar {
    private String rsz;
    private int ido;
    private double osszeg;
    private String fizetesMod;

    public Fuvar(String rsz, int ido, double osszeg, String fizetesMod) {
        this.rsz = rsz;
        this.ido = ido;
        this.osszeg = osszeg;
        this.fizetesMod = fizetesMod;
    }

    public String getRsz() {
        return rsz;
    }

    public int getIdo() {
        return ido;
    }

    public double getOsszeg() {
        return osszeg;
    }

    public String getFizetesMod() {
        return fizetesMod;
    }
    
    
}
