package com.bank.kubancredit_tst_evgeniyspivak.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class Task {

    private int id;
    private String title;
    private String description;
    private LocalDateTime get_time;
    private String status;

}
