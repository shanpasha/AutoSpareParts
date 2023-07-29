package com.narvee.usit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SpareParts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer partId;

	private Integer serialNumber;
	private String partName;

	private String description;

	private String model;

	private String manufacturer;

	private Double cost;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicleId")
	@JsonIgnoreProperties("sparePart")
	@Exclude
	private Vechicle vehicle;

}
