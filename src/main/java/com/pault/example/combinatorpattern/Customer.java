package com.pault.example.combinatorpattern;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Customer {
    public String name;
    public String email;
    public String phoneNumber;
    public LocalDate dob;

}
