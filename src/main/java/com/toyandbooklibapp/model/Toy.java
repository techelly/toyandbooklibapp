package com.toyandbooklibapp.model;

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
public class Toy {
	private Integer toyId;

	private String name;

	private Float price;

	private String company;

	private String category;
}
