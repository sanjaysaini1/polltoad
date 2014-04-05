package controllers;

import models.Constituency;
import models.District;
import models.PoliticalParty;
import models.Politician;
import models.State;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import securesocial.core.Identity;
import securesocial.core.java.SecureSocial;
import security.WithAdmin;

public class StateController extends Controller {

	static Form<State> stateForm = Form.form(State.class);
	

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
			return redirect(routes.StateController.states());
		}
	}

	public static Result deleteState(Long id) {
		State.delete(id);
		return redirect(routes.StateController.states());
	}

	
}