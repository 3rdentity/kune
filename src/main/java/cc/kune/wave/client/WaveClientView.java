/*
 *
 * Copyright (C) 2007-2011 The kune development team (see CREDITS for details)
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
package cc.kune.wave.client;

import org.waveprotocol.box.webclient.client.RemoteViewServiceMultiplexer;
import org.waveprotocol.box.webclient.client.WaveWebSocketClient;
import org.waveprotocol.wave.client.account.ProfileManager;
import org.waveprotocol.wave.client.common.safehtml.SafeHtml;
import org.waveprotocol.wave.client.common.util.AsyncHolder.Accessor;
import org.waveprotocol.wave.client.widget.common.ImplPanel;

import cc.kune.gspace.client.maxmin.IsMaximizable;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.IsWidget;

public interface WaveClientView extends IsWidget, IsMaximizable {

  void clear();

  RemoteViewServiceMultiplexer getChannel();

  Element getLoading();

  ProfileManager getProfiles();

  void getStackTraceAsync(Throwable caught, Accessor<SafeHtml> accessor);

  ImplPanel getWaveHolder();

  WaveWebSocketClient getWebSocket();

  void login();

  void logout();

}
