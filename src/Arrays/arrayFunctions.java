package Arrays;

import java.util.ArrayList;
import java.

public class arrayFunctions {
	
	//Begin of problem 1 find the majority element of an array
	public static int[] mooreArray={1,1,1,1,1,3,4,5};
	
	public static int mooreFindCandidate(int[] array){
		int majIndex=0;
		int count=1;
		for(int i=1; i<array.length;i++){
			if(array[majIndex]==array[i]){
				count++;
			}else{
				count--;
			}
			if(count==0){
				majIndex=i;
				count=1;
			}
		}
		return array[majIndex];
		ArrayList n=new ArrayList();
		Integer.par
	}
	
	public static void moorePrintMajority(int[] array){
		int candidate=mooreFindCandidate(array);
		int count=0;
		for(int i=0;i<array.length;i++){
			if(candidate==array[i]){
				count++;
			}
		}
		if(count>=array.length/2){
			System.out.println("The majority element is "+candidate);
		}else{
			System.out.println("There is no majority element");
		}
	}
	
	//End of Problem 1 find the majority element of an array
	
	//Begin of problem 2 Find the number ocurring odd number of times
	
	public static int[] OddTimesArray={1,1,2,2,1,1,3,4,4,5,5};
	
	public static int getOddOcurrence(int[] array){
		int res=0;
		for(int i=0;i<array.length;i++){
			res=res^array[i];
		}
		return res;
	}
	
	//End of problem 2 Find the number ocurring odd number of times
	
	//Begin of problem 3 Largest Sum Continuous Subarray
	
	public static int[] sumArray={1,-2,3,-4,5,6,-3,-4,-6,-1,5,3};
	
	public static int kadaneAlgorithm(int[] array){
		int maxSoFar=0;
		int maxEndingHere=0;
		for(int i=0;i<array.length;i++){
			maxEndingHere+=array[i];
			if(maxEndingHere<0){
				maxEndingHere=0;
			}else if(maxSoFar<maxEndingHere){
				maxSoFar=maxEndingHere;
			}
		}
		return maxSoFar;
	}
	
	//End of problem 3 Largest Sum Continuous Subarray
	
	//Begin of problem 4 Find the missing number
	
	public static int[] missingArray={0,1,2,3,4,5,7,8,9,10};
	
	public static int missingNumber(int[] array){
		int n=array.length;
		int total=(n*(n+1))/2;
		for(int i=0;i<n;i++){
			total-=array[i];
		}
		return total;
	}
	
	//End of problem 4 Find the missing number
	
	//Begin of problem 5 Search in rotated array
	
	public static int[] rotatedArray={3,4,5,1,2};
	
	public static int rotatedSearch(int[] array,int start, int end,int element){
		int mid=(start+end)/2;
		if(array[mid]==element){
			return mid;
		}else if (array[start]<=array[mid]){
			if(element>=array[start]&&element<=array[mid]){
				return rotatedSearch(array,start,mid,element);
			}else{
				return rotatedSearch(array,mid+1,end,element);
			}
		}else{
			if(element>=array[mid+1]&&element<=array[end]){
				return rotatedSearch(array,mid+1,end,element);
			}else{
				return rotatedSearch(array,start,mid,element);
			}
		}
	}
	
	//End of problem 5 Search in rotated array
	
	//Begin of problem 6 Merge and array of size n into another array of size m+n
	
	public static int[] mnArray={1,2,-1,3,-1};
	public static int[] nArray={1,4};
	
	public static void arrayMerge(int[] mnArray, int[] nArray){
		int movedSpaces=0;
		for(int i=mnArray.length-1;i>=0;i--){
			if(mnArray[i]==-1){
				movedSpaces++;
			}else{
				mnArray[i+movedSpaces]=mnArray[i];
			}
			if(i<movedSpaces){
				mnArray[i]=-1;
			}
		}
		int mnCounter=movedSpaces;
		int nCounter=0;
	
		for(int finalCounter=0;finalCounter<mnArray.length;finalCounter++){
			int mnNumber=99;
			if(nCounter>=nArray.length){
				break;
			}else if(mnCounter>=mnArray.length){
				
			}else{
				mnNumber=mnArray[mnCounter];	
			}
			int nNumber=nArray[nCounter];
			if(mnNumber<nNumber){
				mnArray[finalCounter]=mnNumber;
				mnCounter++;
			}else{
				mnArray[finalCounter]=nNumber;
				nCounter++;
			}
			
		}
		
		System.out.print("Array ["+mnArray[0]);
		for(int i=1;i<mnArray.length;i++){
			System.out.print(","+mnArray[i]);
		}
		System.out.print("]\n");
	}
	
	//End of problem 6 Merge and array of size n into another array of size m+n
	
	//Begin of problem 7 Calculate the median of 2 sorted arrays
	
	//Verify the output
	
	public static int[] sortedMedianArray1={1,2,3,4,5,6,8};
	public static int[] sortedMedianArray2={1,2,3,5,7,9,10};
	
	public static int sortedMedian(int[] array1,int start1, int end1, int[] array2, int start2, int end2){
			int median1=(end1-start1)/2+1;
			int median2=(end2-start2)/2+1;
			if(median1==median2){
				return median1;
			}else if(end1-start1==2){
				return (Math.max(array1[0],array2[0])+Math.min(array1[1], array2[1]))/2;
			}else{
				if(median1>median2){
					return sortedMedian(array1,start1,(end1-start1)/2,array2,(end2-start2)/2,end2);
				}else{
					return sortedMedian(array1,(end1-start1)/2,end1,array2,start2,(end2-start2)/2);
				}
			}

	}

	//End of problem 7 Calculate the median of 2 sorted arrays
	
	//Begin of problem 8 Find the smallest and the second smallest in an array
	
	public static int[] smallestAndSecondArray={5,6,7,1,3,4,5,2};
	
	public static void smallestAndSecond(int[] array){
		int first=Integer.MAX_VALUE;
		int second=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++){
			if(array[i]<first){
				second=first;
				first=array[i];
			}else if(array[i]<second){
				second=array[i];
			}
		}
		System.out.println("The smallest value is "+first+" and the second is "+second);
	}
	
	//End of problem 8 Find the smallest and second smallest in an array
	
	//Begin of problem 9 Binary Search
	
	public static int[] binarySearchArray={1,2,3,4,5,6,7,8,9};
	
	public static int binarySearch(int[] array,int start,int end,int element){
		if(start>end){
			return -1;
		}else{
			int mid=(end+start)/2;
			if(element==array[mid]){
				return mid;
			}
			
			if (element>array[mid]){
				return binarySearch(array,mid+1,end,element);
			}
			return binarySearch(array,start,mid-1,element);
		}
			
	}
	//End of problem 9 BinarySearch
	
	//Begin of problem 10 Check for Majority Element in sorted Array
	
	public static int[] majoritySortedArray={1,2,2,2,3,4};
	
	public static boolean majoritySorted(int[] array, int element){
		int index=majorityBinarySearch(array,0,array.length,element);
		if(index+(array.length)/2>array.length) return false;
		return array[(index+array.length)/2]==array[index];
	}
	
	public static int majorityBinarySearch(int[] array,int start,int end,int element){
		System.out.println(start+" "+end);
		if(start>end){
			return -1;
		}else{
			int mid=(end+start)/2;
			if((mid==0||element>array[mid-1])&&(array[mid]==element)){
				return mid;
			}
			
			if (element>array[mid]){
				return majorityBinarySearch(array,mid+1,end,element);
			}
			return majorityBinarySearch(array,start,mid-1,element);
		}		
	}
	
	//End of problem 10 Check for Majority Element in sorted array
	
	//Start of problem 11 Maximum and minimun of one array
	
	public static int[] maxMinArray={5,6,7,2,8,9,10,11};
	
	public static int[] maxMin(int array[], int start, int end){
		
		if(end==start){
			int[] result={array[start],array[start]};
			return result;
		}else if(end-start==1){
			int[] result={Math.max(array[start],array[end]),Math.min(array[start],array[end])};
			return result;
		}else{
			int mid=(end+start)/2;
			int[] right= maxMin(array,mid,end);
			int[] left=maxMin(array,start,mid-1);
			int[] result={Math.max(right[0],left[0]),Math.min(right[1],left[1])};
			return result;
		}
	}
	//End of problem 11 Maximun and minimun of one array
	
	public static void main(String[] args) {
		moorePrintMajority(mooreArray);
		
		System.out.println("The number that appears an odd number of times is "+getOddOcurrence(OddTimesArray));
		
		System.out.println("The largest sum is "+kadaneAlgorithm(sumArray));
		
		System.out.println("The missing number is "+missingNumber(missingArray));
		
		System.out.println("The element 1 is in position "+rotatedSearch(rotatedArray,0,rotatedArray.length-1,1));
		
		arrayMerge(mnArray,nArray);
		
		System.out.println("The median of the two arrays is "+sortedMedian(sortedMedianArray1,0,sortedMedianArray1.length,sortedMedianArray2,0,sortedMedianArray2.length));
		
		smallestAndSecond(smallestAndSecondArray);
		
		System.out.println("The element 3 is in position "+binarySearch(binarySearchArray,0,binarySearchArray.length,3));
		
		System.out.println(majoritySorted(majoritySortedArray,2));
		
		int[] maxMin=maxMin(maxMinArray,0,maxMinArray.length-1);
		System.out.println("Maximun: "+maxMin[0]+" Minimum: "+maxMin[1]);
	}


}
