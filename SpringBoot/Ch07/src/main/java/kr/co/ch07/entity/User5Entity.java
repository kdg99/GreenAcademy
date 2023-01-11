package kr.co.ch07.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user5")
public class User5Entity {
	@Id
	private String uid;
	private String name;
	private String birth;
	private int age;
	private String address;
	private String hp;
}
