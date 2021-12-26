package ec.edu.epn.SistemaDeCitas;

public class Estudiante {
    private String nombre;
    private String cedula;
    private String correo;
    private String contraseña;

    public Estudiante() {
    }

    public void darBienvenida(){
        System.out.println("**************************************************************");
        System.out.println("Sistema para reservar citas de Tutorías Académicas");
        System.out.println("**************************************************************");
        System.out.println("Sea bienvenido: "+this.nombre);
    }

    public void salirDelSistema(){
        System.out.println("---------------Salida del Sistema---------------");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String clave) {
        this.contraseña = clave;
    }
}
