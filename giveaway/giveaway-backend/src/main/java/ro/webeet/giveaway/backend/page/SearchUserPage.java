package ro.webeet.giveaway.backend.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ro.webeet.giveaway.backend.data.provider.UserDataProvider;
import ro.webeet.giveaway.backend.page.template.BackendPage;
import ro.webeet.giveaway.persistence.model.User;

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

		final UserDataProvider userProvider = new UserDataProvider();

		final List<IColumn<User, String>> columns = new ArrayList<>();
		columns.add(new PropertyColumn<User, String>(Model.of("Name"), "name", "name"));
		columns.add(new PropertyColumn<User, String>(Model.of("Email"), "email", "email"));

		final AjaxFallbackDefaultDataTable<User, String> table = new AjaxFallbackDefaultDataTable<>("datatable",
				columns, userProvider, 2);
		table.setOutputMarkupPlaceholderTag(true);
		table.addBottomToolbar(new NavigationToolbar(table));

		add(table);
	}

}
