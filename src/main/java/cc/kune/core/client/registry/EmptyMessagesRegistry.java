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
 \*/
package cc.kune.core.client.registry;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class EmptyMessagesRegistry.
 * 
 * @author vjrj@ourproject.org (Vicente J. Ruiz Jurado)
 */
public class EmptyMessagesRegistry {

  /** The registry. */
  private final Map<String, String> registry;

  /**
   * Instantiates a new empty messages registry.
   */
  public EmptyMessagesRegistry() {
    registry = new HashMap<String, String>();
  }

  /**
   * Gets the content type icon.
   * 
   * @param typeId
   *          the type id
   * @return the content type icon
   */
  public String getContentTypeIcon(final String typeId) {
    return registry.get(typeId);
  }

  /**
   * Register.
   * 
   * @param contentTypeId
   *          the content type id
   * @param message
   *          the message
   */
  public void register(final String contentTypeId, final String message) {
    registry.put(contentTypeId, message);
  }
}
