package Temee;

class Parabola{
	private double a;
	private double b;
	private double c;
	
	
	//constructor principal
	public Parabola(double aa,double bb,double cc)
	{
		a=aa; b=bb; c=cc;
	}
	//contructorul clasei
	public Parabola(Parabola p) {
		a=p.a; b=p.b; c=p.c;
	}
	//vector de 3 doubles returneaza nr adaugata;
	public double[] get() {
		double[] ans = new double[3];
		ans[0]=a;
		ans[1]=b;
		ans[2]=c;
		return ans;
	}
	//returneaza coordonatele;
	public double[] coord() {
		double[] crd = new double[2];
		crd[0]=(-b)/(2*a);
		crd[1]=(-(b*2)+4*a*c)/(4*a);
		return crd;
	}
	
	public static double[] vf(double x1,double x2,double y1,double y2) {
		double[] varf=new double[4];
		
		varf[0]=(x1+x2)/2;
		varf[1]=(y1+y2)/2;
		return varf;
		
	}
}


public class Pb1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parabola p1 = new Parabola(1,2,3);
		Parabola p2 = new Parabola(2,3,4);
		double[] ans = p1.get();
		System.out.println("a: "+ans[0]+" b: "+ans[1]+" c:"+ans[2]);
		System.out.println("f(x)="+ans[0]+"*x^2+"+ans[1]+"*x"+ans[2]);
		double[] crd = p1.coord();
		System.out.println("\nCoordonatele vf1 sunt: ("+crd[0]+","+crd[1]+")");
		double[] crd2 = p2.coord();
		System.out.println("\nCoordonatele vf2 sunt: ("+crd2[0]+","+crd2[1]+")");
		
		double[] varf = p1.vf(crd[0],crd2[0],crd[1],crd2[1]);
		System.out.println("\nx mij seg: "+varf[0]+" y mij seg: "+varf[1]);
	}
	
	
	

}
