package modelo;

public class Principal {
    

    public static void main(String[] args)  {

        DbConexion.establecerConexion();
        Pokemon pokemon = new Pokemon();
        

        pokemon = Pokemon.generarPokemon();


        System.out.println(pokemon.mostrarPokemon());


        DbConexion.cerrarConexion();
    }


}
