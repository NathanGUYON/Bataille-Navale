package controleurs;

import vue.FenetreBatailleNaval;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PositionControleurDroite implements ActionListener { //Sert à positionner un bateau vers la droite

    private FenetreBatailleNaval fenetre;
    public PositionControleurDroite(FenetreBatailleNaval f){
        fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setHorizontalDroite();
    }

}
