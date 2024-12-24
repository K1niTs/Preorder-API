package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.example.DTO.PreOrderDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Schema(name = "PreOrder API", description = "API for managing pre-order statuses and operations")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreOrderDTO.class))),
        @ApiResponse(responseCode = "201", description = "A new resource has been created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreOrderDTO.class))),
        @ApiResponse(responseCode = "204", description = "The resource was successfully deleted", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreOrderDTO.class))),
        @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreOrderDTO.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreOrderDTO.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreOrderDTO.class)))
})
public interface PreOrderApi {

    @PostMapping
    @Operation(summary = "Create a new PreOrder")
    ResponseEntity<EntityModel<PreOrderDTO>> createPreOrder(@RequestBody PreOrderDTO preOrderDTO);

    @GetMapping
    @Operation(summary = "Get a list of all PreOrders")
    ResponseEntity<CollectionModel<EntityModel<PreOrderDTO>>> getAllPreOrders();

    @GetMapping("/{id}")
    @Operation(summary = "Get PreOrder by ID")
    ResponseEntity<EntityModel<PreOrderDTO>> getPreOrder(@PathVariable UUID id);

    @PutMapping("/{id}")
    @Operation(summary = "Update PreOrder by ID")
    ResponseEntity<EntityModel<PreOrderDTO>> updatePreOrder(@PathVariable UUID id, @RequestBody PreOrderDTO preOrderDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete PreOrder by ID")
    ResponseEntity<Void> deletePreOrder(@PathVariable UUID id);
}
