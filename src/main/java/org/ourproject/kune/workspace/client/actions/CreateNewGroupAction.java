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
package org.ourproject.kune.workspace.client.actions;

import org.ourproject.kune.platf.client.dispatch.Action;
import org.ourproject.kune.platf.client.dto.GroupDTO;
import org.ourproject.kune.platf.client.dto.StateToken;
import org.ourproject.kune.platf.client.rpc.GroupService;
import org.ourproject.kune.platf.client.rpc.GroupServiceAsync;
import org.ourproject.kune.platf.client.rpc.ParamCallback;
import org.ourproject.kune.platf.client.state.Session;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateNewGroupAction implements Action<ParamCallback<GroupDTO, StateToken>> {

    private final Session session;

    public CreateNewGroupAction(final Session session) {
        this.session = session;
    }

    public void execute(final ParamCallback<GroupDTO, StateToken> paramCall) {
        onNewGroup(paramCall.getParam(), paramCall.getCallback());
    }

    private void onNewGroup(final GroupDTO group, final AsyncCallback<StateToken> callback) {
        GroupServiceAsync groupService = GroupService.App.getInstance();
        groupService.createNewGroup(session.getUserHash(), group, callback);
    }
}