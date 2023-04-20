package com.br.miura.data.vo.v2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode



public class PersonVOV2 implements Serializable {
    private static final long serialVersionUID = 1L;


    private long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

    private Date birthDay;
}
