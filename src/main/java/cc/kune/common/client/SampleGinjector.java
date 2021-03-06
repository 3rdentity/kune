/*
 *
 * Copyright (C) 2007-2015 Licensed to the Comunes Association (CA) under
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
package cc.kune.common.client;

import cc.kune.common.client.actions.gwtui.GwtGuiProvider;
import cc.kune.common.client.actions.ui.GuiProvider;
import cc.kune.common.client.shortcuts.GlobalShortcutRegister;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

// TODO: Auto-generated Javadoc
/**
 * The Interface SampleGinjector.
 * 
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
@GinModules(SampleGinModule.class)
public interface SampleGinjector extends Ginjector {
  // FIXME move this to sandbox!!!
  /**
   * Gets the global shortcut register.
   * 
   * @return the global shortcut register
   */
  GlobalShortcutRegister getGlobalShortcutRegister();

  /**
   * Gets the gui provider.
   * 
   * @return the gui provider
   */
  GuiProvider getGuiProvider();

  /**
   * Gets the gwt gui provider.
   * 
   * @return the gwt gui provider
   */
  GwtGuiProvider getGwtGuiProvider();

}
