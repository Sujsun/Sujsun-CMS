package com.sujsun.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.sujsun.cms.jdo.Contact;
import com.sujsun.cms.services.AuthenticationService;

@Controller
@RequestMapping( value="services/0.1/authenticate" )
public class AuthenticationController {
	
	@RequestMapping( method=RequestMethod.POST )
	public @ResponseBody Contact authenticate( @RequestBody JSONObject requestJSONString ) {
		return new AuthenticationService().authenticate( requestJSONString );
	}
	
}
