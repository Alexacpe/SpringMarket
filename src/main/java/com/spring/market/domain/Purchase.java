package com.spring.market.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Purchase {
    private int purchaseId;
    private String client;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private Optional<List<PurchaseItem>> item;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Optional<List<PurchaseItem>> getItem() {
        return item;
    }

    public void setItem(Optional<List<PurchaseItem>> item) {
        this.item = item;
    }
}
