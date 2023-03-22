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
public class Book {
	private Integer bookId;

	private String title;

	private Float price;

	private String author;

	private String category;

	private String publication;

}
