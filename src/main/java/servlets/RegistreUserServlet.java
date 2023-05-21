package servlets;

import java.io.IOException;
import java.sql.SQLException;
import co.edu.sena.javataller4.model.User;
import co.edu.sena.javataller4.model.repository.Repository;
import co.edu.sena.javataller4.model.repository.UserRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formUser")
public class RegistreUserServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //NO SE USA Super
    response.setContentType("text/html");
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //todo collect all from data
    String user_firstname = request.getParameter("user_firstname");
    String user_lastname = request.getParameter("user_lastname");
    String user_email = request.getParameter("user_email");
    String user_password = request.getParameter("user_password");
    //Crear objeto tipo usuario
    User user = new User(user_firstname, user_lastname, user_email, user_password);

    Repository<User> repository = new UserRepositoryImpl();
    int rows = 0;
    try {
      repository.saveObj(user);
    } catch (SQLException e){
      e.printStackTrace();
    }
    //Mensaje de informacion para usuario
    if (rows == 0) {
      System.out.println ("Ocurrio un error");
    }
    else {
      System.out.println ("Todo bien");
    }
    }
  }

