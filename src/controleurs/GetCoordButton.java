package controleurs;


import vue.FenetreBatailleNaval;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GetCoordButton implements MouseListener {

    private FenetreBatailleNaval fenetre;


    public GetCoordButton(FenetreBatailleNaval f){
        fenetre = f;
    }

    @Override
    public void mouseClicked(MouseEvent e) { //Ce contrôleur affiche les coordonnées du bouton cliqué
        JButton res = (JButton) e.getSource(); //récupère les coordonnées du bouton appuyé
        int a = fenetre.giveCoordAbs(res); //récupère l'abscisse des coordonnées
        char b = fenetre.giveCoordOrd(res); //récupère l'ordonnée des coordonnées
        a = a + 1; //ajoute 1 a l'abscisse pour que ça corresponde aux cases
        fenetre.setCoordCase(a,b); //initialise la valeur des coordonnées pour pouvoir la récupérer et l'envoyer au serveur
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
