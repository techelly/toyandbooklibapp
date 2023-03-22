package com.toyandbooklibapp.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Table(	name = "book_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	
	private String title;
	
	private Float price;
	
	private String author;
	
	private String category;

	private String publication;
	
	//@ManyToOne(cascade = CascadeType.ALL)//Owning side
	//@JoinColumn(name = "lendId")
	@Exclude
	@OneToMany(mappedBy = "book") //inverse side
	private Set<LendItemEntity> lendItems;


}
