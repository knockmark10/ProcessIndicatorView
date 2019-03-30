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
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ProcessIndicatorView extends Fragment {

    private int trackColor;
    private int selectedProcessDrawable;
    private int unselectedProcessDrawable;
    private int firstIcon;
    private int secondIcon;
    private int thirdIcon;
    private int fourthIcon;
    private int fifthIcon;
    private int currentProcess = 0;
    private List<StageProcess> processes = new ArrayList<>();

    private View trackView;
    private ImageView ivFirstStage;
    private ImageView ivSecondStage;
    private ImageView ivThirdStage;
    private ImageView ivFourthStage;
    private ImageView ivFifthStage;
    private FrameLayout firstStageContainer;
    private FrameLayout secondStageContainer;
    private FrameLayout thirdStageContainer;
    private FrameLayout fourthStageContainer;
    private FrameLayout fifthStageContainer;

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
        processes.add(StageProcess.First);
        processes.add(StageProcess.Second);
        processes.add(StageProcess.Third);
        processes.add(StageProcess.Fourth);
        processes.add(StageProcess.Fifth);
    }

    private void bindResources(View view) {
        trackView = view.findViewById(R.id.process_track);
        ivFirstStage = view.findViewById(R.id.process_first_stage_image);
        firstStageContainer = view.findViewById(R.id.process_first_stage);
        ivSecondStage = view.findViewById(R.id.process_second_stage_image);
        secondStageContainer = view.findViewById(R.id.process_second_stage);
        ivThirdStage = view.findViewById(R.id.process_third_stage_image);
        thirdStageContainer = view.findViewById(R.id.process_third_stage);
        ivFourthStage = view.findViewById(R.id.process_fourth_stage_image);
        fourthStageContainer = view.findViewById(R.id.process_fourth_stage);
        ivFifthStage = view.findViewById(R.id.process_fifth_stage_image);
        fifthStageContainer = view.findViewById(R.id.process_fifth_stage);
    }

    private void setupView() {
        if (getActivity() != null) {
            trackView.setBackgroundColor(ContextCompat.getColor(getActivity(), trackColor));
            ivFirstStage.setImageDrawable(ContextCompat.getDrawable(getActivity(), firstIcon));
            firstStageContainer.setBackground(ContextCompat.getDrawable(getActivity(), unselectedProcessDrawable));
            ivSecondStage.setImageDrawable(ContextCompat.getDrawable(getActivity(), secondIcon));
            secondStageContainer.setBackground(ContextCompat.getDrawable(getActivity(), unselectedProcessDrawable));
            ivThirdStage.setImageDrawable(ContextCompat.getDrawable(getActivity(), thirdIcon));
            thirdStageContainer.setBackground(ContextCompat.getDrawable(getActivity(), unselectedProcessDrawable));
            ivFourthStage.setImageDrawable(ContextCompat.getDrawable(getActivity(), fourthIcon));
            fourthStageContainer.setBackground(ContextCompat.getDrawable(getActivity(), unselectedProcessDrawable));
            ivFifthStage.setImageDrawable(ContextCompat.getDrawable(getActivity(), fifthIcon));
            fifthStageContainer.setBackground(ContextCompat.getDrawable(getActivity(), unselectedProcessDrawable));
        }
    }

    public void nextStage() {
        if ((currentProcess + 1) < processes.size() && getActivity() != null) {
            this.getCurrentProcessContainer(getCurrentProcess()).setBackground(ContextCompat.getDrawable(getActivity(), unselectedProcessDrawable));
            if (currentProcess == 0) {
                AnimatingManager.scaleDownViewFirst(getCurrentProcessContainer(getCurrentProcess()), 1.5f, 1f);
            } else {
                AnimatingManager.scaleDownView(getCurrentProcessContainer(getCurrentProcess()), 1.5f, 1f);
            }
            currentProcess++;
            this.getCurrentProcessContainer(getCurrentProcess()).setBackground(ContextCompat.getDrawable(getActivity(), selectedProcessDrawable));
            if ((currentProcess + 1) == processes.size()) {
                AnimatingManager.scaleUpViewLast(getCurrentProcessContainer(getCurrentProcess()), 1f, 1.5f);
            } else {
                if (currentProcess == 0) {
                    AnimatingManager.scaleUpViewFirst(getCurrentProcessContainer(getCurrentProcess()), 1f, 1.5f);
                } else {
                    AnimatingManager.scaleUpView(getCurrentProcessContainer(getCurrentProcess()), 1f, 1.5f);
                }
            }
        }

    }

    public void previousStage() {
        if (currentProcess > 0 && getActivity() != null) {
            this.getCurrentProcessContainer(getCurrentProcess()).setBackground(ContextCompat.getDrawable(getActivity(), unselectedProcessDrawable));
            if ((currentProcess + 1) == processes.size()) {
                AnimatingManager.scaleDownViewLast(getCurrentProcessContainer(getCurrentProcess()), 1.5f, 1f);
            } else {
                AnimatingManager.scaleDownView(getCurrentProcessContainer(getCurrentProcess()), 1.5f, 1f);
            }
            currentProcess--;
            getCurrentProcessContainer(getCurrentProcess()).setBackground(ContextCompat.getDrawable(getActivity(), selectedProcessDrawable));
            if (currentProcess == 0) {
                AnimatingManager.scaleUpViewFirst(getCurrentProcessContainer(getCurrentProcess()), 1f, 1.5f);
            } else {
                AnimatingManager.scaleUpView(getCurrentProcessContainer(getCurrentProcess()), 1f, 1.5f);
            }
        }
    }

    private StageProcess getCurrentProcess() {
        switch (currentProcess) {
            case 0:
                return StageProcess.First;
            case 1:
                return StageProcess.Second;
            case 2:
                return StageProcess.Third;
            case 3:
                return StageProcess.Fourth;
            case 4:
                return StageProcess.Fifth;
            default:
                return StageProcess.First;
        }
    }

    private FrameLayout getCurrentProcessContainer(StageProcess currentProcess) {
        switch (currentProcess) {
            case First:
                return firstStageContainer;
            case Second:
                return secondStageContainer;
            case Third:
                return thirdStageContainer;
            case Fourth:
                return fourthStageContainer;
            default:
                return fifthStageContainer;
        }
    }

    private void initStageProcess() {
        if (getActivity() != null) {
            getCurrentProcessContainer(getCurrentProcess()).setBackground(ContextCompat.getDrawable(getActivity(), selectedProcessDrawable));
            AnimatingManager.scaleUpViewFirst(getCurrentProcessContainer(getCurrentProcess()), 1f, 1.5f);
        }
    }

    public static class Builder {

        private int trackColor = -1;
        private int selectedProcessDrawable = -1;
        private int unselectedProcessDrawable = -1;
        private int firstIcon = -1;
        private int secondIcon = -1;
        private int thirdIcon = -1;
        private int fourthIcon = -1;
        private int fifthIcon = -1;

        public Builder setTrackColor(@ColorRes int colorId) {
            this.trackColor = colorId;
            return this;
        }

        public Builder setSelectedProcessDrawable(@DrawableRes int resId) {
            this.selectedProcessDrawable = resId;
            return this;
        }

        public Builder setUnselectedProcessDrawable(@DrawableRes int resId) {
            this.unselectedProcessDrawable = resId;
            return this;
        }

        public Builder setFistStageIcon(@DrawableRes int drawable) {
            this.firstIcon = drawable;
            return this;
        }

        public Builder setSecondStageIcon(@DrawableRes int drawable) {
            this.secondIcon = drawable;
            return this;
        }

        public Builder setThirdStageIcon(@DrawableRes int drawable) {
            this.thirdIcon = drawable;
            return this;
        }

        public Builder setFourthStageIcon(@DrawableRes int drawable) {
            this.fourthIcon = drawable;
            return this;
        }

        public Builder setFiftsStageIcon(@DrawableRes int drawable) {
            this.fifthIcon = drawable;
            return this;
        }

        public ProcessIndicatorView create(int viewId, FragmentManager fragmentManager) {
            checkNotNull();
            ProcessIndicatorView processIndicatorView = new ProcessIndicatorView();
            processIndicatorView.trackColor = this.trackColor;
            processIndicatorView.selectedProcessDrawable = this.selectedProcessDrawable;
            processIndicatorView.unselectedProcessDrawable = this.unselectedProcessDrawable;
            processIndicatorView.firstIcon = this.firstIcon;
            processIndicatorView.secondIcon = this.secondIcon;
            processIndicatorView.thirdIcon = this.thirdIcon;
            processIndicatorView.fourthIcon = this.fourthIcon;
            processIndicatorView.fifthIcon = this.fifthIcon;
            fragmentManager.beginTransaction().replace(viewId, processIndicatorView).commitAllowingStateLoss();
            return processIndicatorView;
        }

        private void checkNotNull() {
            if (trackColor == -1) {
                throw new IllegalArgumentException("You must set trackView color to avoid this exception.");
            }
            if (selectedProcessDrawable == -1) {
                throw new IllegalArgumentException("You must set current process color to avoid this exception.");
            }
            if (unselectedProcessDrawable == -1) {
                throw new IllegalArgumentException("You must set not current process color to avoid this exception.");
            }
            if (firstIcon == -1) {
                throw new IllegalArgumentException("You must set the icon for the searching process to avoid this exception.");
            }
            if (secondIcon == -1) {
                throw new IllegalArgumentException("You must set the icon for the flight process to avoid this exception.");
            }
            if (thirdIcon == -1) {
                throw new IllegalArgumentException("You must set the icon for the seat process to avoid this exception.");
            }
            if (fourthIcon == -1) {
                throw new IllegalArgumentException("You must set the icon for the purchase process to avoid this exception.");
            }
            if (fifthIcon == -1) {
                throw new IllegalArgumentException("You must set the icon for the pay process to avoid this exception.");
            }
        }
    }

    private enum StageProcess {
        First,
        Second,
        Third,
        Fourth,
        Fifth
    }

}
