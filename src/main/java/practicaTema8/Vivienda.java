package practicaTema8;

/**
 *
 * @author Stefan
 */
public class Vivienda{

    protected String referencia;
    protected String direccion;
    protected String superficie;
    protected String fotosdireccion;
    protected double precio;
    protected double poblacion;
    protected byte habitacion;
    protected byte plantas;
    protected byte banos;
    protected boolean disponible;
    protected boolean amueblado;
    protected boolean garaje;

    
    //Constructores
    Vivienda() {
    }
    /*
    Constructor LLeno
    */
    Vivienda(String referencia, String direccion, double poblacion, String superficie,
            byte habitacion, byte banos, byte plantas, boolean garaje,
            String fotosdireccion, double precio, boolean disponible,
            boolean amueblado) {

        this.referencia = referencia;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.superficie = superficie;
        this.habitacion = habitacion;
        this.banos = banos;
        this.plantas = plantas;
        this.garaje = garaje;
        this.fotosdireccion = fotosdireccion;
        this.precio = precio;
        this.disponible = disponible;
        this.amueblado = amueblado;

    }
    
    //<editor-fold desc="Getter y setter" defaultstate="collapsed">

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public String getFotosdireccion() {
        return fotosdireccion;
    }

    public void setFotosdireccion(String fotosdireccion) {
        this.fotosdireccion = fotosdireccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(double poblacion) {
        this.poblacion = poblacion;
    }

    public byte getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(byte habitacion) {
        this.habitacion = habitacion;
    }

    public byte getPlantas() {
        return plantas;
    }

    public void setPlantas(byte plantas) {
        this.plantas = plantas;
    }

    public byte getBanos() {
        return banos;
    }

    public void setBanos(byte banos) {
        this.banos = banos;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isAmueblado() {
        return amueblado;
    }

    public void setAmueblado(boolean amueblado) {
        this.amueblado = amueblado;
    }

    public boolean isGaraje() {
        return garaje;
    }

    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }
    
    
    //</editor-fold>
    
    @Override
    public String toString() {
        return "\nLa lujosa vivienda de " + getPlantas()+ " plantas situada "
                + "en " + getDireccion()+ " que cuenta con " + getHabitacion() 
                + "\n habitaciones y " + getBanos() + " baños que tiene una "
                + "superficie de " + getSuperficie() + " cuyo garaje es " + isGaraje()
                + "\n con estado " + isDisponible() + " y con muebles " + isAmueblado()
                + " .Su precio es de " + getPrecio();
    }
    

    /**
     * Creación del metodo caracteristicas.
     *
     * @return Caracteristicas de la vivienda
     */
    public String caracteristicas() {

        return "\nReferencia: " + getReferencia()
                + "\nSuperficie: " + getSuperficie()
                + "\nPlantas: " + getPlantas()
                + "\nHabitaciones: " + getHabitacion()
                + "\nGaraje: " + isGaraje()
                + "\nBaños: " + getBanos();

    }

}
