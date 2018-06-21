/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Josecarlos
 */
public class CursoHistorial {
    private String codSemestre;
    private int numCreditos;
    private String codCurso;
    private String nombreCurso;
    private String nombreProfesor;
    private double nota;

    public CursoHistorial(String codSemestre, int numCreditos, String codCurso,
            String nombreCurso, String nombreProfesor, double nota) {
        this.codSemestre = codSemestre;
        this.numCreditos = numCreditos;
        this.codCurso = codCurso;
        this.nombreCurso = nombreCurso;
        this.nombreProfesor = nombreProfesor;
        this.nota = nota;
    }

    public String getCodSemestre() {
        return codSemestre;
    }

    public int getNumCreditos() {
        return numCreditos;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "CursoHistorial{" + "codSemestre=" + codSemestre 
                + ", numCreditos=" + numCreditos + ", codCurso=" + codCurso 
                + ", nombreCurso=" + nombreCurso + ", nombreProfesor=" 
                + nombreProfesor + ", nota=" + nota + '}';
    }
    
    
}
