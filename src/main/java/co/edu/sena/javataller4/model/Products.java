package co.edu.sena.javataller4.model;

public class Products {
  private Integer product_id;
  private String product_name;
  private String product_value;
  private String category_id;

  public Products(){

  }

  public Products (Integer product_id, String product_name, String product_value, String category_id){
    this.product_id = product_id;
    this.product_name = product_name;
    this.product_value = product_value;
    this.category_id = category_id;
  }

  public Products (String product_name, String product_value, String category_id){
    this.product_name = product_name;
    this.product_value = product_value;
    this.category_id = category_id;
  }

  public Integer getProduct_id() {
    return product_id;
  }

  public void setProduct_id(Integer product_id) {
    this.product_id = product_id;
  }

  public String getProduct_name() {
    return product_name;
  }
  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public String getProduct_value() {
    return product_value;
  }
  public void setProduct_value(String product_value) {
    this.product_value = product_value;
  }

  public String getCategory_id() {
    return category_id;
  }
  
  public void setCategory_id(String category_id) {
    this.category_id = category_id;
  }

  
  @Override
  public String toString(){
    return "product_id=" + product_id + " | " +
    "product_name=" + product_name + " | "+
    "product_value=" + product_value + " | "+ 
    "category_id=" + category_id + " | " 
    ;
  }
}
