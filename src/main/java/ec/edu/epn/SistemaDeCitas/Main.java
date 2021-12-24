package ec.edu.epn.SistemaDeCitas;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();
        Registro registro = new Registro();
        registro.registrarEstudiante(estudiante);
    }
}
