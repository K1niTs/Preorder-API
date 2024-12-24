package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.DTO.ProductDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Schema(name = "Product API", description = "API for managing products")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
        @ApiResponse(responseCode = "201", description = "A new resource has been created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
        @ApiResponse(responseCode = "204", description = "The resource was successfully deleted", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
        @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductDTO.class)))
})
public interface ProductApi {

    @PostMapping
    @Operation(summary = "create a new Product", description = "Create a new product resource")
    ResponseEntity<EntityModel<ProductDTO>> createProduct(@RequestBody ProductDTO productDTO);

    @GetMapping
    @Operation(summary = "Get all Products", description = "Retrieve a list of all products")
    ResponseEntity<CollectionModel<EntityModel<ProductDTO>>> getAllProducts();

    @GetMapping("/{id}")
    @Operation(summary = "Get Product by ID", description = "Retrieve a product by its ID")
    ResponseEntity<EntityModel<ProductDTO>> getProductById(@PathVariable Long id);

    @PutMapping("/{id}")
    @Operation(summary = "Update Product by ID", description = "Update a product resource by its ID")
    ResponseEntity<EntityModel<ProductDTO>> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Product by ID", description = "Delete a product resource by its ID")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id);
}
