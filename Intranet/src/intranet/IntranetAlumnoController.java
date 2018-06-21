package intranet;

import clases.Alumno;
import clases.CursoHistorial;
import dao.AlumnoDAO;
import java.net.URL;
import utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;

public class IntranetAlumnoController implements Initializable  {
    private AlumnoDAO daoAlumno;
    private Alumno alumno;

    @FXML
    private TabPane tabPane;

    @FXML
    private Label outputCodigo;

    @FXML
    private Label outputNombres;

    @FXML
    private Label outputApellidos;

    @FXML
    private Label outputAnioIngreso;

    @FXML
    private Label outputPromedio;

    @FXML
    private TableView<CursoHistorial> tableHistorialAcademico;

    @FXML
    private TableColumn<CursoHistorial, String> columnSemestre;

    @FXML
    private TableColumn<CursoHistorial, Integer> columnCreditos;

    @FXML
    private TableColumn<CursoHistorial, String> columnCodAsignatura;

    @FXML
    private TableColumn<CursoHistorial, String> columnNomAsignatura;

    @FXML
    private TableColumn<CursoHistorial, String> columnProfesor;

    @FXML
    private TableColumn<CursoHistorial, Double> columnNota;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //public void initialize(){
        daoAlumno = new AlumnoDAO();
        alumno = daoAlumno.obtenerAlumnoPorUsuario(Utils.idUsuarioActual);
        if(daoAlumno.obtenerResultadoSQL() == AlumnoDAO.EJECUCION_CORRECTA){
            System.out.println("Alumno cargado correctamente");
            cargarInformacionAlumno();
            cargarHistorialAlumno();
        }else{
            System.out.println("No se pudo cargar al alumno de la bd");
        }
    }
    
    @FXML
    void mostrarHistorialAcademico(ActionEvent event) {

        System.out.println("Pestaña Historial Academico Seleccionada");
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(1);

    }

    @FXML
    void mostrarPaginaPersonal(ActionEvent event) {

        System.out.println("Pestaña Pagina Personal Seleccionada");
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(0);

    }

    @FXML
    void salir(ActionEvent event) {
        System.out.println("Cerra Sesion");
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    private void cargarInformacionAlumno(){
        outputCodigo.setText(alumno.getCodigo());
        outputNombres.setText(alumno.getNombre());
        outputApellidos.setText(alumno.getApellidoPat()+" "+alumno.getApellidoMat());
        outputAnioIngreso.setText(alumno.getAnioIngreso()+"");
        outputPromedio.setText(alumno.getPromedio()+"");
        
    }

    private void cargarHistorialAlumno() {
        List<CursoHistorial> historial = 
                daoAlumno.obtenerHistorialPorCodAlumno(alumno.getCodigo());
        
        if(daoAlumno.obtenerResultadoSQL()==AlumnoDAO.EJECUCION_CORRECTA){
            System.out.println("Cargado historial correctamente");
            
            tableHistorialAcademico.setItems(FXCollections.observableArrayList(historial));
            columnSemestre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodSemestre()));
            columnCreditos.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getNumCreditos()));
            columnCodAsignatura.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodCurso()));
            columnNomAsignatura.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCurso()));
            columnProfesor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreProfesor()));
            columnNota.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNumCreditos()));
        }else{
            System.out.println("No se pudo cargar el historial");
        }
    }
}
