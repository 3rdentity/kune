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
package cc.kune.common.client.actions.ui.descrip;

import cc.kune.common.client.actions.AbstractAction;
import cc.kune.common.client.actions.Action;
import cc.kune.common.client.actions.BaseAction;

// TODO: Auto-generated Javadoc
/**
 * The Class ButtonDescriptor.
 *
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class ButtonDescriptor extends AbstractGuiActionDescrip {

  public ButtonDescriptor() {
    this(new BaseAction(null, null));
  }

  /**
   * Instantiates a new button descriptor.
   *
   * @param action
   *          the action
   */
  public ButtonDescriptor(final AbstractAction action) {
    super(action);
  }

  public ButtonDescriptor(final AbstractGuiActionDescrip descr) {
    super(descr);
  }

  public ButtonDescriptor(final String text) {
    this(text, new BaseAction(null, null));
  }

  public ButtonDescriptor(final String text, final AbstractAction action) {
    this(action);
    putValue(Action.NAME, text);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * cc.kune.common.client.actions.ui.descrip.AbstractGuiActionDescrip#getType()
   */
  @Override
  public Class<?> getType() {
    return ButtonDescriptor.class;
  }
}
