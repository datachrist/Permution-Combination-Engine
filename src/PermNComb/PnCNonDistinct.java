

package PermNComb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author 
 * 
 */
public class PnCNonDistinct {

	public static int verbose;
	public static int count;
	public static int n;
	public static int kobjects;

	/**
	 * This method print or count number of permutations and combinations of k
	 * objects
	 * 
	 * @param A
	 *            input array
	 * @param n
	 *            objects
	 * @param verbose
	 *            (0,1,2 or 3)
	 */
	public static void visit(int[] A, int n, int verbose) {
		if (verbose == 1) {
			for (int i = 0; i < n; i++) {
				if (A[i] > 0)
					System.out.print(A[i] + " ");
			}
			System.out.println();
		}
		count++;
	}

	/**
	 * this method permutes number of k object which can be non-distinct.
	 * 
	 * @param A
	 *            input array
	 * @param i
	 *            objects
	 */
	public static void permutateNonDistinct(int[] A, int i) {

		visit(A, n, verbose);
		int j = n - 2;
		
		/// finding the largest element j
		while (j >= 0) {
			if (A[j] < A[j + 1]) {
				break;
			}
			j--;
		}

		if (j == -1)
			return;
		
		// finding the lowest most element l after element j
		int l = j + 1;
		for (int m = j + 1; m < n; m++) {
			if (A[j] < A[m]) {
				l = m;
			}
		}
		int temp = A[j];
		A[j] = A[l];
		A[l] = temp;

		// reversing the array after element j 
		for (int k = n - 1; k > j + 1; k--, j++) {
			temp = A[j + 1];
			A[j + 1] = A[k];
			A[k] = temp;
		}
		permutateNonDistinct(A, n);
	}

	/**
	 * the main method takes input from file name "InOutFile.txt" and outputs
	 * prints or count total ways and time taken in millisecond.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("InOutFile.txt"));

			String line = null;
			int count = 1;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("\\s");
				if (count > 2) {
					System.out.println("Ther should be 2 lines in a files");
					return;
				} else {
					if (count == 1) {
						n = Integer.parseInt(parts[0]);
						verbose = Integer.parseInt(parts[1]);
					} else {
						A = new int[n];
						for (int i = 0; i < n; i++)
							A[i] = Integer.parseInt(parts[i]);
					}

				}
				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (verbose > 1) {
			System.out.println("Verbose should be 0 or 1!");
			return;
		}

		// Initial sorting of array with insertion sort.
		for (int i = 0, j = i; i < n - 1; j = ++i) {
			int ai = A[i + 1];
			while (ai < A[j]) {
				A[j + 1] = A[j];
				if (j-- == 0) {
					break;
				}
			}
			A[j + 1] = ai;
		}

		long start = System.currentTimeMillis();
		permutateNonDistinct(A, n);
		long last = System.currentTimeMillis();
		System.out.print(+count);
		System.out.println(" " + (last - start));

	}

}
