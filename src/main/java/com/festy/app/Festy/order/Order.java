package com.festy.app.Festy.order;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Order {

    @Id
    private Long id;

    @OneToMany
    private List<OrderItem> orderItems;

    private Date createdDate;

    private Status status;

}
