package com.toyandbooklibapp.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(	name = "payment_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	
		
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="membershipTypeId")
	private MembershipTypeEntity membershipType;//Owning side
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	@ManyToOne(cascade = CascadeType.ALL)//Owning side
	@JoinColumn(name = "parentId")
	private ParentEntity parent;
}
