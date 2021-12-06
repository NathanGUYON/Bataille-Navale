package controleurs;

import vue.FenetreBatailleNaval;
import vue.PanelMenuPrincipale;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class LancerPartieMenu implements ActionListener { //Permet de passer du premier menu à la fenêtre ce création de la flotte

    private FenetreBatailleNaval fenetre;
    private PanelMenuPrincipale menu;
    public LancerPartieMenu(PanelMenuPrincipale m,FenetreBatailleNaval f){
        fenetre = f;
        menu = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.setVisible(true);
        menu.setVisible(false);

        File file = new File("src/explications.txt");
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
            menu.creerflottePopUp(sb.toString());
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
