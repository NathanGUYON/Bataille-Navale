package controleurs;

import vue.FenetreBatailleNaval;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PositionControleurBas implements ActionListener { //Sert à positionner un bateau vers le bas

    private FenetreBatailleNaval fenetre;
    public PositionControleurBas(FenetreBatailleNaval f){
        fenetre = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setVerticalBas();
    }

}
