package com.splitnice.app.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "expense_d")
public class Expenses {
    @Id
    @GeneratedValue
    private long expense_id;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "lender", referencedColumnName = "user_id")
    private User lender;

    @ManyToOne
    @JoinColumn(name = "borrower", referencedColumnName = "user_id",updatable = false)
    private User borrower;

    private long amount;

    private EXPENSE_STATUS status;

    @UpdateTimestamp
    private Date updated_ts;

    @CreationTimestamp
    private Date created_ts;

}
