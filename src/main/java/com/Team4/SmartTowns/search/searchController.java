package com.Team4.SmartTowns.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class searchController {

    @GetMapping("/search")
    public String search(@RequestParam(name = "query", required = false) String query, Model model) {
        model.addAttribute("searchQuery", query);
        // Add search logic here

        return "search_trails"; // name of the Thymeleaf template
    }
}
