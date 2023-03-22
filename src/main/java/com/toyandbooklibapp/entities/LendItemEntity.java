package com.toyandbooklibapp.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LendItemEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lendId;
	
	@ManyToOne(cascade = CascadeType.ALL)//Owning side
	@JoinColumn(name = "childId")
	private ChildEntity lendedBy;
	private LocalDate lendDate;
	
	private LocalDate returnDate;
	
	//@OneToMany(mappedBy = "lendItems") //inverse side
	@ManyToOne(cascade = CascadeType.ALL)//Owning side
	@JoinColumn(name = "bookId")
	@Exclude
	//private Set<BookEntity> books;
	private BookEntity book;
	
	//@OneToMany(mappedBy = "lendItem") //inverse side
	@ManyToOne(cascade = CascadeType.ALL)//Owning side
	@JoinColumn(name = "toyId")
	@Exclude
	private ToyEntity toy;
	
	private Float fine;
	
	
	

	

}
