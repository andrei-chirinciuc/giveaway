package ro.webeet.giveaway.backend.component.page.navigation;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigation;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationIncrementLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigationLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPageableItems;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;

public class MaterializeNavigationComponent extends AjaxPagingNavigator {

	private static final long serialVersionUID = -1649030479350975236L;

	public MaterializeNavigationComponent(String id, IPageableItems pageable) {
		super(id, pageable);
	}

	public void setCurrentPage(long page) {
		getPageable().setCurrentPage(page);
	}

	public long getCurrentPage() {
		return getPageable().getCurrentPage();
	}

	// Link for: "1 | 2 | 3 | 4"
	@Override
	protected PagingNavigation newNavigation(String id, IPageable pageable, IPagingLabelProvider labelProvider) {
		return new AjaxPagingNavigation(id, pageable, labelProvider) {
			private static final long serialVersionUID = 9131035346487167071L;

			@Override
			protected LoopItem newItem(int iteration) {
				final LoopItem item = super.newItem(iteration);

				// add css for enable/disable link
				final long pageIndex = getStartIndex() + iteration;
				item.add(new AttributeModifier("class", new PageLinkCssModel(pageable, pageIndex, "active")));

				return item;
			}
		};
	}

	// Link for: first,last
	@Override
	protected AbstractLink newPagingNavigationLink(String id, IPageable pageable, int pageNumber) {
		final ExternalLink navCont = new ExternalLink(id + "Cont", (String) null);

		// add css for enable/disable link
		final long pageIndex = pageable.getCurrentPage() + pageNumber;
		navCont.add(new AttributeModifier("class", new PageLinkCssModel(pageable, pageIndex, "disabled")));

		// change original wicket-link, so that it always generates href
		navCont.add(new AjaxPagingNavigationLink(id, pageable, pageNumber) {
			private static final long serialVersionUID = 542327054785166714L;

			@Override
			protected void disableLink(ComponentTag tag) {
			}
		});
		return navCont;
	}

	// Link for: prev,next
	@Override
	protected AbstractLink newPagingNavigationIncrementLink(String id, IPageable pageable, int increment) {
		final ExternalLink navCont = new ExternalLink(id + "Cont", (String) null);

		// add css for enable/disable link
		final long pageIndex = pageable.getCurrentPage() + increment;
		navCont.add(new AttributeModifier("class", new NavigationIncrementLinkCssModel(pageable, pageIndex)));

		// change original wicket-link, so that it always generates href
		navCont.add(new AjaxPagingNavigationIncrementLink(id, pageable, increment) {
			private static final long serialVersionUID = -8544083867148259811L;

			@Override
			protected void disableLink(ComponentTag tag) {
			}
		});
		return navCont;
	}


}
