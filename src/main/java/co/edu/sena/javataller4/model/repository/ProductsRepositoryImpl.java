package co.edu.sena.javataller4.model.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import co.edu.sena.javataller4.model.Products;
import co.edu.sena.javataller4.util.ConnectionPool;

public class ProductsRepositoryImpl implements Repository<Products>{ // Se implmenta la interfaz con la palabra reservada implement
  
    private String sql = null; // Se usa para no crear un sql en cada metodo
  
  @Override
    public Products createObj(ResultSet rs) throws SQLException {
        Products products = new Products();
        products.setProduct_id(rs.getInt("product_id"));
        products.setProduct_name(rs.getString("product_name"));
        products.setProduct_value(rs.getString("product_value"));
        products.setCategory_id(rs.getString("category_id"));
        return products;
    }
  
    @Override // Override se usa porque se sobre escribe el metodo en la interfaz
    
    public List<Products> listAllObj() throws SQLException {
      sql = "select product_id, product_name, product_value, category_id from products";
      List<Products> products = new ArrayList<>();
      try (Connection conn = ConnectionPool.getConnection();
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(sql)) {
              while (rs.next()) {
                Products u = createObj(rs);
                products.add(u);
              }
      }
      return products;
  }
    @Override
    
    public Products byIdObj(Integer id) throws SQLException {
      sql = "select product_id, product_name, product_value, category_id from products where product_id = ?";
      Products products = null;
  
      try (
          Connection conn = ConnectionPool.getConnection();
          PreparedStatement ps = conn.prepareStatement(sql)
          ) {
              ps.setInt(1, id);
              try(ResultSet rs = ps.executeQuery()){
                  if(rs.next()){
                    products = createObj(rs);
                  }
              }
      }
      return products;
  }
  
    @Override
    public Integer saveObj(Products products) throws SQLException {
      int rowsAffected = 0;
  
      if(products.getProduct_id() != null && products.getProduct_id() > 0){
          sql = "update products set product_name = ?, product_value=?, category_id = ? where product_id = ?";
      } else{
          sql = "insert into products (product_name, product_value, category_id)"+ 
          "values ( upper(?), ?, ?" +
          ");";
      }
      try(Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
          ps.setString(1, products.getProduct_name());
          ps.setString(2, products.getProduct_value());
          ps.setString(2, products.getCategory_id());
          if(products.getProduct_id() != null && products.getProduct_id() > 0){
              ps.setInt(2, products.getProduct_id());
          }
          rowsAffected = ps.executeUpdate();
      }
      return rowsAffected;
  }
  
  @Override
  public void deleteObj(Integer id) throws SQLException {
      sql = "delete from products where product_id = ?";
      try(Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
          ps.setInt(1, id);
          ps.executeUpdate();
      }
  }

  }
