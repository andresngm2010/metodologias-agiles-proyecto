package ec.edu.epn.SistemaDeCitas;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();
        Registro registro = new Registro();
        LoginRequest login = new LoginRequest();
        estudiante.setNombre("Andres Gomez");
        estudiante.setCorreo("andres.gomez@epn.edu.ec");
        estudiante.setCedula("1712027554");
        estudiante.setContraseña("123456");
        //registro.ingresarDatosEstudiante(estudiante);
        registro.validarDatosEstudiante(estudiante);
        registro.añadirAListaEstudiantes(estudiante);
        //registro.imprimirLista();
        login.ingresoLogin();
        registro.isAprobado(login.getCorreo(), login.getContraseña());
    }
}
