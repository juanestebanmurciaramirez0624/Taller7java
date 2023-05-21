package co.edu.sena.javataller4.model.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//Una interfaz se crea los metodos pero no se implementa

public interface Repository <T>{ //Los parentesis diamante permiten que la interfas pueda resivir cualquier objeto en forma generica
  List<T> listAllObj() throws SQLException; //En la lista se guarda todos los objetos que se resivan
  T byIdObj(Integer id) throws SQLException; // Resive el argumento id y retorna el objeto 
  Integer saveObj(T t) throws SQLException; //Se guarda una vez
  void deleteObj(Integer id) throws SQLException;
  T createObj(ResultSet rs) throws SQLException;
}
