package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table // Class này là Table
@Entity // Class này là một thực thể Entity
public class Student {

	@Id // PRIMARY KEY
	@GeneratedValue(strategy=GenerationType.IDENTITY) // IDENTITY(1,1)
	private Long id;
	
	@Column(nullable=true) // NULL
	private String name;
	
	@Column(nullable=false) // NOT NULL
	private Integer credits;
	
	@Column(nullable=false) // NOT NULL
	private Float mark;
	
	@Column
	private Date dob;
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public Float getMark() {
		return mark;
	}
	public void setMark(Float mark) {
		this.mark = mark;
	}

}
