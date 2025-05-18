import java.util.Random;

public class Des {
    int nb_jet;
    int nb_face;

    public Des(int jet, int face) {
        this.nb_jet = jet;
        this.nb_face = face;
    }

    public int lancer() {
        int acc = 0;
        for (int i = 0; i < nb_jet + 1; i++) {
            Random random = new Random();
            acc += random.nextInt(nb_face) + 1;
        }
        return acc;
    }
}
