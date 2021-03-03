/**
     * En este ejercicio he decidido utilizar la estructura de datos dinámica "TreeSet",
     * ya que al ser una empresa de alquileres de viviendas, me parece necesario 
     * tener un minimo de orden de la viviendas agregadas si los usuarios que utilizan
     * nuestros software quieren acceder a una vivienda ordenada por su referencia,
     * tambien me parece necesario su eficiencia al agregar respecto a "LinkedHashSet" 
     * y principalmente el hecho de no admitir elementos duplicados al agregar una 
     * nueva vivienda.
     */
package practicaTema8;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import recursos.Utilidades;

/**
 *
 * @author Stefan
 */
public class gestionVivienda {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        boolean verdad = true;
        
        /**
         * Creamos nuestro TreeSet, ademas modificamos la clase comparator que es 
         * hereditaria.
         */
        TreeSet<Vivienda> vivi = new TreeSet<Vivienda>(new Comparator<Vivienda>() {
            @Override
            public int compare(Vivienda o1, Vivienda o2) {
                String refe = o1.getReferencia();
                String refe2 = o2.getReferencia();
                return refe.compareTo(refe2);

            }
        });
        
        /**
         * Metodo que agrega 4 ejemplos a nuestra coleccion para poder trabajar con ellos.
         */
        anadeEjemplos(vivi);

        do {
            /**
             * Haremos un switch, en el estara las diferentes opciones que se
             * pueden dar. 
             */
            switch (menu()) {
                case "C":
                    anadeVivienda(vivi);
                    break;

                case "I":
                infoVivienda(vivi);
                    break;

                case "M":
                    modificarVivienda(vivi);
                    break;
                    
                case "D":
                    bajaVivienda(vivi);
                    break;

                case "S":
                    verdad = false;
                    break;

                default:
                    System.out.println("Por favor, introduzca una opcion correcta");
                    break;
            }
        } while (verdad == true);

    }

    /**
     * informacion vivienda
     * @param vivi
     */
    public static void infoVivienda(TreeSet<Vivienda> vivi) {
        for (Vivienda casa : vivi) {
            System.out.println();
            System.out.println("-------- VIVIENDA --------");
            System.out.println(casa.caracteristicas());
            System.out.println(casa.toString());
        }
    }
    
    /**
     * Un metodo que nos devolvera el String de la opcion que elija el usuario
     * @return 
     */
    public static String menu() {
        String opcion;

        System.out.println("-------------------------------------------------");
        System.out.println("||                   INMOBILIARIA              ||");
        System.out.println("||C. Crear nueva vivienda                      ||");
        System.out.println("||I. Informacion de las viviendas              ||");
        System.out.println("||M. Modificar datos vivienda                  ||");
        System.out.println("||D. Dar de baja vivienda                      ||");
        System.out.println("||S. Salir                                     ||");
        System.out.println("||                                             ||");
        System.out.println("-------------------------------------------------");

        opcion = Utilidades.dameString("Por favor, elija una opcion: ").toUpperCase();

        return opcion;

    }
        /**
     * Un metodo que pedira al usuario los datos por pantalla para posteriormente
     * ingresarlos en la coleccion
     * @param vivienda 
     */
    public static void anadeVivienda(TreeSet<Vivienda> vivienda) {
        String referencia, direccion, superficie, fotosDescripcion;
        byte banos, habitaciones,plantas;
        float poblacion, precio;
        boolean garaje, amueblado, disponible;
        
        referencia = Utilidades.dameString("Introduce la referencia: ");
        direccion = Utilidades.dameString("Introduce la dirreccion: ");
        poblacion = Utilidades.dameFloat("Introduzca la poblacion: ");
        superficie = Utilidades.dameString("introduzca la superficie: ");
        habitaciones = (byte) Utilidades.dameShort("Introduce las habitaciones: ");
        banos = (byte) Utilidades.dameShort("Introduce los baños: ");
        plantas = (byte) Utilidades.dameShort("Introduzca plantas: ");
        garaje = Utilidades.dimeSiNo("Introduce el garaje (S/n): ");
        fotosDescripcion = Utilidades.dameString("Introduzca la descripcionFotos: ");
        precio = Utilidades.dameFloat("Introduzca la poblacion: ");
        disponible = Utilidades.dimeSiNo("Esta disponible? (S/n): ");
        amueblado = Utilidades.dimeSiNo("Esta amueblado? (S/n): ");

        vivienda.add(new Vivienda(referencia, direccion, poblacion, superficie, 
                habitaciones,banos, plantas, garaje, fotosDescripcion, precio, 
                disponible, amueblado));

    }
    
    /**
     * En este metdodo crearemos un iterador que lo usuaremos para comprobar si la 
     * referencia que pasa el usuario por teclado existe en nuestra coleccion. Si 
     * existe nos preguntara dentro de un switch que opcion de un menu con los atributos
     * queremos modificar. Una vez elija la opcion llamaremos a los metodos de utilidades
     * para establecer sus respectivos datos a cambiar.
     * @param vivienda 
     */
    public static void modificarVivienda(TreeSet<Vivienda> vivienda) {
        boolean verdad = false;
        String refCliente;
        String refVivienda;
        
        Iterator<Vivienda> iteradorVivienda = vivienda.iterator();
        System.out.println("Referencia: ");
        for (Vivienda alojamiento : vivienda) {
            System.out.println(alojamiento.getReferencia());
        }

        refCliente = Utilidades.dameString("Que vivienda desea modificar? ");

        while (iteradorVivienda.hasNext()) {
            for (Vivienda casaModificada : vivienda) {
                refVivienda = iteradorVivienda.next().getReferencia();
                if (refCliente.equals(refVivienda) && verdad == false) {
                    verdad = true;
                    switch (menuModificarVivienda()) {
                        case 1: 
                            casaModificada.setReferencia(Utilidades.dameString("Introduzca Referencia: "));
                            break;
                        case 2:
                            casaModificada.setDireccion(Utilidades.dameString("Introduzca Direccion: "));
                            break;
                        case 3:
                            casaModificada.setPoblacion(Utilidades.dameFloat("Introduzca Poblacion: "));
                            break;
                        case 4:
                            casaModificada.setSuperficie(Utilidades.dameString("Introduzca Superficie: "));
                            break;
                        case 5:
                            casaModificada.setHabitacion((byte) Utilidades.dameShort("Introduzca Habitaciones: "));
                            break;
                        case 6:
                            casaModificada.setBanos((byte) Utilidades.dameShort("Introduzca banos: "));
                            break;
                        case 7:
                            casaModificada.setPlantas((byte) Utilidades.dameShort("Introduzca Plantas: "));
                            break;
                        case 8:
                            casaModificada.setGaraje(Utilidades.dimeSiNo("Introduzca S/n: "));
                            break;
                        case 9:
                            casaModificada.setFotosdireccion(Utilidades.dameString("Introduzca fotosDirrecion: "));
                            break;
                        case 10:
                            casaModificada.setPrecio(Utilidades.dameFloat("Introduzca Precio: "));
                            break;
                        case 11:
                            casaModificada.setDisponible(Utilidades.dimeSiNo("Introduzca S/n: "));
                            break;
                        case 12:
                            casaModificada.setAmueblado(Utilidades.dimeSiNo("Introduzca S/n: "));
                            break;
                        default:
                            System.out.println("Por favor, elija un numero correcto del menu...");
                            break;
                    }
                }
            }
        }

        if (verdad == false) {
            System.out.println("Error, no exista una vivienda con esta referencia...");
        }
    }
    
    /**
     * Metodo que nos devolvera una opcion que elija el usuario del metodo anterior
     * para modificar un vivienda
     * @return 
     */
    public static byte menuModificarVivienda() {
    byte opcion;
        System.out.println("¿Que atributo quiere modificar? "
                + "\n 1.referencia"
                + "\n 2.direccion"
                + "\n 3.poblacion"
                + "\n 4.superficie"
                + "\n 5.habitacion"
                + "\n 6.banos"
                + "\n 7.plantas"
                + "\n 8.garaje"
                + "\n 9.fotosDescripcion"
                + "\n 10.precio"
                + "\n 11.disponible"
                + "\n 12.amueblado");

        opcion = (byte) Utilidades.dameShort("Que atributo quiere modificar? ");

        return opcion;

    }
    
    /**
     * Metodo para dar de baja una vivienda, pidiendo al usuario que vivienda
     * desea eliminar, para despues mediante un iterador creado recoreremos el 
     * iterador y daremos de baja la vivienda que tenga la misma referencia 
     * que el usuario ha introducido por teclado. Si no existe la referencia
     * saltara un mensaje de error.
     * @param vivienda 
     */
    public static void bajaVivienda(TreeSet<Vivienda> vivienda) {
        boolean verdad = false;
        String refCliente;
        Iterator<Vivienda> iteradorVivienda = vivienda.iterator();
        
        System.out.println("Referencia: ");
        for (Vivienda casa : vivienda) {
            System.out.println(casa.getReferencia());
        }
        refCliente = Utilidades.dameString("Que vivienda desea eliminar? ");
        
        while (iteradorVivienda.hasNext()) {
            String refVivienda = iteradorVivienda.next().getReferencia();
            if (refCliente.equals(refVivienda) && verdad == false) {
                verdad = true;
                System.out.println("Dada de baja...");
                iteradorVivienda.remove();
            }
        }
        
        if (verdad == false) {
            System.out.println("Error, no exista una vivienda con esta referencia...");
        }

    }
    
    /**
     * Metodo para ingresar ejemplos a la coleccion
     * @param vivienda 
     */
    public static void anadeEjemplos(TreeSet<Vivienda> vivienda) {

        vivienda.add(new Vivienda("vivh001", "Jose Fariña Nº4", 200.21, "80 m2", (byte) 3, (byte) 1, (byte) 1, true, "Grandes", 234012.12, true, false));
        vivienda.add(new Vivienda("vivh002", "Mackay Macdonald Nº2", 122.31, "40 m2", (byte) 2, (byte) 1, (byte) 1, false, "Pequeñas", 30000.12, false, true));
        vivienda.add(new Vivienda("vivh003", "Lopez Quintero Nº1", 423.21, "120 m2", (byte) 4, (byte) 1, (byte) 2, false, "Vista Vela", 73123.31, true, false));
        vivienda.add(new Vivienda("vivh004", "Alfonso Marino Nº9", 2000.1, "250 m2", (byte) 3, (byte) 2, (byte) 2, true, "Fotos buenas", 402212.31, false, true));
        
    }

}
