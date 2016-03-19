/**
 *
 */
package ro.webeet.giveaway.backend.data.provider;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import ro.webeet.giveaway.persistence.model.User;
import ro.webeet.giveaway.rest.client.UserServiceClient;

/**
 * Data provider responsible for retrieving and sorting user data
 *
 */
public class UserDataProvider extends SortableDataProvider<User, String> {

	private static final long serialVersionUID = -1854741827730363650L;

	UserServiceClient userService = new UserServiceClient();

	public UserDataProvider() {
		setSort(new SortParam<String>("id", false));
	}


	@Override
	public Iterator<? extends User> iterator(long first, long count) {
		return userService.findAll(first, count, getSort().getProperty(), getSort().isAscending()).iterator();
	}

	@Override
	public long size() {
		return userService.count();
	}

	@Override
	public IModel<User> model(User user) {
		return Model.of(user);
	}

}
