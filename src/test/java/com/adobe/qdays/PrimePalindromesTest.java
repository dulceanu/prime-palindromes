package com.adobe.qdays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class PrimePalindromesTest {
	private List<Integer> filteringSolution(int a, int b) {
		List<Integer> primePalindromes = new ArrayList<>();
		PrimePalindromes pp = new PrimePalindromes();

		for (int i = a; i < b; i++) {
			if (pp.isPalindrome(i) && pp.isPrime(i)) {
				primePalindromes.add(i);
			}
		}

		return primePalindromes;
	}

	@Test
	public void testIsPrime() {
		PrimePalindromes pp = new PrimePalindromes();
		assertFalse(pp.isPrime(1));
		assertTrue(pp.isPrime(2));
		assertTrue(pp.isPrime(3));
		assertTrue(pp.isPrime(13));
		assertFalse(pp.isPrime(49));
	}
	
	@Test
	public void testGeneratePalindromes() {
		PrimePalindromes mpp = new PrimePalindromes();

		List<Integer> palindromes = mpp.generatePalindromes(1000, 9999);
		for (Integer pal : palindromes) {
			assertTrue(mpp.isPalindrome(pal));
			assertEquals(0, mpp.countDigits(pal) % 2);
		}
	}

	@Test
	public void testGeneratingMatchesFiltering() {
		PrimePalindromes mpp = new PrimePalindromes();
		Random rand = new Random(42);
		for (int i = 0; i < 100; i++) {
			int a = rand.nextInt(10000);
			int b = a + rand.nextInt(500_000);

			List<Integer> filteringResults = filteringSolution(a, b);
			List<Integer> generatingResults = mpp.primePalindromes(a, b);
			assertTrue(filteringResults.containsAll(generatingResults));
			assertTrue(generatingResults.containsAll(filteringResults));
		}
	}
}
