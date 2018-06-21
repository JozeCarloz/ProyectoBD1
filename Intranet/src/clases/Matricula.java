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
public class Matricula {
    private String codAlumno;
    private String codCurso;
    private String codSemestre;
    private int numGrupo;
    private double examenParcial;
    private double examenFinal;
    private double promedioPractica;
    private double notaFinal;

    public Matricula(String codAlumno, String codCurso, String codSemestre, 
            int numGrupo, double examenParcial, double examenFinal, 
            double promedioPractica, double notaFinal) {
        this.codAlumno = codAlumno;
        this.codCurso = codCurso;
        this.codSemestre = codSemestre;
        this.numGrupo = numGrupo;
        this.examenParcial = examenParcial;
        this.examenFinal = examenFinal;
        this.promedioPractica = promedioPractica;
        this.notaFinal = notaFinal;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public String getCodSemestre() {
        return codSemestre;
    }

    public int getNumGrupo() {
        return numGrupo;
    }

    public double getExamenParcial() {
        return examenParcial;
    }

    public double getExamenFinal() {
        return examenFinal;
    }

    public double getPromedioPractica() {
        return promedioPractica;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    @Override
    public String toString() {
        return "Matricula{" + "codAlumno=" + codAlumno + ", codCurso=" + codCurso
                + ", codSemestre=" + codSemestre + ", numGrupo=" + numGrupo 
                + ", examenParcial=" + examenParcial + ", examenFinal=" 
                + examenFinal + ", promedioPractica=" + promedioPractica 
                + ", notaFinal=" + notaFinal + '}';
    }
    
    
}
