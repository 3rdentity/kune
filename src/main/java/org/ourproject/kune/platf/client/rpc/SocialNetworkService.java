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
package org.ourproject.kune.platf.client.rpc;

import org.ourproject.kune.platf.client.dto.SocialNetworkRequestResult;
import org.ourproject.kune.platf.client.dto.SocialNetworkResultDTO;
import org.ourproject.kune.platf.client.dto.StateToken;
import org.ourproject.kune.platf.client.errors.DefaultException;

import com.google.gwt.user.client.rpc.RemoteService;

public interface SocialNetworkService extends RemoteService {

    SocialNetworkResultDTO acceptJoinGroup(String hash, StateToken groupToken, String groupToAcceptShortName)
            throws DefaultException;

    SocialNetworkResultDTO addAdminMember(String hash, StateToken groupToken, String groupToAddShortName)
            throws DefaultException;

    SocialNetworkResultDTO addCollabMember(String hash, StateToken groupToken, String groupToAddShortName)
            throws DefaultException;

    SocialNetworkResultDTO addViewerMember(String hash, StateToken groupToken, String groupToAddShortName)
            throws DefaultException;

    SocialNetworkResultDTO deleteMember(String hash, StateToken groupToken, String groupToDeleteShortName)
            throws DefaultException;

    SocialNetworkResultDTO denyJoinGroup(String hash, StateToken groupToken, String groupToDenyShortName)
            throws DefaultException;

    SocialNetworkResultDTO getSocialNetwork(String hash, StateToken groupToken) throws DefaultException;

    SocialNetworkRequestResult requestJoinGroup(String hash, StateToken groupToken) throws DefaultException;

    SocialNetworkResultDTO setAdminAsCollab(String hash, StateToken groupToken, String groupToSetCollabShortName)
            throws DefaultException;

    SocialNetworkResultDTO setCollabAsAdmin(String hash, StateToken groupToken, String groupToSetAdminShortName)
            throws DefaultException;

    SocialNetworkResultDTO unJoinGroup(String hash, StateToken groupToken) throws DefaultException;
}
