package be.jcrafters.pastebin;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@QuarkusTest
public class DumpRestControllerTest {
    @ParameterizedTest
    @ValueSource(
            strings = {"hello dump"}
    )
    public void dumpEndPointPOST() {
        Dump result = given()
                .when()
                .body("hi")
                .post("/dump")
                .then()
                .statusCode(200)
                .extract().body().as(Dump.class);
        assertThat(result.getDump()).isNotNull();
        assertThat(result.getDump()).isEqualTo("hello dump");
    }
}
