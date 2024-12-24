package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.DTO.OrderStatusDTO;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Schema(name = "Order Status API")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderStatusDTO.class))),
        @ApiResponse(responseCode = "201", description = "A new resource has been created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderStatusDTO.class))),
        @ApiResponse(responseCode = "204", description = "The resource was successfully deleted", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderStatusDTO.class))),
        @ApiResponse(responseCode = "400", description = "Validation error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderStatusDTO.class))),
        @ApiResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderStatusDTO.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderStatusDTO.class)))
})
public interface OrderStatusApi {

    @GetMapping
    @Operation(summary = "Get all order statuses")
    ResponseEntity<CollectionModel<EntityModel<OrderStatusDTO>>> getAllOrderStatuses();

    @GetMapping("/{id}")
    @Operation(summary = "Get an order status by ID")
    ResponseEntity<EntityModel<OrderStatusDTO>> getOrderStatusById(@PathVariable Long id);

    @PostMapping
    @Operation(summary = "Create a new order status")
    ResponseEntity<EntityModel<OrderStatusDTO>> createOrderStatus(@RequestBody OrderStatusDTO orderStatusDTO);

    @PutMapping("/{id}")
    @Operation(summary = "Update an order status by ID")
    ResponseEntity<EntityModel<OrderStatusDTO>> updateOrderStatus(@PathVariable Long id, @RequestBody OrderStatusDTO orderStatusDTO);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an order status by ID")
    ResponseEntity<Void> deleteOrderStatus(@PathVariable Long id);
}
