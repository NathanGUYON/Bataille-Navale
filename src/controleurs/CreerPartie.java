package controleurs;

import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.Game;
import info1.network.Network;
import info1.network.Player;
import info1.ships.BadCoordException;
import info1.ships.NavyFleet;
import info1.ships.UncompleteFleetException;
import vue.FenetreBatailleNaval;
import vue.PanelMenuPrincipale;
import vue.PanelSecondMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CreerPartie implements ActionListener { //Permet de créer une nouvelle partie
    static Player nomjouer;
    static NavyFleet laflotte;
    static FenetreBatailleNaval fn;
    static Game jeu = null;
    private PanelMenuPrincipale menu;
    private PanelSecondMenu mn;

    static boolean lancé = false;
    public CreerPartie(Player Lenomj , NavyFleet Lenomglotte, FenetreBatailleNaval lfn, PanelSecondMenu mn1, PanelMenuPrincipale menu1){
        this.nomjouer = Lenomj;
        this.laflotte = Lenomglotte;
        this.fn = lfn;
        menu = menu1;
        mn = mn1;
    }


    @Override
    public void actionPerformed(ActionEvent e ) {
        fn.enablebouton();
        fn.setEnCours(true);
        fn.remettrecouleur();
        String HTTP_LOCALHOST = "http://37.187.38.219/api/v0";
        Network.setProxy("srv-proxy-etu-2.iut-nantes.univ-nantes.prive", 3128); //à décommenter si vous êtes sur les PC de l'IUT, à mettre en commentaire si vous êtes sur votre PC perso
        Network.enableProxy(true);//à décommenter si vous êtes sur les PC de l'IUT, à mettre en commentaire si vous êtes sur votre PC perso
        try {
            jeu = Network.initNewGame(HTTP_LOCALHOST, nomjouer, laflotte);

            List<Game> list = null;
            try {
                list = Network.listInitializedGames(HTTP_LOCALHOST);
            } catch (UnirestException unirestException) {
                unirestException.printStackTrace();
            }
            JOptionPane.showMessageDialog(fn, list.get(list.size() - 1));
            lancé = true;
            fn.setEnCours(true);
            mn.setAccepte(true);
            menu.setAccepte(true);
            JouerPendantPartieEnCours j = new JouerPendantPartieEnCours(fn, jeu, nomjouer);
            fn.disableboutonchoix();
            fn.boutonquitterjeu();
             JOptionPane.showMessageDialog(fn, "Merci de ne pas jouer 2 coups d'affilée, cela pourrait engendrer des bugs !");

            JOptionPane.showMessageDialog(fn, "A toi de jouer ! \uD83D\uDE01 ");

        } catch (UnirestException unirestException) {
            unirestException.printStackTrace();
        } catch (UncompleteFleetException uncompleteFleetException) {
            JOptionPane.showMessageDialog(fn, "Flotte incomplete", "erreur", JOptionPane.ERROR_MESSAGE);
        } catch (BadCoordException badCoordException) {
            badCoordException.printStackTrace();
        }
    }

    public static NavyFleet getLaflotte() {
        return laflotte;
    }
}
