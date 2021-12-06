package controleurs;

import info1.network.Game;
import info1.network.Network;
import info1.network.Player;
import info1.ships.NavyFleet;
import vue.FenetreBatailleNaval;
import vue.PanelSecondMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RejoindrePartie implements ActionListener {
    static Player nomjouer;
    static NavyFleet laflotte;
    static PanelSecondMenu pnp;
    static FenetreBatailleNaval fn;
    static Game jeu = null;

    public RejoindrePartie(Player Lenomj , NavyFleet Lenomglotte,PanelSecondMenu lpnp, FenetreBatailleNaval lfn){
        this.nomjouer = Lenomj;
        this.laflotte = Lenomglotte;
        this.pnp = lpnp;
        this.fn = lfn;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        fn.enablebouton();
        fn.setEnCours(true);
        fn.remettrecouleur();
        String HTTP_LOCALHOST = "http://37.187.38.219/api/v0";
        Network.setProxy("srv-proxy-etu-2.iut-nantes.univ-nantes.prive", 3128); //à décommenter si vous êtes sur les PC de l'IUT, à mettre en commentaire si vous êtes sur votre PC perso
        Network.enableProxy(true); //à décommenter si vous êtes sur les PC de l'IUT, à mettre en commentaire si vous êtes sur votre PC perso
        int rejoindre;
        try {
            rejoindre = Integer.parseInt(pnp.getnum());//lit le numéro indiqué dans la JTextField
            jeu = new Game(rejoindre);//construction de la partie à rejoindre
            Network.joinGame(HTTP_LOCALHOST, jeu, nomjouer, laflotte); //tente de rejoindre la partie
            List<Game> list = Network.listInitializedGames(HTTP_LOCALHOST);
            pnp.setAccepte(true);
        } catch (Exception e2) {
            pnp.setAccepte(false);
            JOptionPane.showMessageDialog(fn, "Partie inexistante");
        }
        fn.disableboutonchoix();
        fn.boutonquitterjeu();
      JOptionPane.showMessageDialog(fn, "Merci de ne pas jouer 2 coups d'affilée, cela pourrait engendrer des bugs !");

        JouerPendantPartieEnCours j = new JouerPendantPartieEnCours(fn,jeu,nomjouer);
    }
}
