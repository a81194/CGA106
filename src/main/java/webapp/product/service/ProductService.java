package webapp.product.service;

import webapp.product.dto.ProductDTO;
import webapp.product.dto.ProductLoginDTO;
import webapp.product.pojo.Product;

public interface ProductService {
    Boolean loginCheck(ProductLoginDTO productLoginDTO);

    Boolean saveProduct(ProductDTO productDTO);

    ProductDTO findById(Integer id);

    Boolean updateStatus(Integer id, Boolean status);

}