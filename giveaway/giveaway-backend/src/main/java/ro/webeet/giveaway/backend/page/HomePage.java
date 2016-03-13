package ro.webeet.giveaway.backend.page;

import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ro.webeet.giveaway.backend.page.template.BackendPage;

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
	}
}
