package com.splitnice.app.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BillDTO {

    private Bill bill;

    private List<Borrower> borrowers;

    private User lender;

    private EXPENSE_STRATEGY split_method;

    private long amount;
}
