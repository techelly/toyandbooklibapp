package com.toyandbooklibapp.model;

import java.util.List;

import com.toyandbooklibapp.entities.PaymentEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MembershipType {
    private Integer membershipTypeId;
	
	private String description;
	
	private Integer durationMonths;
	
	private Float price;
	

	private List <PaymentEntity> payments;
	

}
