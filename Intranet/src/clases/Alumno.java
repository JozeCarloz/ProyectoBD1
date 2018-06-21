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
public class Alumno {
    private String codigo;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private double promedio;
    private int anioIngreso;
    private String idUsuario;

    public Alumno(String codigo, String nombre, String apellidoPat, 
            String apellidoMat, double promedio, int anioIngreso, 
            String idUsuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.promedio = promedio;
        this.anioIngreso = anioIngreso;
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

    public double getPromedio() {
        return promedio;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "Alumno{" + "codigo=" + codigo + ", nombre=" + nombre 
                + ", apellidoPat=" + apellidoPat + ", apellidoMat=" 
                + apellidoMat + ", promedio=" + promedio + ", anioIngreso=" 
                + anioIngreso + ", idUsuario=" + idUsuario + '}';
    }
    
    

}
