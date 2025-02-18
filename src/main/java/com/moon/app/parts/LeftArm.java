package com.moon.app.parts;

import org.springframework.stereotype.Component;


public class LeftArm implements Arm{
	
	@Override
	public void punch() {
		System.out.println("로켓 발사");		
	}
	
}
