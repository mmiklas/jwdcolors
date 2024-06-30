package pl.edu.wszib.jwd.jwdcolors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.util.StringUtils;
import pl.edu.wszib.jwd.jwdcolors.service.SelectedColorService;

@Controller
public class SelectedColorController {

    @Value("${app.title.select}")
    private String title;

    @Autowired
    SelectedColorService selectedColorService;

    @GetMapping({"select", "select/{color}"})
    public String selectColorPage(@PathVariable(required = false) String color, Model model) {

        if (!StringUtils.isEmpty(color)) {
            selectedColorService.save(color);
        }

        String[][] colors = {
                {"red", "blue", "purple", "teal"},
                {"black", "orange", "yellow", "green"},
                {"gray", "silver", "olive", "lime"},
                {"navy", "white", "aqua", "fuchsia"}
        };

        model.addAttribute("colors", colors);
        model.addAttribute("title", title);
        return "select";
    }
}
