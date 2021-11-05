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
    private BigDecimal valueIncome;
    private BigDecimal outcomeValue;
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

    public BigDecimal getValueIncome() {
        return valueIncome;
    }

    public void setValueIncome(BigDecimal valueIncome) {
        this.valueIncome = valueIncome;
    }

    public BigDecimal getOutcomeValue() {
        return outcomeValue;
    }

    public void setOutcomeValue(BigDecimal outcomeValue) {
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

    public UserModel(Integer id, String user, BigDecimal valueIncome, BigDecimal outcomeValue, Float total) {
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