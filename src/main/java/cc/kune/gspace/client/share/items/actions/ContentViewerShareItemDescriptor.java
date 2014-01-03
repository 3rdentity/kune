/*
 *
 * Copyright (C) 2007-2014 Licensed to the Comunes Association (CA) under 
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
package cc.kune.gspace.client.share.items.actions;

import cc.kune.common.client.actions.InDevelopmentAction;
import cc.kune.common.client.actions.ui.descrip.MenuItemDescriptor;
import cc.kune.common.shared.i18n.I18n;
import cc.kune.core.client.resources.iconic.IconicResources;
import cc.kune.core.client.services.ClientFileDownloadUtils;

import com.google.inject.Inject;

public class ContentViewerShareItemDescriptor extends GroupShareItemDescriptor {

  public static class ChangeToEditorAction extends InDevelopmentAction {
  }
  public static class ChangeToEditorMenuItem extends AbstractToggleShareMenuItem {
    @Inject
    public ChangeToEditorMenuItem(final ChangeToEditorAction action, final IconicResources icons) {
      super(action);
      withText(I18n.t("Change to editor")).withIcon(icons.downArrow());
    }
  }

  public static class RemoveAction extends InDevelopmentAction {
  }

  public static class RemoveMenuItem extends MenuItemDescriptor {
    @Inject
    public RemoveMenuItem(final RemoveAction action, final IconicResources icons) {
      super(action);
      withText(I18n.t("Remove")).withIcon(icons.del());
    }
  }

  @Inject
  public ContentViewerShareItemDescriptor(final IconicResources icons,
      final ClientFileDownloadUtils downloadUtils, final ChangeToEditorMenuItem changeToEditor,
      final RemoveMenuItem remove) {
    super(downloadUtils, I18n.tWithNT("is viewer03", "someone is administrator"), changeToEditor, remove);
  }

}