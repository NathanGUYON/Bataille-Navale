package info1.ships;

import java.util.*;
import java.util.List;
import static java.lang.Character.getNumericValue;

/**
 * une implementation de l'interface ICoord manipulant des coordonnées alphanumériques comme "A1", "B6", "J3", etc.
 */

public class Coord implements ICoord {
    
    private int x = 1;
    private int y;
    private char AlphaX;
    private List<Character> CharList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J');
    private List<Character> NumList = Arrays.asList('0','1','2','3','4','5','6','7','8','9');


    /**
     * NB : LA SIGNATURE DU CONSTRUCTEUR DOIT ETRE RESPECTEE
     *
     * constructeur d'un objet Coord
     * @param xy la coordonnée alphanumérique sous la forme d'une chaine de caractères
     * @throws BadCoordException si la chaine de caractère ne permet pas de définir une coordonnée alphanumérique
     */
    public Coord(String xy) throws BadCoordException {
        if (CharList.contains(xy.charAt(0))){ this.AlphaX = xy.charAt(0); //Retourne le caractère pris dans xy si c'est bien une lettre entre A et J
        } else { throw new BadCoordException(); }

        this.x = x + CharList.indexOf(AlphaX);  //Retourne la valeur numérique de AlphaX

        if ((xy.length() == 3)){
            if ((getNumericValue(xy.charAt(1)) == 1) && (getNumericValue(xy.charAt(2)) == 0) && (NumList.contains(xy.charAt(1))) && (NumList.contains(xy.charAt(2)))) {
                this.y = 10;
            } else {throw new BadCoordException();}
        } else if ((getNumericValue(xy.charAt(1)) != 0) && (xy.length() == 2) && (NumList.contains(xy.charAt(1)))) {
            this.y = getNumericValue(xy.charAt(1));
        } else { throw new BadCoordException();}  //Retourne le nombre pris dans xy s'il est compris entre 1 et 10 et envoie une exception si c'est autre chose (autre nombre ou caractère)

    }

    @Override
    public char getAlphaX() {
        return this.AlphaX;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "" + AlphaX + y + ""; //Retourne la coordonnée
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x &&
                y == coord.y &&
                AlphaX == coord.AlphaX;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, AlphaX);
    }

}
