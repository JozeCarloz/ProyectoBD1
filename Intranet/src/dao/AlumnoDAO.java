package dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import clases.Alumno;
import clases.CursoHistorial;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AlumnoDAO extends FuncionesBD{
    
    private int resultadoSQL = 0;
    
    public List<Alumno> obtenerListaAlumnos() {
        try {
            Connection conn = obtenerConexion();
            String query = "SELECT * FROM alumno";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            List<Alumno> listaAlumnos = new LinkedList<>();

            while (rs.next()) {
                String codigo = rs.getString("codAlumno");
                String nombre = rs.getString("nombrealum");
                String apellidoPat = rs.getString("APELLIDOPATALUM");
                String apellidoMat = rs.getString("APELLIDOMATALUM");
                double promedio = rs.getDouble("PROMPONDERADO");
                int anioIngreso = rs.getInt("ANIOINGRESO");
                String idUsuario = rs.getString("IDUSUARIO");


                Alumno alumno = new Alumno(codigo, nombre, apellidoPat, 
                        apellidoMat, promedio, anioIngreso, idUsuario);
                listaAlumnos.add(alumno);
            }
            resultadoSQL = EJECUCION_CORRECTA;
            return listaAlumnos;
            
        } catch (Exception e) {
            resultadoSQL = FAILURE;
            System.out.println(e);
        }
        return null;
    }
    
    public Alumno obtenerAlumnoPorUsuario(String idUsuario){
        try {
            Connection conn = obtenerConexion();
            String query = "SELECT * FROM ALUMNO WHERE IDUSUARIO = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,idUsuario);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String codigo = rs.getString("codAlumno");
                String nombre = rs.getString("nombrealum");
                String apellidoPat = rs.getString("APELLIDOPATALUM");
                String apellidoMat = rs.getString("APELLIDOMATALUM");
                double promedio = rs.getDouble("PROMPONDERADO");
                int anioIngreso = rs.getInt("ANIOINGRESO");

                Alumno alumno = new Alumno(codigo, nombre, apellidoPat, 
                        apellidoMat, promedio, anioIngreso, idUsuario);

                resultadoSQL = EJECUCION_CORRECTA;
                return alumno;
            }
            
        } catch (Exception e) {
            resultadoSQL = FAILURE;
            System.out.println(e);
        }
        return null;
    }
    
    public List<CursoHistorial> obtenerHistorialPorCodAlumno(String codUsuario){
        try {
            Connection conn = obtenerConexion();
            String query = "SELECT codSemestre, numCreditos, codCurso, "
                    + "nombreCurso, nombreProfe, notaFinal "
                    + "FROM ((matricula NATURAL JOIN curso_semestre_grupo) "
                    + "NATURAL JOIN curso) NATURAL JOIN profesor WHERE codAlumno = ?";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,codUsuario);
            ResultSet rs = pstmt.executeQuery();
            
            List<CursoHistorial> historial = new LinkedList<>();
            while (rs.next()) {
                String codigoSemestre = rs.getString("codSemestre");
                int creditos = rs.getInt("numCreditos");
                String codCurso = rs.getString("codCurso");
                String nombreCurso = rs.getString("nombreCurso");
                String nombreProfesor = rs.getString("nombreProfe");
                double nota = rs.getDouble("notaFinal");
                
                CursoHistorial cursoHistorial = 
                        new CursoHistorial(codigoSemestre, creditos, codCurso, 
                                nombreCurso, nombreProfesor, nota);
                
                historial.add(cursoHistorial);
            }
            resultadoSQL = EJECUCION_CORRECTA;
            return historial;
            
        } catch (Exception e) {
            resultadoSQL = FAILURE;
            System.out.println(e);
        }
        return null;
    }
    
    @Override
     public int obtenerResultadoSQL(){
        return resultadoSQL;
    }
     
    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        List<Alumno> listaAlum = alumnoDAO.obtenerListaAlumnos();
        System.out.println("LISTA DE ALUMNOS");
        if(alumnoDAO.obtenerResultadoSQL() == FuncionesBD.EJECUCION_CORRECTA)
            listaAlum.iterator().forEachRemaining(System.out::println);
        else{
            System.out.println("Existen errores");
        }
        
        String usuario = "A02";
        Alumno alumno = alumnoDAO.obtenerAlumnoPorUsuario("adrian.medina");
        System.out.println("Alumno de usuario "+usuario);
        if(alumnoDAO.obtenerResultadoSQL() == FuncionesBD.EJECUCION_CORRECTA)
            System.out.println(alumno);
        else{
            System.out.println("Existen errores");
        }
        
        String codAlumno = "A01";
        List<CursoHistorial> historial = alumnoDAO.obtenerHistorialPorCodAlumno(codAlumno);
        System.out.println("Historial del alumno "+codAlumno);
        if(alumnoDAO.obtenerResultadoSQL() == FuncionesBD.EJECUCION_CORRECTA)
            historial.forEach(System.out::println);
        else{
            System.out.println("Existen errores");
        }
    }
}
