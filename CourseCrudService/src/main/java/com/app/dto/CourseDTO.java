package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {

	private String name;

	private String category;

	private LocalDate startDate;

	private LocalDate endDate;

	private double fee;
}
