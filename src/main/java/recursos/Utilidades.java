package recursos;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Stefan
 */
public class Utilidades {
    
    /**
     * Metodo que nos pedira un numero entero por pantalla hasta que nos los ingrese
     * y despues nos lo devolvera.
     * @return 
     */ 
    public static int dameEntero(String mensaje) {
        boolean var;
        int entero = 0;
        do {
            try {
                System.out.println(mensaje);
                Scanner sc = new Scanner(System.in);
                entero = sc.nextInt();
                return entero;
                
            } catch (Exception e) {
                var = true;
            }
        } while (var == true);
        return entero;
    }
    
    public static boolean dimeSiNo(String mensaje){
        String aux;
       
        do {            
            try {
                System.out.println(mensaje);
                Scanner sc = new Scanner(System.in);
                aux = sc.nextLine().toLowerCase();
                if("s".equals(aux) || "si".equals(aux)){
                    return true;
                }else{
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } while (true);
    }
    
    /**
     * Metodo dame String, que pediremos al cliente un String y nos lo devolvera
     * en caso de ser un String.
     * @param mensaje
     * @return 
     */
    public static String dameString(String mensaje){
        String mensaje2 = "";
        boolean var;
        do {            
            try {
                System.out.println(mensaje);
                Scanner sc = new Scanner(System.in);
                mensaje2 = sc.nextLine();
                return mensaje2;
            } catch (Exception e) {
                System.out.println("Porfavor, introduzca un valor correcto.");
                var = true;
            }
        } while (var == true);
        return mensaje2;
    }
    
    
    /**
     * Metodo que nos pedira un numero short por pantalla hasta que nos los ingrese
     * y despues nos lo devolvera.
     * @param mensaje
     * @return 
     */ 
    public static short dameShort(String mensaje) {
        boolean var;
        short corto = 0;
        do {
            try {
                System.out.println(mensaje);
                Scanner sc = new Scanner(System.in);
                corto = sc.nextShort();
                return corto;
                
            } catch (Exception e) {
                var = true;
            }
        } while (var == true);
        return corto;
    }
    
    /**
     * Metodo que nos pedira un numero float por pantalla hasta que nos los ingrese
     * y despues nos lo devolvera.
     * @return 
     */ 
    public static float dameFloat(String mensaje) {
        boolean var;
        float flotante = 0;
        do {
            try {
                System.out.println(mensaje);
                Scanner sc = new Scanner(System.in);
                flotante = sc.nextFloat();
                return flotante;
                
            } catch (Exception e) {
                var = true;
            }
        } while (var == true);
        return flotante;
    }
    
    /**
     * Un bucle que nos limpiara la pantalla si lo deseamos
     */
    public static void limpiaPantalla(){
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
    
    /**
     * Metodo que servira si le pasamos un String, para comprobar que los primeros
     * 8 sean numeros y el ultimo una letra. Es decir, comprobara si es un DNI valido
     * @param nif
     * @return 
     */
    public static boolean esValidoDni(String nif){
        
        Pattern p = Pattern.compile("([0-9]{8})([A-Z]{1})");
        Matcher m = p.matcher(nif);

        try {
            if (nif.length() == 9) {
                while (m.find()) {
                    m.group(1);
                    m.group(2);
                }
                return true;
            } else {
                System.out.println("Por favor, introduzca un DNI valido"
                        + " Ejemplo: 12345678L");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Por favor, introduzca una DNI valido"
                    + " Ejemplo: 12345678L");
            return false;
        }

    }
    
    public static void dormir(int x){
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            System.out.println("...");
        }
    }
    
   
}
