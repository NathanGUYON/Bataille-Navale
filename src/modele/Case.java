package modele;

import javax.swing.*;

public class Case { //Classe qui gère chaque case de la grille

    private int abscisse;
    private char ordonnee;
    private JButton bouton;
    private boolean occupe;

    public Case(int a, char o, JButton b){ //crée une case avec des coordonnées et un bouton assigné
        abscisse = a;
        ordonnee = o;
        bouton = b;
    }
    public Case(int a, char o){ //crée une case avec des coordonnées, sans bouton assigné
        abscisse = a;
        ordonnee = o;
        bouton = null;
    }

    public int getAbscisse() {
        return abscisse;
    } //retourne l'abscisse de la position de la case

    public char getOrdonnee() {
        return ordonnee;
    } //retourne l'ordonnée de la position de la case

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    } //met l'abscisse à la valeur passée en paramètre

    public void setOrdonnee(char ordonnee) {
        this.ordonnee = ordonnee;
    }//met l'ordonnée à la valeur passée en paramètre

    public JButton getBouton() {
        return bouton;
    } //retourne le bouton associé à la case

    public void setOccupe(boolean b) {
        this.occupe = b;
    } //définit l'état (occupé ou non) de la case

    public boolean isOccupe() {
        return occupe;
    } //retourne l'état (occupé ou non) de la case

    public String toString(){
        String res = ordonnee+String.valueOf(abscisse);
        return res;}
}
