package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.DTO.CustomerDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Schema(name = "Customer API", description = "API for managing customers")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))),
        @ApiResponse(responseCode = "201", description = "A new resource has been created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))),
        @ApiResponse(responseCode = "204", description = "The resource was successfully deleted", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))),
        @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class)))
})
public interface CustomerApi {

    @GetMapping
    @Operation(summary = "get all customers", description = "Retrieve a list of all customers")
    ResponseEntity<CollectionModel<EntityModel<CustomerDTO>>> getAllCustomers();

    @GetMapping("/{id}")
    @Operation(summary = "Get customer by ID", description = "Retrieve a customer by their ID")
    ResponseEntity<EntityModel<CustomerDTO>> getCustomerById(@PathVariable Long id);

    @PostMapping
    @Operation(summary = "Create a new customer", description = "Create a new customer with the provided details")
    ResponseEntity<EntityModel<CustomerDTO>> createCustomer(@RequestBody CustomerDTO customerDTO);

    @PutMapping("/{id}")
    @Operation(summary = "Update customer by ID", description = "Update the details of an existing customer by their ID")
    ResponseEntity<EntityModel<CustomerDTO>> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete customer by ID", description = "Delete a customer by their ID")
    ResponseEntity<Void> deleteCustomer(@PathVariable Long id);
}
