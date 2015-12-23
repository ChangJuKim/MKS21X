import java.lang.*;

public class BarCode implements Comparable{
    // instance variables
    private String _zip;
    private int _checkDigit;
    private String[] conv = createConversion();

    // constructors
    //precondtion: zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               _zip and _checkDigit are initialized.
    public BarCode(String zip) {
	_zip = zip;
    }
    
    // postcondition: Creates a copy of a bar code.
    public BarCode(BarCode x){
	_zip = x._zip;
	_checkDigit = x._checkDigit;
    }


    private String[] createConversion() {
	String[] ary = new String[10];
	for (int i = 0; i < 9; i++) {
	    if (i == 0) {
		ary[i] = "||:::";
	    } else if (i == 1) {
		ary[i] = ":::||";
	    } else if (i == 2) {
		ary[i] = "::|:|";
	    } else if (i == 3) {
		ary[i] = "::||:";
	    } else if (i == 4) {
		ary[i] = ":|::|";
	    } else if (i == 5) {
		ary[i] = ":|:|:";
	    } else if (i == 6) {
		ary[i] = ":||::";
	    } else if (i == 7) {
		ary[i] = "|:::|";
	    } else if (i == 8) {
		ary[i] = "|::|:";
	    } else if (i == 9) {
		ary[i] = "|:|::";
	    }
	}
	return ary;
    }
    
    private String convToBarcode() {
	String ans = "";
	for (int i = 0; i < _zip.length(); i++) {
	    ans += conv[Integer.parseInt(""+_zip.charAt(i))];
	}
	return ans;
    }
    
    //post: computes and returns the check sum for _zip
    private int checkSum(){
	int ans = 0;
	for (int i = 0; i < _zip.length(); i++) {
	    ans += Integer.parseInt(""+_zip.charAt(i));
	}
	return ans % 10;
    }
    
    //postcondition: format zip + check digit + barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return convToBarcode();
    }
    

    public boolean equals(Object other){
	if (other instanceof BarCode && _zip.equals(((BarCode)other)._zip)) {
	    return true;
	}
	return false;
    }
    // postcondition: false if the object is not a BarCode, 
    // false if it is a non-matching barcode
    // true when they match.


    //   public int compareTo(Comparable other){
    public int compareTo(Object other) {
    // postcondition: compares the zip + checkdigit
	if (_zip.equals(((BarCode)other)._zip) && checkSum() == ((BarCode)other).checkSum()) {
	    return 0;
	}
	int z1 = Integer.parseInt(_zip);
	int z2 = Integer.parseInt(((BarCode)other)._zip);
	
	z1 = z1 * 10 + checkSum();
	z2 = z2 * 10 + ((BarCode)other).checkSum();
	return z1 - z2;

	
    }
}
