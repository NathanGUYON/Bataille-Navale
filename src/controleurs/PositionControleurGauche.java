package controleurs;

import vue.FenetreBatailleNaval;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PositionControleurGauche implements ActionListener { //Sert à positionner un bateau vers la gauche

    private FenetreBatailleNaval fenetre;
    public PositionControleurGauche(FenetreBatailleNaval f){
        fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setHorizontalGauche();
    }

}
