package life4food.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@RequestMapping("/suggest/{text}")
	public Object suggest(@PathParam("text") String text) {
		return text;
	}
}