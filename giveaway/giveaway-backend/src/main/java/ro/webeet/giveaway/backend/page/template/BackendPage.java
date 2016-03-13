/**
 *
 */
package ro.webeet.giveaway.backend.page.template;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.rest.client.UserServiceClient;

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
	protected void onInitialize() {
		super.onInitialize();
		final UserServiceClient client = new UserServiceClient();
		final User user = client.get(1L);
		final Label userEmailLbl = new Label("userEmailLbl", user.getEmail());
		add(userEmailLbl);
	}

	@Override
	protected void onAfterRender() {
		super.onAfterRender();
	}

}
