package com.javastudio.shiro.model;

import java.util.Date;

/**
 * Pay Stub
 */
public class Payslip {

    /**
     * Gross Earning
     */
    private Long gross;
    private Long net;
    private Long tax;

    /**
     * Basic Salary
     */
    private Long basic;

    private Date effectiveDate;

    // Deductions

    /**
     * provident fund
     */
    private Long providentFund;


    public Long getGross() {
        return gross;
    }

    public void setGross(Long gross) {
        this.gross = gross;
    }

    public Long getNet() {
        return net;
    }

    public void setNet(Long net) {
        this.net = net;
    }

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
    }

    public Long getBasic() {
        return basic;
    }

    public void setBasic(Long basic) {
        this.basic = basic;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Long getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(Long providentFund) {
        this.providentFund = providentFund;
    }
}
