/*
 *
 * Copyright (C) 2007-2015 Licensed to the Comunes Association (CA) under
 * one or more contributor license agreements (see COPYRIGHT for details).
 * The CA licenses this file to you under the GNU Affero General Public
 * License version 3, (the "License"); you may not use this file except in
 * compliance with the License. This file is part of kune.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package cc.kune.embed.client.panels;

import cc.kune.common.client.actions.ui.ActionFlowPanel;
import cc.kune.common.shared.res.KuneIcon;
import cc.kune.core.client.events.UserSignInOrSignOutEvent;
import cc.kune.core.client.events.UserSignInOrSignOutEvent.UserSignInOrSignOutHandler;
import cc.kune.core.client.sitebar.EmbedSitebarSignInLink;
import cc.kune.core.client.sitebar.EmbedSitebarSignOutLink;
import cc.kune.core.client.state.Session;
import cc.kune.embed.client.conf.EmbedConfiguration;

import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class EmbedSitebar {
  private final PopupPanel popup;
  private final EmbedSitebarSignInLink signInLink;
  private final EmbedSitebarSignOutLink signOutLink;
  private final ActionFlowPanel toolbar;

  @Inject
  public EmbedSitebar(final Session session, final ActionFlowPanel toolbar,
      final EmbedSitebarSignInLink signInLink, final EmbedSitebarSignOutLink signOutLink) {
    this.toolbar = toolbar;
    this.signOutLink = signOutLink;
    this.signInLink = signInLink;
    if (EmbedConfiguration.get().getShowSignIn()) {
      toolbar.add(signInLink);
    }
    if (EmbedConfiguration.get().getShowSignOut()) {
      toolbar.add(signOutLink);
    }
    popup = new PopupPanel(false, false);
    popup.setWidget(toolbar);
    centerAndShow();
    popup.setAnimationEnabled(false);
    popup.setStyleName("oc-user-msg-popup");
    popup.addStyleName("k-embed-sitebar");
    Window.addResizeHandler(new ResizeHandler() {
      @Override
      public void onResize(final ResizeEvent event) {
        centerAndShow();
      }
    });

    session.onUserSignInOrSignOut(false, new UserSignInOrSignOutHandler() {
      @Override
      public void onUserSignInOrSignOut(final UserSignInOrSignOutEvent event) {
        // This is needed because the panel has different sinces depending on
        // the session
        centerAndShow();
      }
    });
  }

  private void centerAndShow() {
    popup.setPopupPositionAndShow(new PopupPanel.PositionCallback() {
      @Override
      public void setPosition(final int offsetWidth, final int offsetHeight) {
        final Integer rightMargin = EmbedConfiguration.get().getSitebarRightMargin();
        final int left = Window.getClientWidth() - toolbar.getOffsetWidth() - rightMargin;
        final int top = EmbedConfiguration.get().getSitebarTopMargin();
        popup.setPopupPosition(left, top);
      }
    });
  }

  public void init(final String stateToken) {
    signInLink.setTarget(stateToken);
    signInLink.withIcon(KuneIcon.KUNE);
    signOutLink.withIcon(KuneIcon.KUNE);
  }
}
