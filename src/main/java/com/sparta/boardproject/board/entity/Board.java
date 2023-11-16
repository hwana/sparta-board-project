package com.sparta.boardproject.board.entity;

import com.sparta.boardproject.User.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseTime{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "content", nullable = false)
	private String content;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(nullable = false)
	private String username;

	@Column(name = "status", columnDefinition = "boolean default false")
	private boolean status;

	@Builder
	public Board(Long id, String title, String content, User user) {
		this.title = title;
		this.content = content;
		this.user = user;
		this.username = user.getUsername();
	}

	public void update(String title, String content){
		this.title = title;
		this.content = content;
	}
}
