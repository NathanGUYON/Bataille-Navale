package vue;


import controleurs.QuitterJeu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class PanelSecondMenu extends JFrame {
    private JPanel panelPrincipal;

    /*Composants de la partie EAST de notre Panel Principal*/
    private JLabel idjoueurTitre;
    private JLabel idjoueur;

    private JTextField setNomPlayerField;
    private JLabel setNomPlayerLabel;

    private JButton lancerPartie;
    private JButton rejoindrePartieButton;
    private JTextField rejoindrePartieTextField;


    private JButton rules;
    private JButton credits;
    private JButton quitterJeu;


    boolean accepte;


    public PanelSecondMenu(String titre) {
        super(titre);

        // mise en page des différents JComponents
        panelPrincipal = new JPanel(new BorderLayout());
        this.setContentPane(panelPrincipal);
        this.setMinimumSize(new Dimension(560, 420));
        this.setMaximizedBounds(new Rectangle(0, 0, 560, 420));
        this.setLocationRelativeTo(null);

        /*PARTIE DROITE*/
        JPanel partieDroite = new JPanel(new BorderLayout());
        JPanel PartieDroite_Info = new JPanel(new GridLayout(1, 2));
        JPanel partieDroite_Info_Joueur = new JPanel();
        partieDroite_Info_Joueur.setLayout(new BoxLayout(partieDroite_Info_Joueur, BoxLayout.Y_AXIS));
        idjoueurTitre = new JLabel("Pseudo du Joueur :               "); //Pour espacer un peu les boutons
        //idjoueur = new JLabel(Player.getName());
        idjoueur = new JLabel(""); //Exemple pour voir ce que ca donne

        setNomPlayerField = new JTextField("");//Faire un event pour retirer cette valeur si l'un clique dedans
        setNomPlayerLabel = new JLabel("Changement de Pseudo : ");
        /*On ajoute tous nos composants dans les bonnes parties*/
        /*Ajout dans la partie "Joueur" du panneau d'information*/
        partieDroite_Info_Joueur.add(idjoueurTitre);
        partieDroite_Info_Joueur.add(idjoueur);
        partieDroite_Info_Joueur.add(new JLabel(" ")); // Petit Espace
        partieDroite_Info_Joueur.add(setNomPlayerLabel);
        partieDroite_Info_Joueur.add(setNomPlayerField);
        partieDroite_Info_Joueur.add(new JLabel(" ")); //Autre Petit Espace

        /*Ajout des 2 dans la partie "Information"*/
        PartieDroite_Info.add(partieDroite_Info_Joueur);

        /*Ajout à la partie droite*/
        partieDroite.add(PartieDroite_Info, BorderLayout.NORTH);


        /*Création des boutons*/
        lancerPartie = new JButton("Lancer une Partie");
        rejoindrePartieButton = new JButton("Rejoindre une partie déjà créée");
        rejoindrePartieTextField = new JTextField("");

        rules = new JButton("Règles");
        credits = new JButton("Crédits");
        quitterJeu = new JButton("Quitter le jeu");

        /*Création d'espace vide pour la lisibilité et le confot visuel*/
        JPanel espace10 = new JPanel(new FlowLayout());
        espace10.setBorder(new EmptyBorder(0,0,0,0));
        JPanel espace11 = new JPanel(new FlowLayout());
        espace11.setBorder(new EmptyBorder(0,0,0,0));
        JPanel espace12 = new JPanel(new FlowLayout());
        espace12.setBorder(new EmptyBorder(0,0,0,0));
        JPanel espace13 = new JPanel(new FlowLayout());
        espace13.setBorder(new EmptyBorder(0,0,0,0));


        JPanel partieDroite_Menu_Boutons = new JPanel();
        partieDroite_Menu_Boutons.setLayout(new GridLayout(12,1)); /*Grille pour afficher des boutons tous de la meme taille*/
        /*Ajout des boutons dans l'espace reservé*/
        partieDroite_Menu_Boutons.add(lancerPartie);
        partieDroite_Menu_Boutons.add(espace10);
        partieDroite_Menu_Boutons.add(rejoindrePartieButton);
        partieDroite_Menu_Boutons.add(rejoindrePartieTextField);
        partieDroite_Menu_Boutons.add(espace11);
        partieDroite_Menu_Boutons.add(rules);
        partieDroite_Menu_Boutons.add(espace12);
        partieDroite_Menu_Boutons.add(credits);
        partieDroite_Menu_Boutons.add(espace13);
        partieDroite_Menu_Boutons.add(quitterJeu);
        partieDroite_Menu_Boutons.setBorder(new EmptyBorder(25,25,25,25)); //Petit Espace
        /*Fin de la partie "Bouton" de la partie droite*/

        partieDroite.add(partieDroite_Menu_Boutons, BorderLayout.SOUTH);
        panelPrincipal.add(partieDroite);
    }

    public void erreurMessage(String s) {
        JOptionPane.showMessageDialog(this, s, "Erreur", JOptionPane.ERROR_MESSAGE);
    }
    /**
     * setter du idJoueur
     *
     * @param nom est le pseudo à afficher
     */
    public void setIdjoueur(String nom) {
        idjoueur.setText(nom);
    }

    /**
     * setter du idJoueurField
     *
     * @param nom est le pseudo à afficher
     */
    public void setSetNomPlayerField(String nom) {setNomPlayerField.setText(nom);}

    /**
     * getter du idJoueurField
     */
    public String getIdjoueurField() {return setNomPlayerField.getText();}

    /**
     * ajout un Key Listener sur le field
     *
     * @param action le listener à ajouter
     */
    public void fixeListenerChangementPseudoField(KeyListener action){
        setNomPlayerField.addKeyListener(action);
    }

    public void fixeListenerRuleBouton(ActionListener action){
        rules.addActionListener(action);
    }
    public void fixeListenerCreditsBouton(ActionListener action){
        credits.addActionListener(action);
    }
    public void settingsPopUp(String s) {
        JOptionPane.showMessageDialog(this, s, "Règles", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * ajout un Key Listener sur le field
     *
     * @param action le listener à ajouter
     */
    public void fixeListenerChangementPseudoField2(KeyListener action){
        setNomPlayerField.addKeyListener(action);
    }

    /**
     * ajout un Action listener sur le mode BL
     *
     * @param action le listener à ajouter
     */
    public void fixeListenerLancerPartie(ActionListener action){
        lancerPartie.addActionListener(action);
        rejoindrePartieButton.addActionListener(action); }

    public void fixeListenerPourLancer(ActionListener actionListener) {lancerPartie.addActionListener(actionListener);
    }
    public void fixeListenerPourRejoindre(ActionListener actionListener){ rejoindrePartieButton.addActionListener(actionListener); }
    public String getnum(){
        return rejoindrePartieTextField.getText();
    }
    public void creditsPopUp(String s) {
        JOptionPane.showMessageDialog(this, s, "Crédits", JOptionPane.INFORMATION_MESSAGE);
    }

    public void fixeListenerQuitterJeu(ActionListener action) { quitterJeu.addActionListener(action);
    }

    public boolean isAccepte() {
        return accepte;
    }

    public void setAccepte(boolean b){
        accepte = b;
    }
}
