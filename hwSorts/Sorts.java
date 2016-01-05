public class Sorts{
    public static void printArray(int[]data){
	//print the array like:  [ 1, 2, 3, 4]
	String ans = "[";
	for (int i = 0; i < data.length; i++) {
	    ans += " " + data[i] + ",";
	}
	System.out.println(ans.substring(0, ans.length() - 1) + "]");
    }
    //finds num's rightful place
    private static int[] increaseSize(int[]data) {
	int[] newData = new int[data.length * 2];
	for (int i = 0; i < data.length; i++) {
	    newData[i] = data[i];
	}
	return newData;
    }
    
    private static int find(int[]data, int num) {
        int first = 0;
	int last = data.length;
	int middle = (first + last) / 2;
	if (first == last - 1) {
	    return num;
	} else if (data[middle] > num) {
	    first = middle + 1;
	    middle = (first + last) / 2;
	} else if (data[middle] < num) {
	    last = middle;
	    middle = (first + last) / 2;
	} else if (data[middle] == num) {
	    last = middle + 1;
	    middle = (first + last) / 2;
	}
	return middle;
    }
    private static int[] add(int[]data, int num) {
	for (int i = data.length; i > find(data,num); i--) {
	    data[i] = data[i-1];
	}
	data[find(data,num)] = num;
	return data;
    }
    public static void insertionSort(int[]data){
	//your code here to make data re-order its elements
	//from least to greatest just like we did in class
	//same algorithm as the way you created your OrderedSuperArray
	
	/*	int[] ans = new int[data.length];
	int minIndex = 0; //index of minimum number
	//loops through the entire data
	for (int i = 0; i < data.length; i++) {
	    //finds the minimum value
	    for (int j = 0; j < data.length; j++) {
		if (data[j] <= data[minIndex]) {
		    minIndex = j; //records the index of lowest value
		}
	    }
	    //records the minimum value of data
	    ans[i] = data[minIndex];
	    data[minIndex] = Integer.MAX_VALUE; //removes data's minimum number
	}
	printArray(ans); */

	
	//error

	//temporarily holds the number to be moved
	int tempHold;
	for (int i = 1; i < data.length; i++) {
	    if (data[i] < data[i-1]) {
		tempHold = data[i]; 
		int index = find(data, data[i]);
		//shifts everything from num's desired location to i-1 one over. 
		for (int j = i; j > index; j--) {
		    data[j] = data[j-1];
		}
		data[index] = tempHold;
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

    public static void main(String[]args) {
	int[] ary = new int[10];
	for (int i = 0; i < ary.length; i++) {
	    ary[i] = ary.length - i;
	}
	printArray(ary);
	selection(ary);
	insertionSort(ary);
    }
}
