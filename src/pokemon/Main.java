package pokemon;

public class Main {

     public static void main(String[] args) {


        Pokemon pokemon = new Pokemon();

        DbConexion.establecerConexion();

        pokemon = Pokemon.generarPokemon();      

        
        DbConexion.cerrarConexion();
        System.out.println(pokemon.mostrarPokemon());
    }
    
}
