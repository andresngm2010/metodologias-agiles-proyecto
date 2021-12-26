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
        ingresarDatosEstudiante(estudiante);
        validarDatosEstudiante(estudiante);
        if(!aprobado){
            System.out.println("No se ha podido registrar");
            return;
        }
        añadirAListaEstudiantes(estudiante);
    }

    public void añadirAListaEstudiantes(Estudiante estudiante) {
        listaEstudiantesRegistrados.add(estudiante);
        System.out.println("¡¡¡ Usted ha sido registrado correctamente !!!");
        estudiante.darBienvenida();
    }

    public void ingresarDatosEstudiante(Estudiante estudiante) {
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
    }

    public boolean validarDatosEstudiante(Estudiante estudiante){
        Validacion_Datos vd=new Validacion_Datos();
        if(!vd.validacion_nombre(estudiante.getNombre())){
            System.out.println("Su nombre no es válido");
            return aprobado = false;
        }
        if(!vd.validacion_cedula(estudiante.getCedula())){
            System.out.println("Su cédula no es valida");
            return aprobado = false;
        }
        if(!vd.validacion_correo(estudiante.getCorreo())){
            System.out.println("Su correo no es válido");
            return aprobado = false; 
        }
        return aprobado = true;
    }

    public void imprimirLista(){
        listaEstudiantesRegistrados.forEach((misDatos)->{
            System.out.println(misDatos.getCedula());
            System.out.println(misDatos.getContraseña());
            System.out.println(misDatos.getCorreo());
        });
    }

    public boolean isAprobado(String usuario, String contraseña) {
        aprobado=false;
        listaEstudiantesRegistrados.forEach((misDatos)->{
            final boolean verificarCorreo = misDatos.getCorreo().equals(usuario);
            final boolean verificarContraseña = misDatos.getContraseña().equals(contraseña);
            if(verificarCorreo && verificarContraseña) {
                System.out.println("¡¡¡ Login realizado satisfactoriamente !!!");
                misDatos.darBienvenida();
                aprobado=true;
            }
        });
        return aprobado;
    }
}
