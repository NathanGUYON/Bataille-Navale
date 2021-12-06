package controleurs;

import vue.PanelSecondMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuitterJeuMenu2 implements ActionListener { //Permet de pouvoir quitter le jeu en étant au second menu
    private PanelSecondMenu fenetre;
    public QuitterJeuMenu2(PanelSecondMenu f){
        fenetre = f;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setVisible(false);
    }

}
