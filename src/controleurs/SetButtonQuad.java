package controleurs;


import vue.FenetreBatailleNaval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SetButtonQuad implements MouseListener {

    private FenetreBatailleNaval fenetre;


    public SetButtonQuad(FenetreBatailleNaval f){
        fenetre = f;
    }

    @Override
    public void mouseClicked(MouseEvent e) { //Ce contrôleur fait le lien entre le bouton de la grille cliqué, et désactive celui-ci
        if (e.getClickCount() == 1) {
            if (fenetre.isEnCours()) {
                JButton res = (JButton) e.getSource();
                //fenetre.Avalide().setBackground(Color.LIGHT_GRAY);
                if (fenetre.Avalide() == res) {
                    fenetre.activerBoutonQuadrillage(false, res);
                    //fenetre.Avalide().setBackground(Color.LIGHT_GRAY);
                } else {
                    fenetre.setAvalide(res);
                    //fenetre.Avalide().setBackground(Color.WHITE);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
