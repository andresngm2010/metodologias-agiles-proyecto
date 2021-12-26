package ec.edu.epn.SistemaDeCitas;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class Validacion_DatosTest {

    @Test
    public void given_nombre_estudiante_when_validation_then_ok(){
        Estudiante e = new Estudiante();
        Validacion_Datos vd = new Validacion_Datos();
        e.setNombre("Francisco Flores");
        assertTrue(vd.validacion_nombre(e.getNombre()));
    }

    @Test
    public void given_cedula_when_validation_then_ok(){
        Estudiante e = new Estudiante();
        Validacion_Datos vd = new Validacion_Datos();
        e.setCedula("1727624593");
        assertTrue(vd.validacion_cedula(e.getCedula()));
    }

    @Test
    public void given_cedula_when_validation_then_error(){
        Estudiante e = new Estudiante();
        Validacion_Datos vd = new Validacion_Datos();
        e.setCedula("24576");
        assertFalse(vd.validacion_cedula(e.getCedula()));
    }

    @Test(timeout = 5)
    public void given_cedula_when_validation_then_timeout(){
        Estudiante e = new Estudiante();
        Validacion_Datos vd = new Validacion_Datos();
        e.setCedula("24576");
        assertFalse(vd.validacion_cedula(e.getCedula()));
    }

    @Test
    public void given_correo_when_validation_then_ok(){
        Estudiante e = new Estudiante();
        Validacion_Datos vd = new Validacion_Datos();
        e.setCorreo("francisco.flores@epn.edu.ec");
        assertTrue(vd.validacion_correo(e.getCorreo()));
    }

    @Test
    public void given_cedula_when_validation_then_not_null(){
        Estudiante e = new Estudiante();
        Validacion_Datos vd = new Validacion_Datos();
        e.setCedula("1712027554");
        vd.setCedula(e.getCedula());
        String object = vd.getCedula();
        vd.validacion_cedula(object);
        assertNotNull(object);
    }

    @Test
    public void given_correo_when_validation_is_incorrect_then_error(){
        Estudiante e = new Estudiante();
        Validacion_Datos vd = new Validacion_Datos();
        e.setCorreo("steven.@epn");
        String correo = e.getCorreo();
        assertFalse(vd.validacion_correo(correo));
    }

    @Test
    public void given_correo_when_validation_then_notnull(){
        Estudiante e = new Estudiante();
        Validacion_Datos vd = new Validacion_Datos();
        e.setCorreo("fernando.ponce@epn.edu.ec");
        vd.setCorreo(e.getCorreo());
        String object = vd.getCorreo();
        vd.validacion_correo(object);
        assertNotNull(object);
    }

    @Test
    public void given_nombre_and_contrasenia_when_is_correct_then_ok(){
        Login_Sistema_EPN loginSistemaEpn = Mockito.mock(Login_Sistema_EPN.class);
        LoginValidation validation = new LoginValidation(loginSistemaEpn);
        Mockito.when(loginSistemaEpn.requestLogin(Mockito.any()))
                .thenReturn(new LoginResponse(LoginResponse.LoginStatus.OK));
        assertTrue(validation.log_in("1722067574","francisco.flores@epn.edu.ec"));
    }

    @Test
    public void given_nombre_and_contrasenia_when_is_incorrect_then_error(){
        Login_Sistema_EPN loginSistemaEpn = Mockito.mock(Login_Sistema_EPN.class);
        LoginValidation validation = new LoginValidation(loginSistemaEpn);
        Mockito.when(loginSistemaEpn.requestLogin(Mockito.any()))
                .thenReturn(new LoginResponse(LoginResponse.LoginStatus.ERROR));
        assertFalse(validation.log_in("1457846521","asdefgv.ed.@ec"));
    }
        @Test(timeout = 970)
    public void given_nombre_and_contrasenia_when_validation_then_timeout(){
        Login_Sistema_EPN loginSistemaEpn = Mockito.mock(Login_Sistema_EPN.class);
        LoginValidation validation = new LoginValidation(loginSistemaEpn);
        Mockito.when(loginSistemaEpn.requestLogin(Mockito.any()))
                .thenReturn(new LoginResponse(LoginResponse.LoginStatus.OK));
        assertTrue(validation.log_in("1722067574","francisco.flores@epn.edu.ec"));
    }
}