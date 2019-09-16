import java.util.HashMap;
import java.util.Map;

import models.HeroSQ;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());

        post("/heroes/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String data = request.queryParams("data");
            HeroSQ newHero = new HeroSQ(data);
            return new ModelAndView(model, "execution.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
