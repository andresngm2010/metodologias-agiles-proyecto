package ec.edu.epn.SistemaDeCitas;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();
        Registro registro = new Registro();
        estudiante.setNombre("Andres Gomez");
        estudiante.setCorreo("andres.gomez@epn.edu.ec");
        estudiante.setCedula("1712027554");
        estudiante.setContraseña("***************");
        registro.validarDatosEstudiante(estudiante);
        registro.añadirAListaEstudiantes(estudiante);
    }
}
