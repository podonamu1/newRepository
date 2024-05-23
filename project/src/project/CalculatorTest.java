package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator c;
	@BeforeEach
	void setUp() throws Exception {
		c = new Calculator();
	}

	@Test
	void testAdd() {
		System.out.println("덧셈 테스트 시작");
		assertEquals(3, c.add(1, 2), "1 + 2 should equal 3");
		System.out.println("덧셈 테스트 통과 1 + 2 = " + c.add(1, 2));
	}

	@Test
	void testSub() {

		System.out.println("뺄셈 테스트 시작");
		assertEquals(1, c.sub(4, 3), "4 - 3 should equal 1");
		System.out.println("뺼셈 테스트 통과 4 - 3 = " + c.sub(4, 3));
	}

	@Test
	void testMul() {
		System.out.println("곱셈 테스트 시작");
		assertEquals(6, c.mul(2, 3), "2 * 3 should equal 6");
		System.out.println("곱셈 테스트 통과 2 * 3 = " + c.mul(2, 3));
	}

	@Test
	void testDiv() {
		System.out.println("나눗셈 테스트 시작");
		assertEquals(2, c.div(6, 3), "6 / 3 should equal 2");
		System.out.println("나눗셈 테스트 통과 6 / 3 = " + c.div(6, 3));
	}
	
	@Test
	void testDivideByZero() {
		System.out.println("0으로 나누기 테스트 시작");
		assertThrows(IllegalArgumentException.class, () -> c.div(1, 0), "Divisor cannot be zero");
		System.out.println("0으로 나누기 예외 처리 테스트 통과");
	}

}
