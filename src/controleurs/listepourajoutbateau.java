package controleurs;

import info1.ships.NavyFleet;
import info1.ships.Ship;

public class listepourajoutbateau { //Classe pour créer une flotte
static NavyFleet f = null;
public listepourajoutbateau(){
    f = new NavyFleet();
}
public boolean addbateau(Ship s){
    int état;
    état = f.add(s);
    if (état != 0){
        return false;
    }
    return true;
}
public NavyFleet getliste(){
    return f;
}
public void clear(){
    f = new NavyFleet();
}
}
