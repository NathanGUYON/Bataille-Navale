package controleurs;

import vue.FenetreBatailleNaval;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetModeFR implements ActionListener {
    private listepourajoutbateau n;
    private FenetreBatailleNaval fenetre;

    public SetModeFR( FenetreBatailleNaval f,listepourajoutbateau ln){
        fenetre = f;
        n = ln;
    }

    @Override
    public void actionPerformed(ActionEvent e) { //ce contrôleur active le mode français et désactive le mode belge
        
        n.clear();
        fenetre.remettrecouleur();
        fenetre.disablebl();
        fenetre.enablefr();
    }
}
