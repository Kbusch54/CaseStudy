package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name = "findAllCategory", query = "SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String name;

	// bi-directional many-to-one association to Alcohol
	@OneToMany(mappedBy = "category")
	private List<Alcohol> alcohols;

	public Category() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Alcohol> getAlcohols() {
		return this.alcohols;
	}

	public void setAlcohols(List<Alcohol> alcohols) {
		this.alcohols = alcohols;
	}

	public Alcohol addAlcohol(Alcohol alcohol) {
		getAlcohols().add(alcohol);
		alcohol.setCategory(this);

		return alcohol;
	}

	public Alcohol removeAlcohol(Alcohol alcohol) {
		getAlcohols().remove(alcohol);
		alcohol.setCategory(null);

		return alcohol;
	}

}