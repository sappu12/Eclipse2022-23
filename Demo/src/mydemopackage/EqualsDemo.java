package mydemopackage;

public class EqualsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="PerScholas";
	       String s2="PerScholas";
	       String s3=new String("PerScholas");
	       String s4="Teksystem";
	       System.out.println(s1.equals(s2));//true
	       System.out.println(s1.equals(s3));//true 
	       System.out.println(s1.equals(s4));//false
	}

}
