package com.lc.rv.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Alexey.Koyro
 */
@Entity
@Table(name = "MENU")
public class Menu extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "ID")
    private Restaurant restaurant;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Menu))
            return false;
        if (!super.equals(o))
            return false;

        Menu menu = (Menu) o;

        if (createdDate != null ? !createdDate.equals(menu.createdDate) : menu.createdDate != null)
            return false;
        if (restaurant != null ? !restaurant.equals(menu.restaurant) : menu.restaurant != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (restaurant != null ? restaurant.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }
}
