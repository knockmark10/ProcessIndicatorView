package library.android.com.library;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.hdodenhof.circleimageview.CircleImageView;

import java.util.ArrayList;
import java.util.List;

public class ProcessIndicatorView extends Fragment {

    private int trackColor;
    private int selectedProcessColor;
    private int unselectedProcessColor;
    private int searchIcon;
    private int flightIcon;
    private int seatIcon;
    private int purchaseIcon;
    private int payIcon;
    private int currentProcess = 0;
    private List<StageProcess> processes = new ArrayList<>();

    private View trackView;
    private CircleImageView searchView;
    private CircleImageView fligthView;
    private CircleImageView seatView;
    private CircleImageView purchaseView;
    private CircleImageView payView;

    @SuppressLint("ValidFragment")
    private ProcessIndicatorView() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_process_indicator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindResources(view);
        initList();
        setupView();
        initStageProcess();
    }

    private void initList() {
        processes.add(StageProcess.Search);
        processes.add(StageProcess.Flight);
        processes.add(StageProcess.Seat);
        processes.add(StageProcess.Purchase);
        processes.add(StageProcess.Pay);
    }

    private void bindResources(View view) {
        trackView = view.findViewById(R.id.process_track);
        searchView = view.findViewById(R.id.process_search_stage);
        fligthView = view.findViewById(R.id.process_fligth_stage);
        seatView = view.findViewById(R.id.process_seat_stage);
        purchaseView = view.findViewById(R.id.process_purchase_stage);
        payView = view.findViewById(R.id.process_pay_stage);
    }

    private void setupView() {
        if (getActivity() != null) {
            trackView.setBackgroundColor(ContextCompat.getColor(getActivity(), trackColor));
            searchView.setImageDrawable(ContextCompat.getDrawable(getActivity(), searchIcon));
            searchView.setCircleBackgroundColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            searchView.setBorderColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            fligthView.setImageDrawable(ContextCompat.getDrawable(getActivity(), flightIcon));
            fligthView.setCircleBackgroundColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            fligthView.setBorderColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            seatView.setImageDrawable(ContextCompat.getDrawable(getActivity(), seatIcon));
            seatView.setCircleBackgroundColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            seatView.setBorderColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            purchaseView.setImageDrawable(ContextCompat.getDrawable(getActivity(), purchaseIcon));
            purchaseView.setCircleBackgroundColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            purchaseView.setBorderColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            payView.setImageDrawable(ContextCompat.getDrawable(getActivity(), payIcon));
            payView.setCircleBackgroundColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            payView.setBorderColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
        }
    }

    public void nextStage() {
        if ((currentProcess + 1) < processes.size() && getActivity() != null) {
            getCurrentProcessView(getCurrentProcess()).setCircleBackgroundColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            getCurrentProcessView(getCurrentProcess()).setBorderColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            if (currentProcess == 0) {
                AnimatingManager.scaleDownViewFirst(getCurrentProcessView(getCurrentProcess()), 1.5f, 1f);
            } else {
                AnimatingManager.scaleDownView(getCurrentProcessView(getCurrentProcess()), 1.5f, 1f);
            }
            currentProcess++;
            getCurrentProcessView(getCurrentProcess()).setCircleBackgroundColor(ContextCompat.getColor(getActivity(), selectedProcessColor));
            getCurrentProcessView(getCurrentProcess()).setBorderColor(ContextCompat.getColor(getActivity(), selectedProcessColor));
            if ((currentProcess + 1) == processes.size()) {
                AnimatingManager.scaleUpViewLast(getCurrentProcessView(getCurrentProcess()), 1f, 1.5f);
            } else {
                if (currentProcess == 0) {
                    AnimatingManager.scaleUpViewFirst(getCurrentProcessView(getCurrentProcess()), 1f, 1.5f);
                } else {
                    AnimatingManager.scaleUpView(getCurrentProcessView(getCurrentProcess()), 1f, 1.5f);
                }
            }
        }

    }

    public void previousStage() {
        if (currentProcess > 0 && getActivity() != null) {
            getCurrentProcessView(getCurrentProcess()).setCircleBackgroundColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            getCurrentProcessView(getCurrentProcess()).setBorderColor(ContextCompat.getColor(getActivity(), unselectedProcessColor));
            if ((currentProcess + 1) == processes.size()) {
                AnimatingManager.scaleDownViewLast(getCurrentProcessView(getCurrentProcess()), 1.5f, 1f);
            } else {
                AnimatingManager.scaleDownView(getCurrentProcessView(getCurrentProcess()), 1.5f, 1f);
            }
            currentProcess--;
            getCurrentProcessView(getCurrentProcess()).setCircleBackgroundColor(ContextCompat.getColor(getActivity(), selectedProcessColor));
            getCurrentProcessView(getCurrentProcess()).setBorderColor(ContextCompat.getColor(getActivity(), selectedProcessColor));
            if (currentProcess == 0) {
                AnimatingManager.scaleUpViewFirst(getCurrentProcessView(getCurrentProcess()), 1f, 1.5f);
            } else {
                AnimatingManager.scaleUpView(getCurrentProcessView(getCurrentProcess()), 1f, 1.5f);
            }
        }
    }

    private StageProcess getCurrentProcess() {
        switch (currentProcess) {
            case 0:
                return StageProcess.Search;
            case 1:
                return StageProcess.Flight;
            case 2:
                return StageProcess.Seat;
            case 3:
                return StageProcess.Purchase;
            case 4:
                return StageProcess.Pay;
            default:
                return StageProcess.Search;
        }
    }

    private CircleImageView getCurrentProcessView(StageProcess currentProcess) {
        switch (currentProcess) {
            case Search:
                return searchView;
            case Flight:
                return fligthView;
            case Seat:
                return seatView;
            case Purchase:
                return purchaseView;
            case Pay:
                return payView;
            default:
                return searchView;
        }
    }

    private void initStageProcess() {
        if (getActivity() != null) {
            getCurrentProcessView(getCurrentProcess()).setCircleBackgroundColor(ContextCompat.getColor(getActivity(), selectedProcessColor));
            getCurrentProcessView(getCurrentProcess()).setBorderColor(ContextCompat.getColor(getActivity(), selectedProcessColor));
            AnimatingManager.scaleUpViewFirst(getCurrentProcessView(getCurrentProcess()), 1f, 1.5f);
        }
    }

    public static class Builder {

        private int trackColor = -1;
        private int selectedProcessColor = -1;
        private int unselectedProcessColor = -1;
        private int searchIcon = -1;
        private int flightIcon = -1;
        private int seatIcon = -1;
        private int purchaseIcon = -1;
        private int payIcon = -1;

        public Builder setTrackColor(@ColorRes int colorId) {
            this.trackColor = colorId;
            return this;
        }

        public Builder setSelectedProcessColor(@ColorRes int colorId) {
            this.selectedProcessColor = colorId;
            return this;
        }

        public Builder setUnselectedProcessColor(@ColorRes int colorId) {
            this.unselectedProcessColor = colorId;
            return this;
        }

        public Builder setSearchingStageIcon(@DrawableRes int drawable) {
            this.searchIcon = drawable;
            return this;
        }

        public Builder setFlightStageIcon(@DrawableRes int drawable) {
            this.flightIcon = drawable;
            return this;
        }

        public Builder setSeatStageIcon(@DrawableRes int drawable) {
            this.seatIcon = drawable;
            return this;
        }

        public Builder setPurchaseStageIcon(@DrawableRes int drawable) {
            this.purchaseIcon = drawable;
            return this;
        }

        public Builder setPayStageIcon(@DrawableRes int drawable) {
            this.payIcon = drawable;
            return this;
        }

        public ProcessIndicatorView create(int viewId, FragmentManager fragmentManager) {
            checkNotNull();
            ProcessIndicatorView processIndicatorView = new ProcessIndicatorView();
            processIndicatorView.trackColor = this.trackColor;
            processIndicatorView.selectedProcessColor = this.selectedProcessColor;
            processIndicatorView.unselectedProcessColor = this.unselectedProcessColor;
            processIndicatorView.searchIcon = this.searchIcon;
            processIndicatorView.flightIcon = this.flightIcon;
            processIndicatorView.seatIcon = this.seatIcon;
            processIndicatorView.purchaseIcon = this.purchaseIcon;
            processIndicatorView.payIcon = this.payIcon;
            fragmentManager.beginTransaction().replace(viewId, processIndicatorView).commitAllowingStateLoss();
            return processIndicatorView;
        }

        private void checkNotNull() {
            if (trackColor == -1) {
                throw new IllegalArgumentException("You must set trackView color to avoid this exception.");
            }
            if (selectedProcessColor == -1) {
                throw new IllegalArgumentException("You must set current process color to avoid this exception.");
            }
            if (unselectedProcessColor == -1) {
                throw new IllegalArgumentException("You must set not current process color to avoid this exception.");
            }
            if (searchIcon == -1) {
                throw new IllegalArgumentException("You must set the icon for the searching process to avoid this exception.");
            }
            if (flightIcon == -1) {
                throw new IllegalArgumentException("You must set the icon for the flight process to avoid this exception.");
            }
            if (seatIcon == -1) {
                throw new IllegalArgumentException("You must set the icon for the seat process to avoid this exception.");
            }
            if (purchaseIcon == -1) {
                throw new IllegalArgumentException("You must set the icon for the purchase process to avoid this exception.");
            }
            if (payIcon == -1) {
                throw new IllegalArgumentException("You must set the icon for the pay process to avoid this exception.");
            }
        }
    }

    private enum StageProcess {
        Search,
        Flight,
        Seat,
        Purchase,
        Pay
    }

}
