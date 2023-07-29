package com.narvee.usit.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Vechicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vehicleId;

	private String vehicleName;
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "roomId")
	@JsonIgnoreProperties("room")
	
	private Room room;

	@OneToMany(mappedBy = "vehicle")
	@JsonIgnoreProperties("vehicle")
	private List<SpareParts> sparePart;
}
