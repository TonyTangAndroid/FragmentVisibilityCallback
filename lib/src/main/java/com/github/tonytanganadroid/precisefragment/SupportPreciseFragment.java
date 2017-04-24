package com.github.tonytanganadroid.precisefragment;


import android.support.v4.app.Fragment;
import android.util.Log;

import hugo.weaving.DebugLog;

public abstract class SupportPreciseFragment extends Fragment {

    private boolean upcomingFragmentVisibilityToUser;
    private boolean currentFragmentVisibilityToUser;
    private boolean shouldForceHideFragment;
    private boolean hasFragmentEverOnResumed;


    @DebugLog
    @Override
    public void onResume() {
        super.onResume();
        markFragmentEverOnResumed();
        updateUpcomingFramgentVisibility(true);
        toggleFragmentVisibility(true);
    }


    @DebugLog
    @Override
    final public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        toggleFragmentVisibilityForceHiddenStatus(isVisibleToUser);
        updateUpcomingFramgentVisibility(isVisibleToUser);
        toggleFragmentVisibility(false);
    }


    @DebugLog
    @Override
    public void onPause() {
        super.onPause();
        makeFragmentInvisible(true);

    }

    private void markFragmentVisibilityForceHiddenToTrue() {
        shouldForceHideFragment = true;
    }

    private void markFragmentVisibilityForceHiddenToFalse() {
        shouldForceHideFragment = false;
    }

    private void toggleFragmentVisibilityForceHiddenStatus(boolean showFragment) {
        if (showFragment) {
            markFragmentVisibilityForceHiddenToFalse();
        } else {
            markFragmentVisibilityForceHiddenToTrue();
        }
    }


    @DebugLog
    private void updateUpcomingFramgentVisibility(boolean upcomingFragmentVisibility) {
        this.upcomingFragmentVisibilityToUser = upcomingFragmentVisibility;
    }


    private void toggleFragmentVisibility(boolean triggerByOnResumeOrOnPause) {
        if (resumed()) {
            if (isFragmentBecomingVisibleToUser()) {
                makeFragmentVisible(triggerByOnResumeOrOnPause);
            } else {
                makeFragmentInvisible(triggerByOnResumeOrOnPause);
            }
        } else {
            Log.d("SupportPreciseFragment", "toggleFragmentVisibility : Ignored as fragment never has been on resumed");
        }

    }

    private boolean resumed() {
        return hasFragmentEverOnResumed;
    }

    private boolean isFragmentBecomingVisibleToUser() {
        return this.upcomingFragmentVisibilityToUser && !shouldForceHideFragment;
    }

    private void makeFragmentInvisible(boolean fromResume) {
        if (needToBecomingInvisible()) {
            markFragmentInvisibleToUser();
            onFragmentInvisible(fromResume);
        } else {
            Log.d("SupportPreciseFragment", "makeFragmentInvisible : Ignored as fragment is already invisible to user");
        }
    }

    private void markFragmentInvisibleToUser() {
        currentFragmentVisibilityToUser = false;
    }

    private boolean needToBecomingInvisible() {
        return isFragmentCurrentlyVisibleToUser();
    }

    private boolean isFragmentCurrentlyVisibleToUser() {
        return currentFragmentVisibilityToUser;
    }


    private void makeFragmentVisible(boolean triggerByOnResumeOrOnPause) {
        if (readyToBecomeVisible()) {
            markFragmentVisibleToUser();
            onFragmentVisible(triggerByOnResumeOrOnPause);
        } else {
            Log.d("SupportPreciseFragment", "makeFragmentInvisible : Ignored as fragment is already visible to user");
        }
    }

    private void markFragmentVisibleToUser() {
        currentFragmentVisibilityToUser = true;
    }

    private boolean readyToBecomeVisible() {
        return isResumed() && needToBecomeVisible();
    }

    private boolean needToBecomeVisible() {
        return !isFragmentCurrentlyVisibleToUser();
    }

    private void markFragmentEverOnResumed() {
        hasFragmentEverOnResumed = true;
    }

    /**
     * @param triggeredByOnResume true if the event is triggered by onResume event, false otherwise.
     */
    public abstract void onFragmentVisible(boolean triggeredByOnResume);

    /**
     * @param triggeredByOnPause true if the event is triggered by onPause event, false otherwise.
     */
    public abstract void onFragmentInvisible(boolean triggeredByOnPause);


}