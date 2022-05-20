package modelo;
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


  } 
