package com.ClarusWay.TDD.Day10;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Token_Asana {
/**------------ 				Authentication 				------------
 Authentication is the process of verifying the identity of a user or application.
 Common methods for authentication include:
 Token-based Authentication: This is a popular method where users or applications receive a token
 (e.g., JWT) after successful login. They then include this token in their requests to access protected
 resources.
 OAuth 2.0: OAuth 2.0 is a framework for securing APIs. It allows users or applications to obtain
 limited access to resources on behalf of the resource owner. Popular implementations include
 OAuth2 with JWT tokens.
 Basic Authentication: This involves sending a username and password with each request.
 It's less secure than token-based methods and is often used with HTTPS for encryption.
 ------------ 				Authorization 				------------
 Authorization controls what authenticated users or applications can do.
 Common methods for authorization include:
 Role-Based Access Control (RBAC): Users are assigned roles (e.g., admin, user), and each role
 has specific permissions. Authorization decisions are based on these roles.
 Attribute-Based Access Control (ABAC): Access decisions are made based on attributes of the user,
 resource, and the environment. It's more fine-grained than RBAC.
 Policy-Based Access Control: Policies are defined to specify who can access what
 resources and under what conditions. Policies are evaluated to make authorization decisions.
 ---------------------             401 vs 403             ---------------------
 HTTP status codes 401 and 403 both indicate authentication or authorization issues
 when a client makes a request to a server, but they have distinct meanings and use cases:
 HTTP Status Code 401 - Unauthorized:
 Meaning: This status code indicates that the request lacks proper authentication credentials,
 or the provided credentials are invalid. It essentially says, "You need to provide valid
 credentials to access this resource."
 Use Cases:
 Typically used when a user or client attempts to access a resource that requires authentication
 (e.g., a protected API endpoint) without providing valid authentication credentials (e.g.,
 username and password, API key, or token).
 Often used in scenarios where authentication is required, but the provided credentials are
 incorrect or missing.
 HTTP Status Code 403 - Forbidden:
 Meaning: This status code indicates that the client's request is understood,
 but the server refuses to fulfill it due to insufficient permissions or authorization,
 even if valid authentication credentials are provided. It essentially says, "You don't have
 permission to access this resource."
 Use Cases:
 Used when a client, even after successful authentication, tries to access a resource they are not
 authorized to access. For example, an authenticated user trying to access an admin-only page or an
 unauthorized API endpoint.
 Can also be used to protect sensitive resources or to indicate that access to a resource is
 restricted by business logic or policy.
 In summary, the key difference between these status codes is that a 401 status code
 indicates an authentication problem (usually due to missing or invalid credentials),
 while a 403 status code indicates an authorization problem (the client has authenticated
 but lacks the necessary permissions to access the resource). Properly distinguishing between
 these status codes helps in providing meaningful feedback to clients and diagnosing access
 issues in your web applications or APIs.
*/

 String token;

    @BeforeClass
    public void setUp(){

        baseURI= "http://app.asana.com";
        token = "Bearer 1/1205499783701562:7c6f411787216d42d8aca04316face52" ;
    }

    @Test
    public void test1(){

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("authorization", token)
                .when()
                .get("/api/1.0/workspaces")
                .then()
                .extract().response();



        response.prettyPeek();


        //401 hatası: token vermediğimiz durumda sistem kim olduğumuzu bilmediği için 401 code döndürüyor.
        //buna da authentication adı verilir.

        //403 hatası: tokeni sisteme verdik fakat bizim yapmak istediğimiz işlem kullandığımız kullanıcının yetkisiniden fazla ise bu kodu verir
        //buna da authorization adı verilir.



    }}

