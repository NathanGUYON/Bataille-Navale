import com.mashape.unirest.http.exceptions.UnirestException;
import controleurs.*;
import info1.network.Network;
import info1.network.Player;
import info1.ships.*;
import controleurs.RejoindrePartie;
import controleurs.CreerPartie;
import controleurs.JouerPendantPartieEnCours;
import modele.PlayerPseudo;
import vue.FenetreBatailleNaval;
import vue.PanelMenuPrincipale;
import vue.PanelSecondMenu;


class AppliBatailleNaval {

    /**
     * méthode principale exécutable
     *
     * @param args
     */
    public static void main(String[] args) throws UnirestException, BadCoordException, CoordsBadShipException {
        String HTTP_LOCALHOST = "http://37.187.38.219/api/v0";

        Network.setProxy("srv-proxy-etu-2.iut-nantes.univ-nantes.prive", 3128);
        Network.enableProxy(true);
        Player ppp1;
        Player ppp2;

        ppp1 = new Player("\uD83D\uDC4D" );
        ppp2 = new Player("np" );
        Network.suscribeNewPlayer(HTTP_LOCALHOST, ppp1);
        Network.suscribeNewPlayer(HTTP_LOCALHOST, ppp2);

        // on créé le modele
        PlayerPseudo player = new PlayerPseudo("player1");

        // on créé la vue
        FenetreBatailleNaval fenetre = new FenetreBatailleNaval("World of Warships");
        PanelMenuPrincipale menu = new PanelMenuPrincipale("Menu");
        PanelSecondMenu menu2 = new PanelSecondMenu("Menu");


        // on associe les controleurs à la vue
        // NB : les controleurs connaissent le modèle ET la vue
        fenetre.fixeListenerDesactiveButton(new SetButtonQuad(fenetre));
        fenetre.fixeListenerRuleBouton(new Rules(fenetre));
        fenetre.fixeListenerGiveCoord(new GetCoordButton(fenetre));
        fenetre.fixeListenerPositionGauche(new PositionControleurGauche(fenetre));
        fenetre.fixeListenerPositionDroite(new PositionControleurDroite(fenetre));
        fenetre.fixeListenerPositionBas(new PositionControleurBas(fenetre));
        fenetre.fixeListenerPositionHaut(new PositionControleurHaut(fenetre));


        /* **************** */
        menu.fixeListenerChangementPseudoField(new ChangementPseudoKLMenu(menu,player,fenetre,menu2));
        menu.fixeListenerRuleBouton(new RulesMenu(menu));
        menu.fixeListenerCreerFlotte(new LancerPartieMenu(menu,fenetre));
        menu.fixeListenerCreditsBouton(new CreditsMenu1(menu));
        menu.fixeListenerQuitterJeu(new QuitterJeuMenu1(menu));

        menu2.fixeListenerChangementPseudoField2(new ChangementPseudoKLMenu(menu,player,fenetre,menu2));
        menu2.fixeListenerChangementPseudoField(new ChangementPseudoKLMenu2(player,fenetre,menu2));
        menu2.fixeListenerRuleBouton(new RulesMenu2(menu2));
        menu2.fixeListenerLancerPartie(new LancePartieMenu2(menu2,fenetre));
        menu2.fixeListenerCreditsBouton(new CreditsMenu2(menu2));
        menu2.fixeListenerQuitterJeu(new QuitterJeuMenu2(menu2));

        /* **************** */
        fenetre.pack();
        fenetre.setVisible(false);
        menu.pack();
        menu.setVisible(true);
        menu2.pack();
        menu2.setVisible(false);


        listepourajoutbateau a = new listepourajoutbateau();
        NavyFleet flotte1  = a.getliste();

        fenetre.setPartieCentre_Info_Bateau(false);
        //On active le mode Belge
        fenetre.activerBoutonModeBL(true);

        menu2.fixeListenerPourLancer(new CreerPartie(ppp1,flotte1,fenetre,menu2,menu));
        fenetre.fixeListenerpourvalider(new JouerPendantPartieEnCours(fenetre,null,ppp1));
        fenetre.fixeListenerpourvalider(new JouerPendantPartieEnCours(fenetre,null,ppp2));
        menu2.fixeListenerPourRejoindre(new RejoindrePartie(ppp2,flotte1,menu2, fenetre));
        fenetre.listenerbateaufr1(new porteavionajoutbouton(fenetre,a));
        fenetre.listenerbateaufr2(new cuirassé1FRbouton(fenetre,a));
        fenetre.listenerbateaufr3(new croisseur1FR(fenetre,a));
        fenetre.listenerbateaufr4(new croisseur2FR(fenetre,a));
        fenetre.listenerbateaufr5(new torpilleur1FR(fenetre,a));
        fenetre.listenerbateaufr6(new torpilleur2FR(fenetre,a));
        fenetre.listenerbateaufr7(new submarrin1FR(fenetre,a));

        fenetre.listenerbateauBEL1(new CuiracéBEL1(fenetre,a));
        fenetre.listenerbateauBEL2(new croisseur1BL(fenetre,a));
        fenetre.listenerbateauBEL3(new croisseur2BL(fenetre,a));
        fenetre.listenerbateauBEL4(new torpilleur1BL(fenetre,a));
        fenetre.listenerbateauBEL5(new torpilleur2BL(fenetre,a));
        fenetre.listenerbateauBEL6(new torpilleur3BL(fenetre,a));
        fenetre.listenerbateauBEL7(new submarrin1BL(fenetre,a));
        fenetre.listenerbateauBEL8(new submarrin2BL(fenetre,a));
        fenetre.listenerbateauBEL9(new submarrin3BL(fenetre,a));
        fenetre.listenerbateauBEL10(new submarrin4BL(fenetre,a));
        fenetre.fixeListenerChangementModeBL(new SetModeBL(fenetre,a));
        fenetre.fixeListenerChangementModeFR(new SetModeFR(fenetre,a));
        fenetre.fixeListenerQuitterPartie(new LancerBaseMenu(menu2,fenetre,a));
        fenetre.fixeListenerQuitterJeu(new QuitterJeu(fenetre));

        fenetre.disablebl();
        fenetre.enablefr();


    }

}
