package com.Team4.SmartTowns.profile.model;
import com.Team4.SmartTowns.checkpoints.model.Checkpoint;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
public class Profile {
    private String userName;
//    private String password;
    private String email;
    private String address;
    private String address2;
    private String city;
    private String zipCode;

    private List<Checkpoint> checkpoints;

//    public RegistrationForm(String userName, String email, String address, String address2, String city, String zipCode) {
//        this.userName = userName;
//        this.email = email;
//        this.address = address;
//        this.address2 = address2;
//        this.city = city;
//        this.zipCode = zipCode;
//    }
    public Profile(){
        this.userName = "";
//        this.password = "";
        this.email = "";
        this.address = "";
        this.address2 = "";
        this.city = "";
        this.zipCode = "";
        this.checkpoints = new ArrayList<>();
    }
}
