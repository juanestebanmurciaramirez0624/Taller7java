package servlets;

import java.io.IOException;
import java.sql.SQLException;

import co.edu.sena.javataller4.model.Products;
import co.edu.sena.javataller4.model.repository.ProductsRepositoryImpl;
import co.edu.sena.javataller4.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formProducts")
public class RegistreProductsServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //NO SE USA Super
    response.setContentType("text/html");
  }
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //todo collect all from data
    String product_name = request.getParameter("product_name");
    String product_value = request.getParameter("product_value");
    String category_id = request.getParameter("category_id");
    //Crear objeto tipo usuario
    Products products = new Products(product_name, product_value, category_id);
    
    Repository<Products> repository = new ProductsRepositoryImpl();
    int rows = 0;
    try {
      repository.saveObj(products);
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

