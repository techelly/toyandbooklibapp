package com.toyandbooklibapp.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Table(name = "toy_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer toyId;

	private String name;

	private Float price;

	private String company;

	private String category;
	
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)//Owning side
	 * 
	 * @JoinColumn(name = "lendId")
	 * 
	 * @Exclude
	 */
	@OneToMany(mappedBy = "toy") //inverse side
	@Exclude
	private Set<LendItemEntity> lendItem;

}
