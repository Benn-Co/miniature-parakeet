package org.netlib.lapack;

import org.netlib.util.Util;
import org.netlib.util.doubleW;

public final class Dlanv2 {
	public static void dlanv2(doubleW doublew, doubleW doublew1,
			doubleW doublew2, doubleW doublew3, doubleW doublew4,
			doubleW doublew5, doubleW doublew6, doubleW doublew7,
			doubleW doublew8, doubleW doublew9) {
		double d14 = 0.0D;
		d14 = Dlamch.dlamch("P");
		if (doublew2.val == 0.0D) {
			doublew8.val = 1.0D;
			doublew9.val = 0.0D;
		} else if (doublew1.val == 0.0D) {
			doublew8.val = 0.0D;
			doublew9.val = 1.0D;
			double d33 = doublew3.val;
			doublew3.val = doublew.val;
			doublew.val = d33;
			doublew1.val = -doublew2.val;
			doublew2.val = 0.0D;
		} else if ((doublew.val - doublew3.val == 0.0D)
				&& (Util.dsign(1.0D, doublew1.val) != Util.dsign(1.0D,
						doublew2.val))) {
			doublew8.val = 1.0D;
			doublew9.val = 0.0D;
		} else {
			double d34 = doublew.val - doublew3.val;
			double d16 = 0.5D * d34;
			double d5 = Math
					.max(Math.abs(doublew1.val), Math.abs(doublew2.val));
			double d7 = Math
					.min(Math.abs(doublew1.val), Math.abs(doublew2.val))
					* Util.dsign(1.0D, doublew1.val)
					* Util.dsign(1.0D, doublew2.val);
			double d23 = Math.max(Math.abs(d16), d5);
			double d37 = (d16 / d23) * d16 + (d5 / d23) * d7;
			if (d37 >= 4D * d14) {
				d37 = d16 + Util.dsign(Math.sqrt(d23) * Math.sqrt(d37), d16);
				doublew.val = doublew3.val + d37;
				doublew3.val = doublew3.val - (d5 / d37) * d7;
				double d29 = Dlapy2.dlapy2(doublew2.val, d37);
				doublew8.val = d37 / d29;
				doublew9.val = doublew2.val / d29;
				doublew1.val = doublew1.val - doublew2.val;
				doublew2.val = 0.0D;
			} else {
				double d25 = doublew1.val + doublew2.val;
				double d30 = Dlapy2.dlapy2(d25, d34);
				doublew8.val = Math.sqrt(0.5D * (1.0D + Math.abs(d25) / d30));
				doublew9.val = -((d16 / (d30 * doublew8.val)) * Util.dsign(
						1.0D, d25));
				double d1 = doublew.val * doublew8.val + doublew1.val
						* doublew9.val;
				double d3 = -(doublew.val * doublew9.val) + doublew1.val
						* doublew8.val;
				double d9 = doublew2.val * doublew8.val + doublew3.val
						* doublew9.val;
				double d13 = -(doublew2.val * doublew9.val) + doublew3.val
						* doublew8.val;
				doublew.val = d1 * doublew8.val + d9 * doublew9.val;
				doublew1.val = d3 * doublew8.val + d13 * doublew9.val;
				doublew2.val = -(d1 * doublew9.val) + d9 * doublew8.val;
				doublew3.val = -(d3 * doublew9.val) + d13 * doublew8.val;
				d34 = 0.5D * (doublew.val + doublew3.val);
				doublew.val = d34;
				doublew3.val = d34;
				if (doublew2.val != 0.0D)
					if (doublew1.val != 0.0D) {
						if (Util.dsign(1.0D, doublew1.val) == Util.dsign(1.0D,
								doublew2.val)) {
							double d19 = Math.sqrt(Math.abs(doublew1.val));
							double d21 = Math.sqrt(Math.abs(doublew2.val));
							double d17 = Util.dsign(d19 * d21, doublew2.val);
							double d31 = 1.0D / Math.sqrt(Math.abs(doublew1.val
									+ doublew2.val));
							doublew.val = d34 + d17;
							doublew3.val = d34 - d17;
							doublew1.val = doublew1.val - doublew2.val;
							doublew2.val = 0.0D;
							double d11 = d19 * d31;
							double d27 = d21 * d31;
							d34 = doublew8.val * d11 - doublew9.val * d27;
							doublew9.val = doublew8.val * d27 + doublew9.val
									* d11;
							doublew8.val = d34;
						}
					} else {
						doublew1.val = -doublew2.val;
						doublew2.val = 0.0D;
						double d35 = doublew8.val;
						doublew8.val = -doublew9.val;
						doublew9.val = d35;
					}
			}
		}
		doublew4.val = doublew.val;
		doublew6.val = doublew3.val;
		if (doublew2.val == 0.0D) {
			doublew5.val = 0.0D;
			doublew7.val = 0.0D;
		} else {
			doublew5.val = Math.sqrt(Math.abs(doublew1.val))
					* Math.sqrt(Math.abs(doublew2.val));
			doublew7.val = -doublew5.val;
		}
	}
}
