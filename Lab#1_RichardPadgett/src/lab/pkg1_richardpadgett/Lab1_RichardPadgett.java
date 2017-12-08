package lab.pkg1_richardpadgett;

import java.util.Scanner;

public class Lab1_RichardPadgett {

    static Scanner sc = new Scanner(System.in);
    static int contatacantes = 24;
    static int ontdefense = 1;

    public static void main(String[] args) {
        System.out.println("[[[[[[[[[[[[TAWLBWRDD]]]]]]]]]]]]");
        String[][] tablero = new String[11][11];
        llenar(tablero);
        impat(tablero, 0, 0);
        System.out.println();
        turno(llenar(tablero));
    }

    public static void impat(String[][] tablero, int f, int c) {
        if (f == tablero.length - 1 && c == tablero.length - 1) {
            System.out.print(tablero[f][c] + " ");
        } else {
            if (c == tablero.length - 1) {
                System.out.println(tablero[f][c]);
                impat(tablero, f + 1, 0);
            } else {
                System.out.print(tablero[f][c] + " ");
                impat(tablero, f, c + 1);
            }
        }

    }

    public static void turno(String[][] tablero) {
        boolean turn = true;
        int contturno = 0;
        do {
            if (contturno % 2 == 0) {
                System.out.println();
                System.out.println("[[[[ENEMY PHASE]]]]]");
                System.out.println("ingrese la pieza que desea mover");
                System.out.println("ingrese su coordenada en X");
                int x = sc.nextInt();
                System.out.println("ingrese su coordenada en Y");
                int y = sc.nextInt();
                if (tablero[y][x].equals("[X]") || tablero[y][x].equals("[$]") || tablero[y][x].equals(" ")) {
                    System.out.println("Unidad incorrecta");
                    System.out.println("ingrese su coordenada en X");
                    x = sc.nextInt();
                    System.out.println("ingrese su coordenada en Y");
                    y = sc.nextInt();
                }
                System.out.println(tablero[y][x]+y+x);
                System.out.println("De que manera se que mover?");
                System.out.println("1.Horizontal");
                System.out.println("2.Vertical");
                int movimiento = sc.nextInt();
                switch (movimiento) {
                    case 1:

                        System.out.println("ingrese su coordenada en X");
                        int x2 = sc.nextInt();
                        System.out.println(tablero[y][x2]);
                        if (tablero[y][x2].equals("[+]") || tablero[y][x2].equals("[X]")) {
                            System.out.println("El espacio esta ocupado");
                            System.out.println("ingrese su coordenada en X");
                            x2 = sc.nextInt();
                           

                        }
                        if (x2 >= x) {
                            for (int i = x; i <= x2; i++) {
                                System.out.println(tablero[y][i] + y + i);
                               if (!tablero[y][i].equals("[ ]") ) {
                                    System.out.println("no puede saltar fichas");
                                    System.out.println("ingrese su coordenada en X");
                                    x2 = sc.nextInt();
                                }
                            }
                        } else {
                            for (int i = x; i >= x2; i--) {
                                if (tablero[y][i].equals("[X]") || tablero[y][i].equals("[+]") || tablero[y][i].equals("[$]")) {
                                    System.out.println("no puede saltar fichas");
                                    System.out.println("ingrese su coordenada en X");
                                    x2 = sc.nextInt();

                                }
                            }
                        }
                        tablero[y][x2] = "[+]";
                        tablero[y][x] = "[ ]";
                        impat(tablero, 0, 0);
                        manerasdeganarey(tablero, turn);
                        break;

                    case 2:
                        System.out.println("Ingrese a que poscicion desea moverse");
                        System.out.println("ingrese su coordenada en Y");
                        int y2 = sc.nextInt();

                        if (tablero[y2][y].equals("[+]") || tablero[y2][y].equals("[X]")) {
                            System.out.println("El espacio esta ocupado");
                            System.out.println("ingrese su coordenada en Y");
                            y2 = sc.nextInt();

                        }
                        if (y2 >= x) {
                            for (int i = x; i <= y2; i++) {
                                if (tablero[y2][i].equals("[X]") || tablero[y2][i].equals("+") || tablero[y2][i].equals("[$]")) {
                                    System.out.println("no puede saltar fichas");
                                    System.out.println("ingrese su coordenada en Y");
                                    y2 = sc.nextInt();
                                }
                            }
                        } else {
                            for (int i = x; i >= y2; i--) {
                                if (tablero[y2][i].equals("[X]") || tablero[y2][i].equals("+") || tablero[y2][i].equals("[$]")) {
                                    System.out.println("no puede saltar fichas");
                                    System.out.println("ingrese su coordenada en Y");
                                    y2 = sc.nextInt();

                                }
                            }
                        }
                        tablero[y2][y] = "[+]";
                        tablero[x][y] = "[ ]";
                        impat(tablero, 0, 0);
                        manerasdeganarey(tablero, turn);

                        break;
                }

            } else {
                System.out.println();
                System.out.println("[[[[DEFENDER PHASE]]]]]");
                System.out.println("ingrese la pieza que desea mover");
                System.out.println("ingrese su coordenada en Y");
                int x = sc.nextInt();
                System.out.println("ingrese su coordenada en X");
                int y = sc.nextInt();
                if (tablero[x][y].equals("[+]") || tablero[x][y].equals(" ")) {
                    System.out.println("Unidad incorrecta");
                    System.out.println("ingrese su coordenada en Y");
                    x = sc.nextInt();
                    System.out.println("ingrese su coordenada en X");
                    y = sc.nextInt();
                }
                System.out.println("De que manera se que mover?");
                System.out.println("1.Vertical");
                System.out.println("2.Horizontal");
                int movimiento = sc.nextInt();
                switch (movimiento) {
                    case 1:
                        System.out.println("Ingrese a que poscicion desea moverse");
                        System.out.println("ingrese su coordenada en Y");
                        int y2 = sc.nextInt();

                        if (tablero[x][y2].equals("[+]") || tablero[x][y2].equals("[X]")) {
                            System.out.println("El espacio esta ocupado");
                            System.out.println("ingrese su coordenada en Y");
                            y2 = sc.nextInt();

                        }
                        if (tablero[x][y].equals("[$]")) {
                            tablero[x][y] = "[ ]";
                            tablero[x][y2] = "[$]";
                        }
                        if (y2 >= y) {
                            for (int i = y2; i <= y2; i++) {
                                if (tablero[x][i].equals("[X]") || tablero[x][i].equals("[+]") || tablero[x][i].equals("[$]")) {
                                    System.out.println("no puede saltar fichas");
                                    System.out.println("ingrese su coordenada en Y");
                                    y2 = sc.nextInt();
                                }
                            }
                        } else {
                            for (int i = y2; i >= y2; i--) {
                                if (tablero[x][i].equals("[X]") || tablero[x][i].equals("[+]") || tablero[x][i].equals("[$]")) {
                                    System.out.println("no puede saltar fichas");
                                    System.out.println("ingrese su coordenada en Y");
                                    y2 = sc.nextInt();

                                }
                            }
                        }
                        tablero[x][y2] = "[X]";
                        tablero[x][y] = "[ ]";
                        Comer(tablero);
                        manerasdeganarey(tablero, turn);
                        impat(tablero, 0, 0);

                        break;
                    case 2:
                        System.out.println("Ingrese a que poscicion desea moverse");
                        System.out.println("ingrese su coordenada en X");
                        int x1 = sc.nextInt();

                        if (tablero[x1][y].equals("[+]") || tablero[x1][y].equals("[X]")) {
                            System.out.println("El espacio esta ocupado");
                            System.out.println("ingrese su coordenada en Y");
                            x1 = sc.nextInt();

                        }
                        if (tablero[x][y].equals("[$]")) {
                            tablero[x][y] = "[ ]";
                            tablero[x1][y] = "[$]";
                        }
                        if (x1 >= x) {
                            for (int i = x; i <= x1; i++) {
                                if (tablero[i][y].equals("[X]") || tablero[i][y].equals("[+]") || tablero[i][y].equals("[$]")) {
                                    System.out.println("no puede saltar fichas");
                                    System.out.println("ingrese su coordenada en X");
                                    x1 = sc.nextInt();
                                }
                            }
                        } else {
                            for (int i = x; i >= x1; i--) {
                                if (tablero[i][y].equals("[X]") || tablero[i][y].equals("[+]") || tablero[i][y].equals("[$]")) {
                                    System.out.println("no puede saltar fichas");
                                    System.out.println("ingrese su coordenada en X");
                                    x1 = sc.nextInt();

                                }
                            }
                        }
                        tablero[x1][y] = "[X]";
                        tablero[x][y] = "[ ]";
                        Comer(tablero);
                        manerasdeganarey(tablero, turn);
                        impat(tablero, 0, 0);

                        break;
                }

            }
            contturno++;

        } while (turn);

    }

    public static String[][] llenar(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                //llenar atacantes
                if (i == 0 && j == 3) {
                    tablero[i][j] = "[+]";
                } else if (i == 0 && j == 4) {
                    tablero[i][j] = "[+]";
                } else if (i == 0 && j == 5) {
                    tablero[i][j] = "[+]";
                } else if (i == 0 && j == 6) {
                    tablero[i][j] = "[+]";
                } else if (i == 0 && j == 7) {
                    tablero[i][j] = "[+]";
                } else if (i == 1 && j == 5) {
                    tablero[i][j] = "[+]";
                    /////////////////////
                } else if (i == 3 && j == 0) {
                    tablero[i][j] = "[+]";
                } else if (i == 4 && j == 0) {
                    tablero[i][j] = "[+]";
                } else if (i == 5 && j == 0) {
                    tablero[i][j] = "[+]";
                } else if (i == 6 && j == 0) {
                    tablero[i][j] = "[+]";
                } else if (i == 7 && j == 0) {
                    tablero[i][j] = "[+]";
                } else if (i == 5 && j == 1) {
                    tablero[i][j] = "[+]";
                    /////////////////
                } else if (i == 3 && j == 10) {
                    tablero[i][j] = "[+]";
                } else if (i == 4 && j == 10) {
                    tablero[i][j] = "[+]";
                } else if (i == 5 && j == 10) {
                    tablero[i][j] = "[+]";
                } else if (i == 6 && j == 10) {
                    tablero[i][j] = "[+]";
                } else if (i == 7 && j == 10) {
                    tablero[i][j] = "[+]";
                } else if (i == 5 && j == 9) {
                    tablero[i][j] = "[+]";
                    //////////////////////
                } else if (i == 10 && j == 3) {
                    tablero[i][j] = "[+]";
                } else if (i == 10 && j == 4) {
                    tablero[i][j] = "[+]";
                } else if (i == 10 && j == 5) {
                    tablero[i][j] = "[+]";
                } else if (i == 10 && j == 6) {
                    tablero[i][j] = "[+]";
                } else if (i == 10 && j == 7) {
                    tablero[i][j] = "[+]";
                } else if (i == 9 && j == 5) {
                    tablero[i][j] = "[+]";
                } else if (i == 5 && j == 5) {
                    tablero[i][j] = "[$]";
                    // llenar defensores
                } else if (i == 2 && j == 5) {
                    tablero[i][j] = "[X]";
                } else if (i == 3 && j == 5) {
                    tablero[i][j] = "[X]";
                } else if (i == 4 && j == 5) {
                    tablero[i][j] = "[X]";
                } else if (i == 6 && j == 5) {
                    tablero[i][j] = "[X]";
                } else if (i == 7 && j == 5) {
                    tablero[i][j] = "[X]";
                } else if (i == 8 && j == 5) {
                    tablero[i][j] = "[X]";
                } else if (i == 5 && j == 2) {
                    tablero[i][j] = "[X]";
                } else if (i == 5 && j == 3) {
                    tablero[i][j] = "[X]";
                } else if (i == 5 && j == 4) {
                    tablero[i][j] = "[X]";
                } else if (i == 5 && j == 6) {
                    tablero[i][j] = "[X]";
                } else if (i == 5 && j == 7) {
                    tablero[i][j] = "[X]";
                } else if (i == 5 && j == 8) {
                    tablero[i][j] = "[X]";
                } else {
                    tablero[i][j] = "[ ]";
                }

            }
        }

        return tablero;
    }

    public static boolean manerasdeganarey(String[][] tablero, boolean ganar) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (i == 0) {
                    if (tablero[i][j].equals("[$]")) {
                        System.out.println("Han ganado los defensores!");
                        ganar = false;
                    }
                    break;
                } else if (j == 0) {
                    if (tablero[i][j].equals("[$]")) {
                        System.out.println("Han ganado los defensores!");
                        ganar = false;
                    }
                    break;
                } else if (i == tablero.length) {
                    if (tablero[i][j].equals("[$]")) {
                        System.out.println("Han ganado los defensores!");
                        ganar = false;
                    }
                    break;
                } else if (j == tablero.length) {
                    if (tablero[i][j].equals("[$]")) {
                        System.out.println("Han ganado los defensores!");
                        ganar = false;
                    }
                    break;
                }
            }
        }
        return ganar;
    }

    public static String[][] Comer(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {

                ////////////////BORDES//////////////////////
                // borde izquierdo
                if (i > 0 && i < 10) {
                    if (tablero[i][j].equals("+")) {
                        if ((tablero[i - 1][j].equals("X") || tablero[i - 1][j].equals("$")) &&/* 2  */ (tablero[i + 1][j].equals("X") || tablero[i + 1][j].equals("$"))) {
                            tablero[i][j] = " ";
                            contatacantes--;
                        }
                    } else if (tablero[i][j].equals("X")) {
                        if ((tablero[i - 1][j].equals("+")) && (tablero[i + 1][j].equals("X"))) {
                            tablero[i][j] = " ";
                        }
                    }
                }
                ////borde superior
                if (j > 0 && j < 10) {
                    if (tablero[i][j].equals("+")) {
                        if ((tablero[i][j - 1].equals("X") || tablero[i][j - 1].equals("$")) && (tablero[i][j + 1].equals("X") || tablero[i][j + 1].equals("$"))) {
                            tablero[i][j] = " ";
                            contatacantes--;
                        }

                    } else if (tablero[i][j].equals("X")) {
                        if ((tablero[i][j - 1].equals("+")) && (tablero[i][j + 1].equals("X"))) {
                            tablero[i][j] = " ";
                        }

                    }

                }
                ///// Borde inferior
                if ((i == 10) && (j > 0 && j < 10)) {
                    if (tablero[i][j].equals("+")) {
                        if ((tablero[i][j - 1].equals("X") || tablero[i][j - 1].equals("$")) && (tablero[i][j + 1].equals("X") || tablero[i][j + 1].equals("$"))) {
                            tablero[i][j] = " ";
                            contatacantes--;
                        }

                    } else if (tablero[i][j].equals("X")) {
                        if ((tablero[i][j - 1].equals("+")) && (tablero[i][j + 1].equals("X"))) {
                            tablero[i][j] = " ";
                        }

                    }

                }
                ////////////Borde Derecho
                if ((i > 10 && i < 10) && (j == 10)) {
                    if (tablero[i][j].equals("+")) {
                        if ((tablero[i - 1][j].equals("X") || tablero[i - 1][j].equals("$")) &&/* 2  */ (tablero[i + 1][j].equals("X") || tablero[i + 1][j].equals("$"))) {
                            tablero[i][j] = " ";
                            contatacantes--;
                        }
                    } else if (tablero[i][j].equals("X")) {
                        if ((tablero[i - 1][j].equals("+")) && (tablero[i + 1][j].equals("X"))) {
                            tablero[i][j] = " ";
                        }
                    }
                }
                //////////////////COMIDA GENERAL////////////////////////////////
                ////ARRIBA Y ABAJO
                if (tablero[i][j].equals("+")) {
                    if ((tablero[i - 1][j].equals("X") || tablero[i - 1][j].equals("$")) &&/* 2  */ (tablero[i + 1][j].equals("X") || tablero[i + 1][j].equals("$"))) {
                        tablero[i][j] = " ";
                        contatacantes--;
                    }
                } else if (tablero[i][j].equals("X")) {
                    if ((tablero[i - 1][j].equals("+")) && (tablero[i + 1][j].equals("X"))) {
                        tablero[i][j] = " ";
                    }
                }
                ///// DERECHA E IZQUIERDA
                if (tablero[i][j].equals("+")) {
                    if ((tablero[i - 1][j].equals("X") || tablero[i - 1][j].equals("$")) &&/* 2  */ (tablero[i + 1][j].equals("X") || tablero[i + 1][j].equals("$"))) {
                        tablero[i][j] = " ";
                        contatacantes--;
                    }
                } else if (tablero[i][j].equals("X")) {
                    if ((tablero[i - 1][j].equals("+")) && (tablero[i + 1][j].equals("X"))) {
                        tablero[i][j] = " ";
                    }
                }
            }
        }
        return tablero;
    }

}
