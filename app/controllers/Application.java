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

	static Form<Politician> politicianForm = Form.form(Politician.class);
	static Form<State> stateForm = Form.form(State.class);
	static Form<District> districtForm = Form.form(District.class);
	static Form<PoliticalParty> politicalpartyForm = Form.form(PoliticalParty.class);
	static Form<Constituency> constituencyForm = Form.form(Constituency.class);

	
	public static Result index() {
		return redirect(routes.PoliticianController.politicians());
	}
}