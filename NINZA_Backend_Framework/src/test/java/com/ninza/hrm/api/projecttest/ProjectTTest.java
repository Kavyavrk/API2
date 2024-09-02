package com.ninza.hrm.api.projecttest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.niza.hrm.api.pojoclasses.ProjectPOJO;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class ProjectTTest
{
	ProjectPOJO pobj;
	@Test
	public void createProject() throws Throwable
	{
		Random r=new Random();
		int ran = r.nextInt(5000);
		String expectedMsg="Successful message";
		String ProjectName="ABC_"+ran;
		
		pobj=new ProjectPOJO(ProjectName,"Created",0,"Deepak");
		
		 Response res = given().contentType(ContentType.JSON).body(pobj)
		.when().post("http://49.249.28.218:8091/addProject");
		res.then()
		.assertThat().statusCode(201)
		.assertThat().time(Matchers.lessThan(3000L))
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		 
		 String actualMsg=res.jsonPath().get("msg");
		 Assert.assertEquals(expectedMsg, actualMsg);
		 
		 Driver driver=new Driver();
		 DriverManager.registerDriver(driver);
		 Connection conn = DriverManager.getConnection("Jdbc:mysql://localhost:3306/project","root","Mummy#143");
		 System.out.println("==Done===");
		 ResultSet result = conn.createStatement().executeQuery("select * from students");
		 while(result.next())
		 {
			 System.out.println(result.getString(1));
		 }
		conn.close(); 
	}
	
	@Test
	public void createDuplicateProject()
	{
		given().contentType(ContentType.JSON).body(pobj)
		.when().post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(409).log().all();
	}
}
