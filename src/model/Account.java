package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQueries(value = {
		@NamedQuery(name = "findAllAcc", query = "SELECT a FROM Account a"),
		@NamedQuery(name= "accBioPage", query="Select a.bio , a.email, a.fName, a.lName, a.email, a.picture, a.userName From Account a where a.userName = :name")})

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String bio;

	@Column(name = "date_Added")
	private Timestamp dateAdded;

	private String email;
	
	private String picture;

	
	@Column(name = "first_Name")
	private String fName;

	@Column(name = "is_Admin")
	private boolean admin;

	@Column(name = "last_Name")
	private String lName;

	private String password;

	@Column(name = "user_Name")
	private String userName;

	// bi-directional many-to-one association to Alcohol
	@OneToMany(mappedBy = "account")
	private List<Alcohol> alcohols;

	// bi-directional many-to-one association to Comment
	@OneToMany(mappedBy = "account")
	private List<Comment> comments;

	// bi-directional many-to-one association to Like
	@OneToMany(mappedBy = "account")
	private List<Like> likes;

	// bi-directional many-to-one association to Star
	@OneToMany(mappedBy = "account")
	private List<Star> stars;

	public Account() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Timestamp getDate_Added() {
		return this.dateAdded;
	}

	public void setDate_Added(Timestamp date_Added) {
		this.dateAdded = date_Added;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_Name() {
		return this.fName;
	}

	public void setFirst_Name(String first_Name) {
		this.fName = first_Name;
	}

	public boolean getIs_Admin() {
		return this.admin;
	}

	public void setIs_Admin(boolean is_Admin) {
		this.admin = is_Admin;
	}

	public String getLast_Name() {
		return this.lName;
	}

	public void setLast_Name(String last_Name) {
		this.lName = last_Name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_Name() {
		return this.userName;
	}

	public void setUser_Name(String user_Name) {
		this.userName = user_Name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Alcohol> getAlcohols() {
		return this.alcohols;
	}

	public void setAlcohols(List<Alcohol> alcohols) {
		this.alcohols = alcohols;
	}

	public Alcohol addAlcohol(Alcohol alcohol) {
		getAlcohols().add(alcohol);
		alcohol.setAccount(this);

		return alcohol;
	}

	public Alcohol removeAlcohol(Alcohol alcohol) {
		getAlcohols().remove(alcohol);
		alcohol.setAccount(null);

		return alcohol;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setAccount(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setAccount(null);

		return comment;
	}

	public List<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public Like addLike(Like like) {
		getLikes().add(like);
		like.setAccount(this);

		return like;
	}

	public Like removeLike(Like like) {
		getLikes().remove(like);
		like.setAccount(null);

		return like;
	}

	public List<Star> getStars() {
		return this.stars;
	}

	public void setStars(List<Star> stars) {
		this.stars = stars;
	}

	public Star addStar(Star star) {
		getStars().add(star);
		star.setAccount(this);

		return star;
	}

	public Star removeStar(Star star) {
		getStars().remove(star);
		star.setAccount(null);

		return star;
	}

}