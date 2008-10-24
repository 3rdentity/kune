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
 */package org.ourproject.kune.platf.client.ui.rate;

import org.ourproject.kune.platf.client.dto.StateAbstractDTO;
import org.ourproject.kune.platf.client.dto.StateContentDTO;
import org.ourproject.kune.platf.client.state.StateManager;

import com.calclab.suco.client.listener.Listener;

public class RatePresenter {

    private RateView view;

    public RatePresenter(final StateManager stateManager) {
        stateManager.onStateChanged(new Listener<StateAbstractDTO>() {
            public void onEvent(final StateAbstractDTO state) {
                if (state instanceof StateContentDTO) {
                    setState((StateContentDTO) state);
                } else {
                    view.setVisible(false);
                }
            }
        });
    }

    public void init(final RateView view) {
        this.view = view;
    }

    public void setVisible(final boolean visible) {
        view.setVisible(visible);
    }

    private void setState(final StateContentDTO state) {
        if (state.isRateable()) {
            view.setVisible(true);
            view.setRate(state.getRate());
            view.setByUsers(state.getRateByUsers());
        }
    }
}
