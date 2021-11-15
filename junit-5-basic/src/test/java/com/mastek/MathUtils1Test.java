package com.mastek;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtils1Test {

	@Test
	void test() {
		
	MathUtils1 mathutils2=new MathUtils1();
	int expected=3;
	int actual=mathutils2.sub(5,2);
	assertEquals(expected,actual);
	}

}
