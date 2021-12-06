package controleurs;

import vue.FenetreBatailleNaval;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuitterJeu implements ActionListener { //Permet de pouvoir quitter le jeu en étant sur la fenêtre de jeu ou de création de la flotte
    private FenetreBatailleNaval fenetre;
    public QuitterJeu(FenetreBatailleNaval f){
        fenetre = f;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setVisible(false);
    }

}
