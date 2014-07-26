package com.sujsun.cms.controllers;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sujsun.cms.services.ContactService;

@Controller
@RequestMapping( value="contact" )
public class ContactController {
	
	@RequestMapping( method=RequestMethod.POST )
	public @ResponseBody Map<String, Object> createContact( @RequestBody String requestBody ) {
		return new ContactService().createContact( requestBody );
	}
	
	@RequestMapping( method=RequestMethod.GET )
	public @ResponseBody Map<String, Object> getContact( @RequestParam( value = "id" ) String contactId ) {
		return new ContactService().getContact( contactId );
	}
	
	@RequestMapping( method=RequestMethod.PUT )
	public @ResponseBody Map<String, Object> updateContact( @RequestBody String requestBody ) {
		return new ContactService().createContact( requestBody );
	}
	
	@RequestMapping( method=RequestMethod.DELETE )
	public @ResponseBody Map<String, Object> deleteContact( @RequestBody String requestBody ) {
		return new ContactService().createContact( requestBody );
	}
	
}
