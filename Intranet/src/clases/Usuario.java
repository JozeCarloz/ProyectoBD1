package clases;

public class Usuario {
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
