package controllers;

import models.District;
import models.State;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import securesocial.core.Identity;
import securesocial.core.java.SecureSocial;
import security.WithAdmin;

public class DistrictController extends Controller {

	
	static Form<District> districtForm = Form.form(District.class);
	
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
			return redirect(routes.DistrictController.districts());
		}
	}
	
	@SecureSocial.SecuredAction( authorization = WithAdmin.class, params = {""})
	public static Result deleteDistrict(Long id) {
		District.delete(id);
		return redirect(routes.DistrictController.districts());
	}

}