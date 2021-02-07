package pl.codegym.task.task15.task1522;

// import pl.codegym.task.task15.task1529.Plane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Praca nad wzorcem projektowym singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String planeta = null;
        try{
            String linia;
            while (!((linia = bf.readLine()) == null)){
                planeta = linia;
                bf.close();
            }
        } catch (IOException e){
        }

        // tworzenieObiektuZgodnegoZWprowadzonymStringiem
        if (planeta.equals(Planet.SUN)){
            thePlanet = (Sun) Sun.getInstance();
        } else if (planeta.equals(Planet.EARTH)){
            thePlanet = (Earth) Earth.getInstance();
        } else if (planeta.equals(Planet.MOON)){
            thePlanet = (Moon) Moon.getInstance();
        } else {
            thePlanet = null;
        }


    }
}
