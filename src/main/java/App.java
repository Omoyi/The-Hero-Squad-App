import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.HeroSQ;
import models.SquadHR;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<HeroSQ> hero = HeroSQ.getAll();
            model.put("hero", hero);
            return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());

        post("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String heroName = request.queryParams("heroName");
          String weakPoint = request.queryParams("weakPoint");
            int heroAge = Integer.parseInt(request.queryParams("heroAge"));
            String knownPower = request.queryParams("knownPower");
            HeroSQ newHero = new HeroSQ(heroName,heroAge,weakPoint,knownPower);
            response.redirect("/index");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "HeroForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            HeroSQ.clear();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: delete an individual task
        get("/heroes/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTaskToDelete = Integer.parseInt(req.params("id"));
            HeroSQ deleteHero = HeroSQ.find(idOfTaskToDelete);
            deleteHero.deleteHero();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTaskToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            HeroSQ foundHero = HeroSQ.find(idOfTaskToFind); //use it to find task
            model.put("hero", foundHero); //add it to model for template to display
            return new ModelAndView(model, "hero-detail.hbs"); //individual task page.
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a task
        get("/heroes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTaskToEdit = Integer.parseInt(req.params("id"));
            HeroSQ editHero = HeroSQ.find(idOfTaskToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process a form to update a task
        post("/heroes/:id", (req, res) -> { //URL to update task on POST route
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("name");
            int newAge=Integer.parseInt(req.queryParams("age"));
            String newSpecialPower = req.queryParams("specialPower");
            String newWeakness=req.queryParams("weakness");
            int idOfTaskToEdit = Integer.parseInt(req.params("id"));
            HeroSQ editHero = HeroSQ.find(idOfTaskToEdit);
            editHero.update(newName,newAge,newSpecialPower,newWeakness);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


        get("/squads/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            SquadHR.clear();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: delete an individual task
        get("/squads/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            SquadHR deleteHero = SquadHR.find(idOfSquadToDelete); //use it to find task
            deleteHero.deleteSquad();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show all tasks
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<SquadHR> squads = SquadHR.getAll();
            model.put("squads", squads);
            return new ModelAndView(model, "mySecond.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show new task form
        get("/squads/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process new task form
        post("/squads", (req, res) -> { //URL to make new task on POST route
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int size=Integer.parseInt(req.queryParams("size"));
            String cause = req.queryParams("cause");

            SquadHR newSquad = new SquadHR(name,cause,size);
            res.redirect("/squad/new");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/squads/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            SquadHR foundSquad = SquadHR.find(idOfSquadToFind); //use it to find task
            model.put("squad", foundSquad); //add it to model for template to display
            return new ModelAndView(model, "squad-detail.hbs"); //individual task page.
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a task
        get("/squads/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToEdit = Integer.parseInt(req.params("id"));
            SquadHR editSquad = SquadHR.find(idOfSquadToEdit);
            model.put("editSquad", editSquad);
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process a form to update a task
        post("/squads/:id", (req, res) -> { //URL to update task on POST route
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("name");
            int newSize=Integer.parseInt(req.queryParams("size"));
            String newCause=req.queryParams("cause");
            int idOfSquadToEdit = Integer.parseInt(req.params("id"));
            SquadHR editSquad = SquadHR.find(idOfSquadToEdit);
            editSquad.update(newName,newCause,newSize);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());






    }
}



