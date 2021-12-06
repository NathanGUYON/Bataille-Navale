package controleurs;

import vue.FenetreBatailleNaval;
import vue.PanelSecondMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LancerBaseMenu implements ActionListener { //Permet de passer de la fenêtre de création de la flotte au second menu
    private listepourajoutbateau l;
    private FenetreBatailleNaval fenetre;
    private PanelSecondMenu menu;
    public LancerBaseMenu(PanelSecondMenu m, FenetreBatailleNaval f,listepourajoutbateau ln){
        fenetre = f;
        menu = m;
        l = ln;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    if (l.getliste().isFrenchConfiguration() == true || l.getliste().isBelgianConfiguration() == true) {
        fenetre.setVisible(false);
        menu.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(fenetre, "Vous n'avez pas ajouté tous les bateaux", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    }

}
