package ro.webeet.giveaway.backend.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ro.webeet.giveaway.backend.core.component.ComponentFactory;
import ro.webeet.giveaway.backend.page.template.BackendPage;
import ro.webeet.giveaway.rest.client.UserServiceClient;

public class HomePage extends BackendPage {

	private static final long serialVersionUID = -5031543042965269269L;

	public HomePage() {
		super();
	}

	public HomePage(PageParameters params) {
		super(params);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
		feedbackPanel.setOutputMarkupPlaceholderTag(true);
		add(feedbackPanel);

		final UserServiceClient userServiceClient = new UserServiceClient();

		add(ComponentFactory.newAjaxLink("searchUsers", target -> setResponsePage(SearchUserPage.class)));
		add(new Label("usersCounted", userServiceClient.count() + " users counted ..."));
	}
}
