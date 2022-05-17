package com.queueup.qup.dto;

/*
import com.queueup.qup.enums.GenderStatus;
*/
import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private String gender;
    private String role;
    private boolean enable;
   /* public void setEnable(boolean b) {
    }*/
}
