package com.example.demo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class MemberPo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3392344421663120242L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long uuid;
	
	Integer age;
	
	String name;
	
	Float height;
	
	Sex sex;
}
