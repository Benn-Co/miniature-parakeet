package org.netlib.lapack;

import org.netlib.util.Util;
import org.netlib.util.doubleW;

public final class Dlasv2 {
	public static void dlasv2(double d, double d1, double d2, doubleW doublew,
			doubleW doublew1, doubleW doublew2, doubleW doublew3,
			doubleW doublew4, doubleW doublew5) {
		boolean flag2 = false;
		byte byte0 = 0;
		double d5 = 0.0;
		double d6 = 0.0;
		double d9 = 0.0;
		double d10 = 0.0;
		double d11 = 0.0;
		double d12 = 0.0;
		double d13 = 0.0;
		double d14 = 0.0;
		double d25 = 0.0;
		double d26 = 0.0;
		double d31 = 0.0;
		d10 = d;
		d9 = Math.abs(d10);
		d14 = d2;
		d13 = Math.abs(d2);
		byte0 = 1;
		flag2 = d13 > d9;
		if (flag2) {
			byte0 = 3;
			double d30 = d10;
			d10 = d14;
			d14 = d30;
			d30 = d9;
			d9 = d13;
			d13 = d30;
		}
		d12 = d1;
		d11 = Math.abs(d12);
		if (d11 == 0.0) {
			doublew.val = d13;
			doublew1.val = d9;
			d5 = 1.0;
			d6 = 1.0;
			d25 = 0.0;
			d26 = 0.0;
		} else {
			boolean flag1 = true;
			if (d11 > d9) {
				byte0 = 2;
				if (d9 / d11 < Dlamch.dlamch("EPS")) {
					flag1 = false;
					doublew1.val = d11;
					if (d13 > 1.0)
						doublew.val = d9 / (d11 / d13);
					else
						doublew.val = (d9 / d11) * d13;
					d5 = 1.0;
					d25 = d14 / d12;
					d26 = 1.0;
					d6 = d10 / d12;
				}
			}
			if (flag1) {
				double d8 = d9 - d13;
				double d16;
				if (d8 == d9)
					d16 = 1.0;
				else
					d16 = d8 / d9;
				double d18 = d12 / d10;
				double d28 = 2.0 - d16;
				double d20 = d18 * d18;
				double d33 = d28 * d28;
				double d24 = Math.sqrt(d33 + d20);
				double d22;
				if (d16 == 0.0)
					d22 = Math.abs(d18);
				else
					d22 = Math.sqrt(d16 * d16 + d20);
				double d4 = 0.5 * (d24 + d22);
				doublew.val = d13 / d4;
				doublew1.val = d9 * d4;
				if (d20 == 0.0) {
					if (d16 == 0.0)
						d28 = Util.dsign(2D, d10) * Util.dsign(1.0, d12);
					else
						d28 = d12 / Util.dsign(d8, d10) + d18 / d28;
				} else {
					d28 = (d18 / (d24 + d28) + d18 / (d22 + d16)) * (1.0 + d4);
				}
				d16 = Math.sqrt(d28 * d28 + 4.0);
				d6 = 2.0 / d16;
				d26 = d28 / d16;
				d5 = (d6 + d26 * d18) / d4;
				d25 = ((d14 / d10) * d26) / d4;
			}
		}
		if (flag2) {
			doublew5.val = d26;
			doublew4.val = d6;
			doublew3.val = d25;
			doublew2.val = d5;
		} else {
			doublew5.val = d5;
			doublew4.val = d25;
			doublew3.val = d6;
			doublew2.val = d26;
		}
		if (byte0 == 1)
			d31 = Util.dsign(1.0, doublew3.val)
					* Util.dsign(1.0, doublew5.val) * Util.dsign(1.0, d);
		if (byte0 == 2)
			d31 = Util.dsign(1.0, doublew2.val)
					* Util.dsign(1.0, doublew5.val) * Util.dsign(1.0, d1);
		if (byte0 == 3)
			d31 = Util.dsign(1.0, doublew2.val)
					* Util.dsign(1.0, doublew4.val) * Util.dsign(1.0, d2);
		doublew1.val = Util.dsign(doublew1.val, d31);
		doublew.val = Util.dsign(doublew.val,
				d31 * Util.dsign(1.0, d) * Util.dsign(1.0, d2));
	}
}
