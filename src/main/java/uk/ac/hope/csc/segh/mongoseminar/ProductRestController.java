package uk.ac.hope.csc.segh.mongoseminar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    private static final Logger log = LoggerFactory.getLogger(ProductRestController.class);

    private ProductService productService;

    public ProductRestController() {

    }

    @Autowired
    public ProductRestController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        log.info("Returning all documents under products");
        return ResponseEntity.ok().body("I'm as well as can be expected");
    }

    @GetMapping("/products")
    public ResponseEntity <List<Product>> getAllProduct() {
        log.info("Returning all documents under products");
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity < Product > getProductById(@PathVariable long id) {
        log.info("Returning documents id {}", id);
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @GetMapping("/products/namr/{name}")
    public ResponseEntity < Product > getProductById(@PathVariable String name) {
        log.info("Returning documents name {}", name);
        return ResponseEntity.ok().body(productService.getProductByName(name));
    }

    @PostMapping("/products")
    public ResponseEntity < Product > createProduct(@RequestBody Product product) {
        log.info("Creating new documents id {}", product.getId());
        return ResponseEntity.ok().body(this.productService.createProduct(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity < Product > updateProduct(@PathVariable long id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProduct(@PathVariable long id) {
        this.productService.deleteProduct(id);
        return HttpStatus.OK;
    }
}
