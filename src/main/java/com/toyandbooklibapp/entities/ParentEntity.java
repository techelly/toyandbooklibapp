package com.toyandbooklibapp.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(	name = "parent_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer parentId;

	private String name;

	private String cardNo;

	private String upiNo;

	//One to One Bi directional relationship
	@OneToOne(cascade = CascadeType.ALL)
	private ChildEntity child;// owning side

	@OneToMany(mappedBy = "parent")
	private List<PaymentEntity> payments;// inverse side

}
