/*
 * Copyright 2020 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.rendering.nui.layers.ingame.metrics;

import org.terasology.config.Config;
import org.terasology.engine.Time;
import org.terasology.entitySystem.entity.EntityManager;
import org.terasology.input.cameraTarget.CameraTargetSystem;
import org.terasology.logic.players.LocalPlayer;
import org.terasology.persistence.StorageManager;
import org.terasology.registry.In;
import org.terasology.rendering.nui.CoreScreenLayer;
import org.terasology.rendering.nui.databinding.ReadOnlyBinding;
import org.terasology.rendering.nui.widgets.UILabel;
import org.terasology.world.WorldProvider;

public class EntityDebugOverlay extends CoreScreenLayer {

    @In
    private Config config;

    @In
    private CameraTargetSystem cameraTarget;

    @In
    private Time time;

    @In
    private EntityManager entityManager;

    @In
    private LocalPlayer localPlayer;

    @In
    private WorldProvider worldProvider;

    @In
    private DebugMetricsSystem debugMetricsSystem;

    @In
    private StorageManager storageManager;


    @Override
    public void initialise() {
        bindVisible(new ReadOnlyBinding<Boolean>() {
            @Override
            public Boolean get() {
                return config.getSystem().isDebugEnabled();
            }
        });

        UILabel label1 = find("label1", UILabel.class);
        if (label1 != null) {
            label1.bindText(new ReadOnlyBinding<String>() {
                @Override
                public String get() {
                    return "HERE IS MY FIRST LABEL";
                }
            });
        }

        UILabel label2 = find("label2", UILabel.class);
        if (label2 != null) {
            label2.bindText(new ReadOnlyBinding<String>() {
                @Override
                public String get() {
                    return "Hello World!";
                }
            });
        }

    }

    @Override
    public boolean isModal() {
        return false;
    }

    @Override
    protected boolean isEscapeToCloseAllowed() {
        return false;
    }
}
