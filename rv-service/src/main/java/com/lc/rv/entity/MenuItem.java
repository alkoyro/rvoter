package com.lc.rv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Alexey.Koyro
 */
@Entity
@Table(name = "MENU_ITEM")
public class MenuItem extends AbstractEntity {

    @Column(name = "PRICE", columnDefinition = "DECIMAL(4,2)")
    private BigDecimal price;

    @Column(name = "NAME")
    private String name;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
