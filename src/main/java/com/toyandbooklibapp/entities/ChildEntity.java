package com.toyandbooklibapp.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(	name = "child_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChildEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer childId;
	
	@NotBlank
	@Size(max = 10)
	private LocalDateTime dateOfBirth;
	//One to One Bi directional relationship
	@OneToOne(mappedBy = "child")
	private ParentEntity parent; //inverse side
	
	@OneToMany(mappedBy = "lendedBy") //inverse side
	private Set<LendItemEntity> lendItems;
}
