package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static String BASE_URL = "https://reqres.in";
    public static final String DIR = System.getProperty("user.dir");
    public static String REQ_BODY_DIR = DIR+"/src/test/resources/JSON/ReqBody/";
    public static String JSON_SCHEMA_DIR = DIR+"/src/test/resources/JSON/JSONSchema/";

    public static String GET_LIST_USERS = BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = BASE_URL+"/api/users";

    @Step("Get lists user with valid parameter page")
    public void getListUsersValidParamPage(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
