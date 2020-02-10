package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name = "comments")
@NamedQueries(value = {
		@NamedQuery(name = "findAllComment", query = "SELECT c FROM Comment c"),
//		@NamedQuery(name = "CommentBox", 
//		query = "SELECT c.text, l.id, s.number, acc.userName "
//				+ "FROM Comment c "
//				+ "left JOIN Like l on c.id = l.commentId "
//				+ "left JOIN Account acc on c.userId = acc.id "
//				+ "left JOIN Star s on acc.id = s.userId "
//				+ "left JOIN Alcohol al on c.alcoholId=al.id "
//				+ "Group by al.id") 
		} )
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name="alch_Id")
	private Long alcoholId;

	private String text;

	@Column(name="user_Id")
	private Long userId;

	// bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private Account account;

	// bi-directional many-to-one association to Alcohol
	@ManyToOne
	@JoinColumn(name = "alch_Id")
	private Alcohol alcohol;

	// bi-directional many-to-one association to Like
	@OneToMany(mappedBy = "comment")
	private List<Like> likes;

	public Comment() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAlcoholId() {
		return this.alcoholId;
	}

	public void setAlcoholId(Long alcoholId) {
		this.alcoholId = alcoholId;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Alcohol getAlcohol() {
		return this.alcohol;
	}

	public void setAlcohol(Alcohol alcohol) {
		this.alcohol = alcohol;
	}

	public List<Like> getLikes() {
		return this.likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public Like addLike(Like like) {
		getLikes().add(like);
		like.setComment(this);

		return like;
	}

	public Like removeLike(Like like) {
		getLikes().remove(like);
		like.setComment(null);

		return like;
	}

}