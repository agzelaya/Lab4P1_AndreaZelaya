package lab4p1_andreazelaya;

import java.util.Scanner;

public class Lab4P1_AndreaZelaya {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("MENU");
            System.out.println("1. Sumador binario");
            System.out.println("2. Contains");
            System.out.println("3. Alpha");
            System.out.println("4. Salida");
            System.out.print("Ingrese la opcion que desea usar: ");
            opcion = in.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese un numero binario: ");
                    String string1 = in.next();
                    System.out.println("Ingrese otro numero binario: ");
                    String string2 = in.next();

                    sumbinario(string1, string2);
                }
                break;

                case 2: {
                    System.out.println("Ingrese la cadena contenedor: ");
                    in.nextLine();
                    String contenedor = in.nextLine();
                    System.out.println("Ingrese la cadena contenida: ");
                    String contenida = in.nextLine();

                    contains(contenedor, contenida);
                }
                break;

                case 3: {
                    System.out.println("Ingrese una cadena: ");
                    in.nextLine();
                    String cadena = in.nextLine();

                    is_alpha(cadena);
                }
                break;

            }//fin switch
            System.out.println();
        } while (opcion != 4);

    }

    public static void sumbinario(String string1, String string2) {
        int cont1 = 0, cont2 = 0;
        char char1, char2;
        for (int i = 0; i < string1.length(); i++) {
            char num1 = string1.charAt(i);
            if (num1 != '0' && num1 != '1') {
                cont1++;
            }
        }
        //validacion de chars
        if (cont1 > 0) {
            System.out.println("El primer numero contiene caracteres distintos de 0 y 1");
        }

        for (int i = 0; i < string2.length(); i++) {
            char num2 = string2.charAt(i);
            if (num2 != '0' && num2 != '1') {
                cont2++;
            }
        }

        if (cont2 > 0) {
            System.out.println("El segundo numero contiene caracteres distintos de 0 y 1");
        }//fin de validacion de chars
        else if (cont1 == 0 && cont2 == 0) {
            if (string1.length() == string2.length()) {
                //desarrollo de suma
                char move = '0';
                String acum = "";
                String reverse = "";
                
                for (int j = string1.length() - 1; j >= 0; j--) {
                    char1 = string1.charAt(j);
                    char2 = string2.charAt(j);
                    
                    //ifs de suma
                    if(move == '0'){
                        if(char1 == '0' && char2 == '0'){
                            acum += '0';
                            move = '0';
                        }
                        
                        if(char1 == '1' && char2 == '0' ||char1== '0' && char2== '1'){
                            acum += '1';
                            move = '0';
                        }
                        
                        if (char1 == '1' && char2 == '1' ){
                            acum += '0';
                            move = '1';
                        }
                    }
                    
                    else if (move == '1'){
                        if(char1 == '0' && char2 == '0'){
                            acum += '1';
                            move = '0';
                        }   
                        
                        if(char1 == '1' && char2 == '0' ||char1== '0' && char2== '1'){
                            acum += '0';
                            move = '1';
                        }
                        
                        if (char1 == '1' && char2 == '1' ){
                            acum += '1';
                            move = '1';
                        }
                        
                    }
                }
                
                if(move=='1'){
                    acum+='1';
                }
                
                for (int i = acum.length()-1; i>=0; i--){
                    char letra = acum.charAt(i);
                    reverse += letra;
                    
                }
                System.out.println("La suma es: "+ reverse);
                
            } 
            else if (string1.length() != string2.length()) {
                System.out.println("Los numeros deben tener el mismo numero de bits");
            }
        }
    }

    public static void contains(String str, String innerStr) {
        char inner1 = innerStr.charAt(0);
        String div2 = "";

        if (innerStr.length() < str.length()) {
            for (int i = 0; i < str.length(); i++) {
                char chara = str.charAt(i);

                if (chara == inner1) {
                    String div = str.substring(i);
                    if (div.length() >= innerStr.length()) {
                        char lastinner = str.charAt(str.length() - 1);
                        for (int j = 0; j < div.length(); j++) {
                            char lastouter = div.charAt(j);

                            if (lastinner == lastouter) {
                                div2 = div.substring(0, j + 1);
                            }
                        }

                    }
                }
            }

            if (div2.equals(innerStr)) {
                System.out.println("La cadena " + str + " contiene la cadena " + innerStr);
            } else {
                System.out.println("La cadena " + str + " no contiene la cadena " + innerStr);
            }
        } else {
            System.out.println("La cadena contenida no puede ser mayor que la contenedora.");
        }
    }

    public static void is_alpha(String str) {
        int cont = 0;
        for (int i = 0; i < str.length(); i++) {
            char chara = str.charAt(i);
            if ((int) chara < 65 || (int) chara > 122) {
                cont++;
            }

            if ((int) chara >= 91 && (int) chara <= 96) {
                cont++;
            }
        }

        if (cont > 0) {
            System.out.println("La cadena contiene caracteres que no solo son letras");
        } else {
            System.out.println("La cadena solo contiene letras");
        }

    }

}
