package controleurs;


import vue.PanelMenuPrincipale;
import vue.PanelSecondMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CreditsMenu2 implements ActionListener {

    private PanelSecondMenu menu;


    public CreditsMenu2(PanelSecondMenu f){
        menu = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Ce contrôleur affiche les crédits quand on appuie sur le bouton crédits
        File file = new File("src/crédits.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null)
            {
                // ajoute la ligne au buffer
                sb.append(line);
                sb.append("\n");
            }
            menu.creditsPopUp(sb.toString());
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
