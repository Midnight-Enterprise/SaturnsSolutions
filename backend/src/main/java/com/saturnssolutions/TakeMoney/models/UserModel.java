package com.saturnssolutions.TakeMoney.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "money")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String user;
    private Float valueIncome;
    private Float outcomeValue;
    private Float total;
    private Boolean incomeProperty;

    public Boolean getIncomeProperty() {
        return incomeProperty;
    }

    public void setIncomeProperty(Boolean incomeProperty) {
        this.incomeProperty = incomeProperty;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Float getValueIncome() {
        return valueIncome;
    }

    public void setValueIncome(Float valueIncome) {
        this.valueIncome = valueIncome;
    }

    public Float getOutcomeValue() {
        return outcomeValue;
    }

    public void setOutcomeValue(Float outcomeValue) {
        this.outcomeValue = outcomeValue;
    }

    public Float getTotal() {
        return total;
    }

    public Float setTotal(Float total) {
        this.total = total;
        return total;
    }

    public UserModel() {
    }

    public UserModel(Integer id, String user, Float valueIncome, Float outcomeValue, Float total) {
        this.id = id;
        this.user = user;
        this.valueIncome = valueIncome;
        this.outcomeValue = outcomeValue;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public Integer setId(Integer id) {
        return this.id = id;
    }


//other setters and getters
}