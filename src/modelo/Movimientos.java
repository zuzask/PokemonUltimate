package modelo;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


abstract class Movimientos {

    protected String nombre;
    protected int idMovimientos;

    public Movimientos() {
      super();
      this.nombre = "";
      this.idMovimientos = 0;
    }

    public Movimientos(String nombre,int idMovimientos) {
    	super();
      this.nombre = nombre;
      this.idMovimientos = idMovimientos;
    }

      public String getNombre() {
          return nombre;
      }

      public void setNombre(String nombre) {
          this.nombre = nombre;
      }

      public int getIdMovimientos() {
        return idMovimientos;
      }

      public void setIdMovimientos(int idMovimientos) {
        this.idMovimientos = idMovimientos;
      }

      abstract int calculoConsumo();

      public static Movimientos generarMovimientos(){

        List<Movimientos> movimientos = new LinkedList<>();
        
        try {
          movimientos = DbConexion.cargarMovimientos();
        } catch (SQLException e) {
          e.printStackTrace();
        }
       
        Movimientos movGenerado = movimientos.get(((int)Math.floor(Math.random()*(1-movimientos.size()+1)+movimientos.size())));

        return movGenerado;
      }

  } 
