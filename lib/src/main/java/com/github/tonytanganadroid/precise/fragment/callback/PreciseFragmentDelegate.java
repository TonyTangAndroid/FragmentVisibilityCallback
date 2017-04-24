package com.github.tonytanganadroid.precise.fragment.callback;


public class PreciseFragmentDelegate {

    private boolean upcomingFragmentVisibilityToUser;
    private boolean currentFragmentVisibilityToUser;
    private boolean shouldForceHideFragment;
    private boolean hasFragmentEverOnResumed;
    private PreciseFragmentDelegateCallback callback;

    public PreciseFragmentDelegate(PreciseFragmentDelegateCallback callback) {
        this.callback = callback;
    }

    final public void onResume() {
        markFragmentEverOnResumed();
        updateUpcomingFramgentVisibility(true);
        toggleFragmentVisibility(true);
    }


    final public void setUserVisibleHint(boolean isVisibleToUser) {
        toggleFragmentVisibilityForceHiddenStatus(isVisibleToUser);
        updateUpcomingFramgentVisibility(isVisibleToUser);
        toggleFragmentVisibility(false);
    }

    final public void onPause() {
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

    private void updateUpcomingFramgentVisibility(boolean upcomingFragmentVisibility) {
        this.upcomingFragmentVisibilityToUser = upcomingFragmentVisibility;
    }

    private void toggleFragmentVisibility(boolean triggerByOnResumeOrOnPause) {
        if (hasFragmentEverOnResumed()) {
            if (isFragmentBecomingVisibleToUser()) {
                makeFragmentVisible(triggerByOnResumeOrOnPause);
            } else {
                makeFragmentInvisible(triggerByOnResumeOrOnPause);
            }
        } else {
            DebugLog.d("SupportPreciseFragment", "toggleFragmentVisibility : Ignored as fragment never has been on resumed");
        }

    }

    private boolean hasFragmentEverOnResumed() {
        return hasFragmentEverOnResumed;
    }

    private boolean isFragmentBecomingVisibleToUser() {
        return this.upcomingFragmentVisibilityToUser && !shouldForceHideFragment;
    }

    private void makeFragmentInvisible(boolean fromResume) {
        if (needToBecomingInvisible()) {
            markFragmentInvisibleToUser();
            if (callback != null) {
                callback.onFragmentInvisible(fromResume);
            }
        } else {
            DebugLog.d("SupportPreciseFragment", "makeFragmentInvisible : Ignored as fragment is already invisible to user");
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
            if (callback != null) {
                callback.onFragmentVisible(triggerByOnResumeOrOnPause);
            }
        } else {
            DebugLog.d("SupportPreciseFragment", "makeFragmentInvisible : Ignored as fragment is already visible to user");
        }
    }

    private void markFragmentVisibleToUser() {
        currentFragmentVisibilityToUser = true;
    }

    private boolean readyToBecomeVisible() {
        return hasFragmentEverOnResumed() && needToBecomeVisible();
    }

    private boolean needToBecomeVisible() {
        return !isFragmentCurrentlyVisibleToUser();
    }

    private void markFragmentEverOnResumed() {
        hasFragmentEverOnResumed = true;
    }


    /**
     * Call back when fragment is becoming visible or invisible to user. These fragment could also be applied to fragment in view pager,
     * which means that only the selected fragment is visible to user.
     */
    public interface PreciseFragmentDelegateCallback {
        /**
         * @param triggeredByOnResume true if the event is triggered by onResume event, false otherwise.
         */
        void onFragmentVisible(boolean triggeredByOnResume);

        /**
         * @param triggeredByOnPause true if the event is triggered by onPause event, false otherwise.
         */
        void onFragmentInvisible(boolean triggeredByOnPause);

    }

}