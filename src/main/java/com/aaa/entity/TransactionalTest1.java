package com.aaa.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "transactional_test1")
public class TransactionalTest1 {
	private UUID id;
	private String context;

	public TransactionalTest1() {
		super();
	}

	public TransactionalTest1(String context) {
		super();
		this.context = context;
	}

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Column(length = 5)
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
