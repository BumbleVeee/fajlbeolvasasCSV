package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            double osszeg = Double.parseDouble(s[2]); //double-nál parseDouble!
            String fizetesMod = s[3];
            Fuvar auto = new Fuvar(rsz, ido, osszeg, fizetesMod);
            fuvar.add(auto);
        }
        feladatok(); //összes feladat egyben!
    }

    private static void feladatok() {
        //1. feladat
        System.out.printf("\nÖsszes fuvar értéke: ");
        int i = 0;
        final int N = fuvar.size();
        double osszeg = 0.0;

        while (i < N) {
            osszeg += fuvar.get(i).getAr();
            i++;
        }
        System.out.println(osszeg);
        
        //2. feladat
        System.out.printf("\nLegdrágább fuvar rendszáma: ");
        
        i = 0;
        double maxOsszeg = fuvar.get(0).getAr();
        String rendszam = fuvar.get(0).getRsz();

        while (i < N) {

            if (fuvar.get(i).getAr() > maxOsszeg) {

            maxOsszeg = fuvar.get(i).getAr();
            rendszam = fuvar.get(i).getRsz();
            }

            i++;
        }

        System.out.println(rendszam);
        
        //3. feladat
        System.out.printf("\nLegolcsóbb fuvar rendszáma: ");
        
        i = 0;
        double minAr = fuvar.get(0).getAr();
        String rendszam2 = fuvar.get(0).getRsz(); //új változó, hogy kevésbé legyen zavaros (2)
        
        while (i < N) {

            if (fuvar.get(i).getAr() < minAr) {

                minAr = fuvar.get(i).getAr();
                rendszam2 = fuvar.get(i).getRsz();
            }

            i++;
        }
        System.out.println(rendszam2);
        
        //4. feladat
        System.out.printf("\nKártyás fizetések száma: ");
        
        i = 0;

        int db = 0;

        while (i < N) {

            if (fuvar.get(i).getFizetesMod().equals("kártya")) {
                db++;
            }

            i++;
        }

        System.out.println(db);
        
        //5. feladat
        System.out.printf("\nMinden fizetési mód meghatározott: ");
        
        i = 0;
        db = 0;

        while (i < N) {

            if (!fuvar.get(i).getFizetesMod().equals("-")) { //ha a fizetési mód nem "-"
                db++;
            }

            i++;
        }

        System.out.println(db);
        
        //6. feladat
        System.out.printf("\nHány db autó van a rendszerben?: "); //ismétlés nélkül!
        
        i = 0;
        
        List<String> egyediRendszamok = new ArrayList<>(); //rendszámok ismétlés nélkül

        while (i < N) {

            String rendszam3 = fuvar.get(i).getRsz(); //új változó, hogy kevésbé legyen zavaros (3)

            if (!egyediRendszamok.contains(rendszam)) { //ha az egyedi rendszámokban nem szerepel az aktuális rednszám
                egyediRendszamok.add(rendszam3);
            }

            i++;
        }

        System.out.println(egyediRendszamok.size());
        
        //7. feladat
        System.out.printf("\nHány féle fizetési mód van?: "); // "-" nem fizetési mód!
        
        i = 0;
        
        List<String> egyediModok = new ArrayList<>(); //fizetési módok ismétlés nélkül

        while (i < N) {

            String mod = fuvar.get(i).getFizetesMod();

            if (!mod.equals("-") && !egyediModok.contains(mod)) { //ha a mód nem "-" és az egyediModok nem tartalmazzák az aktuális módot!
                egyediModok.add(mod);                             //A nem meghatározott fizetés nem fizetési mód!
            }

            i++;
        }

        System.out.println(egyediModok.size());
        
        //8. feladat
        System.out.println("\nMelyik autó mennyi fuvart teljesített?: ");
        
        List<Fuvar> autok = new ArrayList<>();
        
        Map<String, Integer> nm = new HashMap<>();
        
        for(Fuvar fuvar : autok){
            String kulcs = fuvar.getRsz();
            if(nm.containsKey(kulcs)){
                int ertek = nm.get(kulcs);
                nm.put(kulcs, ++ertek);
            }else{
                nm.put(kulcs, 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry : nm.entrySet()) {
            String kulcs = entry.getKey();
            Integer ertek = entry.getValue();
            
            System.out.printf("[%s] = %d\n", kulcs, ertek);
        }
    }
}
