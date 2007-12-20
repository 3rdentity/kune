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

package org.ourproject.kune.platf.server.rpc;

import java.util.HashMap;

import org.ourproject.kune.platf.client.rpc.I18nService;
import org.ourproject.kune.platf.server.UserSession;
import org.ourproject.kune.platf.server.domain.I18nTranslation;
import org.ourproject.kune.platf.server.manager.I18nTranslationManager;

import com.google.gwt.user.client.rpc.SerializableException;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.wideplay.warp.persist.TransactionType;
import com.wideplay.warp.persist.Transactional;

@Singleton
public class I18nRPC implements RPC, I18nService {
    private final I18nTranslationManager i18nTranslationManager;
    private final UserSession userSession;

    @Inject
    public I18nRPC(final UserSession userSession, final I18nTranslationManager i18nTranslationManager) {
        this.userSession = userSession;
        this.i18nTranslationManager = i18nTranslationManager;
    }

    @Transactional(type = TransactionType.READ_ONLY)
    public String getInitialLanguage() {
        String initLanguage;
        if (userSession.isUserLoggedIn()) {
            initLanguage = userSession.getUser().getLanguage().getCode();
        } else {
            if (userSession.getBrowserLanguage() != null) {
                // Not logged, use browser language if possible
                initLanguage = userSession.getBrowserLanguage();
            } else {
                initLanguage = I18nTranslation.DEFAULT_LANG;
            }
        }
        return initLanguage;
    }

    @Transactional(type = TransactionType.READ_ONLY)
    public HashMap getLexicon(final String language) {
        return i18nTranslationManager.getLexicon(language);
    }

    @Transactional(type = TransactionType.READ_WRITE)
    public String getTranslation(final String userHash, final String language, final String text) {
        return i18nTranslationManager.getTranslation(language, text);
    }

    @Transactional(type = TransactionType.READ_WRITE)
    public void setTranslation(final String userHash, final String id, final String translation)
            throws SerializableException {
        i18nTranslationManager.setTranslation(id, translation);
    }

}