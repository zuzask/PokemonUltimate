package modelo;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import controladores.TestController;
import controladores.TestController2;

public class Combat {

	private int idCombate; 
	private Entrenador entrenador;
	private Entrenador rival;
	private List<Turno> combate;
	private int idGanador;
	private int numKO1;
	private int numKO2;
	
	
	public Combat() {
		super();
		idCombate = 0;
		entrenador = new Entrenador();
		rival = new Entrenador();
		combate = new LinkedList<Turno>();
		idGanador = 0;
		numKO1 = 0;
		numKO2 = 0;
	}
	
	public Combat(int idCombate, Entrenador entrenador, Entrenador rival, List<Turno> combate, int idGanador, int numKO1,
			int numKO2) {
		super();
		this.idCombate = idCombate;
		this.entrenador = entrenador;
		this.rival = rival;
		this.combate = combate;
		this.idGanador = idGanador;
		this.numKO1 = numKO1;
		this.numKO2 = numKO2;
	}

	

	public int getIdCombate() {
		return idCombate;
	}

	public void setIdCombate(int idCombate) {
		this.idCombate = idCombate;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public Entrenador getRival() {
		return rival;
	}

	public void setRival(Entrenador rival) {
		this.rival = rival;
	}

	public List<Turno> getCombate() {
		return combate;
	}

	public void setCombate(List<Turno> combate) {
		this.combate = combate;
	}

	public int getIdGanador() {
		return idGanador;
	}

	public void setIdGanador(int idGanador) {
		this.idGanador = idGanador;
	}

	public int getNumKO1() {
		return numKO1;
	}

	public void setNumKO1(int numKO1) {
		this.numKO1 = numKO1;
	}

	public int getNumKO2() {
		return numKO2;
	}

	public void setNumKO2(int numKO2) {
		this.numKO2 = numKO2;
	}
	
	public void rendirse(Entrenador rival) {
		
		this.idGanador = rival.getIdEntrenador();
	}
	
	public void ganarExp(Pokemon pokemonVencedor,Pokemon pokemonDerrotado) {
		
		int gananciaExp;
		gananciaExp = pokemonVencedor.getNivel() + (pokemonDerrotado.getNivel()*10)/4;
		
		pokemonVencedor.setExp(gananciaExp + pokemonVencedor.getExp());
		
		while(pokemonVencedor.getExp() >= 10 * pokemonVencedor.getNivel()) {
		pokemonVencedor.subirNivel();
		pokemonVencedor.setExp(pokemonVencedor.getExp() - (10 * pokemonVencedor.getNivel()));
		}
		
	}
		
	
	public void pagar() {
		
		int dineroPagar;
		
		if (idGanador == entrenador.getIdEntrenador()){
			
			dineroPagar = (rival.getPokedollar()) / 3 ;
			entrenador.setPokedollar(entrenador.getPokedollar() + dineroPagar);
			rival.setPokedollar(rival.getPokedollar() - dineroPagar);
			System.out.println(entrenador.getNombre() + " ha recibido "+ dineroPagar+ " de "+ rival.getNombre());
			
		}else {
			dineroPagar = (entrenador.getPokedollar()) / 3 ;
			rival.setPokedollar(rival.getPokedollar() + dineroPagar);
			entrenador.setPokedollar(entrenador.getPokedollar() - dineroPagar);
			System.out.println(rival.getNombre() + " ha recibido "+ dineroPagar+ " de "+ entrenador.getNombre());
		}
		
		
	}
	
	public String combatir() {
		
		Combat batalla;
		boolean finalizar = false;
		Pokemon equipoEntrenador[] = entrenador.getEquipo();
		Pokemon equipoRival[] = rival.getEquipo();
		Pokemon pokemonEntrenador = new Pokemon();
		Pokemon pokemonRival = new Pokemon();
		int i = 0;
		int j = 0;
		int numTurno = 0;
		String accionEntrenador = "";
		String accionRival = "";
		String ganador;
		Turno turno = new Turno(numTurno, accionEntrenador, accionRival);

		do{
			 pokemonEntrenador = equipoEntrenador[i];
			 pokemonRival = equipoRival[j];

			if (pokemonEntrenador.getVelocidad() >= pokemonRival.getVelocidad()){

				accionEntrenador = pokemonEntrenador.atacar(pokemonRival);
			
				accionRival = pokemonRival.atacaqueRival(pokemonEntrenador);


			}else{

				accionRival = pokemonRival.atacaqueRival(pokemonEntrenador);

				accionEntrenador = pokemonEntrenador.atacar(pokemonRival);

			}

			if(accionEntrenador == pokemonEntrenador.getNombre()+" MUERTO"){
				numKO1++;
				i++;
			}
			
			if(accionRival == pokemonRival.getNombre()+" MUERTO"){
				numKO2++;
				j++;
				ganarExp(pokemonEntrenador, pokemonRival);
			}

			numTurno++;

			combate.add(turno);

			if(numKO1 == 4 || numKO2 == 4){

				finalizar = true;

			}

		}while(finalizar == false);

		batalla = new Combat(this.idCombate, entrenador, rival, this.combate, this.idGanador, this.numKO1, this.numKO2);

		try {
			DbConexion.insertarCombate(batalla, entrenador.getIdEntrenador(), rival.getIdEntrenador());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(numKO1 == 4){
			this.idGanador = rival.getIdEntrenador();
			ganador = rival.getNombre();
		}else{
			this.idGanador = entrenador.getIdEntrenador();
			ganador = entrenador.getNombre();
		}

		pagar();

		return "El ganador es: "+ ganador;
	}

	
}
