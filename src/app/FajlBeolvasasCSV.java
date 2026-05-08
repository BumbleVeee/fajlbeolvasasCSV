package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FajlBeolvasasCSV {

    private static List<Fuvar> fuvar = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        
        Path path = Path.of("adatok.csv");
        String egySor = Files.readString(path);
        System.out.println("egySor= " + egySor);
        
        List<String> sorok = Files.readAllLines(path);
        for (String sor : sorok) {
            //System.out.println("sor= " + sor);
            String[] s = sor.split(";");
            String rsz = s[0];
            int ido = Integer.parseInt(s[1]);
            double osszeg = Integer.parseInt(s[2]);
            String fizetesMod = s[3];
            Fuvar auto = new Fuvar(rsz, ido, osszeg, fizetesMod);
            fuvar.add(auto);
        }
        feladatok();
    }

    private static void feladatok() {
        System.out.println("Összes fuvar értéke: ");
        int i = 0;
        final int N = fuvar.size();
        double osszeg = 0.0;
        while (i < N){
            osszeg += fuvar.size(i).getOsszeg();
            i++;
        }
        
    }
}
