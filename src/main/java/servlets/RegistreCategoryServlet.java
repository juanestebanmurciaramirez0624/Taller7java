package servlets;


import java.io.IOException;
import java.sql.SQLException;

import co.edu.sena.javataller4.model.Category;
import co.edu.sena.javataller4.model.repository.CategoryRepositoryImpl;
import co.edu.sena.javataller4.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formCategory")
public class RegistreCategoryServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //NO SE USA Super
    response.setContentType("text/html");
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //todo collect all from data
    String category_name = request.getParameter("category_name");
    //Crear objeto tipo usuario
    Category category = new Category(category_name);
    
    Repository<Category> repository = new CategoryRepositoryImpl();
    int rows = 0;
    try {
      repository.saveObj(category);
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
