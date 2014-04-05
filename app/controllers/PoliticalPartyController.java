package controllers;

import models.PoliticalParty;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import securesocial.core.Identity;
import securesocial.core.java.SecureSocial;
import security.WithAdmin;

public class PoliticalPartyController extends Controller {

	
	static Form<PoliticalParty> politicalpartyForm = Form.form(PoliticalParty.class);

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
			return redirect(routes.PoliticalPartyController.politicalparties());
		}
	}
	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {""})
	public static Result deletePoliticalparty(Long id) {
		PoliticalParty.delete(id);
		return redirect(routes.PoliticalPartyController.politicalparties());
	}

}