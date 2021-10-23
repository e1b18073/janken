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

import oit.is.z1652.kaizi.janken.model.Entry;
import oit.is.z1652.kaizi.janken.model.Janken;
import oit.is.z1652.kaizi.janken.model.Match;
import oit.is.z1652.kaizi.janken.model.MatchMapper;
import oit.is.z1652.kaizi.janken.model.User;
import oit.is.z1652.kaizi.janken.model.UserMapper;

@Controller
public class Lec02Controller {

  @Autowired
  UserMapper userMapper;
  @Autowired
  MatchMapper matchMapper;

  @GetMapping("/lec02")
  @Transactional
  public String lec02(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    User user = new User();
    user.setName(loginUser);
    userMapper.insertUser(user);
    ArrayList<User> u = userMapper.selectAllUsers();
    model.addAttribute("users", u);
    ArrayList<Match> m = matchMapper.selectAllMatches();
    model.addAttribute("matches", m);
    return "lec02.html";
  }

  @GetMapping("/match")
  public String match(@RequestParam Integer id, Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    User user1 = userMapper.selectByName(loginUser);
    User user2 = userMapper.selectById(id);
    model.addAttribute("user1", user1);
    model.addAttribute("user2", user2);
    return "match.html";
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
