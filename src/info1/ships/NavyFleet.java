package info1.ships;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe définissant une flotte de navires
 */

public class NavyFleet implements INavyFleet {

    static ArrayList<IShip> list ;
    static int taille;
    static ArrayList<ICoord> listcord;
    /**
     * NB : LA SIGNATURE DU CONSTRUCTEUR DOIT ETRE RESPECTEE
     *
     * Construit une nouvelle flotte
     */
    public NavyFleet() {
        list = new ArrayList<>();
        taille = 20;
        listcord = new ArrayList<>();
    }

    @Override
    public int remainingSize() {
        return taille;
    } //retourne la taille restante (entre 0 et 20) selon les bateaux placés

    @Override
    public boolean isComplete() {
        return taille == 0;
    } // Retourne true si tous les bateaux sont placés; false sinon


    @Override
    public int add(IShip IShip) {  //Ajout d'un bateau dans la flotte
        if (list.contains(IShip)){
            return -1;
        }
        if (IShip.getSize() > taille) {
            return -2;
        }
        boolean déjala = false;
        for (ICoord i : IShip.getCoords()) {
            if (listcord.contains(i)){
                déjala = true;
            }
        }
        if (déjala){
            return -3;
        }


        listcord.addAll(IShip.getCoords());
        list.add(IShip);
        taille = taille - IShip.getSize();
        return 0;
    }

    @Override
    public List<IShip> getShips() { //Renvoie une liste triée de la flotte
        list.sort(null);
        return list;
    }

    @Override
    public Set<IShip> getShips(ShipCategory shipCategory) { //Renvoie les bateaux d'une catégorie donnée
        Set<IShip> list2 = new HashSet<>();
        for (IShip i : list) {
            if (i.getCategory().equals(shipCategory)){
                list2.add(i);
            }
        }
        return list2;
    }

    @Override
    public boolean isBelgianConfiguration() { //Vérifie si la flotte est en configuration belge ou non
        boolean good = true;
        if (isComplete()){
            if (this.getShips(ShipCategory.SUBMARINE).size() != 4 ){
                good = false;
            }
            if (this.getShips(ShipCategory.DESTROYER).size() != 3 ){
                good = false;
            }
            if (this.getShips(ShipCategory.CRUISER).size() != 2 ){
                good = false;
            }
            if (this.getShips(ShipCategory.BATTLESHIP).size() != 1 ){
                good = false;
            }
            if (this.getShips(ShipCategory.AIRCRAFT_CARRIER).size() != 0 ){
                good = false;
            }
            return good;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFrenchConfiguration() { //Vérifie si la flotte est en configuration française ou non
        boolean good = true;
        if (isComplete()){
            if (this.getShips(ShipCategory.SUBMARINE).size() != 1 ){
                good = false;
            }
            if (this.getShips(ShipCategory.DESTROYER).size() != 2 ){
                good = false;
            }
            if (this.getShips(ShipCategory.CRUISER).size() != 2 ){
                good = false;
            }
            if (this.getShips(ShipCategory.BATTLESHIP).size() != 1 ){
                good = false;
            }
            if (this.getShips(ShipCategory.AIRCRAFT_CARRIER).size() != 1 ){
                good = false;
            }
            return good;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
