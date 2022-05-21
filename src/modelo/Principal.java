package modelo;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    

    public static void main(String[] args)  {
       boolean opcion = true;
       int deseo = 0;
       Scanner sc = new Scanner(System.in);
        Caja caja = new Caja();
        Pokemon pokemon1 = new Pokemon();
        Pokemon pokemon2 =new Pokemon();
        pokemon1 = Pokemon.generarPokemon();
        pokemon2 = Pokemon.generarPokemon();
        
            System.out.println(pokemon1.atacar(pokemon2));
           
        
        
    }


}
