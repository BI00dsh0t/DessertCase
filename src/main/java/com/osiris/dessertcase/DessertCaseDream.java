/*
 * Copyright (C) 2013 The Android Open Source Project
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

package com.osiris.dessertcase;

import android.service.dreams.DreamService;

public class DessertCaseDream extends DreamService {
    private DessertCaseView mView;
    private DessertCaseView.RescalingContainer mContainer;

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setInteractive(false);

        mView = new DessertCaseView(this);

        mContainer = new DessertCaseView.RescalingContainer(this);

        mContainer.setView(mView);

        setContentView(mContainer);
    }

    @Override
    public void onDreamingStarted() {
        super.onDreamingStarted();
        mView.postDelayed(new Runnable() {
            public void run() {
                mView.start();
            }
        }, 1000);
    }

    @Override
    public void onDreamingStopped() {
        super.onDreamingStopped();
        mView.stop();
    }
}
