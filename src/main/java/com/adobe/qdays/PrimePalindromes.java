package com.adobe.qdays;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that finds all prime palindromes 
 * in the range of two supplied numbers a and b (2 <= a < b <= 500,000,000). 
 *
 * Palindrome examples: 12321, 123321
 * 
 * Prime palindromes example: 101
 */
public class PrimePalindromes {

	 List<Integer> generatePalindromes(int a, int b) {
		List<Integer> palindromes = new ArrayList<>();
		
		for (int d = countDigits(a); d <= countDigits(b); d++) {
			for (int j = 1; j < 10; j++) {
				generatePalindrome(d, j, palindromes);
			}
		}

		return palindromes;
	}

	private void generatePalindrome(int digits, int n, List<Integer> palindromes) {
		if (countDigits(n) == digits / 2) {
			if (digits % 2 == 0) {
				palindromes.add(Integer.parseInt(n + "" + reverse(n)));
			} else {
				for (int i = 0; i < 10; i++) {
					palindromes.add(Integer.parseInt(n + "" + i + reverse(n)));
				}
			}
		} else {
			for (int i = 0; i < 10; i++) {
				generatePalindrome(digits, n * 10 + i, palindromes);
			}
		}
	}

	List<Integer> primePalindromes(int a, int b) {
		List<Integer> results = new ArrayList<>();

		List<Integer> palindromes = generatePalindromes(a, b);
		for (Integer pal : palindromes) {
			if (a <= pal && pal < b && isPrime(pal)) {
				results.add(pal);
			}
		}

		return results;
	}

	boolean isPrime(int n) {
		if (n < 2) return false;

		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	int countDigits(int n) {
		return Integer.toString(n).length();
	}
	
	boolean isPalindrome(int n) {
		return String.valueOf(n).equals(reverse(n));
	}
	
	String reverse(int n) {
		return new StringBuilder("" + n).reverse().toString();
	}
}
