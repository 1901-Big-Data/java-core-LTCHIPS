package com.revature.eval.java.core;

import java.time.LocalDateTime;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	
	/*
	 * NOTE: I had been committing stuff to master the whole time since I didn't see much point in doing so for assignments.
	 * Turns out that's you can't do master -> master for pull requests, so now there's a dev branch! 
	 * With that being said, I apologize for any inconviences that may arise from my lack of foresight.
	 */
	
	
	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		String[] splitPhrase = phrase.toUpperCase().split("[ -]");
		
		StringBuilder acronym = new StringBuilder();
		
		
		for(int x = 0; x < splitPhrase.length; x++) 
		{
			char charToAdd = splitPhrase[x].charAt(0);
			acronym.append(charToAdd);
			
		}
		
		return acronym.toString();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			return ((this.sideOne == this.sideTwo) 
					&& (this.sideTwo == this.sideThree) 
					&& (this.sideThree == this.sideOne)) ? true : false ;
		}

		public boolean isIsosceles() {
			return ((this.sideOne == this.sideTwo) 
					|| (this.sideTwo == this.sideThree) 
					|| (this.sideThree == this.sideOne)) ? true : false ;
		}

		public boolean isScalene() {
			return ((this.sideOne != this.sideTwo) 
					&& (this.sideTwo != this.sideThree) 
					&& (this.sideThree != this.sideOne)) ? true : false ;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		String upperCased = string.toUpperCase();
		
		//This is probably overkill, but it felt natural to go with a hashmap...
		
		HashMap<Character, Integer> scoreMap = new HashMap<Character, Integer>();
		
		scoreMap.put('A', 1);
		scoreMap.put('E', 1);
		scoreMap.put('I', 1);
		scoreMap.put('O', 1);
		scoreMap.put('U', 1);
		scoreMap.put('L', 1);
		scoreMap.put('N', 1);
		scoreMap.put('R', 1);
		scoreMap.put('S', 1);
		scoreMap.put('T', 1);
		
		scoreMap.put('D', 2);
		scoreMap.put('G', 2);
		
		scoreMap.put('B', 3);
		scoreMap.put('C', 3);
		scoreMap.put('M', 3);
		scoreMap.put('P', 3);
		
		scoreMap.put('F', 4);
		scoreMap.put('H', 4);
		scoreMap.put('V', 4);
		scoreMap.put('W', 4);
		scoreMap.put('Y', 4);
		
		scoreMap.put('K', 5);
		
		scoreMap.put('J', 8);
		scoreMap.put('X', 8);
		
		scoreMap.put('Q', 10);
		scoreMap.put('Z', 10);
		
		int score = 0;
		
		
		
		for(int x = 0; x < string.length(); x++) 
		{
			try {
				Character lookup = upperCased.charAt(x);
				Integer value = scoreMap.get(lookup);
				score+=value;
			}
			catch (Exception e) {
				continue;
			}
			
		}
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		
		//strip any unnecessary characters from the phone numbers
		//also strip letters to catch any phone numbers with letters in them
		String[] phnumArray = string.split("[+()-\\.\\sa-zA-Z]+");
		
		String phnumStrCleaned = "";
		
		for(String x : phnumArray) 
		{	
			phnumStrCleaned+=x;	
		}
		
		if(phnumStrCleaned.length() >= 12) 
		{
			throw new IllegalArgumentException("Not a real phone number! (Too long)");
			
		}
		if (phnumStrCleaned.length() == 11)
		{
			phnumStrCleaned.substring(1);
			
		}
		if (phnumStrCleaned.length() < 10)
		{
			throw new IllegalArgumentException("Not a real phone number! (Too short or there were letters inside of it)");
			
		}
		
		return phnumStrCleaned;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> mapOfWords = new HashMap<String, Integer>();
		
		String[] words = string.split("[\\n\\s,]+");
		
		for (String x : words) 
		{
			Integer putAttempt = mapOfWords.get(x);
				
			if (putAttempt == null) 
			{
				mapOfWords.put(x, 1);
			}
			else 
			{
				mapOfWords.replace(x, putAttempt + 1);
				
			}
		}
		return mapOfWords;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) 
		{	
			int x = (sortedList.size() - 1)/2;
			int baseIndex = 0;
			
			List<T> subArray = this.getSortedList();
			
			while(true) 
			{
				if (t instanceof Integer ) 
				{
					Integer val = (Integer) subArray.get(x);
					if (val < (Integer)t) 
					{
						subArray = subArray.subList(x+1, subArray.size());
						baseIndex+=(x+1);
					}
					else if (val > (Integer)t)
					{
						subArray = subArray.subList(0,  x); 
					}
					else 
					{
						break;			
					}
				}
				else if (t instanceof String) 
				{
					String val = (String) sortedList.get(x);
					int result = val.compareTo((String) t);
					if (result < 0) // val > t
					{
						subArray = subArray.subList(x+1, subArray.size());
						baseIndex+=(x+1);
					}
					else if (result > 0) // val < t
					{
						subArray = subArray.subList(0,  x); 
					}
					else
					{
						break;
						
					}					
				}
				
				x = (subArray.size() - 1)/2;
				
			}
			
			return x + baseIndex;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}
		
		

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	
	public String toPigLatin(String string) 
	{
		String[] splitStr = string.split(" ");
		
		//PURE VOWELS. PUUUUUUUURRRRRRRRRRREEEEEEEEEEEEEEEE
		List<Character> vowels = new ArrayList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		
		StringBuilder result = new StringBuilder();
		
		StringBuilder intermediateSB = new StringBuilder();
		
		for (String x : splitStr) 
		{
			if (!vowels.contains(x.charAt(0))) 
			{	
				intermediateSB.append(x.charAt(0));
				char[] subStr = x.substring(1).toCharArray();
				for (int y = 0; y < subStr.length; y++) 
				{
					if (vowels.contains(subStr[y]))
					{
						//super special case when dealing with "u"
						if (Character.compare(intermediateSB.charAt(intermediateSB.length() - 1), 'q') == 0
								&& subStr[y] == 'u') 
						{
							intermediateSB.append(subStr[y]);
							break;
						}
						else
							break;
					}
					else
					{
						intermediateSB.append(subStr[y]);
					}
					
				}
				result.append(x.substring(intermediateSB.length()));
				result.append(intermediateSB.toString());
			}
			else
			{	
				result.append(x);
				intermediateSB.append(x.charAt(0));
			}
			
			result.append("ay ");
			
			intermediateSB.delete(0, intermediateSB.length());
		}
		
		return result.toString().substring(0, result.length() - 1);
		
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		String intToStr = String.valueOf(input);
		
		int numOfDigits = intToStr.length();
		
		int result = 0;
		
		for(int x = 0; x < numOfDigits; x++) 
		{
			//convert char to integer
			
			int val = (intToStr.charAt(x) - '0');
			int temp = val;
			
			//silly integer power calculation because Math class didn't have one for ints >:(
			for(int y = 0; y < numOfDigits - 1; y++) 
			{
				temp*=val;
				
			}
			
			result+=temp;
			
		}

		return result == input ? true : false;

	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) 
	{
		List<Long> primeFactors = new ArrayList<Long>();
		
		long z = l;
		for (long x = 2; x <= l; x++ ) 
		{
			if (l % x == 0) 
			{
				//we already know 1 divides x
				int primeCheck = 1;
				for (long y = 2; y <= x; y++) 
				{
					if (x % y == 0) 
					{
						primeCheck+=1;
					}
				}
				if (primeCheck == 2) 
				{
					//cool, let's figure out how many times this prime goes into z
					while(z%x == 0) 
					{
						z/=x;
						primeFactors.add(x);
					}
				}
			}
		}
		
		return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;
		
		private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		private static String capAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) 
		{
			StringBuilder sb = new StringBuilder();
			
			for (int x = 0; x < string.length(); x++) 
			{
				int index = 0;
				for (int y = 0; y < alphabet.length(); y++) 
				{	
					
					if(Character.isUpperCase(string.charAt(x))) 
					{
						if (Character.compare(string.charAt(x), capAlphabet.charAt(y)) == 0) 
						{
							index = y;
							int newIndex = index + key;
							
							if  (newIndex > 25) 
							{
								newIndex-=26;
							}
							sb.append(capAlphabet.charAt(newIndex));
							break;
						}
					}
					else if (Character.isLowerCase(string.charAt(x))) 
					{
						if (Character.compare(string.charAt(x), alphabet.charAt(y)) == 0) 
						{
							index = y;
							
							int newIndex = index + key;
							
							if  (newIndex > 25) 
							{
								newIndex-=26;
							}
							sb.append(alphabet.charAt(newIndex));
							break;
						}
					}
					else 
					{
						sb.append(string.charAt(x));
						break;
					}
					
				}
			}
			
			
			
			return sb.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		int x = 1;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		if (i < 1) 
		{
			throw new IllegalArgumentException("Illegal argument provided");
		}
		while(true) 
		{
			ArrayList<Integer> factors = new ArrayList<Integer>();
			for (int y = 1; y <= x; y++) 
			{
				if (x % y == 0) 
				{
					factors.add(y);
				}
				
			}
			if (factors.size() == 2) 
			{
				primes.add(x);
			}
			
			if(primes.size() == i) 
			{
				break;
			}
			x++;
		}
		
		// TODO Write an implementation for this method declaration
		return  primes.get(i - 1);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		private static String alphabetRev = "zyxwvutsrqponmlkjihgfedcba";
		
		
		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) 
		{
			StringBuilder sb = new StringBuilder();
			
			String strlower = string.toLowerCase();
			
			int seqCount = 0;
			
			for (int x = 0; x < strlower.length(); x++) 
			{
				if (seqCount % 5 == 0 && seqCount != 0) 
				{
					sb.append(' ');
					seqCount = 0;
				}
				if (Character.isDigit(strlower.charAt(x))) 
				{
					sb.append(strlower.charAt(x));
					seqCount+=1;
					continue;
				}
				if (Character.isWhitespace(strlower.charAt(x)) || !Character.isLetterOrDigit(strlower.charAt(x))) 
				{
					continue;
				}
				
				int index = 0;
				
				for (int y = 0; y < alphabet.length(); y++) 
				{
					if (Character.compare(strlower.charAt(x), alphabet.charAt(y)) == 0) 
					{
						index = y;
						seqCount+=1;
						break;
					}
				}
				
				sb.append(alphabet.charAt((alphabet.length() - 1) - index));
			}
		
			return sb.toString().trim();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) 
		{
			StringBuilder sb = new StringBuilder();
			
			String strlower = string.toLowerCase();
			
			for (int x = 0; x < strlower.length(); x++) 
			{
				if (Character.isDigit(strlower.charAt(x))) 
				{
					sb.append(strlower.charAt(x));
					continue;
				}
				if (Character.isWhitespace(strlower.charAt(x)) || !Character.isLetterOrDigit(strlower.charAt(x))) 
				{
					continue;
				}
				
				int index = 0;
				
				for (int y = 0; y < alphabetRev.length(); y++) 
				{
					if (Character.compare(strlower.charAt(x), alphabetRev.charAt(y)) == 0) 
					{
						index = y;
						break;
					}
				}
				
				sb.append(alphabetRev.charAt((alphabetRev.length() - 1) - index));
			}
		
			return sb.toString().trim();
		}
		
		
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		
		char [] strChar = string.toCharArray();
		
		int result = 0;
		
		int y = 10;
		
		for(int x = 0; x < string.length(); x++) 
		{
			//skip dashes
			if (strChar[x] == '-') 
			{
				continue;
			}
			
			//case when character isn't a number
			if (!Character.isDigit(strChar[x])) 
			{
				if (strChar[x] == 'X' && x == string.length() - 1) 
				{
					result+=10;	
				}
				else 
				{
					//character was invalid, no need to bother with the rest of the array...
					result = -1;
					break;
				}
			}
			else 
			{
				int charAsNum = strChar[x] - '0';
				
				result+=charAsNum*(y);
				
			}
			
			y--;
			
		}
		
		return ((result % 11) == 0) ? true : false; 
		
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) 
	{	
		Set<Character> lettersUsed = new HashSet<Character>();
		
		for (Character x : string.toLowerCase().toCharArray()) 
		{
			if (Character.isAlphabetic(x)) 
			{
				lettersUsed.add(x);
			}
			if (lettersUsed.size() == 26) 
			{
				break;
			}
		}
		
		return (lettersUsed.size() == 26) ? true : false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		//long seconds = 1_000_000_000;
		
		LocalDateTime ldt;
		
		
		if(given.isSupported(ChronoField.HOUR_OF_DAY)) 
		{
			ldt = LocalDateTime.of(given.get(ChronoField.YEAR), 
					given.get(ChronoField.MONTH_OF_YEAR), given.get(ChronoField.DAY_OF_MONTH), 
					given.get(ChronoField.HOUR_OF_DAY), given.get(ChronoField.MINUTE_OF_HOUR),
					given.get(ChronoField.SECOND_OF_MINUTE));
		}
		
		else 
		{
			ldt = LocalDateTime.of(given.get(ChronoField.YEAR),
					given.get(ChronoField.MONTH_OF_YEAR), given.get(ChronoField.DAY_OF_MONTH),
					0, 0, 0);
			
		}
		
		ldt = ldt.plus(11574, ChronoUnit.DAYS);
		ldt = ldt.plus(1, ChronoUnit.HOURS);
		ldt = ldt.plus(46, ChronoUnit.MINUTES);
		ldt = ldt.plus(40, ChronoUnit.SECONDS);

		return ldt;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		Set<Integer> setOfMultiples = new HashSet<Integer>();
		
		int result = 0;
		for (int x = 1; x < i; x++) 
		{
			for(int y : set) 
			{
				if (x % y == 0) 
				{
					if(setOfMultiples.add(x)) 
					{
						result+=x;
					}
					
				}
			}
			
		}
		
		return result;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		
		String[] trimmedStr = string.split("\\s+");
		
		String newStr = String.join("", trimmedStr);
		
		if (newStr.length() <= 1) 
		{
			return false;
		}
		
		int result = 0;
		
		int y = 1;
		
		for(int x = newStr.length() - 1; x >= 0; x--) 
		{
			
			if (!Character.isDigit(newStr.charAt(x)))
			{
				return false;
				
			}
			
			int num = newStr.charAt(x) - '0';

			 //odd indexes represent the numbers that need to be doubled
			if (y % 2 == 0)
			{
				num*=2;
				if (num > 9)
					num-=9;
				
			}
			result+=(num);
			y++;
		}
		
		return (result % 10 == 0) ? true : false;
		
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) 
	{
		//We don't really need the "What is..." part of the string
		String problemContents = string.substring(8, string.length());
		
		String[] splitString = problemContents.split("[\\s?]+");
		
		int leftVal = Integer.parseInt(splitString[0]);
		
		int rightVal = Integer.parseInt(splitString[splitString.length - 1]);
		
		int result = 0;
		
		if (splitString[1].compareTo("plus") == 0) 
		{
			result = leftVal + rightVal;
			
		}
		else if (splitString[1].compareTo("minus") == 0) 
		{
			result = leftVal - rightVal;
			
		}
		else if (splitString[1].compareTo("multiplied") == 0) 
		{
			result = leftVal * rightVal;
			
		}
		else if (splitString[1].compareTo("divided") == 0) 
		{
			result = leftVal / rightVal;
		}
		
		return result;
	}

}
