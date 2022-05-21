package modelo;

import java.sql.*;
import javax.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DbConexion {

    private static Connection conexion;

    public static void establecerConexion() {
        //launch(args);

        String url = "jdbc:mysql://localhost:3306/pokemon ";
		String login = "root";
		String password = "";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
		    conexion = DriverManager.getConnection(url, login, password);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
        
        System.out.println("conexion establecida");
    }

    public static void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Conexion cerrada");
    }

    public static List<Pokemon> cargarPokemon() throws SQLException {	
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();
        String consulta = "SELECT * FROM pokemon";
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(consulta);

        Pokemon e = null;
        while (rs.next()) {
            e = new Pokemon();
            e.setNumPokedex(rs.getInt("id_pokedex"));
            e.setNombre(rs.getString("nombre"));
            e.setTipo(Tipo.valueOf(rs.getString("tipo1")));
            listaPokemon.add(e);
        }
        statement.close();
        return listaPokemon;
    }

    public static void insertarPokemon(Pokemon p,int equipo,int idEntrenador) throws SQLException {
		String sentencia ="INSERT INTO pokemon_entrenador(id_pokemon, id_pokedex, id_entrenador, mote, vitalidad, ataque, defensa, ataque_esp, defensa_esp, estamina, nivel, velocidad, experiencia, equipo) VALUES("+ p.getNumPokemon()
                                                       +",'"+p.getNumPokedex()
                                                       +",'"+idEntrenador
                                                       +",'"+p.getMote()
                                                       +",'"+p.getVitalidad()
                                                       +",'"+p.getAtaque()
                                                       +",'"+p.getDefensa()
                                                       +",'"+p.getAtaqueEspecial()
                                                       +",'"+p.getDefensaEspecial()
                                                       +",'"+p.getEstamina()
                                                       +",'"+p.getNivel()
                                                       +",'"+p.getVelocidad()
                                                       +",'"+p.getExp()
                                                       +",'"+equipo
                                                       +"')";
		Statement stmt = null;
		try {
			stmt = conexion.createStatement();
			stmt.executeUpdate(sentencia);
			
			System.out.println("Nuevo pokemon insertado. "+p.getNombre());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
													   
	}

    public static List<Movimientos> cargarMovimientos() throws SQLException {		
        LinkedList<Movimientos> listaMovimientos = new LinkedList<>();
        String consulta = "SELECT * FROM movimientos";
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(consulta);

        Movimientos e = null;
            while (rs.next()) {
                String nombre = rs.getString("nombre_mov");
                int idMovimientos = rs.getInt("id_movimientos");
                Tipo tipo = Tipo.valueOf(rs.getString("tipo"));
                Estado estado = Estado.valueOf(rs.getString("estado"));
                int potenciaAtaque = rs.getInt("potencia");
                int formaAtaque = rs.getInt("forma_ataque");
                String mejora = rs.getString("mejora");
                int numTurnos = rs.getInt("num_turno");
                int valor = rs.getInt("cant_mejora");

                

                if(estado == null && mejora == null){

                    e = new MovAtaque(nombre, idMovimientos, potenciaAtaque, tipo, formaAtaque);

                }else if(estado == null && potenciaAtaque == 0){

                    e = new MovMejora(nombre, idMovimientos, mejora, numTurnos, valor);
                }else if(mejora == null && potenciaAtaque == 0) {

                    e = new MovEstado(nombre, idMovimientos, estado, numTurnos);
                }
                listaMovimientos.add(e);
        }
        statement.close();
        return listaMovimientos;
    }

    public static void insertarMovimiento(Movimientos m,Pokemon p) throws SQLException {
		String sentencia ="INSERT INTO movimientos_pokemon(id_pokemon, id_movimientos) VALUES("+ p.getNumPokemon()
                                                       +",'"+ m.getIdMovimientos()
                                                       +"')";
		Statement stmt = null;
		try {
			stmt = conexion.createStatement();
			stmt.executeUpdate(sentencia);
			
			System.out.println("Nuevo Movimiento insertado.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
													   
	}

    public static void insertarCombate(Combate c,int idEntrenador,int idRival) throws SQLException {
		String sentencia ="INSERT INTO combate(id_combate, id_entrenador, id_rival, id_ganador, pokemon_jugador_ko, pokemon_rival_ko) VALUES("+ c.getIdCombate()
                                                       +",'"+ idEntrenador
                                                       +",'"+ idRival
                                                       +",'"+ c.getIdGanador()
                                                       +",'"+ c.getNumKO1()
                                                       +",'"+ c.getNumKO2()
                                                       +"')";
		Statement stmt = null;
		try {
			stmt = conexion.createStatement();
			stmt.executeUpdate(sentencia);
			
			System.out.println("Nuevo Combate insertado.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
													   
	}


    public static void insertarTurno(Turno t,int idCombate) throws SQLException {
		String sentencia ="INSERT INTO tyrno(id_combate, num_turno, accion_entrenador, accion_rival) VALUES("+ idCombate
                                                       +",'"+ t.getNumTurno()
                                                       +",'"+ t.getAccionEntrnador1()
                                                       +",'"+ t.getAccionEntrenador2()
                                                       +"')";
		Statement stmt = null;
		try {
			stmt = conexion.createStatement();
			stmt.executeUpdate(sentencia);
			
			System.out.println("Nuevo turno insertado.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
													   
	}

    


}
