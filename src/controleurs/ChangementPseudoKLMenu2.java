package controleurs;


import modele.PlayerPseudo;
import vue.FenetreBatailleNaval;
import vue.PanelMenuPrincipale;
import vue.PanelSecondMenu;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChangementPseudoKLMenu2 implements KeyListener { //Ce contrôleur change le pseudonyme du joueur par la String présente dans la zone de texte correspondante à l'appui sur la touche Entrée

    private FenetreBatailleNaval fenetre;
    private PlayerPseudo player;
    private PanelSecondMenu menuSecondaire;

    public ChangementPseudoKLMenu2(PlayerPseudo p, FenetreBatailleNaval f, PanelSecondMenu pm) {
        player = p;
        fenetre = f;
        menuSecondaire = pm;
    }

    private PanelSecondMenu menu;



    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) { //détecte l'appui sur une touche du clavier
        if (e.getKeyCode() == KeyEvent.VK_ENTER) { //détecte l'appui sur la touche Entrée
            if (menuSecondaire.getIdjoueurField().length() <= 24) { //Vérifie si la longueur du pseudo est inférieure à 24 caractères
                //on affiche en haut le nom rentré
                menuSecondaire.setIdjoueur(menuSecondaire.getIdjoueurField());
                fenetre.setIdjoueur(menuSecondaire.getIdjoueurField());
                //on réinitialise la valeur de champs du Field
                menuSecondaire.setSetNomPlayerField("");
                //On ajoute ce pseudo au joueur qui l'a rentrer
                player.setPseudo(menuSecondaire.getIdjoueurField());
                //Vérification
                System.out.println("Pseudo Accepté");
            } else {
                System.out.println("Pseudo trop long");
                menuSecondaire.erreurMessage("Pseudo Trop long");
                menuSecondaire.setSetNomPlayerField("");
                if (menu.getIdjoueurField().length() <= 24) { //Vérifie si la longueur du pseudo est inférieure à 24 caractères
                    //on affiche en haut le nom rentré
                    menu.setIdjoueur(menu.getIdjoueurField());
                    //on réinitialise la valeur de champs du Field
                    menu.setSetNomPlayerField("");
                    //On ajoute ce pseudo au joueur qui l'a rentrer
                    player.setPseudo(menu.getIdjoueurField());
                    //Vérification
                    System.out.println("Tout s'est bien passé");
                } else {
                    System.out.println("Pseudo trop long");
                    menu.erreurMessage("Pseudo Trop long");
                    menu.setSetNomPlayerField("");
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
