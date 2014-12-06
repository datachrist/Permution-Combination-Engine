/**
 * 
 */
package PermNCombExtraCredit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Shabad Sehgal
 * 
 */
public class Permutation {

	public static int verbose;
	public static int count;
	public static int n;
	public static int kobjects;
	public static List<List<Integer>> cPairs = new ArrayList<List<Integer>>();

	/**
	 * This method print or count number of permutations and combinations of k
	 * objects
	 * 
	 * @param A
	 *            Input array
	 * @param n
	 *            Objects
	 * @param verbose
	 *            (0,1,2 or 3)
	 */
	public static void visit(List<Integer> A, int n, int verbose) {
		// if ((verbose==2)||(verbose==3)) {
		for (int i = 1; i < A.size(); i++) {
			if ((A.get(i) != null) && (A.get(i) > 0))
				System.out.print(A.get(i) + " ");
		}
		System.out.println();
		// }
		count++;
	}

	/**
	 * this method permutes number of k object which can be distinct.
	 * 
	 * @param A
	 *            input array
	 * @param k
	 *            objects
	 */
	static void permutate(List<Integer> A, int k) {
		for (int i = k; i < A.size(); i++) {
			Collections.swap(A, i, k);
			permutate(A, k + 1);
			Collections.swap(A, k, i);
		}
		if (k == A.size() - 1) {
			visit(A, n, verbose);
		}
	}

	/**
	 * this method permutes number of k object which can be distinct.
	 * 
	 * @param A
	 *            input array
	 * @param k
	 *            objects
	 */
	static void permutateOriginal(List<Integer> A, int i) {
		if (i == 0) {
			visit(A, n, verbose);
		} else {
			for (int k = 1; k < n; k++) {
				if (A.get(k) == 0) {
					A.set(k, i);
					permutateOriginal(A, i - 1);
					A.set(k, 0);
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = new ArrayList<Integer>();
		A.addAll(Arrays.asList(0, 0, 0, 0,0));
		n = A.size();
/*
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("PreFile.txt"));
			String line = null;
			int countLine = 1;
			int tc = 0;			
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("\\s");

				if (countLine == 1) {
					n = Integer.parseInt(parts[0]);
					verbose = Integer.parseInt(parts[2]);
					tc = Integer.parseInt(parts[1]);

				} else {
					if (countLine <= tc + 1) {
						List<Integer> cPair = new ArrayList<Integer>();
						cPair.add(Integer.parseInt(parts[0]));
						cPair.add(Integer.parseInt(parts[1]));
						cPairs.add(cPair);
					}
				}
				countLine++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
		permutateOriginal(A, n - 1);
		System.out.println(count);
	}

}
