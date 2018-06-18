package intranet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class IntranetAlumnoController {

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
    private TableView<?> tableHistorialAcademico;

    @FXML
    private TableColumn<?, ?> columnSemestre;

    @FXML
    private TableColumn<?, ?> columnCreditos;

    @FXML
    private TableColumn<?, ?> columnCodAsignatura;

    @FXML
    private TableColumn<?, ?> columnNomAsignatura;

    @FXML
    private TableColumn<?, ?> columnProfesor;

    @FXML
    private TableColumn<?, ?> columnNota;

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

}
