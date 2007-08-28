/*
 *
 * Copyright (C) 2007 The kune development team (see CREDITS for details)
 * This file is part of kune.
 *
 * Kune is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kune is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.ourproject.kune.platf.server.init;

import javax.persistence.NoResultException;

import org.ourproject.kune.platf.server.domain.License;
import org.ourproject.kune.platf.server.domain.User;
import org.ourproject.kune.platf.server.manager.GroupManager;
import org.ourproject.kune.platf.server.manager.LicenseManager;
import org.ourproject.kune.platf.server.properties.DatabaseProperties;

import com.google.gwt.user.client.rpc.SerializableException;
import com.google.inject.Inject;
import com.wideplay.warp.persist.TransactionType;
import com.wideplay.warp.persist.Transactional;

public class DatabaseInitializer {
    private final LicenseManager licenseManager;
    private final DatabaseProperties properties;
    private final GroupManager groupManager;

    @Inject
    public DatabaseInitializer(final DatabaseProperties properties, final GroupManager groupManager,
	    final LicenseManager licenseManager) {
	this.properties = properties;
	this.groupManager = groupManager;
	this.licenseManager = licenseManager;
    }

    public void initConditional() throws SerializableException {
	try {
	    groupManager.getDefaultGroup();
	} catch (NoResultException e) {
	    initDatabase();
	}
    }

    @Transactional(type = TransactionType.READ_WRITE)
    public void initDatabase() throws SerializableException {
	createUsers();
	createLicenses();
    }

    private void createUsers() throws SerializableException {
	String adminName = properties.getAdminUserName();
	String adminShortName = properties.getAdminShortName();
	String adminEmail = properties.getAdminEmail();
	String adminPassword = properties.getAdminPassword();
	User user = new User(adminShortName, adminName, adminEmail, adminPassword);
	groupManager.createUserGroup(user);

	String siteName = properties.getDefaultSiteName();
	String siteShortName = properties.getDefaultSiteShortName();
	String siteEmail = properties.getDefaultSiteAdminEmail();
	String sitePassword = properties.getDefaultSiteAdminPassword();
	user = new User(siteShortName, siteName, siteEmail, sitePassword);
	groupManager.createUserGroup(user);
    }

    private void createLicenses() {
	License license = new License("by", "Creative Commons Attribution", "",
		"http://creativecommons.org/licenses/by/3.0/", true, false, false, "", "");
	licenseManager.persist(license);
	license = new License("by-sa", "Creative Commons Attribution-ShareAlike", "",
		"http://creativecommons.org/licenses/by-sa/3.0/", true, true, false, "", "");
	licenseManager.persist(license);
	license = new License("by-nd", "Creative Commons Attribution-NoDerivs", "",
		"http://creativecommons.org/licenses/by-nd/3.0/", true, false, false, "", "");
	licenseManager.persist(license);
	license = new License("by-nc", "Creative Commons Attribution-NonCommercial", "",
		"http://creativecommons.org/licenses/by-nc/3.0/", true, false, false, "", "");
	licenseManager.persist(license);
	license = new License("by-nc-sa", "Creative Commons Attribution-NonCommercial-ShareAlike", "",
		"http://creativecommons.org/licenses/by-nc-sa/3.0/", true, false, false, "", "");
	licenseManager.persist(license);
	license = new License("by-nc-nd", "Creative Commons Attribution-NonCommercial-NoDerivs", "",
		"http://creativecommons.org/licenses/by-nc-nd/3.0/", true, false, false, "", "");
	licenseManager.persist(license);
	license = new License("gfdl", "GNU Free Documentation License", "", "http://www.gnu.org/copyleft/fdl.html",
		false, true, false, "", "");
	licenseManager.persist(license);
    }

}
