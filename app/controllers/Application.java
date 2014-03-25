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
import securesocial.core.Identity;
import securesocial.core.java.SecureSocial;
import security.WithAdmin;

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
		
		
		Identity user=(Identity)SecureSocial.currentUser();
		System.out.println(user);
		if(user!=null)
		return ok(views.html.admin.politician.render(Politician.all(), Constituency.allMap(),PoliticalParty.allMap(),politicianForm));
		else
			return ok(views.html.politician.render(Politician.all(), Constituency.allMap(),PoliticalParty.allMap(),politicianForm));
	}

	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {})
	public static Result newPolitician() {
		Formatters.register(PoliticalParty.class, new Formatters.SimpleFormatter<PoliticalParty>() {

			@Override
			public PoliticalParty parse(String arg0, Locale arg1)
					throws ParseException {
			
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
			return badRequest(views.html.admin.politician.render(Politician.all(), Constituency.allMap(),PoliticalParty.allMap(),filledForm));
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
		Identity user=(Identity)SecureSocial.currentUser();
		if(user!=null)
		return ok(views.html.admin.state.render(State.all(), stateForm));
		else
			return ok(views.html.state.render(State.all(), stateForm));
	}
	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {""})
	public static Result newState() {
		Form<State> filledForm = stateForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.admin.state.render(State.all(), filledForm));
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
		Identity user=(Identity)SecureSocial.currentUser();
		if(user!=null)
		return ok(views.html.admin.district.render(District.all(), State.allMap(),
				districtForm));
		else
			return ok(views.html.district.render(District.all(), State.allMap(),
					districtForm));
	}
	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {""})
	public static Result newDistrict() {
		Form<District> filledForm = districtForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(

			views.html.admin.district.render(District.all(), State.allMap(),
					filledForm));
		} else {
			//System.out.println(filledForm.get().toString());
			District.create(filledForm.get());
			return redirect(routes.Application.districts());
		}
	}
	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {""})
	public static Result deleteDistrict(Long id) {
		District.delete(id);
		return redirect(routes.Application.districts());
	}

	// political parties
	public static Result politicalparties() {

		Identity user=(Identity)SecureSocial.currentUser();
		if(user!=null)
		return ok(views.html.admin.politicalparty.render(PoliticalParty.all(),
				politicalpartyForm));
		else
			return ok(views.html.politicalparty.render(PoliticalParty.all(),
					politicalpartyForm));
	}
	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {})
	public static Result newPoliticalparty() {
		Form<PoliticalParty> filledForm = politicalpartyForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.admin.politicalparty.render(PoliticalParty.all(), filledForm));
		} else {
			PoliticalParty.create(filledForm.get());
			return redirect(routes.Application.politicalparties());
		}
	}
	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {""})
	public static Result deletePoliticalparty(Long id) {
		PoliticalParty.delete(id);
		return redirect(routes.Application.politicalparties());
	}
	
	//Constituency
	public static Result constituencies() {
		Identity user=(Identity)SecureSocial.currentUser();
		if(user!=null)
		return ok(views.html.admin.constituency.render(Constituency.all(),State.allMap(),constituencyForm));
		else
			return ok(views.html.constituency.render(Constituency.all(),State.allMap(),constituencyForm));
	}
	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {""})
	public static Result newConstituency() {
		Form<Constituency> filledForm = constituencyForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(	views.html.admin.constituency.render(Constituency.all(),State.allMap(), filledForm));
		} else {
			Constituency.create(filledForm.get());
			return redirect(routes.Application.constituencies());
		}
	}
	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {""})
	public static Result deleteConstituency(Long id) {
		Constituency.delete(id);
		return redirect(routes.Application.constituencies());
	}

}