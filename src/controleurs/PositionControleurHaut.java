package controleurs;

import vue.FenetreBatailleNaval;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PositionControleurHaut implements ActionListener { //Sert à positionner un bateau vers le haut

    private FenetreBatailleNaval fenetre;
    public PositionControleurHaut(FenetreBatailleNaval f){
        fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setVerticalHaut();
    }

}
