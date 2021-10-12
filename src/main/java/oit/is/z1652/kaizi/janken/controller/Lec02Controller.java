package oit.is.z1652.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1652.kaizi.janken.model.Janken;
//import oit.is.z1652.kaizi.janken.model.Entry.java;

@Controller
public class Lec02Controller {

  @GetMapping("/lec02")
  public String lec02() {
    return "lec02.html";
  }

  /**
   * @param username
   * @param model
   * @return
   */

  @PostMapping("/lec02")
  public String lec02(@RequestParam String username, ModelMap model) {
    model.addAttribute("name", username);
    return "lec02.html";
  }

  /**
   * @param hand
   * @param model
   * @return
   */

  @GetMapping("/lec02janken")
  public String lec02janken(@RequestParam String hand, ModelMap model) {
    Janken result = new Janken(hand);
    model.addAttribute("result", result);
    return "lec02.html";
  }
}
