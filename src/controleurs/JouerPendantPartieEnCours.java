package controleurs;

import com.mashape.unirest.http.exceptions.UnirestException;
import info1.network.BadIdException;
import info1.network.Game;
import info1.network.Network;
import info1.network.Player;
import info1.ships.Coord;
import info1.ships.IShip;
import info1.ships.NavyFleet;
import info1.ships.Ship;
import modele.Case;
import vue.FenetreBatailleNaval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JouerPendantPartieEnCours implements ActionListener {
    private FenetreBatailleNaval fn;
    static Game jeu;
    private Player nomjouer;
    static ArrayList<String> list = new ArrayList();


    public JouerPendantPartieEnCours(FenetreBatailleNaval nfn, Game njeu , Player nnomjouer){
        fn = nfn;
        jeu = njeu;
        nomjouer = nnomjouer;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        fn.setEnCours(true);
        if (jeu != null) {
            String coorde;
            try {
                coorde = fn.getCoordCase().toString();
                Case c = fn.getCoordCase();
                String HTTP_LOCALHOST = "http://37.187.38.219/api/v0";
                Network.setProxy("srv-proxy-etu-2.iut-nantes.univ-nantes.prive", 3128); //à décommenter si vous êtes sur les PC de l'IUT, à mettre en commentaire si vous êtes sur votre PC perso
                Network.enableProxy(true); //à décommenter si vous êtes sur les PC de l'IUT, à mettre en commentaire si vous êtes sur votre PC perso
                try {
                    if (Network.getInfo(HTTP_LOCALHOST, jeu, nomjouer) == 10 && coorde != null && list.contains(coorde) == false) {
                        try {
                            int enfonctiondelaaction = Network.playOneTurn(HTTP_LOCALHOST, jeu, nomjouer, new Coord(coorde));
                            System.out.println(enfonctiondelaaction);
                            if (enfonctiondelaaction == -10) {
                                JOptionPane.showMessageDialog(fn, "pasmontours", "erreur", JOptionPane.ERROR_MESSAGE);
                            }
                            if (enfonctiondelaaction == 0) {
                                fn.changerc2(c, Color.BLUE);
                                JOptionPane.showMessageDialog(fn, "Dommage c'est raté");
                            }
                            if (enfonctiondelaaction == 1) {
                                JOptionPane.showMessageDialog(fn, "Bateau adverse touché ");
                                fn.changerc2(c, Color.ORANGE);
                            }
                            if (enfonctiondelaaction == 10) {
                                JOptionPane.showMessageDialog(fn, "Bateau adverse coulé ");
                                fn.changerc2(c, Color.RED);
                            }
                            if (enfonctiondelaaction == 100) {
                                System.out.println("YOU WIN");
                                JOptionPane.showMessageDialog(fn, "YOU WIN ");
                            }
                            list.add(coorde);
                            System.out.println("tire");
                            fn.disablecorde(c);

                        } catch (Exception e1) {
                            System.out.println("Coordonnée inexistante");
                            JOptionPane.showMessageDialog(fn, "coordonnée inexistante", "erreur", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        //JOptionPane.showMessageDialog(fn, "stop", "erreur", JOptionPane.ERROR_MESSAGE);

                    }
                } catch (UnirestException unirestException) {
                    unirestException.printStackTrace();
                } catch (BadIdException badIdException) {
                    badIdException.printStackTrace();
                }
            } catch (HeadlessException headlessException) {
                headlessException.printStackTrace();
            }
        }
        }
        }

