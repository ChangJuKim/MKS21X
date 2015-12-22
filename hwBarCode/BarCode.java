public class BarCode implements Comparable{
    // instance variables
    private String _zip;
    private int _checkDigit;
    private static String[] conv;

    // constructors
    //precondtion: zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public BarCode(String zip) {
	for (int i = 0; i < 9; i++) {
	    
	}
    }
    
    // postcondition: Creates a copy of a bar code.
    public BarCode(BarCode x){}


    private String[] createConversion() {
	String[] ary = new ary[10];
	for (int i = 0; i < 9; i++) {
	    if (i = 0) {
		ary[i] = "||:::";
	    } else if (i = 1) {
		ary[i] = ":::||";
	    } else if (i = 2) {
		ary[i] = "::|:|";
	    } else if (i = 3) {
		ary[i] = "::||:";
	    } else if (i = 4) {
		ary[i] = ":|::|";
	    } else if (i = 5) {
		ary[i] = ":|:|:";
	    } else if (i = 6) {
		ary[i] = ":||::";
	    } else if (i = 7) {
		ary[i] = "|:::|";
	    } else if (i = 8) {
		ary[i] = "|::|:";
	    } else if (i = 9) {
		ary[i] = "|:|::";
	    }
	}
	return ary;
    }
    
    private String toBarcode(int n) {
	
    }
    
    //post: computes and returns the check sum for _zip
    private int checkSum(){}

    //postcondition: format zip + check digit + barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){}


    public boolean equals(Object other){}
    // postcondition: false if the object is not a BarCode, 
    // false if it is a non-matching barcode
    // true when they match.


    public int compareTo(Comparable other){}
    // postcondition: compares the zip + checkdigit 

}
