package com.stackroute.activitystream.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stackroute.activitystream.config.HibernateUtil;
import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.repository.MessageRepository;

/*Annotate the class with @Controller annotation.@Controller annotation is used to mark 
 * any POJO class as a controller so that Spring can recognize this class as a Controller*/
@Controller
public class MessageController {

	/*
	 * From the problem statement, we can understand that the application
	 * requires us to implement two functionalities. They are as following:
	 * 
	 * 1. display the list of existing messages from the database. Each message
	 *    should contain senderName, message, and timestamp 
	 * 2. send a message which should contain the senderName, message, and timestamp.
	 * 
	 */
	
	
	/*Define a handler method to read the existing messages by calling the getAllMessages() method 
	 * of the MessageRepository class and add it to the ModelMap which is an implementation of Map 
	 * for use when building model data for use with views. it should map to the default URL i.e. "/" */
	

	
	
	/*Define a handler method which will read the senderName and message from request parameters and
	 * save the message by calling the sendMessage() method of MessageRepository class. Please note 
	 * that the timestamp should always be auto populated with system time and should not be accepted 
	 * from the user. Also, after saving the message, it should show the same along with existing 
	 * messages. Hence, reading messages has to be done here again and the retrieved messages object 
	 * should be sent back to the view using ModelMap.
	 * This handler method should map to the URL "/sendMessage". 
	*/
	@Autowired
	MessageRepository messageRepository;
	
	@GetMapping("/")
	public String displayAllMessages(ModelMap model)
	{
			
		model.addAttribute("message", new Message());
		model.addAttribute("allMessages", messageRepository.getAllMessages());
		
		
		return "index";
	}
	
	
	
	
	
	
	@PostMapping("/insertMessage")
	public String insertMessage(@Valid @ModelAttribute("message") Message message,BindingResult bindingResult,ModelMap model)
	{
		if(bindingResult.hasErrors())
		{
		  model.addAttribute("allMessages", messageRepository.getAllMessages());
		  return "index";	
		}
		message.setPostedDate();
		messageRepository.sendMessage(message);
		
		return "redirect:/";
	}
	


}
