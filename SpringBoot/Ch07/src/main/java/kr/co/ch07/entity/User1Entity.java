package kr.co.ch07.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="user1")
public class User1Entity {
	@Id // PK필드에 선언
	private String uid;
	private String name;
	private String hp;
	private int age;
}
