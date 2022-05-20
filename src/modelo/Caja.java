package modelo;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Caja {

    private List<Pokemon> listPokemon;

    public Caja() {
        this.listPokemon = new LinkedList<Pokemon>();
    }

    public Caja(Pokemon pokemon, List<Pokemon> listPokemon) {
        this.listPokemon = listPokemon;
    }

	public List<Pokemon> getListPokemon() {
		return listPokemon;
	}

	public void setListPokemon(List<Pokemon> listPokemon) {
		this.listPokemon = listPokemon;
	}

	public String toString() {
		return "Caja [listPokemon=" + listPokemon + "]";
	}

}
