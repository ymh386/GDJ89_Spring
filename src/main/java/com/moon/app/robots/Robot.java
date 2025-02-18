package com.moon.app.robots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.moon.app.parts.Arm;
import com.moon.app.parts.LeftArm;
import com.moon.app.parts.RightArm;


public class Robot {
	
	
	private Arm la;
	
	private Arm ra;
	
	private String name;
	
	private Integer age;
	
	public Robot(Arm la, Arm ra, String name, Integer age) {
		this.la = la;
		this.ra = ra;
		this.name = name;
		this.age = age;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Arm getLa() {
		return la;
	}

	public void setLa(Arm la) {
		this.la = la;
	}

	public Arm getRa() {
		return ra;
	}

	public void setRa(Arm ra) {
		this.ra = ra;
	}

	
	
	public void attack() {
		this.la.punch();
		this.ra.punch();
	}

}
