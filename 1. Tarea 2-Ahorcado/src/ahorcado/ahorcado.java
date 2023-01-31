package ahorcado;

import java.util.Random;
import java.util.Scanner;
public class ahorcado {

    public static void main(String[] args) {

        String[] palabrasJuego = {"solidaridad","empatia", "responsabilidad","paz","conciencia","tranquilidad","cultura"
        ,"libertad","tolerancia","equidad"};
        char continuar = 's';
        Scanner sc = new Scanner(System.in);
        while(continuar=='s'){
            int vida = 7;
            char[] abecedario = new char[]{'a','b','c','d','e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n','o', 'p' ,'q' ,'r' ,'s', 't' ,'u', 'v', 'w', 'x', 'y', 'z'};
            String palabraActual = asignarPalabraAleatoria(palabrasJuego);
            int espaciosFaltantes = palabraActual.length();
            char[] palabraAdivinada = crearArregloEspacios(palabraActual);

            while(vida>0){
                System.out.println("letras faltantes:");
                imprimirArreglo(abecedario);
                System.out.println("Estado de la palabra:");
                imprimirArreglo(palabraAdivinada);
                mostrar_ahorcado(vida);
                System.out.println("Vidas:" + vida);
                System.out.println("Introduzca la letra: ");
                char letraUsuario = sc.nextLine().charAt(0);
                boolean letraNoUsada = comprobarNoFueUsada(letraUsuario,abecedario);
                if(letraNoUsada){
                    boolean hayLaLetra = buscar(letraUsuario,palabraActual);
                    if (hayLaLetra){
                        System.out.println("Esa letra hace parte de la palabra");
                        imprimirArreglo(ActualizarEstadoPalabra(letraUsuario,palabraAdivinada,palabraActual));
                        espaciosFaltantes = contarEspaciosFaltantes(palabraAdivinada);

                    }else{
                        System.out.println("Esta letra no hace parte de la palabra");
                        vida-=1;
                        mostrar_ahorcado(vida);
                    }
                    abecedario = tachar(letraUsuario,abecedario);

                    if(espaciosFaltantes==0){
                        System.out.println("Fin del juego gg");
                        vida = 0;
                    }
                }
                else {
                    System.out.println("Esa letra ya la usaste.");
                }

            }
            System.out.println("GAME OVER");
            System.out.println("--------------");
            System.out.println("Introduzca s para comenzar de nuevo o n para terminar: ");
            continuar = sc.nextLine().charAt(0);
        }
        System.out.println("Gracias por jugar, nos vemos en una proxima ocasión");
    }

    public static void imprimirArreglo(char [] arreglo ){
        System.out.print("[");
        for(char letra : arreglo){
            System.out.print(" "+ letra +" ");
        }
        System.out.println("] ");
    }

    public static char[] crearArregloEspacios(String palabra){
        int n = palabra.length();
        char[] arregloEspacios = new char[n];
        for(int i = 0; i<n; i ++){
            arregloEspacios[i] = '_';
        }
        return arregloEspacios;
    }

    public static String asignarPalabraAleatoria(String[]palabras){
        Random indiceAleatorio = new Random();
        int a = indiceAleatorio.nextInt(palabras.length);
        return palabras[a];
    }

    public static boolean buscar(char letraUsuario, String palabra) {
        int n = palabra.length() ;
        int j = 0;
        while(j < n && letraUsuario != palabra.charAt(j)){
            j ++;
        }
        return j < n;
    }
    public static int contarEspaciosFaltantes(char[] palabraAdivinada){
        int contador = 0;
        for(char letra : palabraAdivinada){
            if(letra == '_'){
                contador ++;
            }
        }
        return contador;
    }
    public static char[] ActualizarEstadoPalabra(char letraUsuario, char [] palabraAdivinada, String palabra){
        int n = palabra.length();
        int j = 0;
        while(j < n){
            if(letraUsuario == palabra.charAt(j)){
                palabraAdivinada[j] = letraUsuario;
            }
            j ++;
        }
        return palabraAdivinada;
    }
    public static char[] tachar(char letraAtachar, char[]abecedario ){
        int i = Character.toLowerCase(letraAtachar)-97;
        abecedario[i] = '_';
        return abecedario;
    }

    public static boolean comprobarNoFueUsada(char letraUsuario, char[] abecedario){
        int i = Character.toLowerCase(letraUsuario)- 97;
        return ! (abecedario[i] == '_') ;
    }

    public static void mostrar_ahorcado(int a){
        int estado = 7-a;
        String[] ahorcado_pic = new String[]{

                " +----+\n"+
                        "      |\n"+
                        "      |\n"+
                        "      |\n"+
                        "      |\n"+
                        "      |\n"+
                        "=========\n",
                " +----+\n"+
                        " |    |\n"+
                        "      |\n"+
                        "      |\n"+
                        "      |\n"+
                        "      |\n"+
                        "=========\n",
                " +----+\n"+
                        " |    |\n"+
                        " O    |\n"+
                        "      |\n"+
                        "      |\n"+
                        "      |\n"+
                        "=========\n",
                " +----+\n"+
                        " |    |\n"+
                        " O    |\n"+
                        " |    |\n"+
                        "      |\n"+
                        "      |\n"+
                        "=========\n",
                " +----+\n"+
                        " |    |\n"+
                        " O    |\n"+
                        "/|    |\n"+
                        "      |\n"+
                        "      |\n"+
                        "=========\n",
                " +----+\n"+
                        " |    |\n"+
                        " O    |\n"+
                        "/|\\   |\n"+
                        "      |\n"+
                        "      |\n"+
                        "=========\n",
                " +----+\n"+
                        " |    |\n"+
                        " O    |\n"+
                        "/|\\   |\n"+
                        "/     |\n"+
                        "      |\n"+
                        "=========\n",
                " +----+\n"+
                        " |    |\n"+
                        " O    |\n"+
                        "/|\\   |\n"+
                        "/ \\   |\n"+
                        "      |\n"+
                        "=========\n"
        };

        System.out.println(ahorcado_pic[estado]);

    }

}
