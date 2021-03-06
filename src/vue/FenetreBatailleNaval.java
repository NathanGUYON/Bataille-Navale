package vue;


import info1.ships.ICoord;
import info1.ships.Ship;
import modele.Case;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class FenetreBatailleNaval extends JFrame {

    private JPanel panelPrincipal;
    private JPanel partieCentre;

    /*Composants de la partie EAST de notre Panel Principal*/
    private JLabel idjoueurTitre;
    private JLabel idjoueur;

    private JButton quitterPartie;
    private JButton quitterJeu;

    private JRadioButton modeFR;
    private JRadioButton modeBL;

    private JButton settings;
    private JPanel modeJeu;

    private JLabel historique;
    private JTextArea history;

    /*Composants de la partie WEST de notre Panel Principal*/
    private JPanel partieCentre_Info_Bateau;
    private JPanel regroupementBateauxJ1FR;
    private JPanel regroupementBateauxJ1BL;
    private JPanel validation;
    private JPanel regroupementPanels;

    private JPanel espace = new JPanel(new FlowLayout());
    private JPanel espace2;
    private JPanel espace3 = new JPanel(new FlowLayout());
    private JButton valider;
    private JPanel separateur;
    private JPanel partieDroite_Menu_Boutons;
    private JPanel partieCentre_Histo;
    private JPanel partieDroite;
    private JPanel partieDroite_Info;
    private JPanel partieDroite_Info_Joueur;
    private JPanel partieDroite_Info_Partie;
    private JPanel partieGauche_PlateauJeu;

    private JRadioButton bateau_j1_FR_1;
    private JRadioButton bateau_j1_FR_2;
    private JRadioButton bateau_j1_FR_3;
    private JRadioButton bateau_j1_FR_4;
    private JRadioButton bateau_j1_FR_5;
    private JRadioButton bateau_j1_FR_6;
    private JRadioButton bateau_j1_FR_7;

    private JRadioButton bateau_j1_BL_1;
    private JRadioButton bateau_j1_BL_2;
    private JRadioButton bateau_j1_BL_3;
    private JRadioButton bateau_j1_BL_4;
    private JRadioButton bateau_j1_BL_5;
    private JRadioButton bateau_j1_BL_6;
    private JRadioButton bateau_j1_BL_7;
    private JRadioButton bateau_j1_BL_8;
    private JRadioButton bateau_j1_BL_9;
    private JRadioButton bateau_j1_BL_10;


    private ArrayList<Case> quadrillage = new ArrayList();

    private boolean modeFRchoisis = true;
    private boolean modeBLchoisis = false;
    private Case coordCase = new Case(1, 'A');


    private ButtonGroup groupBateauBLAlli??s;
    private ButtonGroup groupBateauFRAlli??s;
    private ArrayList<JRadioButton> groupBateauBLAlli??sList = new ArrayList<>();
    private ArrayList<JRadioButton> groupBateauFRAlli??sList = new ArrayList<>();

    private boolean verticalHaut = false;
    private boolean verticalBas = false;
    private boolean horizontalGauche = false;
    private boolean horizontalDroite = false;

    private JButton gauche;
    private JButton droite;
    private JButton haut;
    private JButton bas;

    private boolean enCours = false;
    private JButton avalide = new JButton();

    /**
     * construit une nouvelle fen??tre
     *
     * @param titre le titre de la fen??tre
     */
    public FenetreBatailleNaval(String titre) {
        super(titre);

        // mise en page des diff??rents JComponents
        panelPrincipal = new JPanel(new BorderLayout());
        this.setContentPane(panelPrincipal);
        this.setMinimumSize(new Dimension(1100, 750));
        this.setMaximizedBounds(new Rectangle(0, 0, 1100, 700));
        this.setLocationRelativeTo(null);


        /*PARTIE DROITE*/
        partieDroite = new JPanel(new BorderLayout());
        partieDroite_Info = new JPanel(new GridLayout(1, 2));
        partieDroite_Info_Joueur = new JPanel();
        partieDroite_Info_Joueur.setLayout(new BoxLayout(partieDroite_Info_Joueur, BoxLayout.Y_AXIS));
        partieDroite_Info_Partie = new JPanel();
        partieDroite_Info_Partie.setLayout(new BoxLayout(partieDroite_Info_Partie, BoxLayout.Y_AXIS));
        idjoueurTitre = new JLabel("Pseudo du Joueur :                  "); //Pour espacer un peu les boutons
        idjoueur = new JLabel(""); //S'instanciera ?? l'aide de controlleurs

        /*On ajoute tous nos composants dans les bonnes parties*/
        /*Ajout dans la partie "Joueur" du panneau d'information*/
        partieDroite_Info_Joueur.add(idjoueurTitre);
        //partieDroite_Info_Joueur.add(new JLabel(" ")); //Autre Petit Espace
        partieDroite_Info_Joueur.add(idjoueur);
        partieDroite_Info_Joueur.add(new JLabel(" ")); // Petit Espace
        partieDroite_Info_Joueur.add(new JLabel(" ")); //Autre Petit Espace

        /*Ajout des 2 dans la partie "Information"*/
        partieDroite_Info.add(partieDroite_Info_Joueur);
        partieDroite_Info.add(partieDroite_Info_Partie);

        /*Ajout ?? la partie droite*/
        partieDroite.add(partieDroite_Info, BorderLayout.NORTH);

        partieDroite_Menu_Boutons = new JPanel();
        partieDroite_Menu_Boutons.setLayout(new GridLayout(9, 1)); /*Grille pour afficher des boutons tous de la meme taille*/

        /*Cr??eation d'espace vide pour la lisibilit?? et le confot visuel*/
        JPanel espace10 = new JPanel(new FlowLayout());
        espace10.setBorder(new EmptyBorder(0, 0, 0, 0));
        JPanel espace11 = new JPanel(new FlowLayout());
        espace11.setBorder(new EmptyBorder(0, 0, 0, 0));
        JPanel espace12 = new JPanel(new FlowLayout());
        espace12.setBorder(new EmptyBorder(0, 0, 0, 0));

        settings = new JButton("R??gles");
        /*Choix exclusif entre 2 mode de jeu*/
        modeJeu = new JPanel(new GridLayout(1, 2));
        ButtonGroup group = new ButtonGroup();
        modeFR = new JRadioButton("Mode Fran??ais");
        modeFR.setSelected(true);
        modeBL = new JRadioButton("Mode Belge");
        group.add(modeBL);
        group.add(modeFR);
        modeJeu.add(modeBL);
        modeJeu.add(modeFR);

        quitterPartie = new JButton("Fin du placement des Bateaux");
        quitterJeu = new JButton("Quitter le jeu");
        /*Fin du codage des boutons*/

        /*Ajout des boutons dans l'espace reserv??*/

        partieDroite_Menu_Boutons.add(modeJeu);
        partieDroite_Menu_Boutons.add(espace10);
        partieDroite_Menu_Boutons.add(settings);
        partieDroite_Menu_Boutons.add(espace11);
        partieDroite_Menu_Boutons.add(quitterPartie);
        partieDroite_Menu_Boutons.add(espace12);
        partieDroite_Menu_Boutons.add(quitterJeu);
        partieDroite_Menu_Boutons.setBorder(new EmptyBorder(50, 50, 50, 50)); //Petit Espace
        /*Fin de la partie "Bouton" de la partie droite*/

        partieDroite.add(partieDroite_Menu_Boutons, BorderLayout.SOUTH);

        /*FIN DE LA PARTIE DROITE*/


        /*PARTIE CENTRE*/
        partieCentre = new JPanel(new BorderLayout());

        /*Sud de la partie centre => Historique*/
        partieCentre_Histo = new JPanel(new BorderLayout());
        history = new JTextArea("Tr??s long text pour tester"); //Valeur arbitraire pour tester
        history.setEnabled(false); //On ne peut pas ecrire dans la zone, le serveur le fera tout seul

        /*Pour avoir un beau texte qui revient bien ?? la ligne la ou il faut*/
        history.setLineWrap(true);
        history.setWrapStyleWord(true);

        partieCentre_Histo.add(history, BorderLayout.CENTER);
        partieCentre_Histo.setBorder(BorderFactory.createTitledBorder(" Historique de la Partie "));

        /*PARTIE CENTRALE => INFORMATION SUR LES BATEAUX*/
        partieCentre_Info_Bateau = new JPanel();
        partieCentre_Info_Bateau.setLayout(new BoxLayout(partieCentre_Info_Bateau, BoxLayout.Y_AXIS));

        groupBateauFRAlli??s = new ButtonGroup();
        bateau_j1_FR_1 = new JRadioButton("Porte-avions");
        bateau_j1_FR_2 = new JRadioButton("Cuirass??");
        bateau_j1_FR_3 = new JRadioButton("Croiseur");
        bateau_j1_FR_4 = new JRadioButton("Croiseur");
        bateau_j1_FR_5 = new JRadioButton("Torpilleur");
        bateau_j1_FR_6 = new JRadioButton("Torpilleur");
        bateau_j1_FR_7 = new JRadioButton("Sous-marin");
        groupBateauFRAlli??s.add(bateau_j1_FR_1);
        groupBateauFRAlli??s.add(bateau_j1_FR_2);
        groupBateauFRAlli??s.add(bateau_j1_FR_3);
        groupBateauFRAlli??s.add(bateau_j1_FR_4);
        groupBateauFRAlli??s.add(bateau_j1_FR_5);
        groupBateauFRAlli??s.add(bateau_j1_FR_6);
        groupBateauFRAlli??s.add(bateau_j1_FR_7);
        groupBateauFRAlli??sList.add(0, bateau_j1_FR_1);
        groupBateauFRAlli??sList.add(1, bateau_j1_FR_2);
        groupBateauFRAlli??sList.add(2, bateau_j1_FR_3);
        groupBateauFRAlli??sList.add(3, bateau_j1_FR_4);
        groupBateauFRAlli??sList.add(4, bateau_j1_FR_5);
        groupBateauFRAlli??sList.add(5, bateau_j1_FR_6);
        groupBateauFRAlli??sList.add(6, bateau_j1_FR_7);
        regroupementBateauxJ1FR = new JPanel(new GridLayout(3, 5));
        regroupementBateauxJ1FR.setBorder(BorderFactory.createTitledBorder("Bateaux fran??ais"));
        regroupementBateauxJ1FR.add(bateau_j1_FR_1);
        regroupementBateauxJ1FR.add(bateau_j1_FR_2);
        regroupementBateauxJ1FR.add(bateau_j1_FR_3);
        regroupementBateauxJ1FR.add(bateau_j1_FR_4);
        regroupementBateauxJ1FR.add(bateau_j1_FR_5);
        regroupementBateauxJ1FR.add(bateau_j1_FR_6);
        regroupementBateauxJ1FR.add(bateau_j1_FR_7);

        groupBateauBLAlli??s = new ButtonGroup();
        bateau_j1_BL_1 = new JRadioButton("Cuirass??");
        bateau_j1_BL_2 = new JRadioButton("Croiseur");
        bateau_j1_BL_3 = new JRadioButton("Croiseur");
        bateau_j1_BL_4 = new JRadioButton("Torpilleur");
        bateau_j1_BL_5 = new JRadioButton("Torpilleur");
        bateau_j1_BL_6 = new JRadioButton("Torpilleur");
        bateau_j1_BL_7 = new JRadioButton("Sous-marin");
        bateau_j1_BL_8 = new JRadioButton("Sous-marin");
        bateau_j1_BL_9 = new JRadioButton("Sous-marin");
        bateau_j1_BL_10 = new JRadioButton("Sous-marin");
        groupBateauBLAlli??s.add(bateau_j1_BL_1);
        groupBateauBLAlli??s.add(bateau_j1_BL_2);
        groupBateauBLAlli??s.add(bateau_j1_BL_3);
        groupBateauBLAlli??s.add(bateau_j1_BL_4);
        groupBateauBLAlli??s.add(bateau_j1_BL_5);
        groupBateauBLAlli??s.add(bateau_j1_BL_6);
        groupBateauBLAlli??s.add(bateau_j1_BL_7);
        groupBateauBLAlli??s.add(bateau_j1_BL_8);
        groupBateauBLAlli??s.add(bateau_j1_BL_9);
        groupBateauBLAlli??s.add(bateau_j1_BL_10);
        groupBateauBLAlli??sList.add(0, bateau_j1_BL_1);
        groupBateauBLAlli??sList.add(1, bateau_j1_BL_2);
        groupBateauBLAlli??sList.add(2, bateau_j1_BL_3);
        groupBateauBLAlli??sList.add(3, bateau_j1_BL_4);
        groupBateauBLAlli??sList.add(4, bateau_j1_BL_5);
        groupBateauBLAlli??sList.add(5, bateau_j1_BL_6);
        groupBateauBLAlli??sList.add(6, bateau_j1_BL_7);
        groupBateauBLAlli??sList.add(7, bateau_j1_BL_8);
        groupBateauBLAlli??sList.add(8, bateau_j1_BL_9);
        groupBateauBLAlli??sList.add(9, bateau_j1_BL_10);
        regroupementBateauxJ1BL = new JPanel(new GridLayout(3, 5));
        regroupementBateauxJ1BL.setBorder(BorderFactory.createTitledBorder("Bateaux belges"));
        regroupementBateauxJ1BL.add(bateau_j1_BL_1);
        regroupementBateauxJ1BL.add(bateau_j1_BL_2);
        regroupementBateauxJ1BL.add(bateau_j1_BL_3);
        regroupementBateauxJ1BL.add(bateau_j1_BL_4);
        regroupementBateauxJ1BL.add(bateau_j1_BL_5);
        regroupementBateauxJ1BL.add(bateau_j1_BL_6);
        regroupementBateauxJ1BL.add(bateau_j1_BL_7);
        regroupementBateauxJ1BL.add(bateau_j1_BL_8);
        regroupementBateauxJ1BL.add(bateau_j1_BL_9);
        regroupementBateauxJ1BL.add(bateau_j1_BL_10);

        espace.setBorder(new EmptyBorder(150, 0, 0, 0));
        espace2 = new JPanel(new BorderLayout());
        espace2.add(gauche = new JButton("<"), BorderLayout.WEST);
        espace2.add(droite = new JButton(">"), BorderLayout.EAST);
        espace2.add(haut = new JButton("^"), BorderLayout.NORTH);
        espace2.add(bas = new JButton("v"), BorderLayout.SOUTH);
        espace2.setBorder(new EmptyBorder(0, 150, 0, 150));
        espace3.setBorder(new EmptyBorder(80, 0, 0, 0));
        //partieCentre_Info_Bateau.add(espace);
        if (modeFRchoisis) { //V??rification que les boutons s'affiche bien
            partieCentre_Info_Bateau.add(regroupementBateauxJ1FR);
        } else if (modeBLchoisis) {
            partieCentre_Info_Bateau.add(regroupementBateauxJ1BL);
        }
        partieCentre_Info_Bateau.add(espace2);


        partieCentre.add(partieDroite_Info, BorderLayout.NORTH);


        valider = new JButton("Valider le Tir !");
        valider.setVisible(false);
        validation = new JPanel(new BorderLayout());
        validation.add(valider, BorderLayout.SOUTH);

        separateur = new JPanel(new BorderLayout());
        separateur.add(validation, BorderLayout.SOUTH);

        regroupementPanels = new JPanel(new BorderLayout());
        regroupementPanels.add(partieCentre_Info_Bateau, BorderLayout.CENTER);
        regroupementPanels.add(partieDroite_Menu_Boutons, BorderLayout.SOUTH);
        regroupementPanels.add(espace3, BorderLayout.NORTH);

        separateur.add(regroupementPanels, BorderLayout.NORTH);

        partieCentre.add(separateur, BorderLayout.CENTER);
        partieCentre.add(partieDroite_Info, BorderLayout.NORTH);

        partieCentre.add(partieCentre_Histo, BorderLayout.SOUTH);



        /*Partie principale de Jeu*/
        partieGauche_PlateauJeu = new JPanel(new GridLayout(10, 10));
        partieGauche_PlateauJeu.setBorder(BorderFactory.createTitledBorder("Carte du Jeu"));
        for (int i = 0; i < 10; i++) {
            for (char j = 'A'; j < 'K'; j++) {
                String res = "";
                res = res + j;
                res = res + "." + (i + 1);
                JButton x = new JButton(res);
                Case c = new Case(i, j, x);
                quadrillage.add(c);
                quadrillage.get(quadrillage.indexOf(c)).getBouton().setBackground(Color.LIGHT_GRAY);
                if (quadrillage.get(quadrillage.indexOf(c)).isOccupe()) {
                    quadrillage.get(quadrillage.indexOf(c)).getBouton().setBackground(Color.red);
                }
                partieGauche_PlateauJeu.add(x);
            }
        }

        /*Ajout de Tous les composants au panel Principal*/
        panelPrincipal.add(partieGauche_PlateauJeu, BorderLayout.WEST);
        panelPrincipal.add(partieCentre, BorderLayout.CENTER);
        panelPrincipal.add(partieDroite, BorderLayout.EAST);
        panelPrincipal.setSize(new Dimension(1000, 500));


    }

    public void erreurMessage(String s) {
        JOptionPane.showMessageDialog(this, s, "Une erreur s'est produite", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * active / d??sactive le Bouton permettant de passer au mode FR
     *
     * @param etat vrai si le bouton doit ??tre activ??
     */
    public void activerBoutonModeFR(boolean etat) {
        modeFRchoisis = true;
        modeBLchoisis = false;
    }

    /**
     * active / d??sactive le Bouton permettant de passer au mode BL
     *
     * @param etat vrai si le bouton doit ??tre activ??
     */
    public void activerBoutonModeBL(boolean etat) {
        modeFRchoisis = false;
        modeBLchoisis = true;
    }

    /**
     * setter du idJoueur
     *
     * @param nom est le pseudo ?? afficher
     */
    public void setIdjoueur(String nom) {
        idjoueur.setText(nom);
    }

    /**
     * ajout un Action listener sur le mode BL
     *
     * @param action le listener ?? ajouter
     */
    public void fixeListenerChangementModeBL(ActionListener action) {
        modeBL.addActionListener(action);
    }

    /**
     * ajout un Action listener sur le mode FR
     *
     * @param action le listener ?? ajouter
     */
    public void fixeListenerChangementModeFR(ActionListener action) {
        modeFR.addActionListener(action);
    }

    /**
     * setter pour l'infomation des bateaux
     *
     * @param b indique si le mode est francais
     */
    public void setPartieCentre_Info_Bateau(boolean b) {

        espace.setBorder(new EmptyBorder(150, 0, 0, 0));
        espace2 = new JPanel(new BorderLayout());
        espace2.add(gauche = new JButton("<"), BorderLayout.WEST);
        espace2.add(droite = new JButton(">"), BorderLayout.EAST);
        espace2.add(haut = new JButton("^"), BorderLayout.NORTH);
        espace2.add(bas = new JButton("v"), BorderLayout.SOUTH);
        espace2.setBorder(new EmptyBorder(0, 150, 0, 150));
        espace3.setBorder(new EmptyBorder(80, 0, 0, 0));

        if (b) { //V??rification que les boutons s'affiche bien
            partieCentre_Info_Bateau.add(regroupementBateauxJ1FR);
        } else {
            partieCentre_Info_Bateau.add(regroupementBateauxJ1BL);
        }

        panelPrincipal.updateUI();
    }


    /**
     * remise ?? z??ro du panel Partie CentreInfoBateau
     */
    public void nullifierPartieCentreInfoB() {
        partieCentre_Info_Bateau.removeAll();
    }

    /**
     * active / d??sactive un bouton du quadrillage
     *
     * @param etat vrai si le bouton doit ??tre activ??
     */
    public void activerBoutonQuadrillage(boolean etat, JButton res) {
        for (Case i : quadrillage) {
            if (res == i.getBouton()) {
                i.getBouton().setEnabled(etat);
            }
        }
    }

    /**
     * abonnement d'un listener a chaque bouton du quadrillage
     */
    public void fixeListenerDesactiveButton(MouseListener action) {
        for (Case i : quadrillage) {
            i.getBouton().addMouseListener(action);
        }
    }

    /**
     * abonnement d'un listener a chaque bouton du quadrillage
     */
    public void fixeListenerGiveCoord(MouseListener action) {
        for (Case i : quadrillage) {
            i.getBouton().addMouseListener(action);
        }
    }

    /**
     * une case rends ces abscisses
     */
    public int giveCoordAbs(JButton res) {
        int test = -1;
        for (Case i : quadrillage) {
            if (res == i.getBouton()) {
                test = i.getAbscisse();
            }
        }
        return test;
    }

    /**
     * une case rends ces ordon??es
     */
    public char giveCoordOrd(JButton res) {
        char test = 0;
        for (Case i : quadrillage) {
            if (res == i.getBouton()) {
                test = (char) i.getOrdonnee();
            }
        }
        return test;
    }

    public void enablebouton() {
        for (Case i : quadrillage) {
            i.getBouton().setEnabled(true);
        }
    }

    /**
     * abonnement d'un listener au bouton Settings
     */
    public void fixeListenerRuleBouton(ActionListener action) {
        settings.addActionListener(action);
    }

    public void settingsPopUp(String s) {
        JOptionPane.showMessageDialog(this, s, "R??gles", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean isFR() {
        return modeFRchoisis;
    }

    public boolean isBEL() {
        return modeBLchoisis;
    }


    public void setCoordCase(int a, char b) {
        coordCase.setAbscisse(a);
        coordCase.setOrdonnee(b);
    }


    public Case getCoordCase() {
        return coordCase;
    }

    public int getBateauSelect() {
        if (isBEL()) {
            for (JRadioButton b : groupBateauBLAlli??sList) {
                if (b.isSelected()) {
                    return groupBateauBLAlli??sList.indexOf(b);
                }
            }
        }
        if (isFR()) {
            for (JRadioButton c : groupBateauFRAlli??sList) {
                if (c.isSelected()) {
                    return groupBateauFRAlli??sList.indexOf(c);
                }
            }
        }
        return -1;
    }

    public JButton Avalide() {
        return avalide;
    }

    public void setAvalide(JButton b) {
        avalide = b;
    }


    public void fixeListenerPositionGauche(ActionListener action) {
        gauche.addActionListener(action);
    }

    public void fixeListenerPositionDroite(ActionListener action) {
        droite.addActionListener(action);
    }

    public void fixeListenerPositionBas(ActionListener action) {
        bas.addActionListener(action);
    }

    public void fixeListenerPositionHaut(ActionListener action) {
        haut.addActionListener(action);
    }

    public void setHorizontalGauche() {
        horizontalGauche = true;
        horizontalDroite = false;
        verticalHaut = false;
        verticalBas = false;
    }

    public void setHorizontalDroite() {
        horizontalGauche = false;
        horizontalDroite = true;
        verticalHaut = false;
        verticalBas = false;
    }

    public void setVerticalHaut() {
        horizontalGauche = false;
        horizontalDroite = false;
        verticalHaut = true;
        verticalBas = false;
    }

    public void setVerticalBas() {
        horizontalGauche = false;
        horizontalDroite = false;
        verticalHaut = false;
        verticalBas = true;
    }

    public boolean getHorizontalGauche() {
        return horizontalGauche;
    }

    public boolean getHorizontalDroite() {
        return horizontalDroite;
    }

    public boolean getVerticalHaut() {
        return verticalHaut;
    }

    public boolean getVerticalBas() {
        return verticalBas;
    }

    public void fixeListenerpourvalider(ActionListener actionListener) {
        valider.addActionListener(actionListener);
    }

    public void fixeListenerQuitterPartie(ActionListener action) {
        quitterPartie.addActionListener(action);
    }

    public void fixeListenerQuitterJeu(ActionListener action) {
        quitterJeu.addActionListener(action);
    }

    public void setVisibleButton(boolean b) {
        valider.setVisible(b);
    }

    public void setChangerButtonTextField(String s) {
        quitterPartie.setText(s);
    }

    public boolean isEnCours() {
        return enCours;
    }

    public void setEnCours(boolean b) {
        enCours = b;
    }

    public void listenerbateaufr1(ActionListener actionListener) {
        bateau_j1_FR_1.addActionListener(actionListener);
    }

    public void listenerbateaufr2(ActionListener actionListener) {
        bateau_j1_FR_2.addActionListener(actionListener);
    }

    public void listenerbateaufr3(ActionListener actionListener) {
        bateau_j1_FR_3.addActionListener(actionListener);
    }

    public void listenerbateaufr4(ActionListener actionListener) {
        bateau_j1_FR_4.addActionListener(actionListener);
    }

    public void listenerbateaufr5(ActionListener actionListener) {
        bateau_j1_FR_5.addActionListener(actionListener);
    }

    public void listenerbateaufr6(ActionListener actionListener) {
        bateau_j1_FR_6.addActionListener(actionListener);
    }

    public void listenerbateaufr7(ActionListener actionListener) {
        bateau_j1_FR_7.addActionListener(actionListener);
    }

    public void listenerbateauBEL1(ActionListener actionListener) {
        bateau_j1_BL_1.addActionListener(actionListener);
    }

    public void listenerbateauBEL2(ActionListener actionListener) {
        bateau_j1_BL_2.addActionListener(actionListener);
    }

    public void listenerbateauBEL3(ActionListener actionListener) {
        bateau_j1_BL_3.addActionListener(actionListener);
    }

    public void listenerbateauBEL4(ActionListener actionListener) {
        bateau_j1_BL_4.addActionListener(actionListener);
    }

    public void listenerbateauBEL5(ActionListener actionListener) {
        bateau_j1_BL_5.addActionListener(actionListener);
    }

    public void listenerbateauBEL6(ActionListener actionListener) {
        bateau_j1_BL_6.addActionListener(actionListener);
    }

    public void listenerbateauBEL7(ActionListener actionListener) {
        bateau_j1_BL_7.addActionListener(actionListener);
    }

    public void listenerbateauBEL8(ActionListener actionListener) {
        bateau_j1_BL_8.addActionListener(actionListener);
    }

    public void listenerbateauBEL9(ActionListener actionListener) {
        bateau_j1_BL_9.addActionListener(actionListener);
    }

    public void listenerbateauBEL10(ActionListener actionListener) {
        bateau_j1_BL_10.addActionListener(actionListener);
    }


    public void changerc(Ship s) {
        ArrayList<String> listenString = new ArrayList<>();
        String s1 = "";
        for (ICoord i : s.getCoords()) {
            s1 = "" + i.getAlphaX() + (i.getY() - 1);
            listenString.add(s1);
        }
        for (Case i : quadrillage) {
            if (listenString.contains(i.toString()) == true) {
                i.getBouton().setBackground(Color.red);
            }
        }
    }

    public void changerc2(Case c, Color color) {
        c.setAbscisse(c.getAbscisse()-1);
        for(Case i : quadrillage){
            if(i.toString().compareTo(c.toString())==0){
                i.getBouton().setBackground(color);
            }
        }
        c.setAbscisse(c.getAbscisse()+1);
    }

    public void remettrecouleur() {
        for (Case i : quadrillage) {
            i.getBouton().setBackground(Color.LIGHT_GRAY);
        }

    }

    public void disablecorde(Case c) {  //permet de disable un bouton instanement apr??s avoir ??t?? utilis??
        for (Case i : quadrillage) {
            String s = "" + c.getOrdonnee() + (c.getAbscisse()-1);
            if (s.toString().equals(i.toString())){
                i.getBouton().setEnabled(false);
            }
        }

    }

    public void disablefr(){
        bateau_j1_FR_1.setEnabled(false);
        bateau_j1_FR_2.setEnabled(false);
        bateau_j1_FR_3.setEnabled(false);
        bateau_j1_FR_4.setEnabled(false);
        bateau_j1_FR_5.setEnabled(false);
        bateau_j1_FR_6.setEnabled(false);
        bateau_j1_FR_7.setEnabled(false);
    }
    public void enablefr(){
        bateau_j1_FR_1.setEnabled(true);
        bateau_j1_FR_2.setEnabled(true);
        bateau_j1_FR_3.setEnabled(true);
        bateau_j1_FR_4.setEnabled(true);
        bateau_j1_FR_5.setEnabled(true);
        bateau_j1_FR_6.setEnabled(true);
        bateau_j1_FR_7.setEnabled(true);
    }
    public void disablebl(){
        bateau_j1_BL_1.setEnabled(false);
        bateau_j1_BL_2.setEnabled(false);
        bateau_j1_BL_3.setEnabled(false);
        bateau_j1_BL_4.setEnabled(false);
        bateau_j1_BL_5.setEnabled(false);
        bateau_j1_BL_6.setEnabled(false);
        bateau_j1_BL_7.setEnabled(false);
        bateau_j1_BL_8.setEnabled(false);
        bateau_j1_BL_9.setEnabled(false);
        bateau_j1_BL_10.setEnabled(false);

    }
    public void enablebl(){
        bateau_j1_BL_1.setEnabled(true);
        bateau_j1_BL_2.setEnabled(true);
        bateau_j1_BL_3.setEnabled(true);
        bateau_j1_BL_4.setEnabled(true);
        bateau_j1_BL_5.setEnabled(true);
        bateau_j1_BL_6.setEnabled(true);
        bateau_j1_BL_7.setEnabled(true);
        bateau_j1_BL_8.setEnabled(true);
        bateau_j1_BL_9.setEnabled(true);
        bateau_j1_BL_10.setEnabled(true);

    }

    public void disableboutonchoix(){
        modeBL.setEnabled(false);
        modeFR.setEnabled(false);
        disablebl();
        disablefr();
    }

    public void boutonquitterjeu(){
        quitterPartie.setEnabled(false);
        quitterJeu.setEnabled(true);
        quitterPartie.setVisible(false);
        quitterJeu.setVisible(true);
    }
}
