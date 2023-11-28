package com.Team4.SmartTowns.search.service;

import com.Team4.SmartTowns.search.model.Trail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class searchController {

    private final searchService searchService;

    @Autowired
    public searchController(searchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "query", required = false) String query, Model model) {
        List<Trail> trails = searchService.searchTrails(query);
        model.addAttribute("trails", trails);
        return "search_trails"; // Name of your Thymeleaf template
    }

    // Other methods...
}

