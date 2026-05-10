package app;

public class Fuvar {
    private String rsz;
    private int ido;
    private double ar;
    private String fizetesMod;

    public Fuvar(String rsz, int ido, double ar, String fizetesMod) {
        this.rsz = rsz;
        this.ido = ido;
        this.ar = ar;
        this.fizetesMod = fizetesMod;
    }

    public String getRsz() {
        return rsz;
    }

    public int getIdo() {
        return ido;
    }

    public double getAr() {
        return ar;
    }

    public String getFizetesMod() {
        return fizetesMod;
    }
    
    
}
