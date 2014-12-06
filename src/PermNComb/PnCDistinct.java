
/**
 * 
 */
package PermNComb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 
 *
 */
public class PnCDistinct {
	public static int verbose;
	public static int count;
	public static int n;
	public static int kobjects;
	
	/**
	 * This method print or count number of permutations and combinations of k objects
	 * @param A Input array
	 * @param n Objects
	 * @param verbose (0,1,2 or 3)
	 */
	public static void visit(List<Integer> A,int n,int verbose)
	{
		if ((verbose==2)||(verbose==3)) {
			for (int i = 1; i < A.size(); i++) {
				if ((A.get(i)!=null)&&(A.get(i) > 0))
					System.out.print(A.get(i) + " ");
			}
			System.out.println();
	   }
	   count++;
	}
	
	/**
	 * this method permutes number of k object which can be distinct.
	 * @param A input array
	 * @param k objects
	 */
	static void permutate(List<Integer> A, int k){
        for(int i = k; i < A.size(); i++){
            Collections.swap(A, i, k);
            permutate(A, k+1);
            Collections.swap(A, k, i);
        }
        if (k == A.size() -1){
        	visit(A, n, verbose);
        }
    }		
	
	/**
	 * this method selects number of k object which is distinct.
	 * @param A input array
	 * @param i objects
	 * @param k objects
	 * @param PnCFlag (true for permutation and False for Combination)
	 */
	public static void combinate(Integer[] A, int i, int k,boolean PnCFlag) {		
		if (k == 0) {					
			if(PnCFlag){		
				List<Integer> B = new ArrayList<Integer>();
				B.add(0);
				for(int m=0;m<A.length;m++){
					if((A[m]!=null)&&(A[m]>0))
						B.add(A[m]);					
				}				
				permutate(B,1);		 /// Permutate method is called for selected objects
			}
			else
				visit(new ArrayList<Integer>(Arrays.asList(A)), n, verbose);
		} else if (i < k) {
			return;

		} else {
			A[i] = i;
			combinate(A, i - 1, k - 1,PnCFlag);
			A[i] = 0;
			combinate(A, i - 1, k,PnCFlag);
		}
	}

	/**
	 * the main method takes 3 arguments from input and 
	 * outputs prints or count total ways and time taken in millisecond.
	 * PnCFlag is boolean variable which is used to tell if Permutation or Combination that needs to be calculated
	 * PnCFlag is True then permutation needs to calculated otherwise Combination.
	 * @param args
	 */
	public static void main(String[] args) {
		n = Integer.parseInt(args[0]);
		Integer[] A = new Integer[n+1];
		kobjects = Integer.parseInt(args[1]);
		verbose=Integer.parseInt(args[2]);
		boolean PnCFlag= false;
		if(kobjects>n){
			System.out.println("The K objects cannot be more than total objects!");
			return;
		}
		switch(verbose){
		case 0:			
		case 2:
			PnCFlag=true;		 
				break;
		case 1:			
		case 3:
			PnCFlag=false;
			break;		
		default:			
			System.out.println("Verbose should be 0,1,2 or 3!");
			return;
		}
		long start = System.currentTimeMillis();
		combinate(A, n,kobjects,PnCFlag);
		long last = System.currentTimeMillis();
		System.out.print(+count);
		System.out.println(" "+(last - start));
								
			
	}

}
