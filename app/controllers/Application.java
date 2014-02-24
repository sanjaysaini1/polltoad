package controllers;

import java.text.ParseException;
import java.util.Locale;

import models.Constituency;
import models.District;
import models.PoliticalParty;
import models.Politician;
import models.State;
import play.data.Form;
import play.data.format.Formatters;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	static Form<Politician> politicianForm = Form.form(Politician.class);
	static Form<State> stateForm = Form.form(State.class);
	static Form<District> districtForm = Form.form(District.class);
	static Form<PoliticalParty> politicalpartyForm = Form.form(PoliticalParty.class);
	static Form<Constituency> constituencyForm = Form.form(Constituency.class);
	
	public static Result index() {
		return redirect(routes.Application.politicians());
	}

	// politician
	public static Result politicians() {
		
		return ok(views.html.politician.render(Politician.all(), Constituency.allMap(),PoliticalParty.allMap(),politicianForm));
	}

	public static Result newPolitician() {
		Formatters.register(PoliticalParty.class, new Formatters.SimpleFormatter<PoliticalParty>() {

			@Override
			public PoliticalParty parse(String arg0, Locale arg1)
					throws ParseException {
				// TODO Auto-generated method stub
				PoliticalParty currentpoliticalParty=PoliticalParty.find.byId(new Long(arg0));
				
				return currentpoliticalParty;
			}

			@Override
			public String print(PoliticalParty politicalParty, Locale arg1) {
				// TODO Auto-generated method stub
				return politicalParty.politicalPartyId.toString();
			}
		});
		
		
		Form<Politician> filledForm = politicianForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.politician.render(Politician.all(), Constituency.allMap(),PoliticalParty.allMap(),filledForm));
		} else {
			Politician.create(filledForm.get());
			return redirect(routes.Application.politicians());
		}
	}

	public static Result deletePolitician(Long id) {
		Politician.delete(id);
		return redirect(routes.Application.politicians());
	}

	// states

	public static Result states() {
		return ok(views.html.state.render(State.all(), stateForm));
	}

	public static Result newState() {
		Form<State> filledForm = stateForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.state.render(State.all(), filledForm));
		} else {
			State.create(filledForm.get());
			return redirect(routes.Application.states());
		}
	}

	public static Result deleteState(Long id) {
		State.delete(id);
		return redirect(routes.Application.states());
	}

	// districts
	public static Result districts() {
		return ok(views.html.district.render(District.all(), State.allMap(),
				districtForm));
	}

	public static Result newDistrict() {
		Form<District> filledForm = districtForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			// System.out.println("Bad request"+
			// filledForm.errorsAsJson().toString());
			//System.out.println("Bad request"+ filledForm.errorsAsJson().toString());
			return badRequest(

			views.html.district.render(District.all(), State.allMap(),
					filledForm));
		} else {
			//System.out.println(filledForm.get().toString());
			District.create(filledForm.get());
			return redirect(routes.Application.districts());
		}
	}

	public static Result deleteDistrict(Long id) {
		District.delete(id);
		return redirect(routes.Application.districts());
	}

	// political parties

	public static Result politicalparties() {
		return ok(views.html.politicalparty.render(PoliticalParty.all(),
				politicalpartyForm));
	}

	public static Result newPoliticalparty() {
		Form<PoliticalParty> filledForm = politicalpartyForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			// System.out.println("Bad request"+
			// filledForm.errorsAsJson().toString());
			//System.out.println("Bad request"+ filledForm.errorsAsJson().toString());
			return badRequest(

			views.html.politicalparty.render(PoliticalParty.all(), filledForm));
		} else {
			//System.out.println(filledForm.get().toString());
			PoliticalParty.create(filledForm.get());
			return redirect(routes.Application.politicalparties());
		}
	}

	public static Result deletePoliticalparty(Long id) {
		PoliticalParty.delete(id);
		return redirect(routes.Application.politicalparties());
	}
	
	//Constituency
	
	public static Result constituencies() {
		return ok(views.html.constituency.render(Constituency.all(),State.allMap(),constituencyForm));
	}

	public static Result newConstituency() {
		Form<Constituency> filledForm = constituencyForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			// System.out.println("Bad request"+
			// filledForm.errorsAsJson().toString());
			//System.out.println("Bad request"+ filledForm.errorsAsJson().toString());
			return badRequest(

			views.html.constituency.render(Constituency.all(),State.allMap(), filledForm));
		} else {
			//System.out.println(filledForm.get().toString());
			Constituency.create(filledForm.get());
			return redirect(routes.Application.constituencies());
		}
	}

	public static Result deleteConstituency(Long id) {
		Constituency.delete(id);
		return redirect(routes.Application.constituencies());
	}
}
