package ro.webeet.giveaway.backend.page;

import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ro.webeet.giveaway.backend.page.template.BackendPage;

public class SearchUserPage extends BackendPage {

	private static final long serialVersionUID = -6362243320633672947L;

	public SearchUserPage(PageParameters parameters) {
		super(parameters);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
		feedbackPanel.setOutputMarkupPlaceholderTag(true);
		add(feedbackPanel);
	}

}
