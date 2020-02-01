package com.hs.mobile.data.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TestUser {

    @JsonProperty
    private String id;

    @JsonProperty
    private String mobileNumber;

    @JsonProperty
    private String verificationCode;
}
