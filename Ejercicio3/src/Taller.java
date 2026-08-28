import java.util.ArrayList;
import java.util.List;
public class Taller {
    private List<Orden> ordenes;

    public Taller(){
        this.ordenes = new ArrayList<>();
    }

    public void registrarorden(String norden, String nombre, String placa, String descripcion, double costo) throws Ordenfallida{
        
        if (norden == null || norden.trim().isEmpty()){
            throw new IllegalArgumentException("El número de orden no puede estar vacío");
        }

        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (placa == null || placa.trim().isEmpty()){
            throw new IllegalArgumentException("La placa no puede estar vacía");
        }

        if (descripcion == null || descripcion.trim().isEmpty()){
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }

        if (costo <=0){
            throw new IllegalArgumentException("El costo debe ser mayor a cero");
        }

        if (existenciaorden(norden)){
            throw new Ordenfallida("Ya existe una orden con este número");
        }

        Orden orden = new Orden(norden, nombre, placa, descripcion, costo);
        ordenes.add(orden);
    }

    public boolean existenciaorden(String newnorden){
        for (Orden orden:ordenes){
            if (orden.getnorden().equalsIgnoreCase(newnorden)){
                return true;
            }
        }
        return false;
    }

    public List<Orden> consultarordenes(){
        return new ArrayList<>(ordenes);
    } 

    public Orden buscarorden(String newnorden) throws Ordenfallida{
        for (Orden orden: ordenes){
            if (orden.getnorden().equalsIgnoreCase(newnorden)){
                return orden;
            }
        }
        throw new Ordenfallida("Orden no encontrada");
    }

    public void cancelarorden(String newnorden) throws Ordenfallida{
        for (int i = 0 ; i<ordenes.size();i++){
            Orden orden = ordenes.get(i);
            if (orden.getnorden().equalsIgnoreCase(newnorden)) {
                ordenes.remove(i);
                return;
            }
        }
        throw new Ordenfallida("Orden no encontrada");       
    }

    public List<Orden> coincidenciasplaca(String placa){
        List<Orden> coincidencias = new ArrayList<>();
        for (Orden orden:ordenes){
            if(orden.getplaca().equalsIgnoreCase(placa)){
                coincidencias.add(orden);
            }
        }
        return coincidencias;
    }

    public double totalordenes(){
        double total = 0;
        for (Orden orden:ordenes){
            total+=orden.getcosto();
        }
        return total; 
    }

    public double promedio() {
        if (ordenes.isEmpty()) {
            return 0;
        }

        return totalordenes() / ordenes.size();
    }

    public Orden costomasalto() throws Ordenfallida {
        if (ordenes.isEmpty()) {
            throw new Ordenfallida("No hay órdenes registradas");
        }

        Orden mayor = ordenes.get(0);

        for (Orden orden : ordenes) {
            if (orden.getcosto() > mayor.getcosto()) {
                mayor = orden;
            }
        }

        return mayor;
    }

    public int cantidadordenesregistradas(){
        return ordenes.size();
    }


    public void modificarorden(String norden, String descripcion, double costo) throws Ordenfallida {
        if (descripcion == null || descripcion.trim().isEmpty()){
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        if (costo <=0){
            throw new IllegalArgumentException("El costo debe ser mayor a cero");
        }
        Orden orden = buscarorden(norden);
        orden.setdescripcion(descripcion);
        orden.setcosto(costo);
    }







}
