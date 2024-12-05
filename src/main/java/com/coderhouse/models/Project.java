package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private LocalDateTime startDate;

	private LocalDateTime endhDate;

	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Task> tasks = new ArrayList<Task>();
}
