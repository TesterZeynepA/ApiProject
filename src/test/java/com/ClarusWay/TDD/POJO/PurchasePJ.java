package com.ClarusWay.TDD.POJO;

public class PurchasePJ {

    private int id;
    private int petId;
    private int quantity;
    private String status;
    private boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "PurchasePJ{" +
                "id=" + id +
                ", petId=" + petId +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", complete=" + complete +
                '}';
    }
}
