package com.toyandbooklibapp.model;

import java.time.LocalDate;

import com.toyandbooklibapp.entities.MembershipTypeEntity;
import com.toyandbooklibapp.entities.ParentEntity;

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
public class Payment {
	private Integer paymentId;

	private ParentEntity parent;

	private MembershipTypeEntity membershipType;

	private LocalDate startDate;

	private LocalDate endDate;

}
