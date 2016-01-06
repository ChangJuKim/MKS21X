import java.util.*;

public class Sorts{
    public static void printArray(int[]data){
	//print the array like:  [ 1, 2, 3, 4]
	String ans = "[";
	for (int i = 0; i < data.length; i++) {
	    ans += " " + data[i] + ",";
	}
	System.out.println(ans.substring(0, ans.length() - 1) + "]");
    }

    /*

    private static int[] increaseSize(int[]data) {
	int[] newData = new int[data.length * 2];
	for (int i = 0; i < data.length; i++) {
	    newData[i] = data[i];
	}
	return newData;
    }

    //finds proper place for a number, given it is an ordered list
    private static int find(int[]data, int num) {
        int first = 0;
	int last = data.length;
	int middle = (first + last) / 2;
	boolean foundPlace = false;
	while (!foundPlace) {
	    //if looking at 2 side-by-side numbers
	    if (first == last - 1 || first == last - 2) {
		System.out.println("end!");
		middle = (first + last) / 2;
		foundPlace = true;
	    } else if (data[middle] < num) {
		System.out.println("middle, "+middle+", "+data[middle]+" is < num "+num+"!");
		first = middle + 1;
		middle = (first + last) / 2;
	    } else if (data[middle] > num) {
		System.out.println("middle, "+middle+", "+data[middle]+" is > num "+num+"!");
		last = middle;
		middle = (first + last) / 2;
	    } else if (data[middle] == num) {
		System.out.println("middle, "+middle+", "+data[middle]+" is = num "+num+"!");
		last = middle + 1;
		middle = (first + last) / 2;
	    }
	}
	return middle;
    }


    //
    private static int[] add(int[]data, int num) {
	for (int i = data.length-1; i > find(data,num); i--) {
	    data[i] = data[i-1];
	}
	data[find(data,num)] = num;
	return data;
    }

    */
    
    public static void insertionSort(int[]data){
	//your code here to make data re-order its elements
	//from least to greatest just like we did in class
	//same algorithm as the way you created your OrderedSuperArray

	//temporarily holds the number to be moved
	int tempHold;
	for (int i = 1; i < data.length; i++) {
	    if (data[i] < data[i-1]) {
		tempHold = data[i]; 
		int j = i;
		//shifts everything from num's desired location to i-1 one over.
		//tempHold also preserves number to be compared (to find)
		while (j > 0 && tempHold < data[j-1]) {
		    //System.out.println("j("+j+") - [data[j], data[j-1]] : ["+data[j]+", "+data[j-1]+"]");
		    data[j] = data[j-1];
		    j--;
		}
		data[j] = tempHold;
	    }
	    printArray(data); 
	}
	printArray(data);
    }

    //swaps the minimum value with index 0, 1, 2, ...
    public static void selection(int[] data) {
	int hold = 0; //temporarily holds a value when swapping
	int minIndex = 0;
	for (int i = 0; i < data.length; i++) {
	    //finds minimum number's index
	    for (int j = 0; j < data.length; j++) {
		if (data[j] <= data[minIndex]) {
		    minIndex = j;
		}
	    }
	    hold = data[minIndex];
	    data[minIndex] = data[i];
	    data[i] = hold;
	}
	printArray(data);
    }

    public static int[] randomArray() {
	Random rand = new Random();
	int seed = rand.nextInt();
	rand = new Random(seed);
	int size = rand.nextInt(5);
	int[] ary = new int[5 + size];
	for (int i = 0; i < ary.length; i++) {
	    ary[i] = rand.nextInt(20);
	}
	return ary;
    }

    public static void main(String[]args) {
	int[] ary = randomArray();
	printArray(ary);
	insertionSort(ary);
    }
}
