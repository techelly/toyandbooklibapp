package com.toyandbooklibapp.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(	name = "membership_type_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MembershipTypeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer membershipTypeId;
	
	private String description;
	
	private Integer durationMonths;
	
	private Float price;
	
	@OneToMany(mappedBy = "membershipType")
	private List <PaymentEntity> payments;
	
	

}
