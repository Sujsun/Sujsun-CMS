package com.sujsun.cms.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sujsun.cms.services.SkillService;

@Controller
@RequestMapping( value="skill" )
public class SkillController {
	/*
	@RequestMapping( method=RequestMethod.POST )
	public @ResponseBody Map<String, Object> createContact( @RequestBody String requestBody ) {
		return new SkillService().createSkill( requestBody );
	}
	*/
	@RequestMapping( method=RequestMethod.GET )
	public @ResponseBody Map<String, Object> getContact( @RequestParam( value = "id" ) String contactId ) {
		return new SkillService().getSkill( contactId );
	}
	/*
	@RequestMapping( method=RequestMethod.PUT )
	public @ResponseBody Map<String, Object> updateContact( @RequestBody String requestBody ) {
		return new SkillService().skillContact( requestBody );
	}
	
	@RequestMapping( method=RequestMethod.DELETE )
	public @ResponseBody Map<String, Object> deleteContact( @RequestBody String requestBody ) {
		return new SkillService().deleteSkill( requestBody );
	}
	*/
}
