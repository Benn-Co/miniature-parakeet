package org.netlib.lapack;

public final class Dlaqr1 {
	public static void dlaqr1(int i, double ad[], int j, int k, double d,
			double d1, double d2, double d3, double ad1[], int l) {
		if (i == 2) {
			double d10 = Math.abs(ad[(1 - 1) + (1 - 1) * k + j] - d2)
					+ Math.abs(d3) + Math.abs(ad[(2 - 1) + (1 - 1) * k + j]);
			if (d10 == 0.0D) {
				ad1[(1 - 1) + l] = 0.0D;
				ad1[(2 - 1) + l] = 0.0D;
			} else {
				double d5 = ad[(2 - 1) + (1 - 1) * k + j] / d10;
				ad1[(1 - 1) + l] = (d5 * ad[(1 - 1) + (2 - 1) * k + j] + (ad[(1 - 1)
						+ (1 - 1) * k + j] - d)
						* ((ad[(1 - 1) + (1 - 1) * k + j] - d2) / d10))
						- d1 * (d3 / d10);
				ad1[(2 - 1) + l] = d5
						* ((ad[(1 - 1) + (1 - 1) * k + j] + ad[(2 - 1)
								+ (2 - 1) * k + j])
								- d - d2);
			}
		} else {
			double d11 = Math.abs(ad[(1 - 1) + (1 - 1) * k + j] - d2)
					+ Math.abs(d3) + Math.abs(ad[(2 - 1) + (1 - 1) * k + j])
					+ Math.abs(ad[(3 - 1) + (1 - 1) * k + j]);
			if (d11 == 0.0D) {
				ad1[(1 - 1) + l] = 0.0D;
				ad1[(2 - 1) + l] = 0.0D;
				ad1[(3 - 1) + l] = 0.0D;
			} else {
				double d6 = ad[(2 - 1) + (1 - 1) * k + j] / d11;
				double d8 = ad[(3 - 1) + (1 - 1) * k + j] / d11;
				ad1[(1 - 1) + l] = ((ad[(1 - 1) + (1 - 1) * k + j] - d)
						* ((ad[(1 - 1) + (1 - 1) * k + j] - d2) / d11) - d1
						* (d3 / d11))
						+ ad[(1 - 1) + (2 - 1) * k + j]
						* d6
						+ ad[(1 - 1) + (3 - 1) * k + j] * d8;
				ad1[(2 - 1) + l] = d6
						* ((ad[(1 - 1) + (1 - 1) * k + j] + ad[(2 - 1)
								+ (2 - 1) * k + j])
								- d - d2) + ad[(2 - 1) + (3 - 1) * k + j] * d8;
				ad1[(3 - 1) + l] = d8
						* ((ad[(1 - 1) + (1 - 1) * k + j] + ad[(3 - 1)
								+ (3 - 1) * k + j])
								- d - d2) + d6 * ad[(3 - 1) + (2 - 1) * k + j];
			}
		}
	}
}
