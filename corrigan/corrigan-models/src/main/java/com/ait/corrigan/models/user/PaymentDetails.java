package com.ait.corrigan.models.user;

import java.util.Date;

public class PaymentDetails {
    enum CardType{VISA, VISADEBIT, MASTERCARD}
    private long id;
    private CardType type;
    private String cardNo;
    private Date expireDate;
    private String cvv2;
    private String cardHolder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentDetails that = (PaymentDetails) o;

        if (id != that.id) return false;
        if (type != that.type) return false;
        if (cardNo != null ? !cardNo.equals(that.cardNo) : that.cardNo != null) return false;
        if (expireDate != null ? !expireDate.equals(that.expireDate) : that.expireDate != null) return false;
        if (cvv2 != null ? !cvv2.equals(that.cvv2) : that.cvv2 != null) return false;
        return cardHolder != null ? cardHolder.equals(that.cardHolder) : that.cardHolder == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        result = 31 * result + (cvv2 != null ? cvv2.hashCode() : 0);
        result = 31 * result + (cardHolder != null ? cardHolder.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "id=" + id +
                ", type=" + type +
                ", cardNo='" + cardNo + '\'' +
                ", expireDate=" + expireDate +
                ", cvv2='" + cvv2 + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                '}';
    }
}
