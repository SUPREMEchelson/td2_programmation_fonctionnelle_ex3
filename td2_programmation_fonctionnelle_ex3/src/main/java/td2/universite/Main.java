package td2.universite;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;


public class Main {
    public static  final Predicate<Etudiant> toujours = x-> true;
    public static final Set<Matiere> toutesLesMatieresDeLAnnee(Annee a){
        Set<Matiere> rtr = new HashSet<>();
        for (UE ue: a.ues()){
            rtr.addAll(ue.ects().keySet());
        }
        return rtr;
    }
    private static Set<Matiere> toutesLesMatieresDeLetudiant(Annee annee) {
    boolean rtr =false;
    Set<Matiere> toutesLesMatieresDeLetudiant = Main.toutesLesMatieresDeLetudiant(x.annee());
        Matiere[] toutesLesMatiersDeLetudiant;
        for(Matiere m : toutesLesMatiersDeLetudiant).constainsKey(m)){
        rtr = true;
    }
    return rtr;
    }        
            
     

    public static   final Predicate<Etudiant> defaillant = e -> {
        Set<Matiere> toutesLesMatieresDeLetudiant = Main.toutesLesMatieresDeLetudiant(e.annee());
        for (Matiere  m: toutesLesMatieresDeLetudiant){
            // m n'est pas une cles dans la map  de notes
            if(!e.notes().containsKey(m)){
                return true;
            }

        }
        return false;
    }


    public static void afficheSi2(String entete, Predicate<Etudiant> condition, Annee annee) {
        for (Etudiant e : annee.etudiants()) {
            if (condition.test(e)) {
                System.out.println(e);
            }

        }
    }



    public static void main(String[] argv) {
        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");
        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
        Matiere m3 = new Matiere("MAT3");
        UE ue2 = new UE("UE2", Map.of(m3, 1));
        Annee a1 = new Annee(Set.of(ue1, ue2));
        Etudiant e1 = new Etudiant("39001", "Alice", "Merveille", a1);
        e1.noter(m1, 12.0);
        e1.noter(m2, 14.0);
        e1.noter(m3, 10.0);
        System.out.println(e1);
        Etudiant e2 = new Etudiant("39002", "Bob", "Eponge", a1);
        e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1);
        e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);

        afficheSi2("tous les etudiants",x->true,a1);
        afficheSi2("Etudiant defaillaint",aDef,a1);


    }
}
