package org.generation.app.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders_products")
public class OrderProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Long id;
	@Column(name = "purchase_date" , columnDefinition = "timestamp default CURRENT_TIMESTAMP"  )
	private Date purchaseDate;
	@Column(name = "total_amount")
	private double totalAmount;
	@ManyToOne
	@JoinColumn(name = "fk_customer_id" )
	@JsonIgnoreProperties("orders")
	private Customer customer;

}
