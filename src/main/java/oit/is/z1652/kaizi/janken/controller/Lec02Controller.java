package oit.is.z1652.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z1652.kaizi.janken.model.*;

@Controller
public class Lec02Controller {

  @Autowired
  UserMapper userMapper;

  @GetMapping("/lec02")
  @Transactional
  public String lec02(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    User user = new User();
    user.setName(loginUser);
    userMapper.insertUser(user);
    ArrayList<User> users = userMapper.selectAllUsers();
    model.addAttribute("users", users);
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
