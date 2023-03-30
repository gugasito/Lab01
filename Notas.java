import java.util.Scanner;

public class Notas{

    public static void main(String[] args) {
        double students[][] = new double[5][50];
        menu(students);
    }

    public static void menu(double[][] students) {
        System.out.println("Bienvenido al menú");
        System.out.println("[1] Agregar estudiante");
        System.out.println("[2] Mostrar cantidad de estudiantes aprobados");
        System.out.println("[3] Mostrar cantidad de estudiantes reprobados");
        System.out.println("[4] Mostrar cantidad de estudiantes en examen");
        System.out.println("[5] Mostrar estado de todos los estudiantes");
        System.out.println("[6] Salir");
        opcion(students);
    }

    private static void opcion(double[][] students) {
        Scanner screen = new Scanner(System.in);
        int opcion = screen.nextInt();
        switch (opcion) {
            case 1:
                if (revisar(students)) {
                    agregarNota(students, posDisp(students));
                } else {
                    System.out.println("Registro de notas lleno");
                }
                menu(students);
            case 2:
                if (vacia(students)) {
                    aproveS(students);
                    mostrarAprove(students);
                } else {
                    System.out.println("Registro de notas vacio, agregue notas");
                }
                menu(students);
            case 3:
                if (vacia(students)) {
                    disaproveS(students);
                    mostrarDisaprove(students);
                } else {
                    System.out.println("Registro de notas vacio, agregue notas");
                }
                menu(students);
            case 4:
                if (vacia(students)) {
                    examen(students);
                    mostrarExam(students);
                } else {
                    System.out.println("Registro de notas vacio, agregue notas");
                }
                menu(students);
            case 5:
                if (vacia(students)) {
                    detalle(students);
                } else {
                    System.out.println("Registro de notas vacio, agregue notas");
                }
                menu(students);
            case 6:
                salir(students);

        }
    }

    public static void agregarNota(double students[][], int disp) {
        int pos = 50 - disp;
        for (int i = 0; i < 5; i++) {
            students[i][pos] = numGen();
        }
    }

    public static double numGen() {
        double num = (Math.random() * 6) + 1;
        return num;
    }

    public static void salir(double[][] students) {
        Scanner screen = new Scanner(System.in);
        System.out.println("Seguro desea salir? (s/n)");
        String opcion = screen.next();
        if (opcion.equals("s")) {
            System.out.println("Hasta la proxima!");
            System.exit(0);
        } else if (opcion.equals("n")) {
            menu(students);
        }
    }

    public static void detalle(double[][] students) {
        for (int j = 0; j < registrados(students); j++) {
            System.out.println("ESTUDIANTE [" + (j + 1) + "]: ");
            System.out.println("Notas:");
            for (int i = 0; i < 5; i++) {
                System.out.println(students[i][j]);
            }
            System.out.println("Promedio:");
            System.out.println(promedio(students, j));
        }
    }

    public static int posDisp(double[][] students) {
        int cant = 0;
        for (int j = 0; j < 50; j++) {
            if (students[0][j] == 0.0) {
                cant++;
            }
        }
        return cant;
    }

    public static int disaproveS(double[][] students) {
        int count;
        count = registrados(students) - aproveS(students);
        return count;
    }

    public static int aproveS(double[][] students) {
        int count = 0;
        for (int j = 0; j < registrados(students); j++) {
            if (promedio(students, j) >= 4.0) {
                count++;
            }
        }
        return count;
    }

    public static int examen(double[][] students) {
        int count = 0;
        for (int j = 0; j < registrados(students); j++) {
            if (promedio(students, j) >= 3.6 && promedio(students, j) < 4.0) {
                count++;
            }
        }
        return count;
    }

    public static void mostrarExam(double[][] students) {
        System.out.println("La cantidad de estudiantes que van a examen es: " + examen(students));
    }

    public static double promedio(double[][] students, int pos) {
        double prom;
        prom = (students[0][pos] * 0.10) + (students[1][pos] * 0.25) + (students[2][pos] * 0.25) + (students[3][pos] * 0.15) + (students[4][pos] * 0.1);
        return prom;
    }

    public static void mostrarAprove(double[][] students) {
        System.out.println("La cantidad de estudiantes que aprueban es: " + aproveS(students));
    }

    public static void mostrarDisaprove(double[][] students) {
        System.out.println("La cantidad de estudiantes que desaprueban es: " + disaproveS(students));
    }

    public static int registrados(double[][] students) {
        int count = 0;
        for (int i = 0; i < 50; i++) {
            if (students[0][i] != 0.0) {
                count++;
            }
        }
        return count;
    }

    public static boolean revisar(double[][] students) {
        boolean llena = true;
        if (students[0][49] != 0.0) {
            llena = false;
        }
        return llena;
    }

    private static boolean vacia(double[][] students) {
        boolean llena = true;
        if (students[0][0] == 0.0) {
            llena = false;
        }
        return llena;
    }
}
