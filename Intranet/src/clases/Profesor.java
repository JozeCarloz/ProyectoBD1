package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josecarlos
 */
public class Profesor {
    /*Nombre de la tabla de los profesores*/
    public static final String TB_PROFESORES = "PROFESOR";
    /*Nombre de los campos*/
    public static final String CP_CODIGO = "CODPROFESOR";
    public static final String CP_NOMBRE = "NOMBREPROFE";
    public static final String CP_APELLIDOPAT = "APELLIDOPATPROFE";
    public static final String CP_APELLIDOMAT = "APELLIDOMATPROFE";
    public static final String CP_IDUSUARIO = "IDUSUARIO";
    
    private String codigo;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String idUsuario;

    public Profesor(String codigo, String nombre, String apellidoPat, String apellidoMat, String idUsuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.idUsuario = idUsuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "Profesor{" + "codigo=" + codigo + ", nombre=" + nombre 
                + ", apellidoPat=" + apellidoPat + ", apellidoMat=" 
                + apellidoMat + ", idUsuario=" + idUsuario + '}';
    }
    
    
}
