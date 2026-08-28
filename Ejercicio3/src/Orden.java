import java.util.Objects;

public class Orden {
    private String norden;
    private String nombre;
    private String placa;
    private String descripcion;
    private double costo;
    public Orden(){
        
    }
    public Orden(String norden, String nombre, String placa, String descripcion, double costo){
        this.norden = norden;
        this.nombre = nombre;
        this.placa = placa;
        this.descripcion = descripcion;
        this.costo = costo;
    }


    public String getnorden(){
        return norden;
    }

    public String getnombre(){
        return nombre;
    }

    public String getplaca(){
        return placa;
    }

    public String getdescripcion(){
        return descripcion;
    }

    public double getcosto(){
        return costo;
    }

    public void setdescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public void setcosto(double costo){
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Número de orden: " + norden
                + "\nNombre del propietario: " + nombre
                + "\nPlaca del vehículo: " + placa
                + "\nDescripción del servicio: " + descripcion
                + "\nCosto estimado: Q" + costo;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Orden)){
            return false;
        }
        Orden newobj = (Orden) obj;
        if (Objects.equals(this.norden, newobj.norden)
            && Objects.equals(this.nombre, newobj.nombre)
            && Objects.equals(this.placa, newobj.placa)
            && Objects.equals(this.descripcion, newobj.descripcion)
            && this.costo == newobj.costo){
                return true;
            }
        return false;
    }








}
