package ro.webeet.giveaway.backend.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import ro.webeet.giveaway.backend.component.column.BooleanColumnPanel;
import ro.webeet.giveaway.backend.component.page.navigation.MaterializeNavigationComponent;
import ro.webeet.giveaway.backend.component.repeater.SimpleDataTable;
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
		columns.add(
				new TextFilteredPropertyColumn<User, Panel, String>(Model.of("Is admin?"), "adminFlag", "adminFlag") {

					private static final long serialVersionUID = 8354927377365801732L;

					@Override
					public void populateItem(Item<ICellPopulator<User>> item, String componentId,
							IModel<User> rowModel) {
						final User user = rowModel.getObject();
						item.add(new BooleanColumnPanel(componentId, Model.of(user.getAdminFlag())));
					}

				});

		final SimpleDataTable<User, String> table = new SimpleDataTable<>("datatable",
				columns, userProvider, 2);
		table.setOutputMarkupPlaceholderTag(true);
		// table.addTopToolbar(new HeadersToolbar<String>(table, null));
		add(new MaterializeNavigationComponent("nav", table));

		add(table);
	}

}
