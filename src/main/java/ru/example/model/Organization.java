package ru.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "org")
public class Organization implements Serializable {

    private static final long serialVersionUID = -8095039359436728475L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; //имя заказчика
    private String address; //адрес доставки

    public Organization() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
