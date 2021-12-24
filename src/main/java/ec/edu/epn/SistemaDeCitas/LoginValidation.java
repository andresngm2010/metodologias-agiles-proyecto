package ec.edu.epn.SistemaDeCitas;

public class LoginValidation {
    private Login_Sistema_EPN login_sistema_epn;

    public LoginValidation(Login_Sistema_EPN login_sistema_epn) {
        this.login_sistema_epn = login_sistema_epn;
    }

    public boolean log_in(String cedula, String correo){
        LoginResponse response = login_sistema_epn.requestLogin(new LoginRequest(cedula, correo));
        if(response.getStatus() == LoginResponse.LoginStatus.OK){
            return true;
        }
        else return false;
    }
}
