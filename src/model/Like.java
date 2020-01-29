package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the likes database table.
 * 
 */
@Entity
@Table(name = "likes")
@NamedQuery(name = "findAllLikes", query = "SELECT l FROM Like l")
public class Like implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private Long alcoholId;

	private Long commentId;

	@Column(name = "id_Likes")
	private Long idLikes;

	private Long userId;

	// bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private Account account;

	// bi-directional many-to-one association to Alcohol
	@ManyToOne
	private Alcohol alcohol;

	// bi-directional many-to-one association to Comment
	@ManyToOne
	private Comment comment;

	public Like() {
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

	public Long getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getId_Likes() {
		return this.idLikes;
	}

	public void setId_Likes(Long id_Likes) {
		this.idLikes = id_Likes;
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

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}