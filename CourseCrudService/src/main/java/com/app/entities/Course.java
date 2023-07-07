package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course extends BaseEntity {

	@Column(nullable = false)
	private String name;
	@Enumerated(EnumType.ORDINAL)
	private Category category;
	@Column(name = "start_date",nullable = false )
	private LocalDate startDate;
	@Column(name = "end_date" ,nullable = false)
	private LocalDate endDate;
	@Column(nullable = false)
	private double fee;
}
/*
 * • Name • Category (Enum, example: JAVA-BEGINER, JAVA-ADVANCED) • Start Date •
 * End Date • Fee • Update Date Time
 */