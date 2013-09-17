package controllers;

import models.Politician;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
  
	static Form<Politician> politicianForm = Form.form(Politician.class);
	
    public static Result index() {
    	return redirect(routes.Application.politicians());
    }
  
    public static Result politicians() {
    	return ok(
    		    views.html.index.render(Politician.all(), politicianForm)
    		  );
      }
      
      public static Result newPolitician() {
    	  Form<Politician> filledForm = politicianForm.bindFromRequest();
    	  if(filledForm.hasErrors()) {
    	    return badRequest(
    	      views.html.index.render(Politician.all(), filledForm)
    	    );
    	  } else {
    	    Politician.create(filledForm.get());
    	    return redirect(routes.Application.politicians());  
    	  }
      }
      
      public static Result deletePolitician(Long id) {
    	  Politician.delete(id);
    	  return redirect(routes.Application.politicians());
      }
}
