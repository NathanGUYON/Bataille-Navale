package controleurs;


import modele.PlayerPseudo;
import vue.FenetreBatailleNaval;
import vue.PanelMenuPrincipale;
import vue.PanelSecondMenu;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChangementPseudoKLMenu implements KeyListener { //Ce contrôleur change le pseudonyme du joueur par la String présente dans la zone de texte correspondante à l'appui sur la touche Entrée

    private PanelMenuPrincipale menu;
    private FenetreBatailleNaval fenetre;
    private PlayerPseudo player;
    private PanelSecondMenu menuSecondaire;

    public ChangementPseudoKLMenu(PanelMenuPrincipale m, PlayerPseudo p, FenetreBatailleNaval f, PanelSecondMenu pm){
        menu = m;
        player = p;
        fenetre = f;
        menuSecondaire = pm;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) { //détecte l'appui sur une touche du clavier
        if(e.getKeyCode()==KeyEvent.VK_ENTER){ //détecte l'appui sur la touche Entrée
            if(menu.getIdjoueurField().length() <=24){ //Vérifie si la longueur du pseudo est inférieure à 24 caractères
                //on affiche en haut le nom rentré
                menu.setIdjoueur(menu.getIdjoueurField());
                fenetre.setIdjoueur(menu.getIdjoueurField());
                menuSecondaire.setIdjoueur(menu.getIdjoueurField());
                //on réinitialise la valeur de champs du Field
                menu.setSetNomPlayerField("");
                //On ajoute ce pseudo au joueur qui l'a rentrer
                player.setPseudo(menu.getIdjoueurField());
                //Vérification
                System.out.println("Pseudo Accepté");
            }else{
                System.out.println("Pseudo trop long");
                menu.erreurMessage("Pseudo Trop long");
                menu.setSetNomPlayerField("");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
