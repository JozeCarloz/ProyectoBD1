
import java.util.List;
import javafx.collections.FXCollections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josecarlos
 */
public class Prueba {
    public static void main(String[] args) {
        FuncionesBD funbd = new FuncionesBD();
        
        //LISTA DE PROFESORES
        List<Profesor> listaProf = funbd.obtenerListaProfesores();
        int codResul = funbd.obtenerResultadoSQL();
        if(codResul == FuncionesBD.EJECUCION_CORRECTA){
            System.out.println("EJECUCION CORRECTA");
            listaProf.forEach(System.out::println);
            
            //Convertir a observableArrayList
            FXCollections.observableArrayList(listaProf);
        }else if(codResul == FuncionesBD.ERROR_QUERY){
            System.out.println("ERROR EN QUERY");
        }else{
            System.out.println("ERROR EN EJECUCION");
        }
        
        List<Usuario> listaUsers = funbd.obtenerListaUsuarios();
        if(funbd.obtenerResultadoSQL() == FuncionesBD.EJECUCION_CORRECTA){
            System.out.println("EJECUCION CORRECTA");
            listaUsers.forEach(System.out::println);
            
            //Convertir a observableArrayList
            FXCollections.observableArrayList(listaUsers);
        }else{
            System.out.println("EJECUCION INCORRECTA");
        }
    }
}
