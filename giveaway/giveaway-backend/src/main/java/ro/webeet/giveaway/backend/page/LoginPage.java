package ro.webeet.giveaway.backend.page;

import org.apache.wicket.bean.validation.PropertyValidator;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import ro.webeet.giveaway.backend.core.WebeetSession;
import ro.webeet.giveaway.backend.core.component.ComponentFactory;
import ro.webeet.giveaway.backend.page.template.BackendPage;
import ro.webeet.giveaway.rest.client.UserServiceClient;
import ro.webeet.giveaway.rest.dto.user.AuthenticationDTO;

public class LoginPage extends BackendPage {

	private final static Logger logger = LoggerFactory.getLogger(LoginPage.class);

	private static final long serialVersionUID = 7983935190770567201L;

	public LoginPage(PageParameters parameters) {
		super(parameters);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		final AuthenticationDTO authenticationDTO = new AuthenticationDTO();
		setDefaultModel(new CompoundPropertyModel<AuthenticationDTO>(authenticationDTO));

		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
		feedbackPanel.setOutputMarkupPlaceholderTag(true);
		add(feedbackPanel);

		final StatelessForm<Void> form = new StatelessForm<Void>("form") {
			private static final long serialVersionUID = -3892480049590342561L;

			@Override
			protected void onError() {
				logger.error("Error in login form.");
				super.onError();
				setResponsePage(getPage().getClass());
			}
		};
		form.add(new EmailTextField("username").add(new PropertyValidator<AuthenticationDTO>()));
		form.add(new PasswordTextField("password").add(new PropertyValidator<AuthenticationDTO>()));
		form.add(ComponentFactory.newAjaxSubmitLink("loginBtn", target -> {
			final UserServiceClient client = new UserServiceClient();
			try {
				WebeetSession.get().setUser(client.authenticate(authenticationDTO));
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
		}));

		add(form);
	}

}
