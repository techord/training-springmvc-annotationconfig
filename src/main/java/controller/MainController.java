package controller;

import java.util.List;
import java.util.Map;
//import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Student;
import service.SomeService;

@Controller
public class MainController {

	@Autowired
	private SomeService someService;
	
	//use injected service
	@RequestMapping("some")
	public @ResponseBody String some()
	{
		return someService.hello("XD");
	}
	
	//query with a query parameter
	//curl localhost:8080/training-springmvc-annotationconfig/hello?user=john
	//hello john
	@RequestMapping("hello")
	public @ResponseBody String hello(@RequestParam("user") String user) {
		return "hello " + user;
	}
	
	
	//form post
	//Content-Type: application/x-www-form-urlencoded
	//curl localhost:8080/training-springmvc-annotationconfig/formpost -d 'name=john&age=1'
	//{"name":"john","age":1}
	@RequestMapping(value="formpost", method = RequestMethod.POST)
	public @ResponseBody Student post1(Student student)
	{	
		return student;
	}
	
	//json post
	//curl localhost:8080/training-springmvc-annotationconfig/jsonpost -d '{"name":"john","age":1}' -H 'content-type:application/json'
	//{"name":"john","age":1}
	@RequestMapping(value="jsonpost", method = RequestMethod.POST)
	public @ResponseBody Student post11(@RequestBody Student student)
	{	
		return student;
	}
	
	//JSON array post
	//curl localhost:8080/training-springmvc-annotationconfig/jsonspost -d '[{"name":"john","age":22},{"name":"ann","age":18}]' -H 'content-type:application/json'
	//[{"name":"john","age":22},{"name":"john","age":222}]	
	@RequestMapping(value="jsonspost", method = RequestMethod.POST)
	public @ResponseBody List<Student> post111(@RequestBody List<Student> students)
	{	
		return students;
	}
	
	//form post and parse keyValue pairs to Map
	//curl localhost:8080/training-springmvc-annotationconfig/mappost -d 'a=1&b=2'
	//a:1,b:2
	@RequestMapping(value="mappost", method = RequestMethod.POST)
	public @ResponseBody String post2(@RequestParam Map<String, String> map)
	{
		/*
		String a = "";
		for(Entry<String, String> x : map.entrySet())
		{
			a = a + "," + x.getKey() + ":" + x.getValue();
		}
		return a;
		*/
		return map.get("a");	
	}
	
}