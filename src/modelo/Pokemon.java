package modelo;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Pokemon {

	public static final int NEUTRO = 0;
	public static final int VENTAJA = 1;
	public static final int DESVENTAJA = -1;

	private String nombre;
	private int numPokedex;
	private int numPokemon;
	private String mote;
	private int vitalidad;
	private int ataque;
	private int defensa;
	private int ataqueEspecial;
	private int defensaEspecial;
	private int velocidad;
	private int estamina;
	private int nivel;
	private Movimientos kitMov[];
	private Tipo tipo;
	private Estado estado;
	private int exp;

	public Pokemon() {

		super();
		this.nombre = "";
		this.numPokedex = 0;
		this.numPokemon = 0;
		this.mote = "";
		this.vitalidad = 0;
		this.ataque = 0;
		this.defensa = 0;
		this.ataqueEspecial = 0;
		this.defensaEspecial = 0;
		this.velocidad = 0;
		this.estamina = 0;
		this.nivel = 0;
		this.kitMov = new Movimientos[4];
		this.estado = Estado.SIN_ESTADO;
		this.exp = 0;
	}

	public Pokemon(String nombre,int numPokedex, int numPokemon,String mote, int vitalidad, int ataque, int defensa, int ataqueEspecial,
			int defensaEspecial, int velocidad, int estamina, int nivel, Movimientos[] kitMov, Tipo tipo, Estado estado,
			int exp) {

		super();
		this.nombre = nombre;
		this.numPokedex = numPokedex;
		this.numPokemon = numPokemon;
		this.mote = mote;
		this.vitalidad = vitalidad;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.estamina = estamina;
		this.nivel = nivel;
		this.kitMov = kitMov;
		this.tipo = tipo;
		this.estado = estado;
		this.exp = exp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumPokedex() {
		return numPokedex;
	}

	public void setNumPokedex(int numPokedex) {
		this.numPokedex = numPokedex;
	}

	public int getNumPokemon() {
		return numPokemon;
	}

	public void setNumPokemon(int numPokemon) {
		this.numPokemon = numPokemon;
	}

	public String getMote() {
		return mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
	}

	public int getVitalidad() {
		return vitalidad;
	}

	public void setVitalidad(int vitalidad) {
		this.vitalidad = vitalidad;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}

	public void setAtaqueEspecial(int ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}

	public int getDefensaEspecial() {
		return defensaEspecial;
	}

	public void setDefensaEspecial(int defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getEstamina() {
		return estamina;
	}

	public void setEstamina(int estamina) {
		this.estamina = estamina;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Movimientos[] getKitMov() {
		return kitMov;
	}

	public void setKitMov(Movimientos[] kitMov) {
		this.kitMov = kitMov;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void subirNivel() {

			this.nivel++;

			this.vitalidad = this.vitalidad + ((int)Math.floor(Math.random()*(0-5)+6));
			this.ataque = this.ataque + ((int)Math.floor(Math.random()*(0-5)+6));
			this.defensa = this.defensa + ((int)Math.floor(Math.random()*(0-5)+6));
			this.ataqueEspecial = this.ataqueEspecial + ((int)Math.floor(Math.random()*(0-5)+6));
			this.defensaEspecial = this.defensaEspecial + ((int)Math.floor(Math.random()*(0-5)+6));
			this.velocidad = this.velocidad + ((int)Math.floor(Math.random()*(0-5)+6));
			this.estamina = this.estamina + ((int)Math.floor(Math.random()*(0-5)+6));

	}

	public void ataqueNuevo() {
	
		Scanner sc = new Scanner(System.in);

		Movimientos nuevoMovimiento = Movimientos.generarMovimientos();
		int opcion;
		boolean check = false;
		String respuesta;

		if (this.nivel % 3 == 0) {

			System.out.println("???Deseas aprender este ataque? (s/n)");
			System.out.println(nuevoMovimiento.getNombre());

			respuesta = sc.nextLine();

			if (respuesta == "s") {

				do {

					System.out.println("Elige el ataque que quieres sustituir (1-4): ");

					for (int i = 0; i < kitMov.length; i++) {

						System.out.println(kitMov[i] + " " + i + 1);
					}

					opcion = sc.nextInt();

					if (opcion >= 1 && opcion <= 4) {
						check = true;

					}
				} while (check == false);

				kitMov[opcion - 1] = nuevoMovimiento;

				System.out.println("Sustituci??n ejecutada exitosamente");

			}
		}

		sc.close();

	}

	public String atacar(Pokemon pkRival) {

		Scanner sc = new Scanner(System.in);

		MovAtaque ataque = new MovAtaque();
		MovEstado estado = new MovEstado();
		MovMejora mejora = new MovMejora();
		int potenciaTotal = ((int) Math.floor(Math.random() * (1 - 100 + 1) + 100));
		String accion = "";

		int opcion;
		boolean check = false;

		if(comprobarCondicion() == 0){

			do {

				System.out.println("Elige el ataque (1-4): ");

				for (int i = 0; i < this.kitMov.length; i++) {

					if (this.kitMov[i] != null) {
						System.out.println(this.kitMov[i].getNombre() + " " + (i + 1));
					} else {
						System.out.println("Sin movimiento.");
					}
				}

				opcion = sc.nextInt();

				if (opcion >= 1 && opcion <= 4) {
					check = true;

				}
			} while (check == false);

			if (this.kitMov[opcion - 1] instanceof MovAtaque) {

				ataque = (MovAtaque) kitMov[opcion - 1];

				if (this.estamina - ataque.calculoConsumo() >= 0) {

					switch (ataque.getFormaAtaque()) {

					case MovAtaque.FISICO:

						if (ataque.getTipo() == Tipo.NORMAL || ataque.getTipo() != this.tipo) {

							potenciaTotal = (this.ataque * ataque.getPotenciaAtaque()) - pkRival.getDefensa();
						}
						if (this.tipo == ataque.getTipo() && ataque.getTipo() != Tipo.NORMAL) {

							potenciaTotal = (this.ataque * 3 * ataque.getPotenciaAtaque() / 2) - pkRival.getDefensa();
						}

						if (comprobarVentaja(ataque, pkRival) == DESVENTAJA) {

							potenciaTotal = potenciaTotal * 1 / 2;
						}
						if (comprobarVentaja(ataque, pkRival) == VENTAJA) {

							potenciaTotal = potenciaTotal * 3 / 2;
						}
						break;
						
					case MovAtaque.ESPECIAL:

						if (ataque.getTipo() == Tipo.NORMAL || ataque.getTipo() != this.tipo) {

							potenciaTotal = (this.ataque * ataque.getPotenciaAtaque()) - pkRival.getDefensa();
						}
						if (this.tipo == ataque.getTipo() && ataque.getTipo() != Tipo.NORMAL) {

							potenciaTotal = (this.ataque * 3 * ataque.getPotenciaAtaque() / 2) - pkRival.getDefensa();
						}

						if (comprobarVentaja(ataque, pkRival) == DESVENTAJA) {

							potenciaTotal = potenciaTotal * 1 / 2;
						}
						if (comprobarVentaja(ataque, pkRival) == VENTAJA) {

							potenciaTotal = potenciaTotal * 3 / 2;
						}
						break;
					}

					pkRival.setVitalidad(pkRival.getVitalidad() - potenciaTotal);
					accion = this.nombre + " us?? " + ataque.getNombre() + " y el rival recibi?? " +	
							potenciaTotal;

				} else {
					accion = "No hay estamina suficiente.";
					this.estamina += 20;
				}

			} else if (this.kitMov[opcion - 1] instanceof MovEstado) {

				estado = (MovEstado) kitMov[opcion - 1];

				if (this.estamina - estado.calculoConsumo() >= 0) {

					pkRival.setEstado(estado.getEstado());

					accion = this.nombre + " us?? " + ataque.getNombre() + " y el estado del rival cambi?? a "
							+ estado.getEstado();

				} else {
					accion = "No hay estamina suficiente.";
					this.estamina += 20;
				}

			} else if (this.kitMov[opcion - 1] instanceof MovMejora) {

				mejora = (MovMejora) kitMov[opcion - 1];

				if (this.estamina - mejora.calculoConsumo() >= 0) {

					switch (mejora.getMejora()) {

					case "ataque":
						this.ataque += mejora.getValor();
						break;
					case "defensa":
						this.defensa += mejora.getValor();
						break;
					case "ataqueEspecial":
						this.ataqueEspecial += mejora.getValor();
						break;
					case "defensaEspecial":
						this.defensaEspecial += mejora.getValor();
						break;
					case "velocidad":
						this.velocidad += mejora.getValor();
						break;
					}

					accion = this.nombre + " us?? " + ataque.getNombre() + " y se mejor?? su "
							+ mejora.getMejora();

				} else {
					accion = "No hay estamina suficiente.";
					this.estamina += 20;
				}

			}
		}else if(comprobarCondicion() == 1){

			accion = "El pokemon "+getNombre() +"est?? " + getEstado();
			this.estamina += 20;

		}else{

			accion = getNombre()+" MUERTO";

		}
			sc.close();

			return accion;
	}

	public String atacaqueRival(Pokemon pkRival) {

		Scanner sc = new Scanner(System.in);

		MovAtaque ataque = new MovAtaque();
		MovEstado estado = new MovEstado();
		MovMejora mejora = new MovMejora();
		int potenciaTotal = 0;
		String accion = "";

		int opcion;
		boolean check = false;


		if(comprobarCondicion() == 0){

			do {
			
				opcion = ((int) Math.floor(Math.random() * (1 - 4 + 1) + 4));

				if (opcion >= 1 && opcion <= 4) {
					check = true;

				}
			} while (check == false);



			if (this.kitMov[opcion - 1] instanceof MovAtaque) {

				ataque = (MovAtaque) kitMov[opcion - 1];

				if (this.estamina - ataque.calculoConsumo() >= 0) {

					switch (ataque.getFormaAtaque()) {

					case MovAtaque.FISICO:

						if (ataque.getTipo() == Tipo.NORMAL || ataque.getTipo() != this.tipo) {

							potenciaTotal = (this.ataque * ataque.getPotenciaAtaque()) - pkRival.getDefensa();
						}
						if (this.tipo == ataque.getTipo() && ataque.getTipo() != Tipo.NORMAL) {

							potenciaTotal = (this.ataque * 3 * ataque.getPotenciaAtaque() / 2) - pkRival.getDefensa();
						}

						if (comprobarVentaja(ataque, pkRival) == DESVENTAJA) {

							potenciaTotal = potenciaTotal * 1 / 2;
						}
						if (comprobarVentaja(ataque, pkRival) == VENTAJA) {

							potenciaTotal = potenciaTotal * 3 / 2;
						}
						break;
						
					case MovAtaque.ESPECIAL:

						if (ataque.getTipo() == Tipo.NORMAL || ataque.getTipo() != this.tipo) {

							potenciaTotal = (this.ataque * ataque.getPotenciaAtaque()) - pkRival.getDefensa();
						}
						if (this.tipo == ataque.getTipo() && ataque.getTipo() != Tipo.NORMAL) {

							potenciaTotal = (this.ataque * 3 * ataque.getPotenciaAtaque() / 2) - pkRival.getDefensa();
						}

						if (comprobarVentaja(ataque, pkRival) == DESVENTAJA) {

							potenciaTotal = potenciaTotal * 1 / 2;
						}
						if (comprobarVentaja(ataque, pkRival) == VENTAJA) {

							potenciaTotal = potenciaTotal * 3 / 2;
						}
						break;
					}

					pkRival.setVitalidad(pkRival.getVitalidad() - potenciaTotal);
					accion = this.nombre + "us?? " + ataque.getNombre() + "y el rival recibi?? " +	
							potenciaTotal;

				} else {
					accion = "No hay estamina suficiente.";
					this.estamina += 20;
				}

			} else if (this.kitMov[opcion - 1] instanceof MovEstado) {

				estado = (MovEstado) kitMov[opcion - 1];

				if (this.estamina - estado.calculoConsumo() >= 0) {

					pkRival.setEstado(estado.getEstado());

					accion = this.nombre + "us?? " + ataque.getNombre() + "y el estado del rival cambi?? a "
							+ estado.getEstado();

				} else {
					accion = "No hay estamina suficiente.";
					this.estamina += 20;
				}

			} else if (this.kitMov[opcion - 1] instanceof MovMejora) {

				mejora = (MovMejora) kitMov[opcion - 1];

				if (this.estamina - mejora.calculoConsumo() >= 0) {

					switch (mejora.getMejora()) {

					case "ataque":
						this.ataque += mejora.getValor();
						break;
					case "defensa":
						this.defensa += mejora.getValor();
						break;
					case "ataqueEspecial":
						this.ataqueEspecial += mejora.getValor();
						break;
					case "defensaEspecial":
						this.defensaEspecial += mejora.getValor();
						break;
					case "velocidad":
						this.velocidad += mejora.getValor();
						break;
					}

					accion = this.nombre + "us?? " + ataque.getNombre() + "y se mejor?? su "
							+ mejora.getMejora();

				} else {
					accion = "No hay estamina suficiente.";
					this.estamina += 20;
				}

			}
		}else if(comprobarCondicion() == 1){

			accion = "El pokemon "+getNombre() +"est?? " + getEstado();
			this.estamina += 20;

		}else{

			accion = getNombre()+" MUERTO";

		}	
		sc.close();

		return accion;
	}

	public int comprobarVentaja(MovAtaque ataque, Pokemon pkRival) {

		int fortaDebilidad = 0;

		switch (ataque.getTipo()) {

		case NORMAL:
			fortaDebilidad = NEUTRO;
			break;

		case AGUA:
			if ((pkRival.getTipo() == Tipo.FUEGO) || (pkRival.getTipo() == Tipo.TIERRA)) {
				fortaDebilidad = VENTAJA;
			} else if ((pkRival.getTipo() == Tipo.PLANTA) || (pkRival.getTipo() == Tipo.ELECTRICO)) {
				fortaDebilidad = DESVENTAJA;
			} else {
				fortaDebilidad = NEUTRO;
			}

			break;

		case FUEGO:
			if ((pkRival.getTipo() == Tipo.PLANTA) || (pkRival.getTipo() == Tipo.BICHO)) {
				fortaDebilidad = VENTAJA;
			} else if ((pkRival.getTipo() == Tipo.TIERRA) || (pkRival.getTipo() == Tipo.AGUA)) {
				fortaDebilidad = DESVENTAJA;
			} else {
				fortaDebilidad = NEUTRO;
			}

			break;

		case PLANTA:
			if ((pkRival.getTipo() == Tipo.TIERRA) || (pkRival.getTipo() == Tipo.AGUA)) {
				fortaDebilidad = VENTAJA;
			} else if ((pkRival.getTipo() == Tipo.FUEGO) || (pkRival.getTipo() == Tipo.BICHO)) {
				fortaDebilidad = DESVENTAJA;
			} else {
				fortaDebilidad = NEUTRO;
			}

			break;

		case BICHO:
			if ((pkRival.getTipo() == Tipo.AGUA) || (pkRival.getTipo() == Tipo.PLANTA)) {
				fortaDebilidad = VENTAJA;
			} else if ((pkRival.getTipo() == Tipo.FUEGO) || (pkRival.getTipo() == Tipo.VOLADOR)) {
				fortaDebilidad = DESVENTAJA;
			} else {
				fortaDebilidad = NEUTRO;
			}

			break;

		case VOLADOR:
			if ((pkRival.getTipo() == Tipo.PLANTA) || (pkRival.getTipo() == Tipo.BICHO)) {
				fortaDebilidad = VENTAJA;
			} else if ((pkRival.getTipo() == Tipo.ELECTRICO) || (pkRival.getTipo() == Tipo.TIERRA)) {
				fortaDebilidad = DESVENTAJA;
			} else {
				fortaDebilidad = NEUTRO;
			}

			break;

		case ELECTRICO:
			if ((pkRival.getTipo() == Tipo.VOLADOR) || (pkRival.getTipo() == Tipo.AGUA)) {
				fortaDebilidad = VENTAJA;
			} else if ((pkRival.getTipo() == Tipo.TIERRA) || (pkRival.getTipo() == Tipo.PLANTA)) {
				fortaDebilidad = DESVENTAJA;
			} else {
				fortaDebilidad = NEUTRO;
			}

			break;

		case TIERRA:
			if ((pkRival.getTipo() == Tipo.FUEGO) || (pkRival.getTipo() == Tipo.ELECTRICO)) {
				fortaDebilidad = VENTAJA;
			} else if ((pkRival.getTipo() == Tipo.AGUA) || (pkRival.getTipo() == Tipo.PLANTA)) {
				fortaDebilidad = DESVENTAJA;
			} else {
				fortaDebilidad = NEUTRO;
			}

			break;
			
		case VENENO:
			if (pkRival.getTipo() == Tipo.PLANTA) {
				fortaDebilidad = VENTAJA;
			} else if (pkRival.getTipo() == Tipo.TIERRA) {
				fortaDebilidad = DESVENTAJA;
			} else {
				fortaDebilidad = NEUTRO;
			}

		default:
			break;

		}
		return fortaDebilidad;
	}
	
	public static Pokemon generarPokemon() {
		
		DbConexion.establecerConexion();
		Pokemon pokemonGenerado = new Pokemon();
		
		List<Pokemon> pokemon = new LinkedList<>();
		try {
		   pokemon = DbConexion.cargarPokemon();
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }

	   pokemonGenerado = pokemon.get(((int)Math.floor(Math.random()*(1-pokemon.size()+1)+pokemon.size())));
		
		pokemonGenerado.subirNivel();
		pokemonGenerado.setNumPokemon(((int)Math.floor(Math.random()*(1-1000000+1)+1000000)));
		pokemonGenerado.setEstamina(1000000);
		pokemonGenerado.setAtaque(20);

		for(int i = 0; i < 2; i++){
		pokemonGenerado.kitMov[i] = Movimientos.generarMovimientos();
		try {
			DbConexion.insertarMovimiento(pokemonGenerado.kitMov[i], pokemonGenerado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		DbConexion.cerrarConexion();
		return pokemonGenerado;
	}

	public int comprobarCondicion(){
		
		int condicion = 0;
		int estadoRaro;

		switch(this.estado){

			case QUEMADO:
				setVitalidad(this.vitalidad-3);
				break;

			case CONGELADO:
				condicion = 1;
				break;

			case DORMIDO:
				condicion = 1;
				break;

			case PARALIZADO:
			  	estadoRaro = ((int) Math.floor(Math.random() * (1 - 3 + 1) + 3));			
				if(estadoRaro > 1){
					condicion = 1;
				}
				break;

			case ENVENENADO:
				setVitalidad(this.vitalidad-3);	
				break;

			case CONFUNDIDO:
				estadoRaro = ((int) Math.floor(Math.random() * (1 - 3 + 1) + 3));			
				if(estadoRaro > 1){
					setVitalidad(this.vitalidad-3);
				}
				break;

			case SIN_ESTADO:
				break;	

			default:
				break;	
		}

		if(this.vitalidad <= 0){
			condicion = 2;
		}
		return condicion;
	}

	public String mostrarPokemon() {
		return "Pokemon [ataque=" + ataque + ", ataqueEspecial=" + ataqueEspecial + ", defensa=" + defensa
				+ ", defensaEspecial=" + defensaEspecial + ", estado=" + estado + ", estamina=" + estamina + ", exp="
				+ exp + ", nombre="+ nombre + ", nivel=" + nivel + ", tipo=" + tipo + ", velocidad=" + velocidad + ", vitalidad=" + vitalidad + "]";
	}

	@Override
	public String toString() {
		return "Pokemon [mote=" + nombre + "]";
	}

}
