package controllers;

import models.Constituency;
import models.State;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import securesocial.core.Identity;
import securesocial.core.java.SecureSocial;
import security.WithAdmin;

public class ConstituencyController extends Controller {

	static Form<Constituency> constituencyForm = Form.form(Constituency.class);

	
	
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
			return redirect(routes.ConstituencyController.constituencies());
		}
	}
	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {""})
	public static Result deleteConstituency(Long id) {
		Constituency.delete(id);
		return redirect(routes.ConstituencyController.constituencies());
	}

}