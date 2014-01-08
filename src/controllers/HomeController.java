package controllers;

import javax.validation.Valid;

import model.LolModel;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Secured(value = { "ROLE_ANONYMOUS" })
@Controller
public class HomeController {
	
	@ModelAttribute("model")
	public LolModel getModel() {
		return new LolModel();
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String getMadar(Model model) {
		model.addAttribute("val","bhagat");
		model.addAttribute("name", SecurityContextHolder.getContext().getAuthentication().getName());
		return "test";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.POST)
	public String getMadar(@Valid @ModelAttribute("model") LolModel lol, BindingResult result, Model model) {
		if(result.hasErrors()) {			
			return "test";
		}
		model.addAttribute("val","bhagat");
		return "home";
	}
}
