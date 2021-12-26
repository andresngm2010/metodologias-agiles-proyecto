package ec.edu.epn.SistemaDeCitas;

import java.util.Scanner;

public class LoginRequest {
    private String cedula;
    private String correo;
    private String contraseña;

    public LoginRequest(String cedula, String correo) {
        this.cedula = cedula;
        this.correo = correo;
    }
    public LoginRequest() {
    }

    public String getCedula() { return cedula; }

    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }
    public String getContraseña() { return contraseña; }

    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    public void ingresoLogin(){
        Scanner sca=new Scanner(System.in);
        System.out.println("////////******Login*****///////////");
        System.out.println("Ingrese su correo");
        correo = sca.nextLine();
        System.out.println("Ingrese su contraseña");
        contraseña = sca.nextLine();

    }
}
