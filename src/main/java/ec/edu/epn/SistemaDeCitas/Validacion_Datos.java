package ec.edu.epn.SistemaDeCitas;

import java.util.regex.Pattern;

public class Validacion_Datos {
    private String nombre;
    private String cedula;
    private String correo;
    private Estudiante estudiante;

    public boolean validacion_nombre(String nombre){
        String patron = "^[A-Z]{1}[a-z]+[ ][A-Z]{1}[a-z]+$";
        return nombre.matches(patron);
    }

    public boolean validacion_cedula(String cedula){
        try{
            if(cedula.length() == 10){
                if(Integer.parseInt(cedula.substring(2, 3)) < 6){
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2 };
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito;
                    for(int i = 0; i < (cedula.length() - 1); i++){
                        digito = Integer.parseInt(cedula.substring(i, i+1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
                    final int residuoBase10 = suma % 10;
                    if((residuoBase10) == 0 && (verificador == 0)){
                        return true;
                    }
                    else return (10 - (residuoBase10)) == verificador;
                }
                return false;
            }
            else return false;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean validacion_correo(String correo){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        return pattern.matcher(correo).find();
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
