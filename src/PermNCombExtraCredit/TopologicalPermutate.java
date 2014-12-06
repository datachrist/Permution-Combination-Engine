package PermNCombExtraCredit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TopologicalPermutate {

	
	public static void permutate(int n,int m) {
		

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0,verbose=0;
		List<List<Integer>> cPairs =new ArrayList<List<Integer>>();
		// reading from the file 
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
		
		
		
		//int n=Integer.parseInt(args[0]);
		int m=cPairs.size();
		int[] count = new int[n+1],top=new int[n+1];
		int[] suc=new int[m+1],next = new int[m+1];
		int[] link=new int[n],base =new int[n];
		int q,k,i,j,p,t,D,D1;
		for(j=0;j<=n;j++){
			count[j]=top[j]=0;			
		}
		
		for(k=0;k<cPairs.size();k++){
			List<Integer> cPair = cPairs.get(k);
			suc[k]=cPair.get(1);
			next[k]=top[cPair.get(0)];
			top[cPair.get(0)]=k;
			count[j]+=1;
		}
		link[0]=D=0;
		
		for(j=0;j<n;j++){
			if(count[j]==0){
				link[D]=j;
					D=j;			
			}
		}
		if(D==0){
			return;
		}
		else{
			link[D]=link[0];
			
		}
		k=0;
		t=0;
		int[] buffer = new int[n+1];
		
		label: do {
			  // do stuff
			  if (check) continue label;
			  // do more stuff
			  break label;
			} while(true);
			
		}
		
		
		
		
	}

}
