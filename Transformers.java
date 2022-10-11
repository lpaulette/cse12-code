
class UpperCaseTransformer implements MyTransformer<String> {

	@Override
	public String transformElement(String s) {
		return s.toUpperCase();
	}
}

//Add your transformers here:

//add 10 to ints
class Increment10Transformer implements MyTransformer<Integer>{
	
	@Override
	public Integer transformElement(Integer num) {
		return num + 10;
	}
}

//removes first character from string
class TrimStringTransformer implements MyTransformer<String>{
	
	@Override
	public String transformElement(String s) {
		//substring() consulted from https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
		return  s.substring(1);
	}
}

//change a characters to 0
class CharTransformer implements MyTransformer<String> {
	
	@Override
	public String transformElement(String s) {
		
		//.replace consulted from https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
		return s.replace("a", "0");
	}
	
	
}

	
	