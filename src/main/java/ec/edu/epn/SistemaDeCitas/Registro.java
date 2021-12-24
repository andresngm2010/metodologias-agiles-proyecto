package ec.edu.epn.SistemaDeCitas;


import java.util.ArrayList;
import java.util.Scanner;

public class Registro {
    boolean aprobado;
    ArrayList<Estudiante> listaEstudiantesRegistrados;

    public Registro() {
        listaEstudiantesRegistrados = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante estudiante){
        Scanner sca=new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String aux = sca.nextLine();
        estudiante.setNombre(aux);
        System.out.println("Ingrese su correo institucional: ");
        aux = sca.nextLine();
        estudiante.setCorreo(aux);
        System.out.println("Ingrese su cedula: ");
        aux = sca.nextLine();
        estudiante.setCedula(aux);
        System.out.println("Ingrese una contraseña para su usuario: ");
        aux = sca.nextLine();
        estudiante.setContraseña(aux);
        validarDatosEstudiante(estudiante);
        if(!aprobado){
            System.out.println("No se ha podido registrar");
            return;
        }
        listaEstudiantesRegistrados.add(estudiante);
        System.out.println("¡¡¡ Usted ha sido registrado correctamente !!!");
        estudiante.darBienvenida();
    }

    public boolean validarDatosEstudiante(Estudiante estudiante){
        Validacion_Datos vd=new Validacion_Datos();
        String nombreAux = estudiante.getNombre();
        if(!vd.validacion_nombre(nombreAux)){
            System.out.println("Su nombre no es válido");
            aprobado = false;
            return aprobado;
        }
        String cedulaAux = estudiante.getCedula();
        if(!vd.validacion_cedula(cedulaAux)){
            System.out.println("Su cédula no es valida");
            aprobado = false;
            return aprobado;
        }
        String correoAux = estudiante.getCorreo();
        if(!vd.validacion_correo(correoAux)){
            System.out.println("Su correo no es válido");
            aprobado = false;
            return aprobado;
        }
        aprobado = true;
        return aprobado;
    }
}
