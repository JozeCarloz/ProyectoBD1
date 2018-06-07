
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class FuncionesBD {
    private final String URL_BASEDEDATOS = "jdbc:mysql://localhost:3306/mydb";
    private final String USER = "root";
    private final String PASSWORD = "root";
    
    
    /*Atributo que contendra el codigo del resultado sobre la ultima consulta realizada*/
    private int resultadoSQL = 0;
    
    /*Codigos de los resultados de las consultas*/
    public static int EJECUCION_CORRECTA = 0;
    public static int ERROR_CONEXION = 1;
    public static int ERROR_QUERY = 2;
    /*FALTARIA PONER MAS CODIGOS DE ERRORES*/
    public static int FAILURE = 911;
    
    private Connection obtenerConexion(){
        Connection conn = null;
        try {
            /* Preparamos la conexion hacia la base de datos */
            conn = DriverManager.getConnection(URL_BASEDEDATOS, USER, PASSWORD);
        } catch (Exception e) {
            resultadoSQL = ERROR_CONEXION;
            System.out.println(e);
        }
        return conn;
    }
    
    private ResultSet ejecutarQuery(String query){
        ResultSet rs = null;
        try{
            Connection conn = obtenerConexion();
            if(conn != null){
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement(query);
                /* Ejecutamos la sentencia SQL */
                rs = pstmt.executeQuery();
            }
        }catch(Exception e){
            resultadoSQL = ERROR_QUERY;
            System.out.println(e);
        }
        return rs;
    }
    
    public List<Profesor> obtenerListaProfesores() {
        try {
            String query = "SELECT * FROM "+Profesor.TB_PROFESORES;
            ResultSet rs = ejecutarQuery(query);
            if(rs!=null){
                List<Profesor> listaProfes = new LinkedList<>();
                
                while (rs.next()) {
                    String codigo = rs.getString(Profesor.CP_CODIGO);
                    String nombre = rs.getString(Profesor.CP_NOMBRE);
                    String apellidoPat = rs.getString(Profesor.CP_APELLIDOPAT);
                    String apellidoMat = rs.getString(Profesor.CP_APELLIDOMAT);
                    String idUsuario = rs.getString(Profesor.CP_IDUSUARIO);

                    Profesor profe = new Profesor(codigo, nombre, apellidoPat, apellidoMat, idUsuario);
                    listaProfes.add(profe);
                }
                resultadoSQL = EJECUCION_CORRECTA;
                return listaProfes;
            }
        } catch (Exception e) {
            resultadoSQL = FAILURE;
            System.out.println(e);
        }
        return null;
    }
    
    public List<Usuario> obtenerListaUsuarios() {
        try {
            String query = "SELECT * FROM "+Usuario.TB_USUARIO;
            ResultSet rs = ejecutarQuery(query);
            if(rs!=null){
                List<Usuario> listaUsuarios = new LinkedList<>();
                
                while (rs.next()) {
                    String idUsuario = rs.getString(Usuario.CP_IDUSUARIO);
                    String contrasenia = rs.getString(Usuario.CP_CONTRASENIA);

                    Usuario usuario = new Usuario(idUsuario, contrasenia);
                    listaUsuarios.add(usuario);
                }
                resultadoSQL = EJECUCION_CORRECTA;
                return listaUsuarios;
            }
        } catch (Exception e) {
            resultadoSQL = FAILURE;
            System.out.println(e);
        }
        return null;
    }
    
    public List<Alumno> obtenerListaAlumnos() {
        try {
            String query = "SELECT * FROM "+Usuario.TB_USUARIO;
            ResultSet rs = ejecutarQuery(query);
            if(rs!=null){
                List<Alumno> listaAlumnos = new LinkedList<>();
                
                while (rs.next()) {
                    String codigo = rs.getString(Alumno.CP_CODIGO);
                    String nombre = rs.getString(Alumno.CP_NOMBRE);
                    String apellidoPat = rs.getString(Alumno.CP_APELLIDOPAT);
                    String apellidoMat = rs.getString(Alumno.CP_APELLIDOMAT);
                    double promedio = rs.getDouble(Alumno.CP_PROMEDIO);
                    int anioIngreso = rs.getInt(Alumno.CP_ANIOING);
                    String idUsuario = rs.getString(Alumno.CP_IDUSUARIO);
                    

                    Alumno alumno = new Alumno(codigo, nombre, apellidoPat, 
                            apellidoMat, promedio, anioIngreso, idUsuario);
                    listaAlumnos.add(alumno);
                }
                resultadoSQL = EJECUCION_CORRECTA;
                return listaAlumnos;
            }
        } catch (Exception e) {
            resultadoSQL = FAILURE;
            System.out.println(e);
        }
        return null;
    }
    
    
    
    public int obtenerResultadoSQL(){
        return resultadoSQL;
    }
}
