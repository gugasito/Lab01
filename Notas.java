import java.util.Scanner;
public class Notas {

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
                agregarNota(students, notasDisp(students));
                menu(students);
            case 2:
                menu(students);
            case 3:
                menu(students);
            case 4:
                menu(students);
            case 5:
                mostrar(students);
                menu(students);
            case 6:
                salir(students);

        }
    }

    public static void agregarNota(double students[][], int disp) {
        int pos = 50 - disp;
        for (int i = 0; i < 5; i++) {
            students[i][pos] = numGen();
            System.out.println(students[i][pos]);
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

    public static void mostrar(double[][] students) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.println(students[i][j]);
            }
        }
    }

    public static boolean revisar(double[][] students) {
        boolean vacio = false;
        if (students[0][0] == 0) {
            vacio = true;
            System.out.println("La matriz está vacia, favor ingresar datos");
        }
        return vacio;
    }

    public static int notasDisp(double[][] students) {
        int cant = 0;
        for (int j = 0; j < 50; j++) {
            if (students[0][j] == 0.0) {
                cant++;
            }
        }
        return cant;
    }
}
