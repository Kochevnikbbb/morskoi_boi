package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int POLE = 10;                                //ограничил размер поля FILED_LENGHT
    public static Scanner scanner = new Scanner(System.in);
    private static char water = ' ';
    private static char ship = '#';
    private static char promazal = '•';
    private static char poPaL = 'X';
    private static char[][] poLe = new char[POLE][POLE];
    private static int kolvoShip = 2;
    private static int kolvoVystrelov = 5;

    private static String player1;
    private static String player2;


    public static void main(String[] args) {
        igrovoePole333();

        addShip();
        igrovoePole();
        vystrel();
        igrovoePole();


    }

    public static void privetstve() {
        System.out.println("ИГРОК №1 введите своё имя ...");
        player1 = scanner.nextLine();                               //СКАНИРУЕТ введенноё имя
        System.out.println("Здарова заЙбал, " + player1 + ")");

        System.out.println("ИГРОК №2 введите своё имя ...");
        player2 = scanner.nextLine();
        System.out.println("Салам алейкум родной " + player2 + ", как ты брат? Как родные?");

        String OtvetNaVopr = scanner.nextLine(); //немного по петросянил
        System.out.println("да ладно не продолжай мне не интересно что у тебя всё " + OtvetNaVopr);
    }

    public static void igrovoePole() {
        for (int i = 0; i < poLe.length; i++) {
            for (int j = 0; j < poLe[i].length; j++) {
                if (i == ship && j == ship) {
                    continue;
                } else if (poLe[i][j] == 0) {
                    poLe[i][j] = water;
                }
                System.out.print(poLe[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void igrovoePole555() {
        for (int i = 0; i < poLe.length; i++) {
            for (int j = 0; j < poLe[i].length; j++) {
                if (poLe[i][j] == 0) {
                    poLe[i][j] = promazal;
                }
                System.out.print(poLe[i][j] + "\t");
            }
            System.out.println();
        }
    }  //чисто для красоты

    public static void igrovoePole333() {
        char[][] pOlE = new char[11][11];

        pOlE[0][0] = '№';
        pOlE[1][0] = '0';
        pOlE[2][0] = '1';
        pOlE[3][0] = '2';
        pOlE[4][0] = '3';
        pOlE[5][0] = '4';
        pOlE[6][0] = '5';
        pOlE[7][0] = '6';
        pOlE[8][0] = '7';
        pOlE[9][0] = '8';
        pOlE[10][0] = '9';

        pOlE[0][1] = '0';
        pOlE[0][2] = '1';
        pOlE[0][3] = '2';
        pOlE[0][4] = '3';
        pOlE[0][5] = '4';
        pOlE[0][6] = '5';
        pOlE[0][7] = '6';
        pOlE[0][8] = '7';
        pOlE[0][9] = '8';
        pOlE[0][10] = '9';
        /*int numX = 0;
        int numY = 0;*/
        for (int i = 0; i < pOlE.length; i++) {
            for (int j = 0; j < pOlE[i].length; j++) {
                if (pOlE[i][j] == 0) {
                    pOlE[i][j] = promazal;
                }
                System.out.print(pOlE[i][j] + "\t");
                /*numY++;
                j=numY;*/
            }
            System.out.println();
            /*numX++;
            i = numX;
            System.out.println(numX);*/
        }

    } //тоже самое

    public static void addShip() {

        int ostShip = 0;
        do {
            ostShip++;
            System.out.println(player1 + " напишите координаты вашего " + ostShip + "-ого коробля ...");

            System.out.println("напишите координату Х...");
            Scanner corX = new Scanner(System.in);
            byte x = corX.nextByte();

            System.out.println("напишите координату Y...");
            Scanner corY = new Scanner(System.in);
            byte y = corY.nextByte();

            poLe[x][y] = ship;
            kolvoShip--;
        }
        while (kolvoShip > 0);

    }

    public static void vystrel() {

        do {

            System.out.println("готовься будем мочить корабли XD у нас есть "+kolvoVystrelov + " снарядов для выстрела");
            System.out.println("напишите координату Х...");
            Scanner vysX = new Scanner(System.in);
            byte X = vysX.nextByte();

            System.out.println("напишите координату Y...");
            Scanner vysY = new Scanner(System.in);
            byte Y = vysY.nextByte();

            if (poLe[X][Y] == ship) {
                poLe[X][Y] = poPaL;
                System.out.println("хороший выстрел");
            } else if (poLe[X][Y] == water) {
                poLe[X][Y] = promazal;
                System.out.println("лошпед");
            }
            System.out.println();

            kolvoVystrelov--;
        }
        while (kolvoVystrelov > 0);
    }

    public static void numPoleGorizont() {
        byte num = 0;
        do {
            System.out.print("   " + num);
            num++;
        } while (num < 10);
    }

    public static void numPoleVysota() {
        System.out.println("\n");
        byte num = 1;
        do {
            System.out.println(num);
            num++;
        } while (num < 10);



        /*for (int i = 0; i < pOlE.length; i++) {
            for (int j = 0; j < pOlE[i].length; j++) {
                num++;
                System.out.print( pOlE[i][j] + num + "\t");
                break;

            }
            System.out.println();
        }*/
    }


}