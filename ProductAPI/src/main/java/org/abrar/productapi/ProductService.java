package org.abrar.productapi;


import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public ProductDTO getProductById(int id) {
        Product product=new Product();
        product.setProductId(1);
        product.setProductName("Laptop");
        product.setCostPrice(40000);
        product.setSellingPrice(44000);


        return new ProductDTO(product.getProductId(), product.getProductName(), product.getTax(), product.getSellingPrice());
    }

    public String healthCheck() {
        if(isHealthy()){
            return "200 OK";
        }
        else{
            return "500 Error";
        }
    }

    private boolean isHealthy() {
        return true;
    }
}
