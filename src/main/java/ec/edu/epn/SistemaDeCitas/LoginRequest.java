package ec.edu.epn.SistemaDeCitas;

public class LoginRequest {
    private String cedula;
    private String correo;

    public LoginRequest(String cedula, String correo) {
        this.cedula = cedula;
        this.correo = correo;
    }

    public String getCedula() { return cedula; }

    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }
}
