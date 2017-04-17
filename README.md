# Precise Fragment Visibility Callback

When Fragment used with ViewPager, the visibility callback is not as predictable as expected. This library will resolve such issue by extending your normal Fragment with

PreciseFragment or SupportPreciseFragment, which has two accurate callback that represents onResume and onPause Callback : 

    public abstract void onFragmentVisible(boolean triggeredByOnResume);

    public abstract void onFragmentInvisible(boolean triggeredByOnPause);
   