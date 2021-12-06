package controleurs;

import vue.FenetreBatailleNaval;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetModeBL implements ActionListener {
    private listepourajoutbateau n;
    private FenetreBatailleNaval fenetre;

    public SetModeBL(FenetreBatailleNaval f, listepourajoutbateau ln){
        fenetre = f;
        n = ln;
    }

    @Override
    public void actionPerformed(ActionEvent e) { //ce contrôleur active le mode belge et désactive le mode français

          n.clear();
          fenetre.remettrecouleur();
          fenetre.disablefr();
          fenetre.enablebl();
    }
}
