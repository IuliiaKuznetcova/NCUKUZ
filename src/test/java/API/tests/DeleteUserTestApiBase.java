package API.tests;

import API.dto.ValidUserCredentials;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteUserTestApiBase extends ApiBase {
    String endpoint = "/users/";

    //String email = "carlton.corkery@hotmail.com";
    @BeforeMethod
    public void successfulCreateUserApiAndUi() {
        ValidUserCredentials requestBody = ValidUserCredentials.builder()
                .full_name(fullName)
                .email(email)
                .password("777555")
                .generate_magic_link(false)
                .build();
        postRequest(endpoint, 201, requestBody);
    }

    @Test
    public void successDelete() {
        deleteRequest(endpoint + email, 200);
    }
}

