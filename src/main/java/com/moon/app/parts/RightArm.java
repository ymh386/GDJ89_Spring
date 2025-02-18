package com.moon.app.parts;

import org.springframework.stereotype.Component;


public class RightArm implements Arm{
	
	@Override
	public void punch() {
		System.out.println("펀치");
		
	}
}
