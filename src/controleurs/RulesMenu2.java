package controleurs;

import vue.PanelSecondMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class RulesMenu2 implements ActionListener {

    private PanelSecondMenu menu;


    public RulesMenu2(PanelSecondMenu f){
        menu = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Ce contrôleur affiche les règles du jeu quand on appuie sur le bouton règles
        File file = new File("src/règles.txt");
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
            menu.settingsPopUp(sb.toString());
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
