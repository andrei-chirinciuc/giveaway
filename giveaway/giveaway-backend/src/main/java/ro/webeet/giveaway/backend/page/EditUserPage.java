package ro.webeet.giveaway.backend.page;

import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.validation.validator.StringValidator;

import ro.webeet.giveaway.backend.core.component.ComponentFactory;
import ro.webeet.giveaway.backend.page.template.BackendPage;
import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.rest.client.UserServiceClient;

public class EditUserPage extends BackendPage {

	private static final long serialVersionUID = -4553317427563392038L;

	public EditUserPage(IModel<User> model) {
		super(model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		final User user = (User) getDefaultModelObject();

		final Label title = new Label("title", user.getId() == null ? "Add user" : "Edit user");
		add(title);

		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
		feedbackPanel.setOutputMarkupPlaceholderTag(true);
		add(feedbackPanel);

		final Form<User> form = new Form<User>("form", new CompoundPropertyModel<>(user)) {
			private static final long serialVersionUID = 7187130138612894201L;

			@Override
			protected void onError() {
				super.onError();
			}
		};

		final TextField<String> name = new TextField<String>("name");
		name.setRequired(true);
		name.add(new StringValidator(3, 30));
		form.add(name);

		final PasswordTextField password = new PasswordTextField("password");
		password.setRequired(true);
		form.add(password);

		final EmailTextField email = new EmailTextField("email");
		email.setRequired(true);
		form.add(email);

		final TextField<String> telephone = new TextField<String>("telephone");
		form.add(telephone);

		final AjaxSubmitLink save = ComponentFactory.newAjaxSubmitLink("save", target -> {
			target.add(feedbackPanel);

			final UserServiceClient client = new UserServiceClient();
			client.save(user);
			setResponsePage(SearchUserPage.class);
		});
		form.add(save);

		form.add(ComponentFactory.newAjaxLink("cancel", target -> setResponsePage(SearchUserPage.class)));

		add(form);
	}

}
