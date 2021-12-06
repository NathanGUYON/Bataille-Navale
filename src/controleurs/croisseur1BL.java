package controleurs;

import info1.ships.*;
import modele.Case;
import vue.FenetreBatailleNaval;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class croisseur1BL implements ActionListener {
    FenetreBatailleNaval fn;
    Ship s;
    listepourajoutbateau ls;
    public croisseur1BL(FenetreBatailleNaval lfn , listepourajoutbateau nls){
        this.fn = lfn;
        ls = nls;
    }
    @Override
    public void actionPerformed(ActionEvent e) { //Permet de positionner le premier croiseur belge
        if (ls.getliste().getShips(ShipCategory.CRUISER).size() > 1) { //Vérifie le nombre de croiseurs déjà positionnés
            JOptionPane.showMessageDialog(fn, "Nombre maximal de croiseurs déjà atteint", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            String listedelettrepossible = "ABCDEFGHIJZZZZZZZZ";
            Case coord;
            Case coodfin = null;
            coord = fn.getCoordCase();
            int place = listedelettrepossible.indexOf(coord.getOrdonnee());
            if (fn.getHorizontalGauche() == true) {
                try {
                    coodfin = new Case(coord.getAbscisse(), listedelettrepossible.charAt(place - 2));

                } catch (Exception e5) {
                    coodfin = new Case(coord.getAbscisse(), 'Z');
                }
            }
            if (fn.getHorizontalDroite() == true) {
                coodfin = new Case(coord.getAbscisse(), listedelettrepossible.charAt(place + 2));
            }
            if (fn.getVerticalBas() == true) {
                coodfin = new Case(coord.getAbscisse() + 2, coord.getOrdonnee());

            }
            if (fn.getVerticalHaut() == true) {
                coodfin = new Case(coord.getAbscisse() - 2, coord.getOrdonnee());
            }

            try {
                try {
                    s = new Cruiser("croiseur1bl", coord.toString(), coodfin.toString());
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
                JOptionPane.showMessageDialog(fn, "Pas assez de place, un croiseur occupe 3 cases", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (CoordsBadShipException coordsBadShipException) {
                JOptionPane.showMessageDialog(fn, "Coordonnée illogique, un croiseur occupe 3 cases", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
