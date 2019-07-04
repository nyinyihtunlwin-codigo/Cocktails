package com.nyinyihtunlwin.cocktails.feature.base.mvi;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.hannesdorfmann.mosby3.FragmentMviDelegate;
import com.hannesdorfmann.mosby3.FragmentMviDelegateImpl;
import com.hannesdorfmann.mosby3.MviDelegateCallback;
import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * <p>
 * This abstract class can be used to extend from to implement an Model-View-Intent pattern with
 * this fragment as View and a {@link MviPresenter} to coordinate the View and the underlying
 * model (business logic)
 * </p>
 *
 * <p>
 * Per default {@link FragmentMviDelegateImpl} is used with the following lifecycle:
 * The View is attached to the Presenter in {@link Fragment#onViewCreated(View, Bundle)}.
 * So you better instantiate all your UI widgets before that lifecycle callback (typically in
 * {@link
 * Fragment#onCreateView(LayoutInflater, ViewGroup, Bundle)}. The View is detached from Presenter in
 * {@link Fragment#onDestroyView()}
 * </p>
 *
 * @author Hannes Dorfmann
 * @since 3.0.0
 */
public abstract class MviXFragment<V extends MvpView, P extends MviPresenter<V, ?>> extends Fragment
        implements MvpView, MviDelegateCallback<V, P> {

    private boolean isRestoringViewState = false;
    protected FragmentXMviDelegateImpl<V, P> mvpDelegate;

    @CallSuper
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @CallSuper
    @Override public void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }

    @CallSuper
    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }

    @CallSuper
    @Override public void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @CallSuper
    @Override public void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @CallSuper
    @Override public void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @CallSuper
    @Override public void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @CallSuper
    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getMvpDelegate().onViewCreated(view, savedInstanceState);
    }

    @CallSuper
    @Override public void onDestroyView() {
        super.onDestroyView();
        getMvpDelegate().onDestroyView();
    }

    @CallSuper
    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getMvpDelegate().onActivityCreated(savedInstanceState);
    }

    @CallSuper
    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
        getMvpDelegate().onAttach(activity);
    }

    @Override public void onAttach(Context context) {
        super.onAttach(context);
        getMvpDelegate().onAttach(context);
    }

    @CallSuper
    @Override public void onDetach() {
        super.onDetach();
        getMvpDelegate().onDetach();
    }

    @CallSuper
    @Override public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        getMvpDelegate().onAttachFragment(childFragment);
    }

    @CallSuper
    @Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getMvpDelegate().onConfigurationChanged(newConfig);
    }

    /**
     * Instantiate a presenter instance
     *
     * @return The {@link MvpPresenter} for this viewState
     */
    @NonNull
    public abstract P createPresenter();

    /**
     * Get the mvp delegate. This is internally used for creating presenter, attaching and detaching
     * viewState from presenter.
     *
     * <p><b>Please note that only one instance of mvp delegate should be used per Fragment
     * instance</b>.
     * </p>
     *
     * <p>
     * Only override this method if you really know what you are doing.
     * </p>
     *
     * @return {@link FragmentMviDelegate}
     */
    @NonNull
    public FragmentMviDelegate<V, P> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new FragmentXMviDelegateImpl<>(this, this);
        }

        return mvpDelegate;
    }

    @NonNull
    @Override public V getMvpView() {
        try {
            return (V) this;
        } catch (ClassCastException e) {
            String msg =
                    "Couldn't cast the View to the corresponding View interface. Most likely you forgot to add \"Fragment implements YourMvpViewInterface\".\"";
            Log.e(this.toString(), msg);
            throw new RuntimeException(msg, e);
        }
    }

    @Override public void setRestoringViewState(boolean restoringViewState) {
        this.isRestoringViewState = restoringViewState;
    }

    protected boolean isRestoringViewState() {
        return isRestoringViewState;
    }
}

