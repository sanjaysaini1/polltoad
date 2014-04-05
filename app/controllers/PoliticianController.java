package controllers;

import java.text.ParseException;
import java.util.Locale;

import models.Constituency;
import models.PoliticalParty;
import models.Politician;
import play.data.Form;
import play.data.format.Formatters;
import play.mvc.Controller;
import play.mvc.Result;
import securesocial.core.Identity;
import securesocial.core.java.SecureSocial;
import security.WithAdmin;

public class PoliticianController extends Controller {

	static Form<Politician> politicianForm = Form.form(Politician.class);
		
	

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
			return redirect(routes.PoliticianController.politicians());
		}
	}
	 
	public static Result deletePolitician(Long id) {
		Politician.delete(id);
		return redirect(routes.PoliticianController.politicians());
	}

	

}