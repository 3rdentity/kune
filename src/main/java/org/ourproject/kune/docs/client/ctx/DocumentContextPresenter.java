/*
 *
 * Copyright (C) 2007-2008 The kune development team (see CREDITS for details)
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
 */
package org.ourproject.kune.docs.client.ctx;

import org.ourproject.kune.docs.client.DocumentClientTool;
import org.ourproject.kune.docs.client.ctx.admin.DocContextEditor;
import org.ourproject.kune.platf.client.dto.StateAbstractDTO;
import org.ourproject.kune.platf.client.dto.StateContainerDTO;
import org.ourproject.kune.platf.client.dto.StateContentDTO;
import org.ourproject.kune.platf.client.state.StateManager;
import org.ourproject.kune.workspace.client.ctxnav.ContextNavigator;

import com.calclab.suco.client.ioc.Provider;
import com.calclab.suco.client.listener.Listener;

public class DocumentContextPresenter implements DocumentContext {
    private final Provider<ContextNavigator> contextNavigatorProvider;
    private final Provider<DocContextEditor> adminContextProvider;

    public DocumentContextPresenter(final StateManager stateManager,
            final Provider<ContextNavigator> contextNavigatorProvider, final Provider<DocContextEditor> adminContextProvider) {
        this.contextNavigatorProvider = contextNavigatorProvider;
        this.adminContextProvider = adminContextProvider;
        stateManager.onStateChanged(new Listener<StateAbstractDTO>() {
            public void onEvent(final StateAbstractDTO state) {
                if (state instanceof StateContainerDTO) {
                    StateContainerDTO stateCntCtx = (StateContainerDTO) state;
                    if (DocumentClientTool.NAME.equals(stateCntCtx.getToolName())) {
                        setState(stateCntCtx);
                        contextNavigatorProvider.get().attach();
                    }
                } else {
                    contextNavigatorProvider.get().detach();
                    adminContextProvider.get().detach();
                    contextNavigatorProvider.get().clear();
                    adminContextProvider.get().clear();
                }
            }
        });
    }

    private void setState(final StateContainerDTO state) {
        contextNavigatorProvider.get().setState(state, true);
        if (state instanceof StateContentDTO) {
            adminContextProvider.get().setState((StateContentDTO) state);
        }
    }
}
