package dev.lucas.order_ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Order creation request")
public class OrderRequest {

    @NotBlank(message = "Customer ID is required")
    @Schema(description = "Customer ID", example = "CUST123")
    private String customerId;

    @NotBlank(message = "Customer email is required")
    @Email(message = "Invalid email format")
    @Schema(description = "Customer email", example = "customer@example.com")
    private String customerEmail;

    @NotBlank(message = "Customer name is required")
    @Schema(description = "Customer name", example = "John Doe")
    private String customerName;

    @NotBlank(message = "Product code is required")
    @Schema(description = "Product code", example = "PROD001")
    private String productCode;

    @NotBlank(message = "Product name is required")
    @Schema(description = "Product name", example = "Smartphone XYZ")
    private String productName;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 1000, message = "Quantity cannot exceed 1000")
    @Schema(description = "Quantity", example = "2")
    private Integer quantity;

    @NotNull(message = "Unit price is required")
    @DecimalMin(value = "0.01", message = "Unit price must be at least 0.01")
    @DecimalMax(value = "999999.99", message = "Unit price too high")
    @Schema(description = "Unit price", example = "999.99")
    private BigDecimal unitPrice;

    @Schema(description = "Shipping address", example = "123 Main St, City, Country")
    private String shippingAddress;

    @Schema(description = "Payment method", example = "CREDIT_CARD")
    private String paymentMethod;

    @Schema(description = "Additional notes", example = "Handle with care")
    private String notes;
}
