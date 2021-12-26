package ec.edu.epn.SistemaDeCitas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith( value = Parameterized.class)
public class Registro_ValidarEstudiantes_ParametersTest {
    private Estudiante estudiante;
    private ArrayList<Estudiante> listaEstudiantes_expected = new ArrayList<>();
    private ArrayList<Estudiante> listaEstudiantes_actual;
    private Registro r = new Registro();

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters(){
        List<Object[]>objects = new ArrayList<>();
        objects.add(new Object[]{"Cristian Gomez", "1712027554", "cristian.gomez@epn.edu.ec"});
        objects.add(new Object[]{"Andres Gomez", "1727624593", "andres.gomez@epn.edu.ec"});
        objects.add(new Object[]{"Juan Herrera", "1303753618", "juan.herrera01@epn.edu.ec"});
        objects.add(new Object[]{"Pedro Ortiz", "1704997012", "pedro.ortiz@epn.edu.ec"});
        objects.add(new Object[]{"Sara Benavides", "1713627071", "sara.benavides@epn.edu.ec"});
        objects.add(new Object[]{"Estefania Fernandez", "0401197298", "stefania.fernandez@epn.edu.ec"});
        objects.add(new Object[]{"Bryan Flores", "0917385288", "bryan.flores01@epn.edu.ec"});
        objects.add(new Object[]{"Francisco Garcia", "1305267542", "fran.garcia@epn.edu.ec"});
        return objects;
    }

    public Registro_ValidarEstudiantes_ParametersTest(String nombre, String cedula, String correo){
        this.estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setCedula(cedula);
        estudiante.setCorreo(correo);
        estudiante.setContraseña("**************");
        this.listaEstudiantes_expected.add(estudiante);
    }

    @Test
    public void given_estudiante_when_validation_then_ok(){
        assertTrue(r.validarDatosEstudiante(estudiante));
    }

    @Test
    public void given_estudiante_when_signing_expected_identical_arrays_then_ok(){
        r.añadirAListaEstudiantes(estudiante);
        listaEstudiantes_actual = r.listaEstudiantesRegistrados;
        assertEquals(listaEstudiantes_expected, listaEstudiantes_actual);
    }
    @Test
    public void given_estudiantes_when_login_then_aprove_login(){
        r.añadirAListaEstudiantes(estudiante);
        LoginRequest lr = new LoginRequest();
        lr.setCorreo(estudiante.getCorreo());
        lr.setContraseña(estudiante.getContraseña());
        assertTrue(r.isAprobado(lr.getCorreo(), lr.getContraseña()));
    }
}
