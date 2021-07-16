package GPS;

public class Xiamen_cotrans {
public Pxyz BLH2xyz(BLH blh) {
	Co_transformation trans = new Co_transformation();
	Pxyz xyz54 =new Pxyz();
	Pxyz xyz84 =new Pxyz();
	double L0=118.30;
	double a84=6378137;
	double b84=a84-a84/298.257223563;
	blh.B=trans.d2rad(trans.dddmm5_to_dddd(blh.B));
	blh.L=trans.d2rad(trans.dddmm5_to_dddd(blh.L));
	L0=trans.d2rad(trans.dddmm3_to_dddd(L0));
	double m=0.0000858589440837498;
	double alpha=3.82702389228116/3600/180*Math.PI;
	double dx=-169.305004998238;
	double dy=-165.229577832145;
	xyz84=trans.Co_BLHtoPxyz(blh, a84, b84, L0);
	xyz54=trans.co_84to54_4canshu(xyz84, dx, dy, alpha, m);
	return xyz54;
}
}
