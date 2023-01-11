package kr.co.ch07.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kr.co.ch07.entity.User1Entity;

//Jpa상속받으면서 Repository 어노테이션 생략가능, <엔티티명, ID필드 자료형>
public interface User1Repo extends JpaRepository<User1Entity, String>{
	//
	//JPA 쿼리메서드
	//
	public User1Entity findUser1EntityByUid(String uid);
	public List<User1Entity> findUser1EntityByName(String name);
	public List<User1Entity> findUser1EntityByNameNot(String name);
	public List<User1Entity> findUser1EntityByUidAndName(String uid, String name);
	public List<User1Entity> findUser1EntityByUidOrName(String uid, String name);
	//age가 변수로들어온 age보다 큰 경우
	public List<User1Entity> findUser1EntityByAgeGreaterThan(int age);
	public List<User1Entity> findUser1EntityByAgeGreaterThanEqual(int age);
	public List<User1Entity> findUser1EntityByAgeLessThan(int age);
	public List<User1Entity> findUser1EntityByAgeLessThanEqual(int age);
	//변수 name 앞뒤로 %명시할 것
	public List<User1Entity> findUser1EntityByNameLike(String name);
	//변수값이 포함된 것, 시작과 끝
	public List<User1Entity> findUser1EntityByNameContains(String name);
	public List<User1Entity> findUser1EntityByNameStartsWith(String name);
	public List<User1Entity> findUser1EntityByNameEndsWith(String name);
	//정렬
	public List<User1Entity> findUser1EntityByAgeOrderByName(int age);
	public List<User1Entity> findUser1EntityByAgeOrderByAgeAsc(int age);
	public List<User1Entity> findUser1EntityByAgeOrderByAgeDesc(int age);
	//조건정렬
	public List<User1Entity> findUser1EntityByAgeGreaterThanOrderByAgeDesc(int age);
	//카운트
	public int countUser1EntityByUid(String uid);
	public int countUser1EntityByName(String name);
	
	
	//
	//JPQL
	//
	@Query("SELECT u1 FROM User1Entity AS u1 WHERE age < 30")
	public List<User1Entity> selectUserUnderAge30();
	
	@Query("SELECT u1 FROM User1Entity AS u1 WHERE u1.name = ?1")
	public List<User1Entity> selectUserByName(String name);
	
	@Query("SELECT u1 FROM User1Entity AS u1 WHERE u1.name = :name")
	public List<User1Entity> selectUserByWithParam(@Param("name") String name);
	
	
	
}
