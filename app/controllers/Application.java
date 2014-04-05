package controllers;

import models.Constituency;
import models.District;
import models.PoliticalParty;
import models.Politician;
import models.State;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	
	public static Result index() {
		return redirect(routes.PoliticianController.politicians());
	}
}