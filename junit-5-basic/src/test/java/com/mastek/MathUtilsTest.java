package com.mastek;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName("Run MathUtilsTest")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	MathUtils mathUtils;
	TestInfo testinfo;
	TestReporter testRepo;
	
	
	@BeforeAll
	void beforeAll() {
		
		
		System.out.println("This is need to un before all");
	}
	
	@BeforeEach
	void init(TestInfo testinfo,TestReporter testRepo) {
		this.testinfo=testinfo;
		this.testRepo=testRepo;
		mathUtils = new MathUtils();
	}
	
	@Nested
	@DisplayName("Adding Methods")
	@Tag("Math")
	class AddTest {
		
		@Test
		@DisplayName("When adding two positive numbers")
		void testAddPositive() {
			
			assertEquals(-2,mathUtils.add(-1,-1),"should return the right sum");
		}
		@Test
		@DisplayName("when adding two negative numbers")
		void testAddNegative() {
			
			assertEquals(-2,mathUtils.add(-1,-1),"should right the right sum");
		}

		
	}
	
	
	
	@AfterEach
	void cleanup() {
		System.out.println("Clean up");
	}
	@Test
	@DisplayName("Testing Add method")
	void test() {
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected, actual, "The add method should add two numbers");

	}
	
	
	@Test
	@DisplayName("mulltiply method")
	@Tag("Math")
	void testMultiply() {
		System.out.println("Running" +testinfo.getDisplayName()+"with tags"+testinfo.getTags());
		
		assertAll(
				()->assertEquals(4,mathUtils.multiply(2,2)),
				()-> assertEquals(0,mathUtils.multiply(2,0)),
				()->assertEquals(-2,mathUtils.multiply(2, -1))
								
				);
	}	
	@Test
	@RepeatedTest(3)
	@Tag("Math")
	void testcomputeCircleRadius() {
		// MathUtils mathUtils=new MathUtils();
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "shoud calculate area of circke");
	}

	@Test
	//@EnabledOnOs(OS.LINUX)
	void testdivide() {
		boolean isServerUp=false;
		// MathUtils mathUtils=new MathUtils();
		assumeTrue(isServerUp);
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by zero should throw");
	
	}
	}
