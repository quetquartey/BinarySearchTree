
public class Fraction implements Comparable<Fraction>{
	private int numerator, denominator;
	private Double value;
	String strFraction;
	
	public Fraction(String strFraction) throws NumberFormatExpressionException
	{
		this.strFraction = strFraction;
		String[] tstString = strFraction.split("/");
//		boolean goodFormat = strFraction.matches("\\d{1}/\\d{1}");
		boolean goodFormat = strFraction.matches("\\d*/\\d*");
//		if ( tstString[0] == null || Integer.parseInt(tstString[1]) == 0 || !goodFormat)
		if ( goodFormat && !tstString[1].equals("0"))			
		{
			numerator = Integer.parseInt(tstString[0]);
			denominator = Integer.parseInt(tstString[1]);
			value = ((double) numerator/denominator);
		}
		else
		{
			throw new NumberFormatExpressionException();
		}
	}
	
	public int getNumerator()
	{
		return numerator;
	}
	
	public int getDenominator()
	{
		return denominator;
	}
	
	public String toString()
	{
		return strFraction;
	}
	
	public double getValue()
	{
		return value;
	}
	
/*	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Fraction fract = (Fraction) o;
		return value.compareTo(fract.getValue());
	}*/

	@Override
	public int compareTo(Fraction o) {
		// TODO Auto-generated method stub
		return value.compareTo(o.getValue());
	}

}
