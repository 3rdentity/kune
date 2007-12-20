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

package org.ourproject.kune.platf.server.manager.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.ourproject.kune.platf.server.domain.I18nLanguage;
import org.ourproject.kune.platf.server.manager.I18nLanguageManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class I18nLanguageManagerDefault extends DefaultManager<I18nLanguage, Long> implements I18nLanguageManager {

    private final I18nLanguage finder;

    @Inject
    public I18nLanguageManagerDefault(final Provider<EntityManager> provider, final I18nLanguage finder) {
        super(provider, I18nLanguage.class);
        this.finder = finder;
    }

    public I18nLanguage findByCode(final String language) {
        return finder.findByCode(language);
    }

    public List<I18nLanguage> getAll() {
        return finder.getAll();
    }
}