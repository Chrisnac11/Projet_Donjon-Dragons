import java.util.Scanner;

public class Caractéristiques {
    private int m_PV;
    private int m_force = 3;
    private int m_dexterite = 3;
    private int m_vitesse = 3;
    private int m_initiative = 3;

    public Caractéristiques() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Voici tes stats pour l'instant :");
        this.AfficherStat();
        boolean[] statchoisie = new boolean[4];

        for(int i=0; i< 4; i++) {
            statchoisie[i] = false;
            Des des = new Des(4, 4);
            int a = des.lancer();
            System.out.println("lancé numéro " + (i+1));
            System.out.println("résultat du lancer :" + a);

            boolean cond = false;
            while (!cond) {
                System.out.println("Tape le numéro de la stat que tu veux :");
                System.out.println("1. force\n2. dexterite\n3. vitesse\n4. initiative");

                String choix = scanner.nextLine().trim();
                if(choix.equals("1")) {
                    if (statchoisie[0]) {
                        System.out.println("Tu ne peux pas choisir deux fois cette statistique");
                        continue;
                    }
                    else {
                        this.m_force += a;
                        statchoisie[0] = true;
                        cond = true;
                        break;
                    }
                }
                if(choix.equals("2")) {
                    if (statchoisie[1]) {
                        System.out.println("Tu ne peux pas choisir deux fois cette statistique");
                        continue;
                    }
                    else {
                        this.m_dexterite += a;
                        statchoisie[1] = true;
                        cond = true;
                        break;
                    }
                }
                if(choix.equals("3")) {
                    if (statchoisie[2]) {
                        System.out.println("Tu ne peux pas choisir deux fois cette statistique");
                        continue;
                    }
                    else {
                        this.m_vitesse += a;
                        statchoisie[2] = true;
                        cond = true;
                        break;
                    }
                }
                if(choix.equals("4")) {
                    if (statchoisie[3]) {
                        System.out.println("Tu ne peux pas choisir deux fois cette statistique");
                        continue;
                    }
                    else {
                        this.m_initiative += a;
                        statchoisie[3] = true;
                        cond = true;
                        break;
                    }
                }
                else {
                    System.out.println("il faut tapper 1, 2, 3 ou 4.\nRéessaye ^^");
                }
            }
            System.out.println("Voici tes stats dorénavant");
            this.AfficherStat();
        }
        scanner.close();
    }

    public int GetPV() {
        return this.m_PV;
    }

    public int[] GetStatperso() {
        int[] tab = new int[4];
        tab[0]= this.m_force;
        tab[1]= this.m_dexterite;
        tab[2]= this.m_vitesse;
        tab[3]= this.m_initiative;
        return tab;
    }

    public void AfficherStat() {
        int[] stat = this.GetStatperso();
        for(int i = 0; i < 4; i++) {
            if(i == 0) {
                System.out.print("votre force est de :");
            }
            if(i == 1) {
                System.out.print("votre dextérité est de :");
            }
            if(i == 2) {
                System.out.print("votre vitesse est de :");
            }
            if(i == 3) {
                System.out.print("votre initiative est de :");
            }
            System.out.println("\t" + stat[i]);
        }
        System.out.println("\n");
    }



}
