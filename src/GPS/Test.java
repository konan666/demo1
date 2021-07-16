package GPS;
public class Test {
	public static void main(String[] args) {
		Co_transformation trans = new Co_transformation();
		BLH ge_coordinates84=new BLH();
		Pxyz xyz54 =new Pxyz();
		Pxyz xyz84 =new Pxyz();
		ge_coordinates84.B=24.885317421;
		ge_coordinates84.L=118.158282717;
		double L0=118.30;
		double a84=6378137;
		double b84=a84-a84/298.257223563;
		ge_coordinates84.B=trans.d2rad(ge_coordinates84.B);
		ge_coordinates84.L=trans.d2rad(ge_coordinates84.L);
		L0=trans.d2rad(trans.dddmm3_to_dddd(L0));
		double m=0.0000858589440837498;
		double alpha=3.82702389228116/3600/180*Math.PI;
		double dx=-169.305004998238;
		double dy=-165.229577832145;
		xyz84=trans.Co_BLHtoPxyz(ge_coordinates84, a84, b84, L0);
		xyz54=trans.co_84to54_4canshu(xyz84, dx, dy, alpha, m);
		System.out.println(xyz54.x);
		System.out.println(xyz54.y);
	}
}
