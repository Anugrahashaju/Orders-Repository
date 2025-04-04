package org.example.controller;

import jakarta.validation.Valid;
import org.example.domain.Product;
import org.example.dto.ProductDto;
import org.example.dto.ResponseDto;
import org.example.exceptions.ProductNotFoundException;
import org.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    //constructor
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /*Create a  new product with POST http method
    * Response entity used to return the responses to the user */

    //Valid annotation that used to validate the data
    @PostMapping
    public ResponseEntity<ResponseDto> createProduct(@Valid @RequestBody ProductDto productDto)
    {
        //Product product = new Product(productDto.getProductName(), productDto.getPrice(), productDto .getStock());
//        To be used if BindingResult parameter is supplied to the controller methods
//        if(result.hasErrors()){
//            Map<Object, Object> errors = new HashMap<>();
//            result.getFieldErrors()
//                    .forEach(fe -> errors.put(fe.getField(), fe.getDefaultMessage()));
//            var response = ResponseDto.builder()
//                    .message(errors)
//                    .status(HttpStatus.BAD_REQUEST)
//                    .build();
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//        }
        var product = Product.builder()
                .productName(productDto.getProductName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .build();
        var res = productService.save(product);
        var response = getResponseDto("Product created with id: " + res.getProductId(),
                HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



    //Get the products by id
    @GetMapping ("/{id}")
    public ResponseEntity<ResponseDto> getProductById(@PathVariable String id)
    {
        Product product = productService
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id
                        + " not found."));
        var response = getResponseDto(product, HttpStatus.OK);
        return ResponseEntity.ok(response);
    }


    //Delete the product using the id
    @DeleteMapping("/{pid}")
    public ResponseEntity<ResponseDto> deleteItem(@PathVariable String pid) {
        Product product = productService
                .findById(pid)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + pid
                        + " not found."));
        productService.deleteById(pid);

        var response = getResponseDto("Product deleted with id: " +pid,
                HttpStatus.OK);
        return ResponseEntity.ok(response);

    }

    //Update the product using the id

   /* public ResponseEntity<ResponseDto> updateItem(@PathVariable String pid, @Valid @RequestBody ProductDto productDto)
    {
        var product = Product.builder()
                .productName(productDto.getProductName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .build();
        var res = productService.save(product);
        var response = getResponseDto("Product created with id: " + res.getProductId(),
                HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }*/


    //Exceptional Handler that used when the product is not found
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseDto> handleValidationErrors(ProductNotFoundException e) {
        var response = getResponseDto(e.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    //get response Dto method
    private static ResponseDto getResponseDto(Object message, HttpStatus status) {
        var response = ResponseDto.builder()
                .message(message)
                .status(status)
                .build();
        return response;
    }

    //Global Exceptional Handler for method argument not valid exception
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public  ResponseEntity<ResponseDto> handleValidationErrors(MethodArgumentNotValidException e)
    {
        Map<Object, Object> errors = new HashMap<>();
        e.getFieldErrors()
                .forEach(fe -> errors.put(fe.getField(), fe.getDefaultMessage()));

        var response = ResponseDto.builder()
                .message(errors)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }



}

