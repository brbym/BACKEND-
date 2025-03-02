package com.project.questapp.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="p_like")
@Data
public class Like {

	@Id
	Long id;
	
	@ManyToOne (fetch = FetchType.LAZY) // n-1 iliski (tek bi user da bir sürü post olabilir )
	@JoinColumn(name="post_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE) // bir user silindiğinde ilgili tüm postlar silinsin 
	@JsonIgnore
	Post post;
	
	
	
	@ManyToOne (fetch = FetchType.LAZY) // n-1 iliski (tek bi user da bir sürü post olabilir )
	@JoinColumn(name="user_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE) // bir user silindiğinde ilgili tüm postlar silinsin 
	@JsonIgnore
	User user;
	
}
