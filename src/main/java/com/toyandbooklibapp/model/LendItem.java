package com.toyandbooklibapp.model;

import java.time.LocalDate;
import java.util.Set;

import com.toyandbooklibapp.entities.BookEntity;
import com.toyandbooklibapp.entities.ChildEntity;
import com.toyandbooklibapp.entities.ToyEntity;

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
public class LendItem {

	private Integer lendId;

	private ChildEntity lendedBy;
	private LocalDate lendDate;

	private LocalDate returnDate;

	private Set<BookEntity> book;

	private Set<ToyEntity> toy;

	private Float fine;

}
