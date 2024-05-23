import java.util.Scanner;

public class Calculacion {
    private String monedaPrimera;
    private String monedaSegunda;
    private double cantidad;

    Scanner lectura = new Scanner(System.in);
     Datosapi conversion;

    public Calculacion(Datosapi conversion) {
        this.conversion = conversion;
    }

    public String getMonedaPrimera() {
        return monedaPrimera;
    }

    public String getMonedaSegunda() {
        return monedaSegunda;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void valores (String monedaPrimera, String monedaSegunda){
        this.monedaPrimera = monedaPrimera;
        this.monedaSegunda = monedaSegunda;

        System.out.println("Ingrese La cantidad que deseas convertir");

        this.cantidad = Double.parseDouble(lectura.nextLine());

    }

    public String respuesta() {
        String mensaje = getMonedaPrimera().toUpperCase() + " " + getCantidad() + " es igual a: " + getMonedaSegunda().toUpperCase() + " " + conversion.hacerConversion(getMonedaPrimera(),  getMonedaSegunda(), getCantidad());
        System.out.println(mensaje);
        return mensaje;
    }
}
