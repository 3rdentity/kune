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
package cc.kune.gspace.client.armor;

import cc.kune.common.client.actions.ui.ActionFlowPanel;
import cc.kune.common.client.actions.ui.IsActionExtensible;
import cc.kune.common.client.ui.HTMLId;
import cc.kune.common.client.ui.WrappedFlowPanel;

import com.google.gwt.dom.client.Element;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.ButtonBase;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InsertPanel.ForIsWidget;

/**
 * The Interface GSpaceArmor.
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public interface GSpaceArmor {

  /**
   * Clear back image.
   */
  void clearBackImage();

  /**
   * Enable center scroll.
   *
   * @param enable
   *          the enable
   */
  void enableCenterScroll(boolean enable);

  /**
   * Gets the doc container.
   *
   * @return the doc container
   */
  GSpaceCenter getDocContainer();

  /**
   * Gets the doc container height.
   *
   * @return the doc container height
   */
  int getDocContainerHeight();

  /**
   * Gets the doc footer.
   *
   * @return the doc footer
   */
  ForIsWidget getDocFooter();

  /**
   * Gets the doc footer toolbar.
   *
   * @return the doc footer toolbar
   */
  IsActionExtensible getDocFooterActionsToolbar();

  /**
   * Gets the doc header.
   *
   * @return the doc header
   */
  ForIsWidget getDocHeader();

  IsActionExtensible getDocHeaderRightActionsToolbar();

  ActionFlowPanel getDocTopActionsToolbar();

  /**
   * Gets the doc subheader.
   *
   * @return the doc subheader
   */
  ForIsWidget getDocTopbar();

  Element getElement(HTMLId htmlId);

  /**
   * Gets the entity footer.
   *
   * @return the entity footer
   */
  ForIsWidget getEntityFooter();

  /**
   * Gets the entity header.
   *
   * @return the entity header
   */
  ForIsWidget getEntityHeader();

  /**
   * Gets the entity tools center.
   *
   * @return the entity tools center
   */
  ForIsWidget getEntityToolsCenter();

  /**
   * Gets the entity tools north.
   *
   * @return the entity tools north
   */
  ForIsWidget getEntityToolsNorth();

  ButtonBase getFollowersButton();

  Image getGroupLogo();

  WrappedFlowPanel getGroupName();

  WrappedFlowPanel getGroupShortName();

  /**
   * Gets the header toolbar.
   *
   * @return the header toolbar
   */
  IsActionExtensible getHeaderActionsTopToolbar();

  ForIsWidget getHeaderBottombar();

  Element getLogoShadow();

  /**
   * Gets the sitebar.
   *
   * @return the sitebar
   */
  ForIsWidget getSitebarLeft();

  ForIsWidget getSitebarRight();

  IsActionExtensible getTopActionsToolbar();

  /**
   * Gets the user space.
   *
   * @return the user space
   */
  ForIsWidget getUserSpace();

  /**
   * Select group space.
   */
  void selectGroupSpace();

  /**
   * Select home space.
   */
  void selectHomeSpace();

  /**
   * Select public space.
   */
  void selectPublicSpace();

  /**
   * Select user space.
   */
  void selectUserSpace();

  /**
   * Sets the back image.
   *
   * @param url
   *          the new back image
   */
  void setBackImage(String url);

  /**
   * Sets the rtl.
   *
   * @param direction
   *          the new rtl
   */
  void setRTL(Direction direction);

  WrappedFlowPanel wrapDiv(HTMLId htmlId);

}
