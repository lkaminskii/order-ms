package dev.lucas.order_ms.dto;

import dev.lucas.order_ms.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Order response")
public class OrderResponse {

    @Schema(description = "Order ID")
    private UUID id;

    @Schema(description = "Order number")
    private String orderNumber;

    @Schema(description = "Customer ID")
    private String customerId;

    @Schema(description = "Customer email")
    private String customerEmail;

    @Schema(description = "Customer name")
    private String customerName;

    @Schema(description = "Product code")
    private String productCode;

    @Schema(description = "Product name")
    private String productName;

    @Schema(description = "Quantity")
    private Integer quantity;

    @Schema(description = "Unit price")
    private BigDecimal unitPrice;

    @Schema(description = "Total amount")
    private BigDecimal totalAmount;

    @Schema(description = "Order status")
    private OrderStatus status;

    @Schema(description = "Shipping address")
    private String shippingAddress;

    @Schema(description = "Payment method")
    private String paymentMethod;

    @Schema(description = "Notes")
    private String notes;

    @Schema(description = "Creation timestamp")
    private LocalDateTime createdAt;

    @Schema(description = "Last update timestamp")
    private LocalDateTime updatedAt;
}
