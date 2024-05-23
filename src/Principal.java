
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal  {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int numeroDEOpcionELegida = 0;

        Datosapi datos = new Datosapi();
        Calculacion calculacion = new Calculacion(datos);
        List<String> respuestas = new ArrayList<>();

        String menu = """
                \n***************************************************
                *** Sea bienvenido al Conversor de Monedas ***
                                
                1) Dolar -------- Peso Argentino
                2) Peso Argentino -------- Dolar
                3) Dolar -------- Real Brasileño
                4) Real Brasileño--------- Dolar
                5) Dolar-------- Peso Colombiano
                6) Peso Colombiano ------- Dolar
                                
                7)Opcion de salir                                                                                                                         
                ***************************************************
                                      
                       """;
        while (numeroDEOpcionELegida != 7) {
            try {
                System.out.println(menu);
                numeroDEOpcionELegida = Integer.parseInt(lectura.nextLine());

                switch (numeroDEOpcionELegida) {
                    case 1:
                        calculacion.valores("USD","ARS" );
                        respuestas.add(calculacion.respuesta());
                        break;
                    case 2:
                        calculacion.valores("ARS","USD" );
                        respuestas.add(calculacion.respuesta());

                        break;
                    case 3:
                        calculacion.valores("USD","BRL" );
                        respuestas.add( calculacion.respuesta());

                        break;
                    case 4:
                        calculacion.valores("BRL","USD" );
                        respuestas.add(calculacion.respuesta());

                        break;
                    case 5:
                        calculacion.valores("USD","COP" );
                        respuestas.add(calculacion.respuesta());

                        break;
                    case 6:
                        calculacion.valores("COP","USD" );
                        respuestas.add(calculacion.respuesta());
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Favor de insertar una opcion valida:::");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error no hay lectura");

            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error Por favor Ingresa Un numero Valido");
            }
          }
        System.out.println("Finalizando programa");
        }
      }