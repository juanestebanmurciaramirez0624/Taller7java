package co.edu.sena.javataller4.model.repository;

import java.sql.SQLException;

import co.edu.sena.javataller4.model.User;

public class TestUserRepositoryImpl {
  public static void main(String[] args) throws SQLException {
    Repository<User> repository = new UserRepositoryImpl();
    
    System.out.println ("========== saveObj Insert ==========");
    User UserInsert = new User (); 
    UserInsert.setUser_firstname("David");
    UserInsert.setUser_lastname("Murcia");
    UserInsert.setUser_email("davidsantiago14@gmail.com");
    UserInsert.setUser_password("Davidcontra01");
    repository.saveObj(UserInsert);
    UserInsert.setUser_firstname("Felipe");
    UserInsert.setUser_lastname("Molano");
    UserInsert.setUser_email("felipemolano12@gmail.com");
    UserInsert.setUser_password("FelipeSantiagoMolContra12");
    repository.saveObj(UserInsert);

    System.out.println("========== listAllObj ==========");
    repository.listAllObj().forEach(System.out::println);
    System.out.println();

    System.out.println("========== byIdObj ==========");
    System.out.println(repository.byIdObj(1));
    System.out.println();

    System.out.println("========== saveObj ==========");
    User UserUpdate = new User();
    UserUpdate.setUser_id(2);
    UserUpdate.setUser_firstname("Santiago");
    UserUpdate.setUser_lastname("Hernandez");
    UserUpdate.setUser_email("SantiagoHern12@gmail.com");
    UserUpdate.setUser_password("SantiagesContra78");
    repository.saveObj(UserUpdate);
    repository.listAllObj().forEach(System.out::println);
    System.out.println();

    System.out.println("========== deleteObj ==========");
    repository.deleteObj(2);
    repository.listAllObj().forEach(System.out::println);
  }
}
