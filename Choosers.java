
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

//choose Integers equal to 5
class Num5Chooser implements MyChooser<Integer> {
	
	@Override
	public boolean chooseElement(Integer num) {
		//compareTo consulted from https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html#compareTo(java.lang.Integer)
		if(num.compareTo(5) == 0)
			return true;
		else
			return false;
	}
}

//chooses strings that end with char s
class SuffixSChooser implements MyChooser<String>{
	
	@Override
	public boolean chooseElement(String s) {
		//endsWith() consulted from https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#endsWith(java.lang.String)
		return s.endsWith("s");
	}
}



