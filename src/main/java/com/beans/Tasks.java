package com.beans;

import javax.persistence.*;


@Entity
@Table(name="task")
public class Tasks {

	@Id
	@Column(name="pk_task_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long pk_task_id;
	
	@Column(name="fk_person_id")
	Long fk_person_id;
	
	@Column(name="task_description")
	String description;
	
	@Column(name="is_completed")
	Integer is_completed;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIs_completed() {
		return is_completed;
	}
	public void setIs_completed(Integer is_completed) {
		this.is_completed = is_completed;
	}
	
	public Long getPk_task_id() {
		return pk_task_id;
	}
	public void setPk_task_id(Long pk_task_id) {
		this.pk_task_id = pk_task_id;
	}
	public Long getFk_person_id() {
		return fk_person_id;
	}
	public void setFk_person_id(Long fk_person_id) {
		this.fk_person_id = fk_person_id;
	}
	
	
	
}
