public class Usuario {
    public static final String TB_USUARIO = "USUARIO";
    public static final String CP_IDUSUARIO = "IDUSUARIO";
    public static final String CP_CONTRASENIA = "CONTRASENIA";
    
    private String idUsuario;
    private String contrasenia;

    public Usuario(String idUsuario, String contrasenia) {
        this.idUsuario = idUsuario;
        this.contrasenia = contrasenia;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", contrasenia=" + contrasenia + '}';
    }
    
    
}
