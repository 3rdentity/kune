/*
 *
 * Copyright (C) 2007-2009 The kune development team (see CREDITS for details)
 * This file is part of kune.
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
 \*/
package org.ourproject.kune.workspace.client.sitebar.siteoptions;

import org.ourproject.kune.platf.client.actions.ui.GuiBindingsRegister;
import org.ourproject.kune.platf.client.i18n.I18nUITranslationService;
import org.ourproject.kune.platf.client.ui.AbstractToolbar;
import org.ourproject.kune.workspace.client.skel.WorkspaceSkeleton;

public class SiteOptionsPanel extends AbstractSiteOptionsPanel implements SiteOptionsView {

    public static final String SITE_OPTIONS_MENU = "kune-sop-om";

    public SiteOptionsPanel(final WorkspaceSkeleton wspace, final I18nUITranslationService i18n,
            final GuiBindingsRegister bindings) {
        super(bindings, SITE_OPTIONS_MENU);
        setBtnText(i18n.t("Options"));
        final AbstractToolbar siteBar = wspace.getSiteBar();
        siteBar.addSeparator();
        siteBar.add(btn);
        siteBar.addSpacer();
        siteBar.addSpacer();
    }
}
