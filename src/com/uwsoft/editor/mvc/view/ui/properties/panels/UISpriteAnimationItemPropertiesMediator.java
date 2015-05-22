/*
 * ******************************************************************************
 *  * Copyright 2015 See AUTHORS file.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *****************************************************************************
 */

package com.uwsoft.editor.mvc.view.ui.properties.panels;

import com.uwsoft.editor.utils.runtime.ComponentRetriever;
import org.apache.commons.lang3.ArrayUtils;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;
import com.puremvc.patterns.observer.Notification;
import com.uwsoft.editor.mvc.view.ui.properties.UIItemPropertiesMediator;
import com.uwsoft.editor.renderer.components.sprite.SpriteAnimationComponent;
import com.uwsoft.editor.renderer.components.sprite.SpriteAnimationStateComponent;

/**
 * Created by azakhary on 4/16/2015.
 */
public class UISpriteAnimationItemPropertiesMediator extends UIItemPropertiesMediator<Entity, UISpriteAnimationItemProperties> {
    private static final String TAG = UISpriteAnimationItemPropertiesMediator.class.getCanonicalName();
    public static final String NAME = TAG;

    private SpriteAnimationComponent spriteAnimationComponent;
    private SpriteAnimationStateComponent stateComponent;

    public UISpriteAnimationItemPropertiesMediator() {
        super(NAME, new UISpriteAnimationItemProperties());
    }

    @Override
    public String[] listNotificationInterests() {
        String[] defaultNotifications = super.listNotificationInterests();
        String[] notificationInterests = new String[]{
                UISpriteAnimationItemProperties.EDIT_ANIMATIONS_CLICKED
        };

        return ArrayUtils.addAll(defaultNotifications, notificationInterests);
    }

    @Override
    public void handleNotification(Notification notification) {
        super.handleNotification(notification);

        switch (notification.getName()) {
            case UISpriteAnimationItemProperties.EDIT_ANIMATIONS_CLICKED:

                break;
            default:
                break;
        }
    }

    @Override
    protected void translateObservableDataToView(Entity entity) {

    	spriteAnimationComponent = ComponentRetriever.get(entity, SpriteAnimationComponent.class);
    	stateComponent = ComponentRetriever.get(entity, SpriteAnimationStateComponent.class);
    	
        Array<String> animations = new Array<>();
        for (String name : spriteAnimationComponent.keyFrames.keySet()) {
            animations.add(name);
        }
      //TODO fix and uncomment 
        //viewComponent.setFPS(item.dataVO.fps);
//        viewComponent.setAnimations(animations);
//        viewComponent.setSelectedAnimation(stateComponent.currentAnimation);
    }

    @Override
    protected void translateViewToItemData() {
    	//TODO fix and uncomment 
        //observableReference.setAnimation(viewComponent.getSelected());
        //observableReference.dataVO.fps = viewComponent.getFPS();
    }
}
