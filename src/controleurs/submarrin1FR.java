package controleurs;

import info1.ships.*;
import modele.Case;
import vue.FenetreBatailleNaval;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class submarrin1FR implements ActionListener {
  FenetreBatailleNaval fn;
    Ship s;
    listepourajoutbateau ls;
    public submarrin1FR(FenetreBatailleNaval lfn , listepourajoutbateau nls){
        this.fn = lfn;
        ls = nls;
    }
    @Override
    public void actionPerformed(ActionEvent e) { //Permet de positionner le sous-marin français
        if (ls.getliste().getShips(ShipCategory.SUBMARINE).size() > 0) { //Vérifie le nombre de sous-marin déjà positionnés
            JOptionPane.showMessageDialog(fn, "Nombre maximal de sous-marin déjà atteint", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            Case coord;
            coord = fn.getCoordCase();

            try {

                try {
                    s = new Submarine("Submarine1FR", coord.toString());
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
                JOptionPane.showMessageDialog(fn, "Pas assez de place, un sous-marin occupe 1 case", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (CoordsBadShipException coordsBadShipException) {
                JOptionPane.showMessageDialog(fn, "Coordonnée illogique, un sous-marin occupe 1 case", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
