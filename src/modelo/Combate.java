package modelo;

import java.util.LinkedList;
import java.util.List;

import controladores.TestController;
import controladores.TestController2;

public class Combate {

	private Entrenador entrenador;
	private Entrenador rival;
	private List<Turno> combate;
	private String ganador;
	private int numKO1;
	private int numKO2;
	
	
	public Combate() {
		super();
		entrenador = new Entrenador();
		rival = new Entrenador();
		combate = new LinkedList<Turno>();
		ganador = "";
		numKO1 = 0;
		numKO2 = 0;
	}
	
	public Combate(Entrenador entrenador, Entrenador rival, List<Turno> combate, String ganador, int numKO1,
			int numKO2) {
		super();
		this.entrenador = entrenador;
		this.rival = rival;
		this.combate = combate;
		this.ganador = ganador;
		this.numKO1 = numKO1;
		this.numKO2 = numKO2;
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

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
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
		
		this.ganador = rival.getNombre();
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
		
		if (ganador.equals(entrenador.getNombre())){
			
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
				ganarExp(pokemonEntrenador, pokemonRival);
			}

			if(accionRival == pokemonRival.getNombre()+" MUERTO"){
				numKO2++;
				j++;
			}

			numTurno++;

			combate.add(turno);

			if(numKO1 == 4 || numKO2 == 4){

				finalizar = true;

			}

		}while(finalizar == false);

		if(numKO1 == 4){
			this.ganador = rival.getNombre();

		}else{
			this.ganador = entrenador.getNombre();
		}

		pagar();

		return "El ganador es: "+ this.ganador;
	}

	
}
