package com.narvee.usit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity
@Data
@NoArgsConstructor
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Room {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		 private Integer roomId;
		 private String  roomName;
		 private String address;
		 @OneToMany(mappedBy = "room")
		@JsonIgnoreProperties("room")
		 private List<Vechicle> vechile;
	
	
}
