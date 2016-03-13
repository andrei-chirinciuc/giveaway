/**
 *
 */
package ro.webeet.giveaway.backend.page.template;

import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ro.webeet.giveaway.backend.core.WebeetSession;
import ro.webeet.giveaway.backend.core.WicketApplication;
import ro.webeet.giveaway.backend.core.component.ComponentFactory;
import ro.webeet.giveaway.backend.page.LoginPage;

/**
 * Template page for front-end application
 *
 */
public class BackendPage extends WebPage {

	private static final long serialVersionUID = -8237599408890177615L;

	public BackendPage() {
		super();
	}

	public BackendPage(IModel<?> model) {
		super(model);
	}

	public BackendPage(PageParameters parameters) {
		super(parameters);
	}

	@Override
	protected void onConfigure() {
		super.onConfigure();

		if (!(getPage() instanceof LoginPage) && !WebeetSession.get().isSignedIn()) {
			((WicketApplication) getApplication()).restartResponseAtSignInPage();
		}
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();


		final Label userEmailLbl = new Label("userEmailLbl",
				WebeetSession.get().isSignedIn() ? WebeetSession.get().getUser().getEmail() : "");
		userEmailLbl.setVisible(WebeetSession.get().isSignedIn());
		add(userEmailLbl);

		final AjaxFallbackLink<Void> logout = ComponentFactory.newAjaxLink("logout", target -> {
			WebeetSession.get().invalidate();
			setResponsePage(LoginPage.class);
		});
		add(logout);
	}

	@Override
	protected void onAfterRender() {
		super.onAfterRender();
	}

}
