package controleurs;

import info1.ships.*;
import modele.Case;
import vue.FenetreBatailleNaval;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class porteavionajoutbouton implements ActionListener {
    FenetreBatailleNaval fn;
    Ship s;
listepourajoutbateau ls;
    public porteavionajoutbouton(FenetreBatailleNaval lfn , listepourajoutbateau nls){
        this.fn = lfn;
       ls = nls;
    }
    @Override
    public void actionPerformed(ActionEvent e) { //Permet de positionner le porte-avions français
        if (ls.getliste().getShips(ShipCategory.AIRCRAFT_CARRIER).size() > 0) { //Vérifie le nombre de porte-avions déjà positionnés
            JOptionPane.showMessageDialog(fn, "Nombre maximal de porte-avions déjà atteint", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
        String listedelettrepossible = "ABCDEFGHIJZZZZZZZZ";
        Case coord;
        Case coodfin = null;
        coord = fn.getCoordCase();
        int place = listedelettrepossible.indexOf(coord.getOrdonnee());
        if (fn.getHorizontalGauche() == true) {
            try {
                coodfin = new Case(coord.getAbscisse(), listedelettrepossible.charAt(place - 4));

            } catch (Exception e5) {
                coodfin = new Case(coord.getAbscisse(), 'Z');
            }
        }
        if (fn.getHorizontalDroite() == true) {
            coodfin = new Case(coord.getAbscisse(), listedelettrepossible.charAt(place + 4));
        }
        if (fn.getVerticalBas() == true) {
            coodfin = new Case(coord.getAbscisse() + 4, coord.getOrdonnee());

        }
        if (fn.getVerticalHaut() == true) {
            coodfin = new Case(coord.getAbscisse() - 4, coord.getOrdonnee());
        }

            try {
                try {
                    s = new AircraftCarrier("porteavionfr", coord.toString(), coodfin.toString());
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
                JOptionPane.showMessageDialog(fn, "Pas assez de place, un porte-avions occupe 5 cases", "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (CoordsBadShipException coordsBadShipException) {
                JOptionPane.showMessageDialog(fn, "Coordonnée illogique, un porte-avions occupe 5 cases", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    }
