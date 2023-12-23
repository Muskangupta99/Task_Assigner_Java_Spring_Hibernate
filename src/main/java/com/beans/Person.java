package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Person")
public class Person {
	
@Id
@Column(name="pk_person_id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
Long pk_person_id;
@Column(name="person_name")
String person_name;

@Column(name="fk_user_id")
Long fk_user_id;
/*@ManyToOne
@JoinColumn(name = "fk_user_id")
Users user;*/
@Column(name="tasks")
String tasks;

@Column(name="passcode")
String passcode;

public String getPasscode() {
	return passcode;
}

public void setPasscode(String passcode) {
	this.passcode = passcode;
}

public String getTasks() {
	return tasks;
}

public void setTasks(String tasks) {
	this.tasks = tasks;
}

public Long getFk_user_id() {
	return fk_user_id;
}

public void setFk_user_id(Long fk_user_id) {
	this.fk_user_id = fk_user_id;
}

public Long getPk_person_id() {
	return pk_person_id;
}

public void setPk_person_id(Long pk_person_id) {
	this.pk_person_id = pk_person_id;
}

public String getPerson_name() {
	return person_name;
}

public void setPerson_name(String person_name) {
	this.person_name = person_name;
}

/*public Users getUser() {
	return user;
}

public void setUser(Users user) {
	this.user = user;
}*/


}
