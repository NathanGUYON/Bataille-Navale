package modele;

import info1.network.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerPseudo extends Player { //Sert à établir le pseudo et à le mettre dans les différentes vues
    public PlayerPseudo(String name) {
        super(name);
    }

    private String pseudo;
    private List<String> pseudos = new ArrayList<>();

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
        pseudos.add(pseudo);
    }
}
