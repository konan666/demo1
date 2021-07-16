package GPS;
public class Test_7cansu {
	public static void main(String[] args) {
		Co_transformation trans = new Co_transformation();
		BLH ge_coordinates84=new BLH();
		Pxyz xyz54 =new Pxyz();
		ge_coordinates84.B=2453.1;
		ge_coordinates84.L=11809.5;
		double L0=118.30;
		ge_coordinates84.B=trans.d2rad(trans.dddmm5_to_dddd(ge_coordinates84.B));
		ge_coordinates84.L=trans.d2rad(trans.dddmm5_to_dddd(ge_coordinates84.L));
		L0=trans.d2rad(trans.dddmm3_to_dddd(L0));
		double m=0.0;
		double ex=0.0/3600/180*Math.PI;
		double ey=0.0/3600/180*Math.PI;
		double ez=0.0/3600/180*Math.PI;
		double dx= 0.0;
		double dy=0.0;
		double dz=0.0;
		xyz54=trans.co_84to54(ge_coordinates84, m, ex, ey, ez, dx, dy, dz, L0);
		System.out.println(xyz54.x);
		System.out.println(xyz54.y);
	}
}
