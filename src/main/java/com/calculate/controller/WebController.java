package com.calculate.controller;

import com.calculate.calculate.Calculater;
import com.calculate.calculate.FormCalculate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class WebController {

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("FormCalculate", new FormCalculate());
        return "calcForm";
    }

    @PostMapping ("/calculate")
    public String showResult(@ModelAttribute("FormCalculate") @Valid FormCalculate formCalculate, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "calcForm";
        }else {
            Calculater calculater = new Calculater();
            List<String> list= formCalculate.getList(formCalculate.getExpression());

            formCalculate.setExpression("");
            formCalculate.setResult(calculater.calculate(list.listIterator()));
        }

        return "calcForm";
    }
}