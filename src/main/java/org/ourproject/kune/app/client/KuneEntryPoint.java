/*
 *
 * Copyright (C) 2007-2009 The kune development team (see CREDITS for details)
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
package org.ourproject.kune.app.client;

import org.ourproject.kune.blogs.client.BlogClientModule;
import org.ourproject.kune.chat.client.ChatClientModule;
import org.ourproject.kune.docs.client.DocumentClientModule;
import org.ourproject.kune.gallery.client.GalleryClientModule;
import org.ourproject.kune.platf.client.services.Loader;
import org.ourproject.kune.platf.client.services.PlatformModule;
import org.ourproject.kune.wiki.client.WikiClientModule;
import org.ourproject.kune.workspace.client.RegistryModule;
import org.ourproject.kune.workspace.client.WorkspaceModule;
import org.ourproject.kune.workspace.client.hello.HelloWorldModule;

import com.allen_sauer.gwt.log.client.Log;
import com.calclab.emiteuimodule.client.EmiteUIModule;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

public class KuneEntryPoint implements EntryPoint {

    public void onModuleLoad() {
        Log.setUncaughtExceptionHandler();

        DeferredCommand.addCommand(new Command() {
            public void execute() {
                onModuleLoadCont();
            }
        });
    }

    public void onModuleLoadCont() {
        // At the moment, in runtime:
        Log.setCurrentLogLevel(Log.LOG_LEVEL_DEBUG);

        Loader.install(new RegistryModule(), new DocumentClientModule(), new BlogClientModule(),
                new WikiClientModule(), new GalleryClientModule(), new EmiteUIModule(), new ChatClientModule(),
                new WorkspaceModule(), new PlatformModule());

        // We install our HelloWorldModule
        Loader.install(new HelloWorldModule());
    }
}
