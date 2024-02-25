package in.madhav.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	
	private String productName;
	
	
	private Double productPrice;
	
	
	private Integer productQuatity;
	
	private String productCategory;
	
	private Double totalPrice;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate productCreateOn;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate productUpdatedOn;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductQuatity() {
		return productQuatity;
	}

	public void setProductQuatity(Integer productQuatity) {
		this.productQuatity = productQuatity;
	}

	
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getProductCreateOn() {
		return productCreateOn;
	}

	public void setProductCreateOn(LocalDate productCreateOn) {
		this.productCreateOn = productCreateOn;
	}

	public LocalDate getProductUpdatedOn() {
		return productUpdatedOn;
	}

	public void setProductUpdatedOn(LocalDate productUpdatedOn) {
		this.productUpdatedOn = productUpdatedOn;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuatity=" + productQuatity + ", productCategory=" + productCategory + "]";
	}

	
	
	
	
	
}
