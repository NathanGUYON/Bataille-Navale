package info1.ships;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * une implémentation "abstraite" d'un bateau quelconque, de taille indéterminée
 */


public abstract class Ship implements IShip {

    private String name;
    private String ayFront;
    private String ayBack;



    /**
     * NB : LA SIGNATURE DU CONSTRUCTEUR DOIT ETRE RESPECTEE
     *
     * construit un bateau quelconque
     * @param name le nom du bateau
     * @param ayFront la coordonnée de la proue du bateau
     * @param ayBack la coordonnée de la poupe du bateau
     * @throws BadCoordException si l'une des coordonnées données ne définit pas une coordonnée alphanumérique correcte
     * @throws CoordsBadShipException si les coordonnées données ne permettent pas de définir un bateau correct :
     *  une ligne, une colonne, de la bonne taille, etc.
     */
    public Ship(String name, String ayFront, String ayBack)
            throws BadCoordException, CoordsBadShipException {




        String listedelettrepossible = "ABCDEFGHIJ";  //je fais une liste de toutes les valeurs possible pour le premier char
        String char2 = "123456789";         //je fais une liste de toutes les valeurs possible pour le second char
        String s1 = "" + ayFront.charAt(0); //je recupère sous format de string le premiers char de ayFront
        String s2 = "" + ayFront.charAt(1); //idem avec le 2ème
        String s11 = "" + ayBack.charAt(0);//idem avec ayBack
        String s12 = "" + ayBack.charAt(1);

        if ((s1.equals(s11) == false) && (s2.equals(s12) == false)){
            throw new CoordsBadShipException();
        }


        if (listedelettrepossible.contains(s1) == false || char2.contains(s2) == false || ayFront.length() > 3 || listedelettrepossible.contains(s11) == false
                || char2.contains(s12) == false || ayBack.length() > 3){  // je regarde si aucune des 2 coordonnées n'est pas inexistante ou de trop grande taille
            throw new BadCoordException();
        }
        if (ayFront.length() == 3){ //si jamais il y a plus de 3 caractères je regarde pour savoir si c'est un 10 (le plateau allant de 1 à 10 seul les coordonnées ayant un 10 auront 3 char
            String s3 = "" + ayFront.charAt(2);
            if (s3.equals("0") == false)
                throw new BadCoordException();
        }
        if (ayBack.length() == 3){   //idem
            String s13 = "" + ayBack.charAt(2);
            if (s13.equals("0") == false)
                throw new BadCoordException();
        }

        int tailleattendu = this.getCategory().getSize() -1;  //je regarde la taille attendue je fais -1 car je commencerai à compter à partir de 0
        int depart;
        int arriver;
        if (s1.equals(s11) == false) {  //je regarde en colome
            depart = listedelettrepossible.indexOf(s1); //je regarde la position du premier char dans la liste des lettres possible
            arriver = listedelettrepossible.indexOf(s11); //je regarde la position du dernier char dans la liste des lettres possible
            if (depart > arriver) {  //si le premier char est plus grand que le dernier ( je fait ça pour éviter les valeurs négatives)
                if (depart - arriver != tailleattendu){   //je regarde si c'est la taille attendue
                    throw new CoordsBadShipException();
                }
            } else {
                if (arriver - depart != tailleattendu) {
                    throw new CoordsBadShipException();
                }
            }
        } else {  //je regardes en lignes
            String lenombreback = ayBack.substring(1);
            String lenombreFront = ayFront.substring(1);
            depart = Integer.parseInt(lenombreback); //je convertie les cordonnées en int
            arriver = Integer.parseInt(lenombreFront);
            if (depart > arriver) {     //pour les 2 sens                                     
                if (depart - arriver != tailleattendu) {
                    throw new CoordsBadShipException();
                }
            } else {
                if (arriver - depart != tailleattendu) {
                    throw new CoordsBadShipException();
                }
            }
        }

//le constructeur
        this.name = name;
        this.ayFront = ayFront;
        this.ayBack = ayBack;
    }

    //liste des coordoné occupé
    @Override
    public List<ICoord> getCoords() {
        List<ICoord> list = new ArrayList<>();
        try {  //try catch pour gérer les expetion
            boolean toutdroit = true;  //pour le sens du bateau
            ICoord font = new Coord(ayFront);
            ICoord back = new Coord(ayBack);  //coordonnées de deb et de fin
            String finall = "";

            if (back.getAlphaX() != font.getAlphaX()){  //je regarde en ligne
                String listedelettrepossible = "ABCDEFGHIJ";
                int place = listedelettrepossible.indexOf(font.getAlphaX());
                int place2 = listedelettrepossible.indexOf(back.getAlphaX());  //je regarde où se situe les lettres
                if (place2 - place < 0) {   //je regarde le "sens" du bateau
                    toutdroit = false;
                }
                String nombre = "" + font.getY();
                for (int i = 0;i<this.getSize();i++){ //je trouve toutes les coordonnées
                    if (toutdroit == true) {
                        finall = "" + listedelettrepossible.charAt(place) + nombre;
                        ICoord ncord = new Coord(finall); //je crée une coordonnée
                        list.add(ncord);
                        place = place + 1;
                    } else {
                        finall = "" + listedelettrepossible.charAt(place) + nombre;
                        ICoord ncord = new Coord(finall);
                        list.add(ncord);
                        place = place - 1;
                    }
                }
            } else {  //je regarde en colonne
                String lettre = "" + font.getAlphaX();
                int deb = font.getY();
                int ariv = back.getY();
                int place = deb;
                if (ariv - deb < 0 ){
                    toutdroit = false;
                }
                for (int i = 0;i<this.getSize();i++) {
                    if (toutdroit == true) {
                        finall = lettre + place;
                        ICoord ncord = new Coord(finall);
                        list.add(ncord);
                        place = place +1;
                    } else {
                        finall = lettre + place;
                        ICoord ncord = new Coord(finall);
                        list.add(ncord);
                        place = place -1;
                    }
                }
            }


            return list;
        } catch (BadCoordException e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public ICoord getFront() {
        try {
            ICoord c = new Coord(ayFront);
            return c;
        } catch (BadCoordException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ICoord getBack() {
        try {
            ICoord c = new Coord(ayBack);
            return c;
        } catch (BadCoordException e) {
            e.printStackTrace();
            return null;
        }    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.getCategory().getSize();
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", ayFront='" + ayFront + '\'' +
                ", ayBack='" + ayBack + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return Objects.equals(name, ship.name) &&
                Objects.equals(ayFront, ship.ayFront) &&
                Objects.equals(ayBack, ship.ayBack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ayFront, ayBack);
    }
}
