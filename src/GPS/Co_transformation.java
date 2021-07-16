package GPS;
import static java.lang.Math.*;
/**
 *
 * @author administered
 *使用前请将所有角度的单位转换为弧度制00
 *方法说明如下：
 *co_84to54  将WGS-84坐标转换为北京-54坐标
 *Co_BLHtoXYZ  将大地坐标转换为空间直角坐标
 *Co_XYZtoBLH  将空间直角坐标转换为大地坐标
 *Co_XYZtoNewXYZ  用布尔萨七参数法进行不同椭球下空间直角坐标的转换
 *Co_BLHtoPxyz  将大地坐标用高斯投影转换为平面坐标
 *sloveX  求解赤道到纬度B所对应的子午线弧长，辅助Co_BLHtoPxyz方法
 *dddmm5_to_dddd  将度分格式数据转换为度，例如30°15.32548′对应的度分数据格式为03015.32548时适用此方法
 *dddmm3_to_dddd  将度分格式数据转换为度，例如30°15.32548′对应的度分数据格式为030.1532548时适用此方法
 *
 *其他参数说明：
 *m,ex,ey,ez,dx,dy,dz  布尔萨七参数
 *L0  投影带的中央子午线
 *a  椭球长半轴
 *b  椭球短半轴
 */

public class Co_transformation {

	public XYZ Co_BLHtoXYZ(BLH ge_coordinates,double a,double b) {
		XYZ sp_coordinate =new XYZ();
		double e;
		double N;
		e=sqrt((a*a-b*b)/(a*a));
		N=a/sqrt(1-pow(e*sin(ge_coordinates.B), 2));
		sp_coordinate.X=(N+ge_coordinates.H)*cos(ge_coordinates.B)*cos(ge_coordinates.L);
		sp_coordinate.Y=(N+ge_coordinates.H)*cos(ge_coordinates.B)*sin(ge_coordinates.L);
		sp_coordinate.Z=(N*(1-e*e)+ge_coordinates.H)*sin(ge_coordinates.B);
		return sp_coordinate;
	}

	public BLH Co_XYZtoBLH(XYZ sp_coordinate,double a,double b) {
		BLH ge_coordinates = new BLH();
		double e;
		double B0;
		double N;
		e=sqrt((a*a-b*b)/(a*a));
		B0=atan(sp_coordinate.Z/sqrt(sp_coordinate.X*sp_coordinate.X+sp_coordinate.Y*sp_coordinate.Y));
		N=a/sqrt(1-pow(e*sin(B0), 2));
		ge_coordinates.H=sqrt(sp_coordinate.X*sp_coordinate.X+sp_coordinate.Y*sp_coordinate.Y)/cos(B0)-N;
		ge_coordinates.B=atan(sp_coordinate.Z*(N+ge_coordinates.H)/(sqrt(sp_coordinate.X*sp_coordinate.X+sp_coordinate.Y*sp_coordinate.Y)*(N*(1-e*e)+ge_coordinates.H)));
		while (abs(B0-ge_coordinates.B)>0.0000000001) {
			B0=ge_coordinates.B;
			N=a/sqrt(1-pow(e*sin(B0), 2));
			ge_coordinates.H=sqrt(sp_coordinate.X*sp_coordinate.X+sp_coordinate.Y*sp_coordinate.Y)/cos(ge_coordinates.B)-N;
			ge_coordinates.B=atan(sp_coordinate.Z*(N+ge_coordinates.H)/(sqrt(sp_coordinate.X*sp_coordinate.X+sp_coordinate.Y*sp_coordinate.Y)*(N*(1-e*e)+ge_coordinates.H)));
		}
		ge_coordinates.L=atan(sp_coordinate.Y/sp_coordinate.X);
		if (ge_coordinates.L<0) {
			ge_coordinates.L=ge_coordinates.L+PI;
		}
		return ge_coordinates;
	}

	public XYZ Co_XYZtoNewXYZ(XYZ sp_coordinate,double m,double ex,double ey,double ez,double dx,double dy,double dz) {
		XYZ newXYZ =new XYZ();
		newXYZ.X=(1+m)*sp_coordinate.X+ez*sp_coordinate.Y-ey*sp_coordinate.Z+dx;
		newXYZ.Y=(1+m)*sp_coordinate.Y-ez*sp_coordinate.X+ex*sp_coordinate.Z+dy;
		newXYZ.Z=(1+m)*sp_coordinate.Z+ey*sp_coordinate.X-ex*sp_coordinate.Y+dz;
		return newXYZ;
	}

	public Pxyz Co_BLHtoPxyz(BLH ge_co,double a,double b,double L0) {
		Pxyz xyz =new Pxyz();
		double e;
		double e1;
		e=sqrt((a*a-b*b)/(a*a));
		e1=sqrt((a*a-b*b)/(b*b));
		double t =tan(ge_co.B);
		double yi=e1*cos(ge_co.B);
		double N =a/pow(1-pow(e*sin(ge_co.B), 2), 0.5);
		double l =ge_co.L-L0;
		Co_transformation xsolve=new Co_transformation();
		double X=xsolve.sloveX(ge_co.B, a, b);
		xyz.x=X+1.0/2*N*t*pow(cos(ge_co.B)*l,2)+1.0/24*N*t*(5-t*t+9*pow(yi, 2)+
				4*pow(yi, 4))*pow(cos(ge_co.B)*l,4)+1.0/720*N*t*(61-58*t*t+pow(t, 4))*pow(cos(ge_co.B)*l,6);
		xyz.y=N*cos(ge_co.B)*l+1.0/6*N*(1-t*t+yi*yi)*pow(cos(ge_co.B)*l,3)+1.0/120*N*(5-18*t*t+pow(t, 4)+
				14*yi*yi-58*yi*yi*t*t)*pow(cos(ge_co.B)*l,5);
		xyz.y=xyz.y+500000;
		return xyz;
	}

	public double sloveX(double B,double a,double b) {
		//求解赤道到纬度B所对应的子午线弧长
		double X;
		double e;
		double m0;double m2;double m4;double m6;double m8;
		double a0;double a2;double a4;double a6;double a8;
		e=sqrt((a*a-b*b)/(a*a));
		m0=a*(1-e*e);
		m2=3.0/2*e*e*m0;
		m4=5.0/4*e*e*m2;
		m6=7.0/6*e*e*m4;
		m8=9.0/8*e*e*m6;
		a0=m0+m2/2+3.0/8*m4+5.0/16*m6+35.0/128*m8;
		a2=m2/2+1.0/2*m4+15.0/32*m6+7.0/16*m8;
		a4=1.0/8*m4+3.0/16*m6+7.0/32*m8;
		a6=1.0/32*m6+1.0/16*m8;
		a8=1.0/128*m8;
		X=a0*B-a2*sin(2*B)/2+a4*sin(4*B)/4-a6*sin(6*B)/6+a8*sin(8*B)/8;
		return X;
	}

	public Pxyz co_84to54(BLH ge_coordinates84,double m,double ex,double ey,double ez,double dx,double dy,double dz,double L0) {
		XYZ XYZ84=new XYZ();
		Pxyz xyz54 =new Pxyz();
		XYZ XYZ54=new XYZ();
		BLH ge_coordinates54=new BLH();
		double a84=6378137;
		double b84=a84-a84/298.257223563;
		double a54=6378245;
		double b54=a54-a54/298.3;
		XYZ84=Co_BLHtoXYZ(ge_coordinates84, a84, b84);
		XYZ54=Co_XYZtoNewXYZ(XYZ84, m, ex, ey, ez, dx, dy, dz);
		ge_coordinates54=Co_XYZtoBLH(XYZ54, a54, b54);
		xyz54=Co_BLHtoPxyz(ge_coordinates54, a54, b54, L0);
		return xyz54;
	}

	public double dddmm5_to_dddd(double dddmm) {
		double d;
		dddmm=dddmm/100;
		double du=floor(dddmm);
		double fen=(dddmm-du)*100;
		d=du+fen/60;
		return d;
	}

	public double dddmm3_to_dddd(double dddmm) {
		double d;
		double du=floor(dddmm);
		double fen=(dddmm-du)*100;
		d=du+fen/60;
		return d;
	}

	public double d2rad(double d) {
		double rad=d/180*PI;
		return rad;
	}

	public Pxyz co_84to54_4canshu(Pxyz xyz84,double dx,double dy,double alpha,double m) {
		Pxyz xyz54= new Pxyz();
		xyz54.x=dx+(1+m)*xyz84.x*cos(alpha)-(1+m)*xyz84.y*sin(alpha);
		xyz54.y=dy+(1+m)*xyz84.x*sin(alpha)+(1+m)*xyz84.y*cos(alpha);
		return xyz54;
	}
}
