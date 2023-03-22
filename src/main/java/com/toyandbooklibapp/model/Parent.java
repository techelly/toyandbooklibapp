package com.toyandbooklibapp.model;

import java.util.List;

import com.toyandbooklibapp.entities.ChildEntity;
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
public class Parent {

	private Integer parentId;

	private String name;

	private String cardNo;

	private String upiNo;

	private ChildEntity child;

	private List<PaymentEntity> payments;

}
