package com.sujsun.cms.controllers;

import java.util.*;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sujsun.cms.jdo.Contact;
import com.sujsun.cms.services.ContactService;

@Controller
@RequestMapping( value="services/0.1/contact" )
public class ContactController {
	
	private static final Logger log = Logger.getLogger( ContactController.class.getName() );
	
	@RequestMapping( method=RequestMethod.POST )
	public @ResponseBody Map<String, Object> createContact( @RequestBody Contact contact ) {
		return new ContactService().createContact( contact );
	}
	
	@RequestMapping( method=RequestMethod.GET )
	public @ResponseBody Map<String, Object> getContact( @RequestParam( value = "id" ) String contactId ) {
		return new ContactService().getContact( contactId );
	}
	
	@RequestMapping( method=RequestMethod.PUT )
	public @ResponseBody Map<String, Object> updateContact( @RequestBody Contact contact ) {
		return new ContactService().updateContact( contact );
	}
	
	@RequestMapping( method=RequestMethod.DELETE )
	public @ResponseBody Map<String, Object> deleteContact( @RequestBody Contact contact ) {
		return new ContactService().deleteContact( contact );
	}
	
}
