package com.github.tonytanganadroid.precisefragment;

import android.app.Fragment;

public abstract class PreciseFragment extends Fragment {

    private boolean newVisibility;
    private boolean currentVisibility;



    @Override
    final public void onResume() {
        super.onResume();
        toggleVisibility(true);
    }


    @Override
    final public void onPause() {
        super.onPause();
        stopIfNecessary(true);

    }


    @Override
    final public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.newVisibility = isVisibleToUser;
        toggleVisibility(false);
    }


    private void toggleVisibility(boolean triggerByOnResumeOrOnPause) {
        if (toBeVisible()) {
            startIfNecessary(triggerByOnResumeOrOnPause);
        } else {
            stopIfNecessary(triggerByOnResumeOrOnPause);
        }
    }

    private boolean toBeVisible() {
        return this.newVisibility;
    }

    private void stopIfNecessary(boolean fromResume) {
        if (currentVisibility) {
            currentVisibility = false;
            onFragmentInvisible(fromResume);
        }
    }



    private void startIfNecessary(boolean triggerByOnResumeOrOnPause) {
        if (readyToBecomeVisible()) {
            currentVisibility = true;
            onFragmentVisible(triggerByOnResumeOrOnPause);
        }
    }

    private boolean readyToBecomeVisible() {
        return !currentVisibility && isResumed();
    }

    public abstract void onFragmentVisible(boolean triggeredByOnResume);

    public abstract void onFragmentInvisible(boolean triggeredByOnPause);


}