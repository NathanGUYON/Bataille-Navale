package controleurs;

import vue.PanelMenuPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuitterJeuMenu1 implements ActionListener { //Permet de pouvoir quitter le jeu en étant au premier menu
    private PanelMenuPrincipale fenetre;
    public QuitterJeuMenu1(PanelMenuPrincipale f){
        fenetre = f;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setVisible(false);
    }

}
