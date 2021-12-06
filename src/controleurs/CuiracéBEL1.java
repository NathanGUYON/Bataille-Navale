package controleurs;

import info1.ships.*;
import modele.Case;
import vue.FenetreBatailleNaval;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CuiracéBEL1 implements ActionListener {
    FenetreBatailleNaval fn;
    Ship s;
    listepourajoutbateau ls;
    public CuiracéBEL1(FenetreBatailleNaval lfn , listepourajoutbateau nls){
        this.fn = lfn;
        ls = nls;
    }
    @Override
    public void actionPerformed(ActionEvent e) { //Permet de positionner le cuirassé belge
        if (ls.getliste().getShips(ShipCategory.BATTLESHIP).size() > 0) { //Vérifie le nombre de cuirassés déjà positionnés
            JOptionPane.showMessageDialog(fn, "Nombre maximal de cuirassés déjà atteint", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {

            String listedelettrepossible = "ABCDEFGHIJZZZZZZZZ";
            Case coord;
            Case coodfin = null;
            coord = fn.getCoordCase();
            int place = listedelettrepossible.indexOf(coord.getOrdonnee());
            if (fn.getHorizontalGauche() == true) {
                try {
                    coodfin = new Case(coord.getAbscisse(), listedelettrepossible.charAt(place - 3));

                } catch (Exception e5) {
                    coodfin = new Case(coord.getAbscisse(), 'Z');
                }
            }
            if (fn.getHorizontalDroite() == true) {
                coodfin = new Case(coord.getAbscisse(), listedelettrepossible.charAt(place + 3));
            }
            if (fn.getVerticalBas() == true) {
                coodfin = new Case(coord.getAbscisse() + 3, coord.getOrdonnee());

            }
            if (fn.getVerticalHaut() == true) {
                coodfin = new Case(coord.getAbscisse() - 3, coord.getOrdonnee());
            }

            try {
                try {
                    s = new Battleship("cuiracéBel", coord.toString(), coodfin.toString());
                    boolean i = ls.addbateau(s);
                    if (i == false) {
                        JOptionPane.showMessageDialog(fn, "Impossible de mettre 2 bateaux à la même place", "Erreur", JOptionPane.ERROR_MESSAGE);
                    } else {
                        fn.changerc(s);
                    }

                } catch (NullPointerException e1) {
                    JOptionPane.showMessageDialog(fn, "Mauvaise utilisation il faut choisir la case et la direction avant le bateau", "Erreur", JOptionPane.ERROR_MESSAGE);

                }

            } catch (BadCoordException badCoordException) {
                JOptionPane.showMessageDialog(fn, "Pas assez de place, un cuirassé occupe 4 cases", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (CoordsBadShipException coordsBadShipException) {
                JOptionPane.showMessageDialog(fn, "Coordonnée illogique,  un cuirassé occupe 4 cases", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
