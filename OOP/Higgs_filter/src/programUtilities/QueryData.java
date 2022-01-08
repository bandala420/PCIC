package programUtilities;

public class QueryData{
	private boolean isNumber;
	private float numValue;
	private String dataString;
	public QueryData(String dataString) {
		try {
			this.numValue = Float.parseFloat(dataString);
			this.isNumber = true;
		}catch (NumberFormatException e) {
			this.isNumber = false;
		}
		this.dataString = dataString;
	}
	public boolean compareTo(QueryData qd,String operator) {
		if (isNumber) {
			if (operator.contains("!=") || operator.contains("=!"))
				return this.numValue!=qd.getNumValue();
			if (operator.contains("="))
				return this.numValue==qd.getNumValue();
			if (operator.contains(">"))
				return this.numValue>qd.getNumValue();
			if (operator.contains("<"))
				return this.numValue<qd.getNumValue();
		}else {
			if (operator.contains("!=") || operator.contains("=!"))
				return !this.dataString.equals(qd.getDataString());
			if (operator.contains("="))
				return this.dataString.equals(qd.getDataString());
			if (operator.contains(">"))
				return this.dataString.length()>qd.getDataString().length();
			if (operator.contains("<"))
				return this.dataString.length()<qd.getDataString().length();
		}
		return false;
	}
	public String getDataString() {
		return this.dataString;
	}
	public float getNumValue() {
		return this.numValue;
	}
}
