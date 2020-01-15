package org.example.testcases;

import com.github.javafaker.Faker;
import org.example.base.TestBase;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ReqResServiceTest extends TestBase {

    @Test(priority=1)
    public void demoGet() {
       REQUEST
           .queryParam("page", "2")
           .get("/api/users")
           .then()
               .statusCode(200)
               .extract().response().prettyPrint();
    }

    @Test(priority=2)
    public void demoPost() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("name", FAKER.name().firstName());
        jsonBody.put("job", FAKER.job().title());

        REQUEST
            .body(jsonBody)
            .post("/api/users")
            .then()
                .statusCode(201)
                .extract().response().prettyPrint();
    }
}
