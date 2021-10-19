package reqres;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ApiTestExamples {

    @Test
    void chekLastNameInData() {
        String response = get("https://reqres.in/api/users?page=2")
                .then()
                .extract().path("data[2].last_name");
        assertThat(response).isEqualTo("Funke");
    }

    @Test
    void chekDataId() {
        Integer response = get("https://reqres.in/api/users?page=2")
                .then()
                .extract().path("data[4].id");
        assertThat(response).isEqualTo(11);
    }

    @Test
    void countPerPage() {
        Integer response = get("https://reqres.in/api/users?page=2")
                .then()
                .extract().path("per_page");
        assertThat(response).isEqualTo(6);

    }

    @Test
    void statusCode() {
        get("https://reqres.in/api/users?page=2")
                .then()
                .extract().path("per_page");
        

    }
}
