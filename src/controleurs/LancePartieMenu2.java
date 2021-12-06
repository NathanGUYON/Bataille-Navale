package controleurs;

import vue.FenetreBatailleNaval;
import vue.PanelSecondMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LancePartieMenu2 implements ActionListener { //Permet de passer du second menu à la fenêtre de jeu

    private FenetreBatailleNaval fenetre;
    private PanelSecondMenu menu;
    public LancePartieMenu2(PanelSecondMenu m, FenetreBatailleNaval f){
        fenetre = f;
        menu = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(menu.isAccepte()){
            fenetre.setVisible(true);
            fenetre.setVisibleButton(true);
            menu.setVisible(false);
        }
    }

}
