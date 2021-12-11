package org.netlib.lapack;

import org.netlib.blas.Lsame;
import org.netlib.blas.Dgemm;
import org.netlib.err.Xerbla;
import org.netlib.util.intW;

public final class Dgesdd
{
    public static void dgesdd(String jobz, int m, int n, double a[], int _a_offset, int lda, double s[], int _s_offset, 
            double u[], int _u_offset, int ldu, double vt[], int _vt_offset, int ldvt, double work[], 
            int _work_offset, int lwork, int iwork[], int _iwork_offset, intW info)
    {
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;
        int i3 = 0;
        int l3 = 0;
        intW intw1 = new intW(0);
        int k7 = 0;
        int l7 = 0;
        boolean flag9 = false;
        int k17 = 0;
        int j18 = 0;
        int k18 = 0;
        int i19 = 0;
        double d = 0.0;
        double d1 = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        int[] ai1 = new int[1];
        double[] ad5 = new double[1];
        info.val = 0;
        k18 = Math.min(m, n);
        flag1 = Lsame.lsame(jobz, "A");
        flag5 = Lsame.lsame(jobz, "S");
        flag2 = flag1 || flag5;
        flag4 = Lsame.lsame(jobz, "O");
        flag3 = Lsame.lsame(jobz, "N");
        flag = (lwork == -1);
        if(!(((flag1 || flag5) || flag4) || flag3))
            info.val = -1;
        else
        if(m < 0)
            info.val = -2;
        else
        if(n < 0)
            info.val = -3;
        else
        if(lda < Math.max(1, m))
            info.val = -5;
        else
        if(((ldu < 1) || (flag2 && (ldu < m))) || ((flag4 && (m < n)) && (ldu < m)))
            info.val = -8;
        else
        if((((ldvt < 1) || (flag1 && (ldvt < n))) || (flag5 && (ldvt < k18))) || ((flag4 && (m >= n)) && (ldvt < n)))
            info.val = -10;
        if(info.val == 0)
        {
            int l18 = 1;
            j18 = 1;
            if((m >= n) && (k18 > 0))
            {
                i19 = (int)(((double)k18 * 11.0) / 6.0);
                if(flag3)
                    i3 = 7 * n;
                else
                    i3 = 3 * n * n + 4 * n;
                if(m >= i19)
                {
                    if(flag3)
                    {
                        int l21 = n + n * Ilaenv.ilaenv(1, "DGEQRF", " ", m, n, -1, -1);
                        l21 = Math.max(l21, 3 * n + 2 * n * Ilaenv.ilaenv(1, "DGEBRD", " ", n, n, -1, -1));
                        j18 = Math.max(l21, i3 + n);
                        l18 = i3 + n;
                    } else
                    if(flag4)
                    {
                        int i22 = n + n * Ilaenv.ilaenv(1, "DGEQRF", " ", m, n, -1, -1);
                        i22 = Math.max(i22, n + n * Ilaenv.ilaenv(1, "DORGQR", " ", m, n, n, -1));
                        i22 = Math.max(i22, 3 * n + 2 * n * Ilaenv.ilaenv(1, "DGEBRD", " ", n, n, -1, -1));
                        i22 = Math.max(i22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "QLN", n, n, n, -1));
                        i22 = Math.max(i22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "PRT", n, n, n, -1));
                        i22 = Math.max(i22, i3 + 3 * n);
                        j18 = i22 + 2 * n * n;
                        l18 = i3 + 2 * n * n + 3 * n;
                    } else
                    if(flag5)
                    {
                        int j22 = n + n * Ilaenv.ilaenv(1, "DGEQRF", " ", m, n, -1, -1);
                        j22 = Math.max(j22, n + n * Ilaenv.ilaenv(1, "DORGQR", " ", m, n, n, -1));
                        j22 = Math.max(j22, 3 * n + 2 * n * Ilaenv.ilaenv(1, "DGEBRD", " ", n, n, -1, -1));
                        j22 = Math.max(j22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "QLN", n, n, n, -1));
                        j22 = Math.max(j22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "PRT", n, n, n, -1));
                        j22 = Math.max(j22, i3 + 3 * n);
                        j18 = j22 + n * n;
                        l18 = i3 + n * n + 3 * n;
                    } else
                    if(flag1)
                    {
                        int k22 = n + n * Ilaenv.ilaenv(1, "DGEQRF", " ", m, n, -1, -1);
                        k22 = Math.max(k22, n + m * Ilaenv.ilaenv(1, "DORGQR", " ", m, m, n, -1));
                        k22 = Math.max(k22, 3 * n + 2 * n * Ilaenv.ilaenv(1, "DGEBRD", " ", n, n, -1, -1));
                        k22 = Math.max(k22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "QLN", n, n, n, -1));
                        k22 = Math.max(k22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "PRT", n, n, n, -1));
                        k22 = Math.max(k22, i3 + 3 * n);
                        j18 = k22 + n * n;
                        l18 = i3 + n * n + 3 * n;
                    }
                } else
                {
                    int l22 = 3 * n + (m + n) * Ilaenv.ilaenv(1, "DGEBRD", " ", m, n, -1, -1);
                    if(flag3)
                    {
                        j18 = Math.max(l22, i3 + 3 * n);
                        l18 = 3 * n + Math.max(m, i3);
                    } else
                    if(flag4)
                    {
                        l22 = Math.max(l22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "QLN", m, n, n, -1));
                        l22 = Math.max(l22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "PRT", n, n, n, -1));
                        l22 = Math.max(l22, i3 + 3 * n);
                        j18 = l22 + m * n;
                        l18 = 3 * n + Math.max(m, n * n + i3);
                    } else
                    if(flag5)
                    {
                        l22 = Math.max(l22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "QLN", m, n, n, -1));
                        l22 = Math.max(l22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "PRT", n, n, n, -1));
                        j18 = Math.max(l22, i3 + 3 * n);
                        l18 = 3 * n + Math.max(m, i3);
                    } else
                    if(flag1)
                    {
                        l22 = Math.max(l22, 3 * n + m * Ilaenv.ilaenv(1, "DORMBR", "QLN", m, m, n, -1));
                        l22 = Math.max(l22, 3 * n + n * Ilaenv.ilaenv(1, "DORMBR", "PRT", n, n, n, -1));
                        j18 = Math.max(j18, i3 + 3 * n);
                        l18 = 3 * n + Math.max(m, i3);
                    }
                }
            } else
            if(k18 > 0)
            {
                i19 = (int)(((double)k18 * 11.0) / 6.0);
                if(flag3)
                    i3 = 7 * m;
                else
                    i3 = 3 * m * m + 4 * m;
                if(n >= i19)
                {
                    if(flag3)
                    {
                        int i23 = m + m * Ilaenv.ilaenv(1, "DGELQF", " ", m, n, -1, -1);
                        i23 = Math.max(i23, 3 * m + 2 * m * Ilaenv.ilaenv(1, "DGEBRD", " ", m, m, -1, -1));
                        j18 = Math.max(i23, i3 + m);
                        l18 = i3 + m;
                    } else
                    if(flag4)
                    {
                        int j23 = m + m * Ilaenv.ilaenv(1, "DGELQF", " ", m, n, -1, -1);
                        j23 = Math.max(j23, m + m * Ilaenv.ilaenv(1, "DORGLQ", " ", m, n, m, -1));
                        j23 = Math.max(j23, 3 * m + 2 * m * Ilaenv.ilaenv(1, "DGEBRD", " ", m, m, -1, -1));
                        j23 = Math.max(j23, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "QLN", m, m, m, -1));
                        j23 = Math.max(j23, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "PRT", m, m, m, -1));
                        j23 = Math.max(j23, i3 + 3 * m);
                        j18 = j23 + 2 * m * m;
                        l18 = i3 + 2 * m * m + 3 * m;
                    } else
                    if(flag5)
                    {
                        int k23 = m + m * Ilaenv.ilaenv(1, "DGELQF", " ", m, n, -1, -1);
                        k23 = Math.max(k23, m + m * Ilaenv.ilaenv(1, "DORGLQ", " ", m, n, m, -1));
                        k23 = Math.max(k23, 3 * m + 2 * m * Ilaenv.ilaenv(1, "DGEBRD", " ", m, m, -1, -1));
                        k23 = Math.max(k23, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "QLN", m, m, m, -1));
                        k23 = Math.max(k23, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "PRT", m, m, m, -1));
                        k23 = Math.max(k23, i3 + 3 * m);
                        j18 = k23 + m * m;
                        l18 = i3 + m * m + 3 * m;
                    } else
                    if(flag1)
                    {
                        int l23 = m + m * Ilaenv.ilaenv(1, "DGELQF", " ", m, n, -1, -1);
                        l23 = Math.max(l23, m + n * Ilaenv.ilaenv(1, "DORGLQ", " ", n, n, m, -1));
                        l23 = Math.max(l23, 3 * m + 2 * m * Ilaenv.ilaenv(1, "DGEBRD", " ", m, m, -1, -1));
                        l23 = Math.max(l23, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "QLN", m, m, m, -1));
                        l23 = Math.max(l23, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "PRT", m, m, m, -1));
                        l23 = Math.max(l23, i3 + 3 * m);
                        j18 = l23 + m * m;
                        l18 = i3 + m * m + 3 * m;
                    }
                } else
                {
                    int i24 = 3 * m + (m + n) * Ilaenv.ilaenv(1, "DGEBRD", " ", m, n, -1, -1);
                    if(flag3)
                    {
                        j18 = Math.max(i24, i3 + 3 * m);
                        l18 = 3 * m + Math.max(n, i3);
                    } else
                    if(flag4)
                    {
                        i24 = Math.max(i24, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "QLN", m, m, n, -1));
                        i24 = Math.max(i24, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "PRT", m, n, m, -1));
                        i24 = Math.max(i24, i3 + 3 * m);
                        j18 = i24 + m * n;
                        l18 = 3 * m + Math.max(n, m * m + i3);
                    } else
                    if(flag5)
                    {
                        i24 = Math.max(i24, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "QLN", m, m, n, -1));
                        i24 = Math.max(i24, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "PRT", m, n, m, -1));
                        j18 = Math.max(i24, i3 + 3 * m);
                        l18 = 3 * m + Math.max(n, i3);
                    } else
                    if(flag1)
                    {
                        i24 = Math.max(i24, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "QLN", m, m, n, -1));
                        i24 = Math.max(i24, 3 * m + m * Ilaenv.ilaenv(1, "DORMBR", "PRT", n, n, m, -1));
                        j18 = Math.max(i24, i3 + 3 * m);
                        l18 = 3 * m + Math.max(n, i3);
                    }
                }
            }
            j18 = Math.max(j18, l18);
            work[_work_offset] = j18;
            if (!flag && lwork < l18)
                info.val = -12;
        }
        if(info.val != 0)
        {
            Xerbla.xerbla("DGESDD", -info.val);
            return;
        }
        if (flag)
            return;
        if (m == 0 || n == 0)
            return;
        d2 = Dlamch.dlamch("P"); // XXX
        d3 = Math.sqrt(Dlamch.dlamch("S")) / d2; // XXX
        d1 = 1.0 / d3; // XXX
        d = Dlange.dlange("M", m, n, a, _a_offset, lda, ad5, 0);
        flag9 = false;
        if (d > 0.0 && d < d3)
        {
            flag9 = true;
            Dlascl.dlascl("G", 0, 0, d, d3, m, n, a, _a_offset, lda, intw1);
        } else
        if (d > d1)
        {
            flag9 = true;
            Dlascl.dlascl("G", 0, 0, d, d1, m, n, a, _a_offset, lda, intw1);
        }
        if(m >= n)
        {
            if(m >= i19)
            {
                if(flag3)
                {
                    int i8 = 1;
                    int j19 = i8 + n;
                    Dgeqrf.dgeqrf(m, n, a, _a_offset, lda, work, (i8 - 1) + _work_offset, work, (j19 - 1) + _work_offset, (lwork - j19) + 1, intw1);
                    Dlaset.dlaset("L", n - 1, n - 1, 0.0, 0.0, a, 1 + _a_offset, lda);
                    int i5 = 1;
                    int k12 = i5 + n;
                    int i10 = k12 + n;
                    j19 = i10 + n;
                    Dgebrd.dgebrd(n, n, a, _a_offset, lda, s, _s_offset, work, (i5 - 1) + _work_offset, work, (k12 - 1) + _work_offset, work, (i10 - 1) + _work_offset, work, (j19 - 1) + _work_offset, (lwork - j19) + 1, intw1);
                    j19 = i5 + n;
                    Dbdsdc.dbdsdc("U", "N", n, s, _s_offset, work, (i5 - 1) + _work_offset, ad5, 0, 1, ad5, 0, 1, ad5, 0, ai1, 0, work, (j19 - 1) + _work_offset, iwork, _iwork_offset, info);
                } else
                if(flag4)
                {
                    l7 = 1;
                    if (lwork >= lda * n + n * n + 3 * n + i3)
                        k17 = lda;
                    else
                        k17 = (lwork - n * n - 3 * n - i3) / n;
                    int j8 = l7 + k17 * n;
                    int k19 = j8 + n;
                    Dgeqrf.dgeqrf(m, n, a, _a_offset, lda, work, (j8 - 1) + _work_offset, work, (k19 - 1) + _work_offset, (lwork - k19) + 1, intw1);
                    Dlacpy.dlacpy("U", n, n, a, _a_offset, lda, work, (l7 - 1) + _work_offset, k17);
                    Dlaset.dlaset("L", n - 1, n - 1, 0.0, 0.0, work, l7 + _work_offset, k17);
                    Dorgqr.dorgqr(m, n, n, a, _a_offset, lda, work, (j8 - 1) + _work_offset, work, (k19 - 1) + _work_offset, (lwork - k19) + 1, intw1);
                    int j5 = j8;
                    int l12 = j5 + n;
                    int j10 = l12 + n;
                    k19 = j10 + n;
                    Dgebrd.dgebrd(n, n, work, (l7 - 1) + _work_offset, k17, s, _s_offset, work, (j5 - 1) + _work_offset, work, (l12 - 1) + _work_offset, work, (j10 - 1) + _work_offset, work, (k19 - 1) + _work_offset, (lwork - k19) + 1, intw1);
                    int i15 = k19;
                    k19 = i15 + n * n;
                    Dbdsdc.dbdsdc("U", "I", n, s, _s_offset, work, (j5 - 1) + _work_offset, work, (i15 - 1) + _work_offset, n, vt, _vt_offset, ldvt, ad5, 0, ai1, 0, work, (k19 - 1) + _work_offset, iwork, _iwork_offset, info);
                    Dormbr.dormbr("Q", "L", "N", n, n, n, work, (l7 - 1) + _work_offset, k17, work, (l12 - 1) + _work_offset, work, (i15 - 1) + _work_offset, n, work, (k19 - 1) + _work_offset, (lwork - k19) + 1, intw1);
                    Dormbr.dormbr("P", "R", "T", n, n, n, work, (l7 - 1) + _work_offset, k17, work, (j10 - 1) + _work_offset, vt, _vt_offset, ldvt, work, (k19 - 1) + _work_offset, (lwork - k19) + 1, intw1);
                    int i4 = 1;
                    for (int j24 = ((m - 1) + k17) / k17; j24 > 0; j24--)
                    {
                        l3 = Math.min((m - i4) + 1, k17);
                        Dgemm.dgemm("N", "N", l3, n, n, 1.0, a, (i4 - 1) + _a_offset, lda, work, (i15 - 1) + _work_offset, n, 0.0, work, (l7 - 1) + _work_offset, k17);
                        Dlacpy.dlacpy("F", l3, n, work, (l7 - 1) + _work_offset, k17, a, (i4 - 1) + _a_offset, lda);
                        i4 += k17;
                    }

                } else
                if(flag5)
                {
                    l7 = 1;
                    k17 = n;
                    int k8 = l7 + k17 * n;
                    int l19 = k8 + n;
                    Dgeqrf.dgeqrf(m, n, a, _a_offset, lda, work, (k8 - 1) + _work_offset, work, (l19 - 1) + _work_offset, (lwork - l19) + 1, intw1);
                    Dlacpy.dlacpy("U", n, n, a, _a_offset, lda, work, (l7 - 1) + _work_offset, k17);
                    Dlaset.dlaset("L", n - 1, n - 1, 0.0, 0.0, work, ((l7 + 1) - 1) + _work_offset, k17);
                    Dorgqr.dorgqr(m, n, n, a, _a_offset, lda, work, (k8 - 1) + _work_offset, work, (l19 - 1) + _work_offset, (lwork - l19) + 1, intw1);
                    int k5 = k8;
                    int i13 = k5 + n;
                    int k10 = i13 + n;
                    l19 = k10 + n;
                    Dgebrd.dgebrd(n, n, work, (l7 - 1) + _work_offset, k17, s, _s_offset, work, (k5 - 1) + _work_offset, work, (i13 - 1) + _work_offset, work, (k10 - 1) + _work_offset, work, (l19 - 1) + _work_offset, (lwork - l19) + 1, intw1);
                    Dbdsdc.dbdsdc("U", "I", n, s, _s_offset, work, (k5 - 1) + _work_offset, u, _u_offset, ldu, vt, _vt_offset, ldvt, ad5, 0, ai1, 0, work, (l19 - 1) + _work_offset, iwork, _iwork_offset, info);
                    Dormbr.dormbr("Q", "L", "N", n, n, n, work, (l7 - 1) + _work_offset, k17, work, (i13 - 1) + _work_offset, u, _u_offset, ldu, work, (l19 - 1) + _work_offset, (lwork - l19) + 1, intw1);
                    Dormbr.dormbr("P", "R", "T", n, n, n, work, (l7 - 1) + _work_offset, k17, work, (k10 - 1) + _work_offset, vt, _vt_offset, ldvt, work, (l19 - 1) + _work_offset, (lwork - l19) + 1, intw1);
                    Dlacpy.dlacpy("F", n, n, u, _u_offset, ldu, work, (l7 - 1) + _work_offset, k17);
                    Dgemm.dgemm("N", "N", m, n, n, 1.0, a, _a_offset, lda, work, (l7 - 1) + _work_offset, k17, 0.0, u, _u_offset, ldu);
                } else
                if(flag1)
                {
                    int j15 = 1;
                    int l17 = n;
                    int l8 = j15 + l17 * n;
                    int i20 = l8 + n;
                    Dgeqrf.dgeqrf(m, n, a, _a_offset, lda, work, (l8 - 1) + _work_offset, work, (i20 - 1) + _work_offset, (lwork - i20) + 1, intw1);
                    Dlacpy.dlacpy("L", m, n, a, _a_offset, lda, u, _u_offset, ldu);
                    Dorgqr.dorgqr(m, m, n, u, _u_offset, ldu, work, (l8 - 1) + _work_offset, work, (i20 - 1) + _work_offset, (lwork - i20) + 1, intw1);
                    Dlaset.dlaset("L", n - 1, n - 1, 0.0, 0.0, a, 1 + _a_offset, lda);
                    int l5 = l8;
                    int j13 = l5 + n;
                    int l10 = j13 + n;
                    i20 = l10 + n;
                    Dgebrd.dgebrd(n, n, a, _a_offset, lda, s, _s_offset, work, (l5 - 1) + _work_offset, work, (j13 - 1) + _work_offset, work, (l10 - 1) + _work_offset, work, (i20 - 1) + _work_offset, (lwork - i20) + 1, intw1);
                    Dbdsdc.dbdsdc("U", "I", n, s, _s_offset, work, (l5 - 1) + _work_offset, work, (j15 - 1) + _work_offset, n, vt, _vt_offset, ldvt, ad5, 0, ai1, 0, work, (i20 - 1) + _work_offset, iwork, _iwork_offset, info);
                    Dormbr.dormbr("Q", "L", "N", n, n, n, a, _a_offset, lda, work, (j13 - 1) + _work_offset, work, (j15 - 1) + _work_offset, l17, work, (i20 - 1) + _work_offset, (lwork - i20) + 1, intw1);
                    Dormbr.dormbr("P", "R", "T", n, n, n, a, _a_offset, lda, work, (l10 - 1) + _work_offset, vt, _vt_offset, ldvt, work, (i20 - 1) + _work_offset, (lwork - i20) + 1, intw1);
                    Dgemm.dgemm("N", "N", m, n, n, 1.0, u, _u_offset, ldu, work, (j15 - 1) + _work_offset, l17, 0.0, a, _a_offset, lda);
                    Dlacpy.dlacpy("F", m, n, a, _a_offset, lda, u, _u_offset, ldu);
                }
            } else
            {
                int i6 = 1;
                int k13 = i6 + n;
                int i11 = k13 + n;
                int j20 = i11 + n;
                Dgebrd.dgebrd(m, n, a, _a_offset, lda, s, _s_offset, work, (i6 - 1) + _work_offset, work, (k13 - 1) + _work_offset, work, (i11 - 1) + _work_offset, work, (j20 - 1) + _work_offset, (lwork - j20) + 1, intw1);
                if (flag3)
                    Dbdsdc.dbdsdc("U", "N", n, s, _s_offset, work, (i6 - 1) + _work_offset, ad5, 0, 1, ad5, 0, 1, ad5, 0, ai1, 0, work, (j20 - 1) + _work_offset, iwork, _iwork_offset, info);
                else
                if(flag4)
                {
                    int k15 = j20;
                    int i18;
                    if(lwork >= m * n + 3 * n + i3)
                    {
                        i18 = m;
                        j20 = k15 + i18 * n;
                        Dlaset.dlaset("F", m, n, 0.0, 0.0, work, (k15 - 1) + _work_offset, i18);
                    } else
                    {
                        i18 = n;
                        j20 = k15 + i18 * n;
                        l7 = j20;
                        k17 = (lwork - n * n - 3 * n) / n;
                    }
                    j20 = k15 + i18 * n;
                    Dbdsdc.dbdsdc("U", "I", n, s, _s_offset, work, (i6 - 1) + _work_offset, work, (k15 - 1) + _work_offset, i18, vt, _vt_offset, ldvt, ad5, 0, ai1, 0, work, (j20 - 1) + _work_offset, iwork, _iwork_offset, info);
                    Dormbr.dormbr("P", "R", "T", n, n, n, a, _a_offset, lda, work, (i11 - 1) + _work_offset, vt, _vt_offset, ldvt, work, (j20 - 1) + _work_offset, (lwork - j20) + 1, intw1);
                    if(lwork >= m * n + 3 * n + i3)
                    {
                        Dormbr.dormbr("Q", "L", "N", m, n, n, a, _a_offset, lda, work, (k13 - 1) + _work_offset, work, (k15 - 1) + _work_offset, i18, work, (j20 - 1) + _work_offset, (lwork - j20) + 1, intw1);
                        Dlacpy.dlacpy("F", m, n, work, (k15 - 1) + _work_offset, i18, a, _a_offset, lda);
                    } else
                    {
                        Dorgbr.dorgbr("Q", m, n, n, a, _a_offset, lda, work, (k13 - 1) + _work_offset, work, (j20 - 1) + _work_offset, (lwork - j20) + 1, intw1);
                        int j4 = 1;
                        for (int k24 = (m - 1 + k17) / k17; k24 > 0; k24--)
                        {
                            l3 = Math.min((m - j4) + 1, k17);
                            Dgemm.dgemm("N", "N", l3, n, n, 1.0, a, (j4 - 1) + _a_offset, lda, work, (k15 - 1) + _work_offset, i18, 0.0, work, (l7 - 1) + _work_offset, k17);
                            Dlacpy.dlacpy("F", l3, n, work, (l7 - 1) + _work_offset, k17, a, (j4 - 1) + _a_offset, lda);
                            j4 += k17;
                        }

                    }
                } else
                if(flag5)
                {
                    Dlaset.dlaset("F", m, n, 0.0, 0.0, u, _u_offset, ldu);
                    Dbdsdc.dbdsdc("U", "I", n, s, _s_offset, work, (i6 - 1) + _work_offset, u, _u_offset, ldu, vt, _vt_offset, ldvt, ad5, 0, ai1, 0, work, (j20 - 1) + _work_offset, iwork, _iwork_offset, info);
                    Dormbr.dormbr("Q", "L", "N", m, n, n, a, _a_offset, lda, work, (k13 - 1) + _work_offset, u, _u_offset, ldu, work, (j20 - 1) + _work_offset, (lwork - j20) + 1, intw1);
                    Dormbr.dormbr("P", "R", "T", n, n, n, a, _a_offset, lda, work, (i11 - 1) + _work_offset, vt, _vt_offset, ldvt, work, (j20 - 1) + _work_offset, (lwork - j20) + 1, intw1);
                } else
                if(flag1)
                {
                    Dlaset.dlaset("F", m, m, 0.0, 0.0, u, _u_offset, ldu);
                    Dbdsdc.dbdsdc("U", "I", n, s, _s_offset, work, (i6 - 1) + _work_offset, u, _u_offset, ldu, vt, _vt_offset, ldvt, ad5, 0, ai1, 0, work, (j20 - 1) + _work_offset, iwork, _iwork_offset, info);
                    if(m > n)
                        Dlaset.dlaset("F", m - n, m - n, 0.0, 1.0, u, n + n * ldu + _u_offset, ldu);
                    Dormbr.dormbr("Q", "L", "N", m, m, n, a, _a_offset, lda, work, (k13 - 1) + _work_offset, u, _u_offset, ldu, work, (j20 - 1) + _work_offset, (lwork - j20) + 1, intw1);
                    Dormbr.dormbr("P", "R", "T", n, n, m, a, _a_offset, lda, work, (i11 - 1) + _work_offset, vt, _vt_offset, ldvt, work, (j20 - 1) + _work_offset, (lwork - j20) + 1, intw1);
                }
            }
        } else
        if(n >= i19)
        {
            if(flag3)
            {
                int i9 = 1;
                int k20 = i9 + m;
                Dgelqf.dgelqf(m, n, a, _a_offset, lda, work, (i9 - 1) + _work_offset, work, (k20 - 1) + _work_offset, (lwork - k20) + 1, intw1);
                Dlaset.dlaset("U", m - 1, m - 1, 0.0, 0.0, a, lda + _a_offset, lda);
                int j6 = 1;
                int l13 = j6 + m;
                int j11 = l13 + m;
                k20 = j11 + m;
                Dgebrd.dgebrd(m, m, a, _a_offset, lda, s, _s_offset, work, (j6 - 1) + _work_offset, work, (l13 - 1) + _work_offset, work, (j11 - 1) + _work_offset, work, (k20 - 1) + _work_offset, (lwork - k20) + 1, intw1);
                k20 = j6 + m;
                Dbdsdc.dbdsdc("U", "N", m, s, _s_offset, work, (j6 - 1) + _work_offset, ad5, 0, 1, ad5, 0, 1, ad5, 0, ai1, 0, work, (k20 - 1) + _work_offset, iwork, _iwork_offset, info);
            } else
            if(flag4)
            {
                int l15 = 1;
                k7 = l15 + m * m;
                int i17;
                if(lwork >= m * n + m * m + 3 * m + i3)
                {
                    i17 = m;
                    l3 = n;
                } else
                {
                    i17 = m;
                    l3 = (lwork - m * m) / m;
                }
                int j9 = k7 + i17 * m;
                int l20 = j9 + m;
                Dgelqf.dgelqf(m, n, a, _a_offset, lda, work, (j9 - 1) + _work_offset, work, (l20 - 1) + _work_offset, (lwork - l20) + 1, intw1);
                Dlacpy.dlacpy("L", m, m, a, _a_offset, lda, work, (k7 - 1) + _work_offset, i17);
                Dlaset.dlaset("U", m - 1, m - 1, 0.0, 0.0, work, ((k7 + i17) - 1) + _work_offset, i17);
                Dorglq.dorglq(m, n, m, a, _a_offset, lda, work, (j9 - 1) + _work_offset, work, (l20 - 1) + _work_offset, (lwork - l20) + 1, intw1);
                int k6 = j9;
                int i14 = k6 + m;
                int k11 = i14 + m;
                l20 = k11 + m;
                Dgebrd.dgebrd(m, m, work, (k7 - 1) + _work_offset, i17, s, _s_offset, work, (k6 - 1) + _work_offset, work, (i14 - 1) + _work_offset, work, (k11 - 1) + _work_offset, work, (l20 - 1) + _work_offset, (lwork - l20) + 1, intw1);
                Dbdsdc.dbdsdc("U", "I", m, s, _s_offset, work, (k6 - 1) + _work_offset, u, _u_offset, ldu, work, (l15 - 1) + _work_offset, m, ad5, 0, ai1, 0, work, (l20 - 1) + _work_offset, iwork, _iwork_offset, info);
                Dormbr.dormbr("Q", "L", "N", m, m, m, work, (k7 - 1) + _work_offset, i17, work, (i14 - 1) + _work_offset, u, _u_offset, ldu, work, (l20 - 1) + _work_offset, (lwork - l20) + 1, intw1);
                Dormbr.dormbr("P", "R", "T", m, m, m, work, (k7 - 1) + _work_offset, i17, work, (k11 - 1) + _work_offset, work, (l15 - 1) + _work_offset, m, work, (l20 - 1) + _work_offset, (lwork - l20) + 1, intw1);
                int k4 = 1;
                for (int l24 = ((n - 1) + l3) / l3; l24 > 0; l24--)
                {
                    int j3 = Math.min((n - k4) + 1, l3);
                    Dgemm.dgemm("N", "N", m, j3, m, 1.0, work, (l15 - 1) + _work_offset, m, a, (k4 - 1) * lda + _a_offset, lda, 0.0, work, (k7 - 1) + _work_offset, i17);
                    Dlacpy.dlacpy("F", m, j3, work, (k7 - 1) + _work_offset, i17, a, (k4 - 1) * lda + _a_offset, lda);
                    k4 += l3;
                }

            } else
            if(flag5)
            {
                k7 = 1;
                int j17 = m;
                int k9 = k7 + j17 * m;
                int i21 = k9 + m;
                Dgelqf.dgelqf(m, n, a, _a_offset, lda, work, (k9 - 1) + _work_offset, work, (i21 - 1) + _work_offset, (lwork - i21) + 1, intw1);
                Dlacpy.dlacpy("L", m, m, a, _a_offset, lda, work, (k7 - 1) + _work_offset, j17);
                Dlaset.dlaset("U", m - 1, m - 1, 0.0, 0.0, work, ((k7 + j17) - 1) + _work_offset, j17);
                Dorglq.dorglq(m, n, m, a, _a_offset, lda, work, (k9 - 1) + _work_offset, work, (i21 - 1) + _work_offset, (lwork - i21) + 1, intw1);
                int l6 = k9;
                int j14 = l6 + m;
                int l11 = j14 + m;
                i21 = l11 + m;
                Dgebrd.dgebrd(m, m, work, (k7 - 1) + _work_offset, j17, s, _s_offset, work, (l6 - 1) + _work_offset, work, (j14 - 1) + _work_offset, work, (l11 - 1) + _work_offset, work, (i21 - 1) + _work_offset, (lwork - i21) + 1, intw1);
                Dbdsdc.dbdsdc("U", "I", m, s, _s_offset, work, (l6 - 1) + _work_offset, u, _u_offset, ldu, vt, _vt_offset, ldvt, ad5, 0, ai1, 0, work, (i21 - 1) + _work_offset, iwork, _iwork_offset, info);
                Dormbr.dormbr("Q", "L", "N", m, m, m, work, (k7 - 1) + _work_offset, j17, work, (j14 - 1) + _work_offset, u, _u_offset, ldu, work, (i21 - 1) + _work_offset, (lwork - i21) + 1, intw1);
                Dormbr.dormbr("P", "R", "T", m, m, m, work, (k7 - 1) + _work_offset, j17, work, (l11 - 1) + _work_offset, vt, _vt_offset, ldvt, work, (i21 - 1) + _work_offset, (lwork - i21) + 1, intw1);
                Dlacpy.dlacpy("F", m, m, vt, _vt_offset, ldvt, work, (k7 - 1) + _work_offset, j17);
                Dgemm.dgemm("N", "N", m, n, m, 1.0, work, (k7 - 1) + _work_offset, j17, a, _a_offset, lda, 0.0, vt, _vt_offset, ldvt);
            } else
            if(flag1)
            {
                int i16 = 1;
                int k16 = m;
                int l9 = i16 + k16 * m;
                int j21 = l9 + m;
                Dgelqf.dgelqf(m, n, a, _a_offset, lda, work, (l9 - 1) + _work_offset, work, (j21 - 1) + _work_offset, (lwork - j21) + 1, intw1);
                Dlacpy.dlacpy("U", m, n, a, _a_offset, lda, vt, _vt_offset, ldvt);
                Dorglq.dorglq(n, n, m, vt, _vt_offset, ldvt, work, (l9 - 1) + _work_offset, work, (j21 - 1) + _work_offset, (lwork - j21) + 1, intw1);
                Dlaset.dlaset("U", m - 1, m - 1, 0.0, 0.0, a, lda + _a_offset, lda);
                int i7 = l9;
                int k14 = i7 + m;
                int i12 = k14 + m;
                j21 = i12 + m;
                Dgebrd.dgebrd(m, m, a, _a_offset, lda, s, _s_offset, work, (i7 - 1) + _work_offset, work, (k14 - 1) + _work_offset, work, (i12 - 1) + _work_offset, work, (j21 - 1) + _work_offset, (lwork - j21) + 1, intw1);
                Dbdsdc.dbdsdc("U", "I", m, s, _s_offset, work, (i7 - 1) + _work_offset, u, _u_offset, ldu, work, (i16 - 1) + _work_offset, k16, ad5, 0, ai1, 0, work, (j21 - 1) + _work_offset, iwork, _iwork_offset, info);
                Dormbr.dormbr("Q", "L", "N", m, m, m, a, _a_offset, lda, work, (k14 - 1) + _work_offset, u, _u_offset, ldu, work, (j21 - 1) + _work_offset, (lwork - j21) + 1, intw1);
                Dormbr.dormbr("P", "R", "T", m, m, m, a, _a_offset, lda, work, (i12 - 1) + _work_offset, work, (i16 - 1) + _work_offset, k16, work, (j21 - 1) + _work_offset, (lwork - j21) + 1, intw1);
                Dgemm.dgemm("N", "N", m, n, m, 1.0, work, (i16 - 1) + _work_offset, k16, vt, _vt_offset, ldvt, 0.0, a, _a_offset, lda);
                Dlacpy.dlacpy("F", m, n, a, _a_offset, lda, vt, _vt_offset, ldvt);
            }
        } else
        {
            int j7 = 1;
            int l14 = j7 + m;
            int j12 = l14 + m;
            int k21 = j12 + m;
            Dgebrd.dgebrd(m, n, a, _a_offset, lda, s, _s_offset, work, (j7 - 1) + _work_offset, work, (l14 - 1) + _work_offset, work, (j12 - 1) + _work_offset, work, (k21 - 1) + _work_offset, (lwork - k21) + 1, intw1);
            if(flag3)
                Dbdsdc.dbdsdc("L", "N", m, s, _s_offset, work, (j7 - 1) + _work_offset, ad5, 0, 1, ad5, 0, 1, ad5, 0, ai1, 0, work, (k21 - 1) + _work_offset, iwork, _iwork_offset, info);
            else
            if(flag4)
            {
                int l16 = m;
                int j16 = k21;
                if(lwork >= m * n + 3 * m + i3)
                {
                    Dlaset.dlaset("F", m, n, 0.0, 0.0, work, (j16 - 1) + _work_offset, l16);
                    k21 = j16 + l16 * n;
                } else
                {
                    k21 = j16 + l16 * m;
                    k7 = k21;
                    l3 = (lwork - m * m - 3 * m) / m;
                }
                Dbdsdc.dbdsdc("L", "I", m, s, _s_offset, work, (j7 - 1) + _work_offset, u, _u_offset, ldu, work, (j16 - 1) + _work_offset, l16, ad5, 0, ai1, 0, work, (k21 - 1) + _work_offset, iwork, _iwork_offset, info);
                Dormbr.dormbr("Q", "L", "N", m, m, n, a, _a_offset, lda, work, (l14 - 1) + _work_offset, u, _u_offset, ldu, work, (k21 - 1) + _work_offset, (lwork - k21) + 1, intw1);
                if (lwork >= m * n + 3 * m + i3)
                {
                    Dormbr.dormbr("P", "R", "T", m, n, m, a, _a_offset, lda, work, (j12 - 1) + _work_offset, work, (j16 - 1) + _work_offset, l16, work, (k21 - 1) + _work_offset, (lwork - k21) + 1, intw1);
                    Dlacpy.dlacpy("F", m, n, work, (j16 - 1) + _work_offset, l16, a, _a_offset, lda);
                } else
                {
                    Dorgbr.dorgbr("P", m, n, m, a, _a_offset, lda, work, (j12 - 1) + _work_offset, work, (k21 - 1) + _work_offset, (lwork - k21) + 1, intw1);
                    int l4 = 1;
                    for (int i25 = ((n - 1) + l3) / l3; i25 > 0; i25--)
                    {
                        int k3 = Math.min((n - l4) + 1, l3);
                        Dgemm.dgemm("N", "N", m, k3, m, 1.0, work, (j16 - 1) + _work_offset, l16, a, (l4 - 1) * lda + _a_offset, lda, 0.0, work, (k7 - 1) + _work_offset, m);
                        Dlacpy.dlacpy("F", m, k3, work, (k7 - 1) + _work_offset, m, a, (l4 - 1) * lda + _a_offset, lda);
                        l4 += l3;
                    }

                }
            } else
            if (flag5)
            {
                Dlaset.dlaset("F", m, n, 0.0, 0.0, vt, _vt_offset, ldvt);
                Dbdsdc.dbdsdc("L", "I", m, s, _s_offset, work, (j7 - 1) + _work_offset, u, _u_offset, ldu, vt, _vt_offset, ldvt, ad5, 0, ai1, 0, work, (k21 - 1) + _work_offset, iwork, _iwork_offset, info);
                Dormbr.dormbr("Q", "L", "N", m, m, n, a, _a_offset, lda, work, (l14 - 1) + _work_offset, u, _u_offset, ldu, work, (k21 - 1) + _work_offset, (lwork - k21) + 1, intw1);
                Dormbr.dormbr("P", "R", "T", m, n, m, a, _a_offset, lda, work, (j12 - 1) + _work_offset, vt, _vt_offset, ldvt, work, (k21 - 1) + _work_offset, (lwork - k21) + 1, intw1);
            } else
            if (flag1)
            {
                Dlaset.dlaset("F", n, n, 0.0, 0.0, vt, _vt_offset, ldvt);
                Dbdsdc.dbdsdc("L", "I", m, s, _s_offset, work, (j7 - 1) + _work_offset, u, _u_offset, ldu, vt, _vt_offset, ldvt, ad5, 0, ai1, 0, work, (k21 - 1) + _work_offset, iwork, _iwork_offset, info);
                if (n > m)
                    Dlaset.dlaset("F", n - m, n - m, 0.0, 1.0, vt, m + m * ldvt + _vt_offset, ldvt);
                Dormbr.dormbr("Q", "L", "N", m, m, n, a, _a_offset, lda, work, (l14 - 1) + _work_offset, u, _u_offset, ldu, work, (k21 - 1) + _work_offset, (lwork - k21) + 1, intw1);
                Dormbr.dormbr("P", "R", "T", n, n, m, a, _a_offset, lda, work, (j12 - 1) + _work_offset, vt, _vt_offset, ldvt, work, (k21 - 1) + _work_offset, (lwork - k21) + 1, intw1);
            }
        }
        if (flag9)
        {
            if (d > d1)
                Dlascl.dlascl("G", 0, 0, d1, d, k18, 1, s, _s_offset, k18, intw1);
            if (d < d3)
                Dlascl.dlascl("G", 0, 0, d3, d, k18, 1, s, _s_offset, k18, intw1);
        }
        work[_work_offset] = j18;
    }
}
