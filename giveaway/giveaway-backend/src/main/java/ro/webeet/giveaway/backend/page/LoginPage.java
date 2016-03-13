package ro.webeet.giveaway.backend.page;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.bean.validation.PropertyValidator;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import ro.webeet.giveaway.backend.core.WebeetSession;
import ro.webeet.giveaway.backend.page.template.BackendPage;
import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.rest.client.UserServiceClient;

public class LoginPage extends BackendPage {

	private final static Logger logger = LoggerFactory.getLogger(LoginPage.class);

	private static final long serialVersionUID = 7983935190770567201L;

	public LoginPage(PageParameters parameters) {
		super(parameters);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		final User user = new User();
		setDefaultModel(new CompoundPropertyModel<User>(user));

		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
		feedbackPanel.setOutputMarkupPlaceholderTag(true);
		add(feedbackPanel);

		final Form<Void> form = new Form<Void>("form");
		form.add(new EmailTextField("email").add(new PropertyValidator<User>()));
		form.add(new PasswordTextField("password").add(new PropertyValidator<User>()));
		form.add(new AjaxSubmitLink("loginBtn") {

			private static final long serialVersionUID = -1832935833100512272L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final UserServiceClient client = new UserServiceClient();
				try {
					WebeetSession.get().setUser(client.authenticate(user.getEmail(), user.getPassword()));
					setResponsePage(HomePage.class);
				} catch (final HttpClientErrorException e) {
					if (HttpStatus.FORBIDDEN.equals(e.getStatusCode())) {
						error("Invalid username or password");
					} else {
						logger.error("The endpoint might be down. Unable to call the authentication service: {}",
								e.getMessage());
						e.printStackTrace();
					}
				}

				target.add(feedbackPanel);

			}

		});


		add(form);
	}

}
