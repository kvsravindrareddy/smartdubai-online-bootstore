package com.veera.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity class to store the online Book store data into DB.
 * @author Veera.Shankara
 *
 */
@Setter
@Getter
@Entity
@Table(name = "BOOK_DATA_TB")
public class BookEntity {
	@Id
	@GeneratedValue
	@JsonIgnore
	private long id;
	private String name;
	private String description;
	private String author;
	private String bookType;
	private double price;
	@Column(length = 13)
	private String isbn;//International Standard Book Number
}