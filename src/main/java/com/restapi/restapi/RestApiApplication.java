package com.restapi.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.PrintStream;

@EnableCaching
@SpringBootApplication
public class RestApiApplication {
	public static void main(String[] args) {
		//오버로딩
		Overloading overloading = new Overloading();
		System.out.println(" ==============오버로딩================ ");
		overloading.method();
		System.out.println("오버로딩테스트1" + overloading.method("김영재"));
		System.out.println("오버로딩테스트2 = " + overloading.method(3));
		System.out.println("오버로딩테스트3 = " + overloading.method(3,5));
		System.out.println(" ==================================== ");
		System.out.println(" ==============오버라이딩================ ");
		Override override = new Override();
		Override2 override2 = new Override2();
		override.overrideTest();
		override2.overrideTest();
		System.out.println(" ==================================== ");

		SpringApplication.run(RestApiApplication.class, args);



	}

}

//오버로딩
class Overloading{
	public void method(){
		System.out.println("오버로딩 test1");
	}
	public String method(String name){
		System.out.println("오버로딩 test2");
		return name;
	}
	public Integer method(Integer num1){
		System.out.println("오버로딩 test3");
		return num1;
	}
	public int method(int num1 , int num2){
		System.out.println("오버로딩 test4");
		return num1+num2;
	}
}
//오버라이딩
class Override {
	void overrideTest(){
		System.out.println("오버라이딩 테스트1");
	}
}
class Override2 extends Override{
	@java.lang.Override
	void overrideTest() {
		System.out.println("오버라이딩 테스트2");
	}
}
