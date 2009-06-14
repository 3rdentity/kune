package org.ourproject.kune.platf.client.actions.common;

import org.ourproject.kune.platf.client.actions.AbstractExtendedAction;
import org.ourproject.kune.platf.client.actions.Action;
import org.ourproject.kune.platf.client.actions.ActionEvent;
import org.ourproject.kune.platf.client.state.StateManager;

public class GotoGroupAction extends AbstractExtendedAction {
    private final String name;
    private final StateManager stateManager;

    public GotoGroupAction(final String logoImageUrl, final String name, final StateManager stateManager) {
        super();
        this.name = name;
        this.stateManager = stateManager;
        putValue(Action.SMALL_ICON, logoImageUrl);
        putValue(Action.NAME, name);
    }

    public void actionPerformed(final ActionEvent event) {
        this.stateManager.gotoToken(name);
    }
}
