package com.iot.controller;

import com.iot.model.Users;
import com.iot.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by xiongxiaoyu on 2017/9/17.
 */

@Controller
public class indexCtro{

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping("/")
    public String index() throws ParseException {
//        Date now = new Date();
//        String begin = new String("2017-9-25 21:25:00");
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            Date begin1 = df.parse(begin);
//            if (now.getTime() > begin1.getTime()) {
//                return "login";
//            }
//            else
//            {
//                return "warning";
//            }

        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model)
            throws ServletException, IOException {
        String name=request.getParameter("Name");
        String number=request.getParameter("Id");
        String phone=request.getParameter("Tel");

        request.getSession().setAttribute("name",name);
        request.getSession().setAttribute("number",number);
        request.getSession().setAttribute("phone",phone);

        model.addAttribute("name",name);
        model.addAttribute("number",number);
        model.addAttribute("phone",phone);
        return "answer";


    }

    @RequestMapping("/add")
    public String add(
    @RequestParam(name = "one")String one, @RequestParam(name = "two")String two, @RequestParam(name = "three")String three,
     @RequestParam(name = "four")String four, @RequestParam(name = "five")String five,@RequestParam(name = "six")String six,
    @RequestParam(name = "seven")String seven,@RequestParam(name = "eight")String eight,@RequestParam(name = "f6")String f6
    ,@RequestParam(name = "nine")String nineb,@RequestParam(name = "ten")String ten,@RequestParam(name = "f1")String f1,
    @RequestParam(name = "f2")String f2,@RequestParam(name = "f3")String f3,@RequestParam(name = "f4")String f4,
    @RequestParam(name = "f5")String f5 ,HttpServletRequest request){
        String number=(String)request.getSession().getAttribute("number");
        String name=(String)request.getSession().getAttribute("name");
        String phone=(String)request.getSession().getAttribute("phone");
        Users users=new Users(name ,number ,phone,one ,two,three,four,five,six,seven,eight,nineb,ten,f1,f2,f3,f4,f6,f5);
        usersRepository.save(users);
        return "redirect:/rejoin";
    }

    @RequestMapping("/rejoin")
    public String rejoin(){return "loading";}

}
