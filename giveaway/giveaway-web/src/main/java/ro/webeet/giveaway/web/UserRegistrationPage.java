package ro.webeet.giveaway.web;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.bean.validation.PropertyValidator;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.rest.client.UserServiceClient;

public class UserRegistrationPage extends FrontendPage{

	private static final long serialVersionUID = 7258496517338918607L;

	public UserRegistrationPage() {
		super();
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		User user = new User();
		setDefaultModel(new CompoundPropertyModel<User>(user));
		
		final FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackPanel");
		feedbackPanel.setOutputMarkupPlaceholderTag(true);
		add(feedbackPanel);
		
		Form<Void> form = new Form<Void>("form");
		
		form.add(new TextField<String>("name").add(new PropertyValidator<User>()));
		form.add(new EmailTextField("email").add(new PropertyValidator<User>()));
		form.add(new TextField<String>("telephone").add(new PropertyValidator<User>()));
		form.add(new PasswordTextField("password").add(new PropertyValidator<User>()));
		
		form.add(new AjaxSubmitLink("registerBtn"){

			private static final long serialVersionUID = -703183971959136121L;
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final UserServiceClient client = new UserServiceClient(); 
				client.save(user);
				info("Saved successfully");
				target.add(feedbackPanel);
			}
			
			@Override
	        protected void onError(AjaxRequestTarget target, Form<?> form) {
	            // Do nothing (using auto-feedback).
	        }
			
		});
		
		add(form);
		
	}
}
